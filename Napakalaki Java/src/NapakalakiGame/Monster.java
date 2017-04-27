package NapakalakiGame;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badconsequence;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.badconsequence = bc;
        this.prize = prize;
    }
    
    public String getName(){ return name; }    
    public int getCombatLevel(){ return combatLevel; }    
    public BadConsequence getBadConsequence(){ return badconsequence; }   
    public int getLevelsGained(){ return prize.getLevel(); }    
    public int getTreasuresGained(){ return prize.getTreasures(); }    

    
    @Override
    public String toString(){
        return "Monster: " + name + " \nCombat level: " + Integer.toString(combatLevel) + " \nPrize: " + prize.toString() + "\nBad Consequence: " + badconsequence.toString() + "\n";
    }
}
    