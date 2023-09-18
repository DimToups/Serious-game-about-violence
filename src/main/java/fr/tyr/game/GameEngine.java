package fr.tyr.game;

import fr.tyr.components.GameComponent;
import fr.tyr.components.ImageComponent;
import fr.tyr.images.Images;
import fr.tyr.tools.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class GameEngine {

    private final boolean devMode;

    private final ReentrantLock componentsLock = new ReentrantLock();
    private final List<GameComponent> components;

    public GameEngine(boolean devMode){
        this.devMode = devMode;
        this.components = new ArrayList<>();
        this.initScene();
    }

    private void initScene(){
        this.componentsLock.lock();
        try{
            this.components.add(new ImageComponent(new Vector2D(100, 100), Images.SWORDS, 50, 50));
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.componentsLock.unlock();
        }
    }

    public boolean isDevMode() {
        return devMode;
    }
    public ReentrantLock getComponentsLock() {
        return componentsLock;
    }
    public List<GameComponent> getComponents() {
        return components;
    }
}
