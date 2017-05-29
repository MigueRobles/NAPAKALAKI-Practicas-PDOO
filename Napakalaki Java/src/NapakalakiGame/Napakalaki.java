package NapakalakiGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */

public class Napakalaki {   
    
    private static Napakalaki instance = null;
    private Monster currentMonster;
    private CardDealer dealer = new CardDealer();
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    private Napakalaki() {
        currentMonster= null;
        dealer = CardDealer.getInstance();
        currentPlayer=null;
        players=new ArrayList();
    }
    
    private void initPlayers(ArrayList<String> names) {
        for (String s: names) {            
            players.add(new Player(s));
        }
    
    }
    
    private Player nextPlayer() {
        int i;
        if(currentPlayer == null) {      
        i = (int) (Math.random() * (players.size()));
        currentPlayer = players.get(i);
        return players.get(i);
        }        
        else{ 
            i = players.indexOf(currentPlayer);
            if(i == players.size() - 1)
                i = -1;
            currentPlayer = players.get(i+1);
        }
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed() {
    if(currentPlayer == null) {         
        return true;
    }
    else
        return currentPlayer.validState();
    }   
    
private void setEnemies(){
        int indice;
        
        for(int i=0; i<players.size(); i++){
            indice = (int) (Math.random()*players.size()-1);
            
            if(indice==i)
                indice = players.size()-1;
            players.get(i).setEnemy(players.get(indice));
        }
    }

    
    

    public static Napakalaki getInstance() {
        if (instance == null)
            instance = new Napakalaki();
        return instance;
    }

    @Override
    public String toString() {
        return "CurrentMonster:" + currentMonster + "\n Dealer: " + dealer + "\n CurrentPlayer: " + currentPlayer + "\n Players:" + players + '}';
    }    
    
    public void discardVisibleTreasures(ArrayList<Treasure> Treasures) {
        for(Treasure treasure:Treasures) {
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }    
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        for(Treasure treasure:treasures) {
            currentPlayer.discardHiddenTreasure(treasure);  
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public CombatResult developCombat() {
        CombatResult result = currentPlayer.combat(currentMonster);
        
        if(result == CombatResult.LOSEANDCONVERT){
            Cultist cultistCard = dealer.nextCultist();
            CultistPlayer cultist = new CultistPlayer(currentPlayer, cultistCard);
            players.add(players.indexOf(currentPlayer), cultist);
            players.remove(currentPlayer);
            
            for(Player p:players){
                if(p.getEnemy() == currentPlayer)
                    p.setEnemy(cultist);
            }
            
            currentPlayer = cultist;
        }
        dealer.giveMonsterBack(currentMonster);
        return result;
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        for(Treasure treasure:treasures) {
            currentPlayer.makeTreasureVisible(treasure);
        }
    } 
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
    public boolean endOfGame(CombatResult result) {
        return result == CombatResult.WINGAME;
    
    }
    
    public boolean nextTurn() {
        boolean stateOK = nextTurnAllowed();
       
        if(stateOK) {
           currentMonster = dealer.nextMonster();
           currentPlayer = nextPlayer();

           if(currentPlayer.isDead())
            currentPlayer.initTreasures();
        }
        
        if(!stateOK){
            System.out.println("\nMal rollo pendiente:");
            this.currentPlayer.checkPending();
            
        }
  
       return stateOK;
    }
    
    public void initGame(ArrayList<String> players) {
        dealer.initCards();
        initPlayers(players);
        setEnemies();
        nextTurn();   
    }

    
}
