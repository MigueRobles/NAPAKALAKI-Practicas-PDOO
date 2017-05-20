package NapakalakiGame;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
import GUI.NapakalakiView;
import GUI.Dice;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;
//import GUI.PlayerNamesCapture;
//import GUI.PlayerView;
//import GUI.TreasureView;
//import java.util.*;

public class Javakalaki {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        
        Dice.createInstance (napakalakiView);
        
        napakalakiView.setNapakalaki(game);
        
        ArrayList<String> names = new ArrayList();
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        names = namesCapture.getNames();
        
        game.initGame(names);
        
        napakalakiView.setVisible(true);
    }
        
}
