package fr.tyr.game;

import fr.tyr.Main;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.game.enums.MouseButtons;
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
        fpsRunner = new Runner("fps_runner", () -> paintImmediately(getBounds()), 60, false);
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
        // Resize listener and timer
        resizeTimer = new Timer(200, e -> resize());
        resizeTimer.setRepeats(false);
        resizeTimer.setCoalesce(true);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if(resizeTimer.isRunning())
                    resizeTimer.restart();
                else
                    resizeTimer.start();
            }
        });
    }

    private void resize(){
        Vector2D newSize = new Vector2D(getWidth(), getHeight());
        Main.getLogger().info("Window resized to %s".formatted(newSize));
        gameEngine.safeListOperation(components -> components.forEach(component -> component.onWindowResized(newSize)));
    }

    private void onClick(MouseEvent e){
        List<GameComponent<?>> localComponents = getReversedComponentsList();
        Vector2D mouseVector = new Vector2D(e.getX(), e.getY());
        Main.getLogger().info("Click detected at %s with %s button".formatted(mouseVector, MouseButtons.from(e.getButton())));
        for(GameComponent<?> component : localComponents){
            Vector2D componentPosition = component.getPosition();
            Vector2D componentSize = component.getSize();
            boolean isMouseBetween = mouseVector.isBetween(componentPosition, Vector2D.add(componentPosition, componentSize));
            if(isMouseBetween){
                component.onClick(MouseButtons.from(e.getButton()));
                return;
            }
        }
    }

    private void tick(){
        List<GameComponent<?>> localComponents = getReversedComponentsList();
        Thread movingThread = new Thread(() -> localComponents.forEach(component -> component.move(tpsRunner.getAps())));
        Thread hoverThread = new Thread(() -> {
            Point mouseLocation = getMousePosition();
            if (Objects.nonNull(mouseLocation)) {
                Vector2D mouseVector = new Vector2D(mouseLocation.x, mouseLocation.y);
                boolean hoverFound = false;
                for (GameComponent<?> component : localComponents)
                    hoverFound = triggerHover(mouseVector, component, hoverFound);
            }
        });
        Thread tickingThread = new Thread(() -> localComponents.forEach(component -> component.tick(tpsRunner.getAps())));
        movingThread.start();
        hoverThread.start();
        tickingThread.start();
        try {
            movingThread.join();
            hoverThread.join();
            tickingThread.join();
        } catch (InterruptedException e) {
            Main.getLogger().warning("Tick interrupted");
        }
    }

    private List<GameComponent<?>> getReversedComponentsList(){
        List<GameComponent<?>> localComponents = new ArrayList<>();
        gameEngine.safeListOperation(localComponents::addAll);
        Collections.reverse(localComponents);
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
        g.setColor(Color.WHITE);
        g.setFont(font);
        if(gameEngine.isDevMode()){
            g.drawString("TPS : %d".formatted(tpsRunner.getCurrentAps()), 10, 50);
            long end = System.nanoTime();
            g.drawString("FPS : %d    %d ms".formatted(fpsRunner.getCurrentAps(), (end - start) / 1000000L), 10, 25);
        }
    }

    private void drawComponents(Graphics g){
        gameEngine.safeListOperation(components -> components.forEach(component -> component.render(g)));
    }
}
