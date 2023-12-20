package fr.tyr.game;

import fr.tyr.Main;
import fr.tyr.components.character.Character;
import fr.tyr.components.character.*;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.gauges.ReputationGauge;
import fr.tyr.components.gauges.TimeGauge;
import fr.tyr.components.sample.SampleBackgroundComponent;
import fr.tyr.tools.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class GameEngine {

    private final boolean devMode;

    private boolean isEnded = false;

    private final ReentrantLock componentsLock = new ReentrantLock();
    private final List<GameComponent<?>> components;
    private final ReputationGauge reputationGauge = new ReputationGauge(new Vector2D(25, 75));
    private final TimeGauge timeGauge = new TimeGauge(new Vector2D(700, 25));
    private final CharacterSheet characterSheet = new CharacterSheet(new Vector2D(850, 175));

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
            // Production components
            componentList.add(new SampleBackgroundComponent());
            componentList.add(reputationGauge);
            componentList.add(timeGauge);
            componentList.add(characterSheet);

            // Dev components
//            FemaleBuilder femaleBuilder = new FemaleBuilder();
//            CharacterDirector characterDirector = new CharacterDirector(femaleBuilder);
//            characterDirector.generateCharacter();
//            Character maleCharacter = femaleBuilder.getFemale();
//            maleCharacter.resize(new Vector2D(200, 200));
//            maleCharacter.resize(new Vector2D(200, 200));
//            maleCharacter.move(new Vector2D(50, 50));
//            componentList.add(maleCharacter);
//
//            characterSheet.show(maleCharacter);
        });
        generateRandomCharacters(5);
        timeGauge.setCurrentProgress(10);
        reputationGauge.setCurrentProgress(85);
        Main.getLogger().info("Scene initialized.");
    }

    private void generateRandomCharacters(int count){
        Random random = new Random();
        for(int i = 0; i < count; i++){
            boolean isMale = random.nextBoolean();
            CharacterBuilder characterBuilder = isMale ? new MaleBuilder() : new FemaleBuilder();
            CharacterDirector characterDirector = new CharacterDirector(characterBuilder);
            characterDirector.generateCharacter();
            Character character = characterBuilder.getCharacter();
            character.resize(character.getSize().getMultiplied(0.3));
            int x = random.nextInt(625) + 80;
            int y = random.nextInt(175) + 325;
            character.move(new Vector2D(x, y));
            safeListOperation(componentList -> componentList.add(character));
        }
    }

    private void clearCharacters(){
        safeListOperation(componentList -> {
            componentList.removeIf(component -> component instanceof Character);
        });
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

    public boolean isEnded() {
        return isEnded;
    }

    public ReputationGauge getReputationGauge() {
        return reputationGauge;
    }

    public TimeGauge getTimeGauge() {
        return timeGauge;
    }

    public CharacterSheet getCharacterSheet() {
        return characterSheet;
    }
}
