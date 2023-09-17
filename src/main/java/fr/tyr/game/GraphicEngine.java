package fr.tyr.game;

import fr.tyr.components.GameComponent;
import fr.tyr.tools.Runner;
import fr.tyr.tools.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GraphicEngine extends JPanel {

    public static final Font font = new Font("Roboto", Font.PLAIN, 18);

    private final GameEngine gameEngine;
    private final Runner fpsRunner;
    private final Runner tpsRunner;

    public GraphicEngine(GameEngine gameEngine){
        this.gameEngine = gameEngine;
        this.setBackground(Color.BLACK);
        // Init components
        // Runner setup
        this.fpsRunner = new Runner(() -> {
            this.paintImmediately(this.getBounds());
        }, 60, false);
        this.tpsRunner = new Runner(this::tick, 60, false);
        this.fpsRunner.start();
        this.tpsRunner.start();
        // Click listener
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClick(e);
            }
        });
        // Sound playing
//        Sounds.DING.setVolume(.5f);
//        Sounds.DING.play();
//        Sounds.BACKGROUND.setVolume(.02f);
//        Sounds.BACKGROUND.playBackground();
    }

    private void onClick(MouseEvent event){
        this.gameEngine.getComponentsLock().lock();
        try{
            Vector2D mouseVector = new Vector2D(event.getX(), event.getY());
            List<GameComponent> localComponents = new ArrayList<>(this.gameEngine.getComponents());
            Collections.reverse(localComponents);
            for(GameComponent component : localComponents){
                Vector2D componentPosition = component.getPosition();
                Vector2D componentSize = component.getSize();
                boolean isMouseBetween = mouseVector.isBetween(componentPosition, Vector2D.add(componentPosition, componentSize));
                if(isMouseBetween){
                    component.onClick();
                    return;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.gameEngine.getComponentsLock().unlock();
        }
    }

    private void tick(){
        this.gameEngine.getComponentsLock().lock();
        try{
            List<GameComponent> localComponents = new ArrayList<>(this.gameEngine.getComponents());
            Collections.reverse(localComponents);
            for(GameComponent component : localComponents)
                component.move(this.tpsRunner.getAps());
            Point mouseLocation = this.getMousePosition();
            if(Objects.nonNull(mouseLocation)){
                Vector2D mouseVector = new Vector2D(mouseLocation.x, mouseLocation.y);
                boolean hoverFound = false;
                for(GameComponent component : localComponents)
                    hoverFound = this.triggerHover(mouseVector, component, hoverFound);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.gameEngine.getComponentsLock().unlock();
        }
    }

    private boolean triggerHover(Vector2D mouseVector, GameComponent component, boolean hoverFound) {
        Vector2D componentPosition = component.getPosition();
        Vector2D componentSize = component.getSize();
        boolean isMouseBetween = mouseVector.isBetween(componentPosition, Vector2D.add(componentPosition, componentSize));
        if(hoverFound || !isMouseBetween) {
            if(component.isHovered()) {
                component.setIsHovered(false);
                component.onHoverLost();
            }
        }else {
            if(!component.isHovered()) {
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
        this.drawComponents(g);
        Point mouseLocation = this.getMousePosition();
        if(Objects.nonNull(mouseLocation) && 0 < mouseLocation.x && mouseLocation.x < this.getWidth() && 0 < mouseLocation.y && mouseLocation.y < this.getHeight()){
            g.setColor(Color.WHITE);
            g.fillOval(mouseLocation.x - 20, mouseLocation.y - 20, 40, 40);
        }
        g.setColor(Color.WHITE);
        g.setFont(font);
        if(this.gameEngine.isDevMode()){
            g.drawString("TPS : %d".formatted(this.tpsRunner.getCurrentAps()), 10, 50);
            long end = System.nanoTime();
            g.drawString("FPS : %d    %d ms".formatted(this.fpsRunner.getCurrentAps(), (end - start) / 1000000L), 10, 25);
        }
    }

    private void drawComponents(Graphics g){
        this.gameEngine.getComponentsLock().lock();
        try{
            this.gameEngine.getComponents().forEach(component -> component.render(g));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.gameEngine.getComponentsLock().unlock();
        }
    }

    public void onFocusLost() {
        this.fpsRunner.setAps(10);
    }

    public void onFocusGained() {
        this.fpsRunner.setAps(60);
    }
}
