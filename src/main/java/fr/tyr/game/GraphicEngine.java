package fr.tyr.game;

import fr.tyr.Main;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.tools.Runner;
import fr.tyr.tools.STimer;
import fr.tyr.tools.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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

    private final Timer resizeTimer;

    private long lastTickTime;

    private static Vector2D windowSize;

    /**
     * Create a new graphic engine
     * @param gameEngine The game engine
     */
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
        windowSize = new Vector2D(getWidth(), getHeight());
    }

    /**
     * Call the resize event on all components
     */
    private void resize(){
        Vector2D newSize = new Vector2D(getWidth(), getHeight());
        windowSize = newSize;
        Main.getLogger().info("Window resized to %s".formatted(newSize));
        gameEngine.safeListOperation(components ->
                components.forEach(component -> component.onWindowResized(new Vector2D(newSize))));
    }

    /**
     * Call the click event on the component that is clicked
     * @param e The mouse event
     */
    private void onClick(MouseEvent e){
        List<GameComponent<?>> localComponents = getReversedComponentsList();
        Vector2D mouseVector = new Vector2D(e.getX(), e.getY());
        Main.getLogger().info("Click detected at %s with %s button"
                .formatted(mouseVector, MouseButtons.from(e.getButton())));
        for(GameComponent<?> component : localComponents.stream().filter(GameComponent::isVisible).toList()){
            Vector2D componentPosition = component.getPosition();
            Vector2D componentSize = component.getSize();
            boolean isMouseBetween = mouseVector.isBetween(
                    componentPosition,
                    Vector2D.add(componentPosition, componentSize));
            if(isMouseBetween){
                component.onClick(MouseButtons.from(e.getButton()));
                return;
            }
        }
    }

    /**
     * Call the tick event on all components every ticks (60 times per second)
     */
    private void tick(){
        long timerId = STimer.start();
        List<GameComponent<?>> localComponents = getReversedComponentsList();
        Thread movingThread = Thread.ofVirtual().start(() -> {
            List<Thread> threads = new ArrayList<>();
            for(GameComponent<?> component : localComponents)
                threads.add(Thread.ofVirtual().start(() -> component.move(tpsRunner.getAps())));
            try{
                for (Thread thread : threads)
                    thread.join();
            }catch (InterruptedException e){
                Main.getLogger().warning("Tick interrupted");
            }
        });
        Thread hoverThread = Thread.ofVirtual().start(() -> {
            Point mouseLocation = getMousePosition();
            if (Objects.nonNull(mouseLocation)) {
                Vector2D mouseVector = new Vector2D(mouseLocation.x, mouseLocation.y);
                boolean hoverFound = false;
                for (GameComponent<?> component : localComponents.stream().filter(GameComponent::isVisible).toList())
                    hoverFound = triggerHover(mouseVector, component, hoverFound);
            }
        });
        Thread tickingThread = Thread.ofVirtual().start(() -> {
            List<Thread> threads = new ArrayList<>();
            for(GameComponent<?> component : localComponents)
                threads.add(Thread.ofVirtual().start(() -> component.tick(tpsRunner.getAps())));
            try{
                for (Thread thread : threads)
                    thread.join();
            } catch (InterruptedException e) {
                Main.getLogger().warning("Tick interrupted");
            }
        });
        Thread componentOptimizerThread = Thread.ofVirtual().start(this::updateRenderedComponents);
        try {
            movingThread.join();
            hoverThread.join();
            tickingThread.join();
            componentOptimizerThread.join();
        } catch (InterruptedException e) {
            Main.getLogger().warning("Tick interrupted");
        }
        lastTickTime = STimer.stop(timerId);
    }

    /**
     * Check if a component is under another component
     * @param bottomComponent The bottom component
     * @param topComponent The top component
     * @return If the bottom component is under the top component
     */
    private boolean isComponentIsUnder(GameComponent<?> bottomComponent, GameComponent<?> topComponent){
        Vector2D bottomComponentPosition = bottomComponent.getPosition();
        Vector2D bottomComponentSize = bottomComponent.getSize();
        Vector2D topComponentPosition = topComponent.getPosition();
        Vector2D topComponentSize = topComponent.getSize();
        return bottomComponentPosition.isBetween(topComponentPosition, Vector2D.add(topComponentPosition, topComponentSize))
                || Vector2D.add(bottomComponentPosition, bottomComponentSize).isBetween(topComponentPosition, Vector2D.add(topComponentPosition, topComponentSize));
    }

    /**
     * Update the rendered state of all components
     * Make a hidden component not rendered at all
     */
    private void updateRenderedComponents(){
        gameEngine.safeListOperation(components -> {
            List<Thread> threads = new ArrayList<>();
            for(int i = 0; i < components.size(); i++) {
                int finalI = i;
                threads.add(Thread.ofVirtual().start(() -> {
                    GameComponent<?> bottomComponent = components.get(finalI);
                    for(int j = finalI + 1; j < components.size(); j++){
                        GameComponent<?> topComponent = components.get(j);
                        if(isComponentIsUnder(bottomComponent, topComponent)){
                            bottomComponent.setRendered(false);
                            break;
                        }
                    }
                    bottomComponent.setRendered(true);
                }));
            }
            try{
                for (Thread thread : threads)
                    thread.join();
            }catch(InterruptedException e){
                Main.getLogger().warning("Tick interrupted");
            }
        });
    }

    /**
     * Get the list of components in reverse order
     * @return The list of components in reverse order
     */
    private List<GameComponent<?>> getReversedComponentsList(){
        List<GameComponent<?>> localComponents = new ArrayList<>();
        gameEngine.safeListOperation(localComponents::addAll);
        Collections.reverse(localComponents);
        return localComponents;
    }

    /**
     * Trigger the hover event on the component if the mouse is on it
     * @param mouseVector The mouse location as a 2d vector
     * @param component The component
     * @param hoverFound If a component is hovered
     * @return If a component is hovered
     */
    private boolean triggerHover(Vector2D mouseVector, GameComponent<?> component, boolean hoverFound) {
        Vector2D componentPosition = component.getPosition();
        Vector2D componentSize = component.getSize();
        boolean isMouseBetween = mouseVector.isBetween(
                componentPosition,
                Vector2D.add(componentPosition, componentSize));
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

    /**
     * Paint the components on the screen
     * @param g The graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        long timerId = STimer.startNano();
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        drawComponents(g);
        g.setColor(Color.WHITE);
        g.setFont(font);
        if(gameEngine.isDevMode()){
            g.drawString("TPS : %d    %d ms".formatted(tpsRunner.getCurrentAps(), lastTickTime / 1000000L), 10, 50);
            g.drawString("FPS : %d    %d ms"
                    .formatted(fpsRunner.getCurrentAps(), STimer.stopNano(timerId) / 1000000L), 10, 25);
        }
    }

    /**
     * Draw all components
     * @param g The graphics object
     */
    private void drawComponents(Graphics g){
        gameEngine.safeListOperation(components ->
                components.stream().filter(fn -> fn.isVisible() && fn.isRendered()).forEach(component -> component.render(g)));
    }

    public Runner getFpsRunner() {
        return fpsRunner;
    }
    public Runner getTpsRunner() {
        return tpsRunner;
    }

    public static Vector2D getWindowSize() {
        return windowSize;
    }
}
