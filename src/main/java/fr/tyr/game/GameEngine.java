package fr.tyr.game;

import fr.tyr.Main;
import fr.tyr.components.character.Character;
import fr.tyr.components.character.*;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.classic.TextComponent;
import fr.tyr.components.end.*;
import fr.tyr.components.gauges.MoneyGauge;
import fr.tyr.components.gauges.ReputationGauge;
import fr.tyr.components.gauges.TimeGauge;
import fr.tyr.components.others.BackgroundComponent;
import fr.tyr.resources.images.Images;
import fr.tyr.components.violence.ViolenceCard;
import fr.tyr.components.violence.ViolenceCardBuilder;
import fr.tyr.components.violence.ViolenceCardDirector;
import fr.tyr.tools.Vector2D;

import java.awt.*;
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
    private final MoneyGauge moneyGauge = new MoneyGauge(new Vector2D(150, 25));
    private final CharacterSheet characterSheet = new CharacterSheet(new Vector2D(850, 175));

    private final List<Character> members = new ArrayList<>();

    /**
     * Create a new game engine
     * @param devMode If true, the game engine will be in dev mode
     */
    public GameEngine(boolean devMode){
        Main.getLogger().info("Initializing game engine...");
        this.devMode = devMode;
        components = new ArrayList<>();
        displayGameScene();
        displayEndScene(true);
        Main.getLogger().info("Game engine initialized.");
    }

    /**
     * Initialize the scene with the components
     */
    public void displayGameScene(){
        Main.getLogger().info("Initializing scene...");
        members.clear();
        safeListOperation(componentList -> {
            componentList.clear();
            // Production components
            componentList.add(new BackgroundComponent(Images.BACKGROUND));
            componentList.add(reputationGauge);
            componentList.add(timeGauge);
            componentList.add(moneyGauge);
            componentList.add(characterSheet);
        });
        generateRandomCharacters(10);
        displayRandomCharacters(5);

        timeGauge.setCurrentProgress(10);
        reputationGauge.setCurrentProgress(85);
        moneyGauge.setMoney(100);
        Main.getLogger().info("Scene initialized.");
        generateViolenceCard(4);
    }

    private final TextComponent winStateText = new TextComponent("", Color.BLACK, new Font("Roboto", Font.PLAIN, 80), new Vector2D(500, 100));
    private final TextComponent winStateMessageText = new TextComponent("", Color.BLACK, new Font("Roboto", Font.PLAIN, 25), new Vector2D(325, 175));

    public void displayEndScene(boolean isWin){
        Main.getLogger().info("Displaying end screen...");
        safeListOperation(componentList -> {
            componentList.clear();
            String winOrLose = isWin ? "Gagné" : "Perdu";
            String winOrLoseMessage = isWin ? "Tu as réussi à passer sous les radars de la police !" : "Tu as perdu !";
            winStateText.setText(winOrLose);
            winStateMessageText.setText(winOrLoseMessage);
            componentList.add(new BackgroundComponent(Images.END_BACKGROUND));
            componentList.add(winStateText);
            componentList.add(winStateMessageText);
            componentList.add(new MembersSummary(new Vector2D(525, 250), members.size(), 100));
            componentList.add(new ReputationSummary(new Vector2D(525, 340), reputationGauge.getCurrentProgress()));
            componentList.add(new MoneySummary(new Vector2D(525, 425), moneyGauge.getMoneyCount()));
            componentList.add(new TimeSummary(new Vector2D(525, 475), timeGauge.getDayCount()));
            componentList.add(new RestartButton(new Vector2D(1000, 600)));
        });
        Main.getLogger().info("End screen displayed.");
    }

    private void displayRandomCharacters(int count){
        Random random = new Random();
        clearCharacters();
        safeListOperation(componentList -> {
            for(int i = 0; i < count; i++){
                Character member = members.get(random.nextInt(members.size()));
                while(componentList.contains(member))
                    member = members.get(random.nextInt(members.size()));
                // Set random position
                int x = random.nextInt(625) + 80;
                int y = random.nextInt(175) + 325;
                member.move(new Vector2D(x, y));
                componentList.add(member);
            }
        });
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
            members.add(character);
        }
    }

    private void removeMember(Character member){
        safeListOperation(componentList -> {
            componentList.remove(member);
            members.remove(member);
        });
    }

    private void clearCharacters(){
        safeListOperation(componentList -> {
            componentList.removeIf(component -> component instanceof Character);
        });
    }

    private void generateViolenceCard(int count){
        double j = 0;
        for(int i = 0; i < count; i++){
            ViolenceCardBuilder violenceCardBuilder = new ViolenceCardBuilder();
            ViolenceCardDirector violenceCardDirector = new ViolenceCardDirector(violenceCardBuilder);
            violenceCardDirector.generateViolenceCard();
            ViolenceCard violenceCard = violenceCardBuilder.getViolenceCard();
            violenceCard.resize(violenceCard.getSize().getMultiplied(0.95));
            violenceCard.move(new Vector2D(50 + j,720 - (violenceCard.getSize().y/3 * 2)));
            j += 10 + violenceCard.getSize().x ;
            safeListOperation(componentList -> componentList.add(violenceCard));
        }
    }
    private void clearViolenceCard(){
        safeListOperation(componentList -> componentList.removeIf(component -> component instanceof ViolenceCard));
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
