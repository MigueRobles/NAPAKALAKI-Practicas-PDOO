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
    
    public Monster(String name, int level, Prize prize, BadConsequence bc){
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badconsequence = bc;
    }
    
    public String getString(){ return name; }    
    public int getCombatLevel(){ return combatLevel; }    
    public Prize getPrize(){ return prize; }    
    public BadConsequence getBadConsequence(){ return badconsequence; }   
    
    @Override
    public String toString(){
        return "Monster: " + name + " \nCombat level: " + Integer.toString(combatLevel) + " \nPrize: " + prize.toString() + "\nBad Consequence: " + badconsequence.toString() + "\n";
    }
}
    
