package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
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
        for (String s: names){            
            Player p = new Player(s);
            players.add(p);
        }
    
    }
    
    private Player nextPlayer() {
        if(currentPlayer.getName() == new String()){         // Indica si aún no se ha elegido un jugador en el primer turno
            turno = (int) (Math.random() * (players.size()));
        }
        else {
            turno = (turno + 1) % players.size();
        }
        currentPlayer = players.get(turno);
        
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed() {
    if(currentPlayer.getName() == new String()){         // Alternativa a currentPlayer == null, comprobando si ha sido inicializado
        return true;
    }
    else
        return currentPlayer.validState();
    }   
    
    private void setEnemies() {
    ArrayList<Player> pl = players;
    Collections.shuffle(pl);
    
     for (int i = 0; i < players.size();i++){
            players.get(i).setEnemy(pl.get(i));
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
    /*
    public CombatResult developCombat() {}
    public void discardVisibleTreasures(ArrayList<Treasure> Treasures) {}    
    public void discardHiddenTreasures(ArrayList<Treasure> Treasures) {}
    public void makeTreasuresVisible(Treasure treasures) {} 
    public void initGame(ArrayList<String> players){}
    */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    /*
    public boolean nextTurn() {}
    */
    public boolean endOfGame(CombatResult result) {
        return result == CombatResult.WINGAME;
    
    }

    
}
