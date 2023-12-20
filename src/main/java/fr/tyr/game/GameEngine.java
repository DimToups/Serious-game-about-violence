package fr.tyr.game;

import fr.tyr.Main;
import fr.tyr.components.character.*;
import fr.tyr.components.character.Character;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.gauges.ReputationGauge;
import fr.tyr.components.gauges.TimeGauge;
import fr.tyr.components.sample.*;
import fr.tyr.tools.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class GameEngine {

    private final boolean devMode;

    private final ReentrantLock componentsLock = new ReentrantLock();
    private final List<GameComponent<?>> components;
    private final CharacterSheet characterSheet = new CharacterSheet(new Vector2D(200, 300));

    /**
     * Create a new game engine
     * @param devMode If true, the game engine will be in dev mode
     */
    public GameEngine(boolean devMode){
        Main.getLogger().info("Initializing game engine...");
        this.devMode = devMode;
        components = new ArrayList<>();
        initScene();
        Main.getLogger().info("Game engine initialized.");
    }

    /**
     * Initialize the scene with the components
     */
    private void initScene(){
        Main.getLogger().info("Initializing scene...");
        safeListOperation(componentList -> {
            componentList.add(new SampleBackgroundComponent());
            //componentList.add(new SampleImageComponent(new Vector2D(100, 100), new Vector2D(50, 50)));
            //componentList.add(new SampleTextComponent(new Vector2D(200, 200)));
            //componentList.add(new SampleAnimatedImageComponent(new Vector2D(300, 300)));
            //componentList.add(new SampleAnimatedTextComponent(new Vector2D(400, 400)));

            FemaleBuilder femaleBuilder = new FemaleBuilder();
            CharacterDirector characterDirector = new CharacterDirector(femaleBuilder);
            characterDirector.generateCharacter();
            Character maleCharacter = femaleBuilder.getFemale();
            maleCharacter.resize(new Vector2D(200, 200));
            maleCharacter.resize(new Vector2D(200, 200));
            maleCharacter.move(new Vector2D(50, 50));
            componentList.add(maleCharacter);

            componentList.add(new ReputationGauge(new Vector2D(500, 200)));
            componentList.add(new TimeGauge(new Vector2D(700, 200)));
            componentList.add(characterSheet);
            characterSheet.show(maleCharacter);
        });
        Main.getLogger().info("Scene initialized.");
    }

    /**
     * Add a component to the game engine
     * Protect the list against concurrent modification
     * @param operation The operation to execute on the list
     */
    public void safeListOperation(Consumer<List<GameComponent<?>>> operation){
        componentsLock.lock();
        try{
            operation.accept(components);
        }catch (Exception e){
            Main.getLogger().severe(e.getMessage());
        }finally {
            componentsLock.unlock();
        }
    }

    public boolean isDevMode() {
        return devMode;
    }
}
