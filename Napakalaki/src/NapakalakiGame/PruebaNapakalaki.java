package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class PruebaNapakalaki {
    
   // static ArrayList<Monster> monstruos = new ArrayList();
   /*
    static ArrayList<Monster> lvlTenUp(){
        ArrayList<Monster> mons = new ArrayList();
        for (Monster monstruo: monstruos)
            if(monstruo.getCombatLevel() > 10)
                mons.add(monstruo); 
    
    return mons;
    }
    static ArrayList<Monster> JustLvlBQ(){
        ArrayList<Monster> mons = new ArrayList();
        for (Monster monstruo: monstruos)
            if(monstruo.getBadConsequence().getnVisibleTreasures() == 0 && monstruo.getBadConsequence().getnHiddenTreasures() == 0)
                mons.add(monstruo); 
    
    return mons;
    }
     static ArrayList<Monster> PrizePlusOneLvl(){
        ArrayList<Monster> mons = new ArrayList();
        for (Monster monstruo: monstruos)
            if(monstruo.getPrize().getLevel() > 1)
                mons.add(monstruo); 
    
    return mons;
    }
     static ArrayList<Monster> BQSpecific(){
        ArrayList<Monster> mons = new ArrayList();
        for (Monster monstruo: monstruos)
            if(monstruo.getBadConsequence().getsHiddenTreasures().isEmpty() && monstruo.getBadConsequence().getsVisibleTreasures().isEmpty())
                mons.add(monstruo); 
    
    return mons;
    }
    */
    public static void main(String[] args) {
        
        
        /*
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2,1);
        monstruos.add(new Monster("Byakhees de bonanza", 8, prize, badConsequence));
        
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Tongue", 19, prize, badConsequence));
                   
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,Integer.MAX_VALUE,0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Bicéfalo", 21, prize, badConsequence));
        
        badConsequence = new BadConsequence("Embobados por el lindo primigenio te descartas de tu casco visible",0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Tenochtitlan", 2, prize, badConsequence));
        
        badConsequence = new BadConsequence("El primordial bostezo contadioso. Pierdes el calzado visible",0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Demonios de Magaluf", 2, prize, badConsequence));
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",0, Integer.MAX_VALUE, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 13, prize, badConsequence));
       
        badConsequence = new BadConsequence("Pierdes la armadura visible",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
               
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Necrófago", 13, prize, badConsequence));
               
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
        prize = new Prize(3,2);
        monstruos.add(new Monster("El rey de rosado", 11, prize, badConsequence));
               
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles",2,0,0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Flecher", 2, prize, badConsequence));
                   
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto",true);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Los Hondos", 8, prize, badConsequence));
                   
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, prize, badConsequence));
                   
        badConsequence = new BadConsequence("e intentas escaquear. Pierdes 1 mano visible",0,1,0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Dameargo", 1, prize, badConsequence));
                   
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles",3,0,0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Pollipólipo volante", 3, prize, badConsequence));
                   
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto",true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 14, prize, badConsequence));
                   
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto",false);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Familia Feliz", 1, prize, badConsequence));
                   
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth", 8, prize, badConsequence));
                   
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El espía sordo", 5, prize, badConsequence));
                   
        
                   
       for (Monster monstruo: monstruos){
           System.out.println (monstruo.toString());
        }
       
       ArrayList<Monster> nivel10 = lvlTenUp();
       System.out.println ("------------------------");
     
       for (Monster monstruo: nivel10){
            System.out.println (nivel10.toString());
        }
       ArrayList<Monster> JustLevel = JustLvlBQ();
       System.out.println ("------------------------");
     
       for (Monster monstruo: JustLevel){
            System.out.println (JustLevel.toString());
        }
       ArrayList<Monster> Prize1 = PrizePlusOneLvl();
       System.out.println ("------------------------");
     
       for (Monster monstruo: Prize1){
            System.out.println (Prize1.toString());
        }
        ArrayList<Monster> Specific = BQSpecific();
       System.out.println ("------------------------");
     
       for (Monster monstruo: Specific){
            System.out.println (Specific.toString());
        }
        
    }
    */
    
    Prize prize = new Prize(5,15);
    System.out.println(prize.toString());
    System.out.println();

        
    BadConsequence bc = new BadConsequence("Lose the Game", 23, 0, 0);
    System.out.println(bc.toString());
    System.out.println(bc.isEmpty());
    System.out.println();

    

    bc = new BadConsequence("Amapola", 23, 2, 3);
    System.out.println(bc.toString());
    System.out.println(bc.isEmpty());
    System.out.println();
    
    
    Dice d = new Dice();
    System.out.println(d.nextNumber());
    System.out.println();
    
    
    Monster m = new Monster("Yskhtihyssg-Goth", 14, bc, prize);
    System.out.println(m.getLevelsGained());
    System.out.println(m.getTreasuresGained());
    System.out.println();
   
    Treasure t = new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET);
    System.out.println(t.getName());
    System.out.println(t.getBonus());
    System.out.println(t.getType());
    System.out.println();
    
    Player p1 = new Player("Urqui");
    Player p2 = new Player("Chino");
    System.out.println(p1.isDead());
    System.out.println(p1.getName());
    System.out.println(p1.getLevels());
    p1.setEnemy(p2);
    System.out.println(p1.canISteal());
    System.out.println(p1.validState());
    System.out.println();

    
    CardDealer c = new CardDealer();
    //Probados todos lo metodos que eran privados
      
  }
}

