package fr.tyr.game;

import fr.tyr.Main;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.sample.*;
import fr.tyr.tools.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class GameEngine {

    private final boolean devMode;

    private final ReentrantLock componentsLock = new ReentrantLock();
    private final List<GameComponent<?>> components;

    public GameEngine(boolean devMode){
        Main.getLogger().info("Initializing game engine...");
        this.devMode = devMode;
        this.components = new ArrayList<>();
        this.initScene();
        Main.getLogger().info("Game engine initialized.");
    }

    private void initScene(){
        Main.getLogger().info("Initializing scene...");
        this.componentsLock.lock();
        try{
            this.components.add(new SampleBackgroundComponent());
            this.components.add(new SampleImageComponent(new Vector2D(100, 100), new Vector2D(50, 50)));
            this.components.add(new SampleTextComponent(new Vector2D(200, 200)));
            this.components.add(new SampleAnimatedImageComponent(new Vector2D(300, 300)));
            this.components.add(new SampleAnimatedTextComponent(new Vector2D(400, 400)));
        }catch (Exception e) {
            Main.getLogger().severe(e.getMessage());
        }finally {
            this.componentsLock.unlock();
        }
        Main.getLogger().info("Scene initialized.");
    }

    public boolean isDevMode() {
        return devMode;
    }
    public ReentrantLock getComponentsLock() {
        return componentsLock;
    }
    public List<GameComponent<?>> getComponents() {
        return components;
    }
}
