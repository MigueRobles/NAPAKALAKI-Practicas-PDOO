package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;


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
    
    private Napakalaki() {
            currentMonster=new Monster(new String(), 1,new BadConsequence(new String(),true), new Prize(0,0));
        dealer=new CardDealer();
        currentPlayer=new Player(new String());
        players=new ArrayList();
    }
    /*
    private void initPlayers(ArrayList<String> names) {}
    private Player nextPlayer() {}
    private boolean nextTurnAllowed() {}
    private void setEnemies() {}
*/
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
    public Player getCurrentPlayer() {}
    public Monster getCurrentMonster() {}
    public boolean nextTurn() {}
    public boolean endOfGame(CombatResult result) {}
*/
    
}
