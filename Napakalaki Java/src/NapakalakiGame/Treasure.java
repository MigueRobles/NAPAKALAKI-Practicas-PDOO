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
    /*
    public Treasure(Treasure t){
        this.name = t.getName();
        this.bonus = t.getBonus();
        this.treasurekind = t.getType();
    }
    */
    public String getName(){ return name; }    
    public int getBonus(){ return bonus; }    
    public TreasureKind getType(){ return treasurekind; }
    
     @Override
    public String toString() {
        return "Treasure: "  + name + " Type: " + bonus + " Bonus: " + treasurekind + '\n';
    }
}
