package fr.tyr.game;

import fr.tyr.Main;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.tools.Runner;
import fr.tyr.tools.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GraphicEngine extends JPanel {

    public static final Font font = new Font("Roboto", Font.PLAIN, 18);

    private final GameEngine gameEngine;
    private final Runner fpsRunner;
    private final Runner tpsRunner;

    private final Timer resizeTimer;

    public GraphicEngine(GameEngine gameEngine){
        this.gameEngine = gameEngine;
        setBackground(Color.BLACK);
        // Init components
        // Runner setup
        Main.getLogger().info("Initializing runners...");
        fpsRunner = new Runner("fps_runner", () -> {
            paintImmediately(getBounds());
        }, 60, false);
        tpsRunner = new Runner("tps_runner", this::tick, 60, false);
        fpsRunner.start();
        tpsRunner.start();
        Main.getLogger().info("Runners initialized.");
        // Click listener
        Main.getLogger().info("Initializing click listener...");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClick(e);
            }
        });
        Main.getLogger().info("Click listener initialized.");

        resizeTimer = new Timer(200, e -> resize());
        resizeTimer.setRepeats(false);
        resizeTimer.setCoalesce(true);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if(resizeTimer.isRunning())
                    resizeTimer.restart();
                else
                    resizeTimer.start();
            }
        });

        // Sound playing
//        Sounds.DING.setVolume(.5f);
//        Sounds.DING.play();
//        Sounds.BACKGROUND.setVolume(.02f);
//        Sounds.BACKGROUND.playBackground();
    }

    private void resize(){
        this.gameEngine.getComponentsLock().lock();
        try{
            this.gameEngine.getComponents().forEach(component -> component.onResize(new Vector2D(getWidth(), getHeight())));
        }catch (Exception e){
            Main.getLogger().severe(e.getMessage());
        }finally {
            this.gameEngine.getComponentsLock().unlock();
        }
    }

    private void onClick(MouseEvent event){
        Main.getLogger().info("Click detected at (%d, %d)".formatted(event.getX(), event.getY()));
        List<GameComponent<?>> localComponents = getReversedComponentsList();
        Collections.reverse(localComponents);
        Vector2D mouseVector = new Vector2D(event.getX(), event.getY());
        for(GameComponent<?> component : localComponents){
            Vector2D componentPosition = component.getPosition();
            Vector2D componentSize = component.getSize();
            boolean isMouseBetween = mouseVector.isBetween(componentPosition, Vector2D.add(componentPosition, componentSize));
            if(isMouseBetween){
                component.onClick();
                return;
            }
        }
    }

    private void tick(){
        List<GameComponent<?>> localComponents = getReversedComponentsList();
        Collections.reverse(localComponents);
        // Trigger movements
        localComponents.forEach(component -> component.move(tpsRunner.getAps()));
        // Trigger hover
        Point mouseLocation = getMousePosition();
        if(Objects.nonNull(mouseLocation)){
            Vector2D mouseVector = new Vector2D(mouseLocation.x, mouseLocation.y);
            boolean hoverFound = false;
            for(GameComponent<?> component : localComponents)
                hoverFound = triggerHover(mouseVector, component, hoverFound);
        }
        // Tick all components
        for(GameComponent<?> component : localComponents)
            component.tick(tpsRunner.getAps());
    }

    private List<GameComponent<?>> getReversedComponentsList(){
        List<GameComponent<?>> localComponents = new ArrayList<>();
        gameEngine.getComponentsLock().lock();
        try{
            localComponents.addAll(gameEngine.getComponents());
        }catch (Exception e){
            Main.getLogger().severe(e.getMessage());
        }finally {
            gameEngine.getComponentsLock().unlock();
        }
        return localComponents;
    }

    private boolean triggerHover(Vector2D mouseVector, GameComponent<?> component, boolean hoverFound) {
        Vector2D componentPosition = component.getPosition();
        Vector2D componentSize = component.getSize();
        boolean isMouseBetween = mouseVector.isBetween(componentPosition, Vector2D.add(componentPosition, componentSize));
        if(hoverFound || !isMouseBetween) {
            if(component.isHovered()) {
                Main.getLogger().info("Hover lost on %s".formatted(component.getClass().getSimpleName()));
                component.setIsHovered(false);
                component.onHoverLost();
            }
        }else {
            if(!component.isHovered()) {
                Main.getLogger().info("Hover detected on %s".formatted(component.getClass().getSimpleName()));
                component.setIsHovered(true);
                component.onHover();
            }
            return true;
        }
        return hoverFound;
    }

    @Override
    protected void paintComponent(Graphics g) {
        long start = System.nanoTime();
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        drawComponents(g);
        Point mouseLocation = getMousePosition();
//        if(Objects.nonNull(mouseLocation)){
//            g.setColor(Color.WHITE);
//            g.fillOval(mouseLocation.x - 20, mouseLocation.y - 20, 40, 40);
//        }
        g.setColor(Color.WHITE);
        g.setFont(font);
        if(gameEngine.isDevMode()){
            g.drawString("TPS : %d".formatted(tpsRunner.getCurrentAps()), 10, 50);
            long end = System.nanoTime();
            g.drawString("FPS : %d    %d ms".formatted(fpsRunner.getCurrentAps(), (end - start) / 1000000L), 10, 25);
        }
    }

    private void drawComponents(Graphics g){
        gameEngine.getComponentsLock().lock();
        try{
            gameEngine.getComponents().forEach(component -> component.render(g));
        }catch (Exception e){
            Main.getLogger().severe(e.getMessage());
        }finally {
            gameEngine.getComponentsLock().unlock();
        }
    }
}
