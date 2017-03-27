package NapakalakiGame;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
class Treasure {
    private String name;
    private int bonus;
    private TreasureKind treasurekind;
    
    public Treasure(String name, int bonus, TreasureKind t){
        this.name = name;
        this.bonus = bonus;
        this.treasurekind = t;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getBonus(){
        return this.bonus;
    }
    
    public TreasureKind getType(){
        return this.treasurekind;
    }
}
