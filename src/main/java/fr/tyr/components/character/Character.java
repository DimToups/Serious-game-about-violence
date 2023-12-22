package fr.tyr.components.character;

import fr.tyr.Main;
import fr.tyr.components.character.identity.Identity;
import fr.tyr.components.character.personality.Personality;
import fr.tyr.components.character.style.CharacterStyle;
import fr.tyr.components.character.style.enums.HairColor;
import fr.tyr.components.classic.GameComponent;
import fr.tyr.components.memo.Memo;
import fr.tyr.components.memo.MemoBuilder;
import fr.tyr.components.memo.MemoDirector;
import fr.tyr.components.mixed.ComposedComponent;
import fr.tyr.components.violence.ViolenceCard;
import fr.tyr.components.violence.ViolenceCardBuilder;
import fr.tyr.components.violence.ViolenceCardDirector;
import fr.tyr.components.violence.enums.Acts;
import fr.tyr.game.enums.MouseButtons;
import fr.tyr.resources.images.Images;
import fr.tyr.tools.Vector2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Character extends ComposedComponent{
    // Personality field
    private Personality personality = new Personality();

    //Identity field
    private Identity identity = new Identity();

    //Style fields
    private CharacterStyle characterStyle;
    private HairColor hairColor;
    private Images special;

    //
    private int dissatisfaction = 100;

    // Sheet
    private boolean isFramed = false;

    // Violences and memo cards
    private final List<ViolenceCard> violenceCards = new ArrayList<>();
    private final List<ViolenceCard> generatedViolenceCards = new ArrayList<>();
    private final List<Memo> memos = new ArrayList<>();

    /**
     * Create a Character
     * @param position The position of the component
     */
    public Character(Vector2D position) {
        super(position);
        generateViolenceCards(4);
        generateMemos(4);
    }

    public void generateViolenceCards(int count){
        violenceCards.clear();
        int maxCards = Acts.values().length;
        int i = 0;
        while(i < count && generatedViolenceCards.size() < maxCards){
            ViolenceCardBuilder violenceCardBuilder = new ViolenceCardBuilder();
            ViolenceCardDirector violenceCardDirector = new ViolenceCardDirector(violenceCardBuilder);
            violenceCardDirector.generateViolenceCard();
            ViolenceCard violenceCard = violenceCardBuilder.getViolenceCard();
            violenceCard.resize(violenceCard.getSize().getMultiplied(0.75));
            violenceCard.move(new Vector2D(violenceCard.getSize().x + 50 + (violenceCard.getSize().x + 10) * i,720 - (violenceCard.getSize().y / 3 * 2)));
            violenceCard.resize(violenceCard.getSize().getMultiplied(0.95));
            violenceCard.move(new Vector2D(violenceCard.getSize().x + 50 + (violenceCard.getSize().x + 10) * i,720 - (violenceCard.getSize().y / 3 * 2)));
            if(generatedViolenceCards.stream().anyMatch(card -> card.getActs() == violenceCard.getActs()))
                continue;
            generatedViolenceCards.add((violenceCard));
            violenceCards.add(violenceCard);
            i++;
        }
    }

    public void displayViolenceCards(){
        for(ViolenceCard violenceCard : violenceCards)
            Main.getGameEngine().safeListOperation(componentList -> componentList.add(violenceCard));
    }

    public void hideViolenceCards(){
        for(ViolenceCard violenceCard : violenceCards)
            Main.getGameEngine().safeListOperation(componentList -> componentList.remove(violenceCard));
    }

    public void applyViolenceCard(ViolenceCard violenceCard){
        violenceCards.remove(violenceCard);
        Main.getGameEngine().safeListOperation(componentList -> componentList.remove(violenceCard));
    }

    public void generateMemos(int count){
        memos.clear();
        MemoDirector md = new MemoDirector(new MemoBuilder());
        for(int i = 0; i < count; i++){
            md.generateMemo();
            Memo memo = md.getBuilder().getMemo();
            memos.add(memo);
            memo.move(new Vector2D(memo.getSize().x + 50 + (memo.getSize().x + 10) * i, 575));
        }
    }

    public void displayMemos(){
        for(Memo memo : memos)
            Main.getGameEngine().safeListOperation(componentList -> componentList.add(memo));
    }

    public void hideMemos(){
        for(Memo memo : memos)
            Main.getGameEngine().safeListOperation(componentList -> componentList.remove(memo));
    }

    public void applyMemo(Memo memo){
        memos.remove(memo);
        Main.getGameEngine().safeListOperation(componentList -> componentList.remove(memo));
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }
    public int getDissatisfaction(){
        return this.dissatisfaction;
    }
    public void setDissatisfaction(int dissatisfaction){
        this.dissatisfaction = dissatisfaction;
    }


    /**
     * Send the Character's Skin
     * @return The Character's Skin
     */
    public CharacterStyle getCharacterStyle(){
        return this.characterStyle;
    }


    public void setCharacterStyle(CharacterStyle characterStyle){
        this.characterStyle = characterStyle;
        characterStyle.assemble(getPosition());
        List<GameComponent<?>> components = new ArrayList<>();
        components.add(characterStyle.getSkin());
        components.add(characterStyle.getShirt());
        components.add(characterStyle.getEyes());
        components.add(characterStyle.getHair());
        if(Objects.nonNull(characterStyle.getAdditionalComponent()))
            components.add(characterStyle.getAdditionalComponent());
        this.setFrame(components);
    }

    /**
     * Send the Character's HairColor
     * @return The Character's HairColor
     */
    public HairColor getHairColor(){
        return this.hairColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public void resize(Vector2D size) {
        super.resize(size);
    }

    @Override
    public void onClick(MouseButtons button) {
        if(isFramed)
            return;
        if(button != MouseButtons.LEFT)
            return;
        if(isHovered())
            onHoverLost();
        Main.getLogger().info("Showing character sheet...");
        Main.getGameEngine().getCharacterSheet().show(this);
        Main.getGameEngine().displayViolenceDeck();
    }

    public void setFramed(boolean framed) {
        isFramed = framed;
    }

    private Vector2D baseSize;

    @Override
    public void onHover() {
        super.onHover();
        if(isFramed) return;
        if(isMoving()) return;
        baseSize = new Vector2D(getSize());
        resize(baseSize.getMultiplied(1.1));
        Vector2D difference = baseSize.getMultiplied(1.1).getSubtracted(baseSize);
        move(getPosition().getSubtracted(difference.getMultiplied(0.5)));
    }

    @Override
    public void onHoverLost() {
        super.onHoverLost();
        if(isFramed) return;
        if(isMoving()) return;
        if(Objects.isNull(baseSize)) return;
        Vector2D difference = getSize().getSubtracted(baseSize);
        resize(baseSize);
        move(getPosition().getAdded(difference.getMultiplied(0.5)));
    }

    @Override
    public void tick(int aps) {
        super.tick(aps);
        if(isFramed) return;
        if(isMoving()) return;
        // Random character movement
        Random random = new Random();
        if(random.nextInt(200) == 0){
            if(isHovered())
                onHoverLost();
            Vector2D nextPosition = Main.getGameEngine().getRandomCharacterPosition();
            double distance = nextPosition.distance(getPosition());
            float duration = (float) (distance / 100);
            moveTo(nextPosition, duration);
        }
    }
}
