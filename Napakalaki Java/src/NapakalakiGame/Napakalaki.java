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
    
    private void setEnemies() {
    ArrayList<Player> pl = players;
    Collections.shuffle(pl);
    
    int j;
     for (int i = 0; i < players.size();i++) {
         do {
             j = (int) (Math.random() * (players.size()));
         } while(players.get(i).getName() == pl.get(j).getName());
         
        players.get(i).setEnemy(pl.get(j));
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
            System.out.println("Mal rollo pendiente:\n");
            
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
