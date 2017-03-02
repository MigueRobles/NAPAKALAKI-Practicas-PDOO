/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Miguel Robles Urquiza & Jesús Sánchez de Lechina Tejada
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
    
    public String getString(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    public BadConsequence getBadConsequence(){
        return badconsequence;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCombatLevel(int level){
        this.combatLevel = level;
    }
    
    public void setPrize(Prize prize){
        this.prize = prize;
    }
    
    public void setBadConsequence(BadConsequence bc){
        this.badconsequence = bc;
    }

    public String toString(){
        return "Monster: " + name + " \nCombat level: " + Integer.toString(combatLevel) + " \nPrize: " + prize.toString() + "\nBad Consequence: " + badconsequence.toString() + "\n";
    }
}
    
