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
    private CardDealer dealer;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private int turno;
    
    private Napakalaki() {
        currentMonster=new Monster(new String(), 1,new BadConsequence(new String(),true), new Prize(0,0));
        dealer=new CardDealer();
        currentPlayer=new Player(new String());
        players=new ArrayList();
    }
    
    private void initPlayers(ArrayList<String> names) {
        for (String s: names) {            
            Player p = new Player(s);
            players.add(p);
        }
    
    }
    
    private Player nextPlayer() {
        if(currentPlayer.getName() == new String()) {      
        turno = (int) (Math.random() * (players.size()));
        }
        
        else 
            turno = (turno + 1) % players.size();
        
        currentPlayer = players.get(turno);
        
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed() {
    if(currentPlayer.getName() == new String()) {         // Alternativa a currentPlayer == null, comprobando si ha sido inicializado
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
            this.currentPlayer.discardVisibleTreasure(treasure);  
        }
    }    
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        for(Treasure treasure:treasures) {
            this.currentPlayer.discardHiddenTreasure(treasure);  
            this.dealer.giveTreasureBack(treasure);
        }
    }
    
    public CombatResult developCombat() {
        CombatResult result = this.currentPlayer.combat(this.currentMonster);
        this.dealer.giveMonsterBack(this.currentMonster);
        return result;
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        for(Treasure treasure:treasures) {
            this.currentPlayer.makeTreasureVisible(treasure);
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
           this.currentMonster = this.dealer.nextMonster(); // CardDealer.getInstance().nextMonster() ??
           nextPlayer();

           if(this.currentPlayer.isDead())
           this.currentPlayer.initTreasures();
        }
       return stateOK;
    }
    
    public void initGame(ArrayList<String> players) {
        initPlayers(players);
        setEnemies();
        this.dealer.initCards();
        nextTurn();   
    }

    
}
