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
import fr.tyr.components.memo.Memo;
import fr.tyr.components.others.BackgroundComponent;
import fr.tyr.components.others.SwitchButtonCard;
import fr.tyr.components.others.SwitchButtonMemo;
import fr.tyr.components.violence.ViolenceCard;
import fr.tyr.components.violence.enums.Types;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class GameEngine {

    private static final int MAX_MEMBERS = 10;

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
     * Display the game scene
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
        generateRandomCharacters();
        displayRandomCharacters(5);

        timeGauge.setCurrentProgress(10);
        timeGauge.setDayCount(0);
        reputationGauge.setCurrentProgress(85);
        moneyGauge.setMoney(100);
        Main.getLogger().info("Scene initialized.");
    }

    private final TextComponent winStateText = new TextComponent("", Color.BLACK, new Font("Roboto", Font.PLAIN, 80), new Vector2D(500, 100));
    private final TextComponent winStateMessageText = new TextComponent("", Color.BLACK, new Font("Roboto", Font.PLAIN, 25), new Vector2D(325, 175));
    private final TextComponent scoreText = new TextComponent("", Color.BLACK, new Font("Roboto", Font.PLAIN, 25), new Vector2D(550, 600));

    /**
     * Display the end screen
     * @param isWin If true, the player won
     */
    public void displayEndScene(boolean isWin){
        Main.getLogger().info("Displaying end screen...");
        characterSheet.hide(false);
        safeListOperation(componentList -> {
            componentList.clear();
            String winOrLose = isWin ? "Gagné" : "Perdu";
            String winOrLoseMessage = isWin ? "Tu as réussi à passer sous les radars de la police !" : "Tu as perdu !";
            winStateText.setText(winOrLose);
            winStateMessageText.setText(winOrLoseMessage);
            componentList.add(new BackgroundComponent(Images.END_BACKGROUND));
            componentList.add(winStateText);
            componentList.add(winStateMessageText);
            componentList.add(new MembersSummary(new Vector2D(525, 250), members.size(), MAX_MEMBERS));
            componentList.add(new ReputationSummary(new Vector2D(525, 340), reputationGauge.getCurrentProgress()));
            componentList.add(new MoneySummary(new Vector2D(525, 425), moneyGauge.getMoneyCount()));
            componentList.add(new TimeSummary(new Vector2D(525, 475), timeGauge.getDayCount()));
            componentList.add(new RestartButton(new Vector2D(1000, 600)));
            int score = timeGauge.getDayCount() * 200 + moneyGauge.getMoneyCount() + reputationGauge.getCurrentProgress() * 10 - members.size() * 1000;
            scoreText.setText("Score : %d".formatted(score));
            componentList.add(scoreText);
        });
        Main.getLogger().info("End screen displayed.");
    }

    public void displayViolenceDeck(){
        hideMemoDeck();
        // Set up of the deck and the reverseButton
        SwitchButtonMemo switchButtonMemo = new SwitchButtonMemo(new Vector2D(25, 575));
        characterSheet.getCharacter().displayViolenceCards();
        // Add of the switchButtonMemo
        safeListOperation(component -> component.add(switchButtonMemo));
    }
    public void hideViolenceDeck(){
        safeListOperation(components -> components.removeIf(component -> component instanceof ViolenceCard || component instanceof SwitchButtonMemo));
    }
    public void displayMemoDeck(){
        hideViolenceDeck();
        // Set up of the deck and the reverseButton
        SwitchButtonCard switchButtonCard = new SwitchButtonCard(new Vector2D(50, 525));
        characterSheet.getCharacter().displayMemos();
        // Add of the switchButtonMemo
        safeListOperation(component -> component.add(switchButtonCard));
    }
    public void hideMemoDeck(){
        safeListOperation(components -> components.removeIf(component -> component instanceof Memo || component instanceof SwitchButtonCard));
    }

    /**
     * Display random characters on the screen from the members list
     * @param count The number of characters to display
     */
    private void displayRandomCharacters(int count){
        Random random = new Random();
        clearCharacters();
        safeListOperation(componentList -> {
            for(int i = 0; i < count; i++){
                Character member = members.get(random.nextInt(members.size()));
                while(componentList.contains(member))
                    member = members.get(random.nextInt(members.size()));
                member.move(getRandomCharacterPosition());
                componentList.add(member);
            }
            componentList.remove(characterSheet);
            componentList.add(characterSheet);
        });
    }

    /**
     * Generate random characters to members list
     */
    private void generateRandomCharacters(){
        Random random = new Random();
        for(int i = 0; i < MAX_MEMBERS; i++){
            boolean isMale = random.nextBoolean();
            CharacterBuilder characterBuilder = isMale ? new MaleBuilder() : new FemaleBuilder();
            CharacterDirector characterDirector = new CharacterDirector(characterBuilder);
            characterDirector.generateCharacter();
            Character character = characterBuilder.getCharacter();
            character.resize(character.getSize().getMultiplied(0.3));
            character.move(getRandomCharacterPosition());
            members.add(character);
        }
    }

    /**
     * Remove a member from the member list
     * @param member The member to remove
     */
    private void removeMember(Character member){
        safeListOperation(componentList -> {
            componentList.remove(member);
            members.remove(member);
        });
    }

    /**
     * Clear characters from the active components list
     */
    private void clearCharacters(){
        safeListOperation(componentList -> componentList.removeIf(component -> component instanceof Character));
    }

    private void removeViolenceCard(ViolenceCard violenceCard){
        safeListOperation(componentList -> {
            componentList.remove(violenceCard);
        });
    }
    private void clearViolenceCard(){
        safeListOperation(componentList -> componentList.removeIf(component -> component instanceof ViolenceCard));
    }
    public void applyViolence(ViolenceCard violenceCard){
        Types type = violenceCard.getType();
        Character character = characterSheet.getCharacter();
        if(Objects.isNull(character))
            hideViolenceDeck();
        double multiplier = character.getPersonality().Sensitivity(type);
        int dissatisfaction = character.getDissatisfaction();
        int damage = violenceCard.getDamage();
        damage *= multiplier;
        dissatisfaction -= damage;
        character.setDissatisfaction(dissatisfaction);

        // Gauges repercussions
        int moneyImpact = 0;
        if(violenceCard.getType().equals(Types.ECONOMICAL))
            moneyImpact = this.members.size() * 100;
        impactGauges(-10, 20, moneyImpact);

        Random rand = new Random();
        int rnd = rand.nextInt(0,100);
        if(rnd >= character.getDissatisfaction()){
            getCharacterSheet().hide(false);
            removeMember(character);
            impactGauges(0, 0, -1000);
        }
        character.applyViolenceCard(violenceCard);
    }

    public void applyMemo(Memo memo){
        Character character = characterSheet.getCharacter();
        switch(memo.getQuestion().getTarget()){
            case COMMON_PAST_FACTS -> character.getPersonality().getPastFact().setCommonPastFactDiscovered(true);
            case GENDER_PAST_FACTS -> character.getPersonality().getPastFact().setGenderPastFactDiscovered(true);
            case ORIGIN_PAST_FACTS -> character.getPersonality().getPastFact().setOriginPastFactDiscovered(true);
            case SEXUAL_ORIENTATION_PAST_FACTS -> character.getPersonality().getPastFact().setSexualOrientationPastFactDiscovered(true);
            case GENDER_THOUGHTS -> character.getPersonality().getThoughts().setGenderThoughtsDiscovered(true);
            case ORIGIN_THOUGHTS -> character.getPersonality().getThoughts().setOriginThoughtsDiscovered(true);
            case SEXUAL_ORIENTATION_THOUGHTS -> character.getPersonality().getThoughts().setSexualOrientationThoughtsDiscovered(true);
        }
        this.getCharacterSheet().updateComponent();
        character.applyMemo(memo);
        impactGauges(5, 20, 0);
    }

    public void impactGauges(int reputationImpact, int timeImpact, int moneyImpact){
        reputationGauge.addProgress(reputationImpact);
        if(reputationGauge.getCurrentProgress() == 0 || reputationGauge.getCurrentProgress() == 100){
            displayEndScene(false);
            return;
        }
        moneyGauge.addMoney(moneyImpact);
        if(moneyGauge.getMoneyCount() <= 0)
            displayEndScene(false);
        else if(timeGauge.addTime(timeImpact))
            nextDay();
        else if(timeGauge.getDayCount() == 5)
            displayEndScene(true);
        else if(members.isEmpty())
            displayEndScene(true);
    }

    public void nextDay(){
        hideViolenceDeck();
        hideMemoDeck();
        characterSheet.hide(false);
        members.forEach(character -> {
            character.generateViolenceCards(4);
            character.generateMemos(4);
        });
        displayRandomCharacters(5);
        impactGauges(0, 0, members.size() * 100);
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

    /**
     * Get a random valid position for a character
     * @return The random position as a Vector2D
     */
    public Vector2D getRandomCharacterPosition(){
        Random random = new Random();
        int x = random.nextInt(800) + 80;
        int y = random.nextInt(150) + 275;
        return new Vector2D(x, y);
    }
}
