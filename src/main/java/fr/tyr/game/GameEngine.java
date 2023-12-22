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
import fr.tyr.components.memo.MemoBuilder;
import fr.tyr.components.memo.MemoDirector;
import fr.tyr.components.others.BackgroundComponent;
import fr.tyr.components.others.SwitchButtonCard;
import fr.tyr.components.others.SwitchButtonMemo;
import fr.tyr.components.violence.ViolenceCard;
import fr.tyr.components.violence.ViolenceCardBuilder;
import fr.tyr.components.violence.ViolenceCardDirector;
import fr.tyr.components.violence.enums.Acts;
import fr.tyr.components.violence.enums.Types;
import fr.tyr.resources.images.Images;
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
    private boolean isInViolenceMode = true;

    private final ReentrantLock componentsLock = new ReentrantLock();
    private final List<GameComponent<?>> components;
    private final ReputationGauge reputationGauge = new ReputationGauge(new Vector2D(25, 75));
    private final TimeGauge timeGauge = new TimeGauge(new Vector2D(700, 25));
    private final MoneyGauge moneyGauge = new MoneyGauge(new Vector2D(150, 25));
    private final CharacterSheet characterSheet = new CharacterSheet(new Vector2D(850, 175));

    private final List<Character> members = new ArrayList<>();
    private List<ViolenceCard> inTheHand = new ArrayList<>();

    /**
     * Create a new game engine
     * @param devMode If true, the game engine will be in dev mode
     */
    public GameEngine(boolean devMode){
        Main.getLogger().info("Initializing game engine...");
        this.devMode = devMode;
        components = new ArrayList<>();
        displayGameScene();
//        displayEndScene(true);
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
        generateRandomCharacters(10);
        displayRandomCharacters(5);

        timeGauge.setCurrentProgress(10);
        reputationGauge.setCurrentProgress(85);
        moneyGauge.setMoney(100);
        Main.getLogger().info("Scene initialized.");
    }

    private final TextComponent winStateText = new TextComponent("", Color.BLACK, new Font("Roboto", Font.PLAIN, 80), new Vector2D(500, 100));
    private final TextComponent winStateMessageText = new TextComponent("", Color.BLACK, new Font("Roboto", Font.PLAIN, 25), new Vector2D(325, 175));

    /**
     * Display the end screen
     * @param isWin If true, the player won
     */
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
            componentList.add(new MembersSummary(new Vector2D(525, 250), members.size(), -1));
            componentList.add(new ReputationSummary(new Vector2D(525, 340), reputationGauge.getCurrentProgress()));
            componentList.add(new MoneySummary(new Vector2D(525, 425), moneyGauge.getMoneyCount()));
            componentList.add(new TimeSummary(new Vector2D(525, 475), timeGauge.getDayCount()));
            componentList.add(new RestartButton(new Vector2D(1000, 600)));
        });
        Main.getLogger().info("End screen displayed.");
    }

    public void displayViolenceDeck(){
        this.isInViolenceMode = true;
        hideMemoDeck();
        // Set up of the deck and the reverseButton
        SwitchButtonMemo switchButtonMemo = new SwitchButtonMemo(new Vector2D(25, 575));
        Main.getLogger().severe("Violence card generating");
        generateViolenceCard(4);
        Main.getLogger().severe("Violence card generated");
        // Add of the switchButtonMemo
        safeListOperation(component -> component.add(switchButtonMemo));
    }
    public void hideViolenceDeck(){
        safeListOperation(components -> components.removeIf(component -> component instanceof ViolenceCard || component instanceof SwitchButtonMemo));
    }
    public void displayMemoDeck(){
        this.isInViolenceMode = false;
        hideViolenceDeck();
        // Set up of the deck and the reverseButton
        SwitchButtonCard switchButtonCard = new SwitchButtonCard(new Vector2D(50, 525));
        generateMemos(4);
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
     * @param count The number of characters to generate
     */
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

    private void generateViolenceCard(int count){
        int maxCards = Acts.values().length;
        int i = 0;
        while(i < count && inTheHand.size() < maxCards){
            ViolenceCardBuilder violenceCardBuilder = new ViolenceCardBuilder();
            ViolenceCardDirector violenceCardDirector = new ViolenceCardDirector(violenceCardBuilder);
            violenceCardDirector.generateViolenceCard();
            ViolenceCard violenceCard = violenceCardBuilder.getViolenceCard();
            violenceCard.resize(violenceCard.getSize().getMultiplied(0.75));
            violenceCard.move(new Vector2D(violenceCard.getSize().x + 50 + (violenceCard.getSize().x + 10) * i,720 - (violenceCard.getSize().y / 3 * 2)));
            violenceCard.resize(violenceCard.getSize().getMultiplied(0.95));
            violenceCard.move(new Vector2D(violenceCard.getSize().x + 50 + (violenceCard.getSize().x + 10) * i,720 - (violenceCard.getSize().y / 3 * 2)));
            if(inTheHand.stream().anyMatch(card -> card.getActs() == violenceCard.getActs()))
                continue;
            inTheHand.add((violenceCard));
            safeListOperation(componentList -> componentList.add(violenceCard));
            i++;
        }
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
        Character framedCharacter = characterSheet.getCharacter();
        double multiplier = framedCharacter.getPersonality().Sensitivity(type);
        int dissatisfaction = framedCharacter.getDissatisfaction();
        int damage = violenceCard.getDamage();
        damage *= multiplier;
        dissatisfaction -= damage;
        framedCharacter.setDissatisfaction(dissatisfaction);

        Random rand = new Random();
        int rnd = rand.nextInt(0,100);
        if(rnd >= framedCharacter.getDissatisfaction()){
            getCharacterSheet().hide(true);
            removeMember(framedCharacter);
        }
        try {
            components.remove(violenceCard);
        }
        catch (Exception e){
            Main.getLogger().warning("The applied violence is not in the deck");
        }
    }

    public void applyMemo(Memo memo){
        Character framedCharacter = characterSheet.getCharacter();
        switch(memo.getQuestion().getTarget()){
            case COMMON_PAST_FACTS -> framedCharacter.getPersonality().getPastFact().setCommonPastFactDiscovered(true);
            case GENDER_PAST_FACTS -> framedCharacter.getPersonality().getPastFact().setGenderPastFactDiscovered(true);
            case ORIGIN_PAST_FACTS -> framedCharacter.getPersonality().getPastFact().setOriginPastFactDiscovered(true);
            case SEXUAL_ORIENTATION_PAST_FACTS -> framedCharacter.getPersonality().getPastFact().setSexualOrientationPastFactDiscovered(true);
            case GENDER_THOUGHTS -> framedCharacter.getPersonality().getThoughts().setGenderThoughtsDiscovered(true);
            case ORIGIN_THOUGHTS -> framedCharacter.getPersonality().getThoughts().setOriginThoughtsDiscovered(true);
            case SEXUAL_ORIENTATION_THOUGHTS -> framedCharacter.getPersonality().getThoughts().setSexualOrientationThoughtsDiscovered(true);
        }
        this.getCharacterSheet().updateComponent();
        try {
            components.remove(memo);
        }
        catch (Exception e){
            Main.getLogger().warning("The applied violence is not in the deck");
        }
    }

    public void generateMemos(int count){
        MemoDirector md = new MemoDirector(new MemoBuilder());
        for(int i = 0; i < count; i++){
            md.generateMemo();
            Memo memo = md.getBuilder().getMemo();
            memo.move(new Vector2D(memo.getSize().x + 50 + (memo.getSize().x + 10) * i, 575));
            safeListOperation(componentList -> componentList.add(memo));
        }
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

    public boolean isInViolenceMode() {
        return isInViolenceMode;
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
