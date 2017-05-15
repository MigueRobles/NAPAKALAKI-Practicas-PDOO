package NapakalakiGame;
import java.util.ArrayList;//Se ve que para inicializar listas asi va guay, cosas de Netbeans
import java.util.Arrays;//Idem
import java.util.Collections;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class CardDealer {
    
    private static CardDealer instance = null;
    
    private ArrayList<Monster> usedMonster = new ArrayList();
    private ArrayList<Monster> unusedMonster = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Cultist> usedCultist = new ArrayList();
    private ArrayList<Cultist> unusedCultist = new ArrayList();
    
    
    
    private void initTreasureCardDeck() {
        
      unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOE));
      unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Necro-playboycón", 3, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOE));
      
    }
    
    private void initMonsterCardDeck() {
        
        BadConsequence badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2,1);
        unusedMonster.add(new Monster("Byakhees de bonanza", 8, badConsequence, prize,0));
        
        badConsequence = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Tongue", 19, badConsequence, prize,0));
                   
        badConsequence = new NumericBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,Integer.MAX_VALUE,0);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Bicéfalo", 21, badConsequence, prize,0));
        
        badConsequence = new SpecificBadConsequence("Embobados por el lindo primigenio te descartas de tu casco visible",0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Tenochtitlan", 2, badConsequence, prize,0));
        
        badConsequence = new SpecificBadConsequence("El primordial bostezo contadioso. Pierdes el calzado visible",0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize,0));
        
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonster.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize,0));
        
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles",0, Integer.MAX_VALUE, 0);
        prize = new Prize(3,1);
        unusedMonster.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize,0));
       
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize,0));
               
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Necrófago", 13, badConsequence, prize,0));
               
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
        prize = new Prize(3,2);
        unusedMonster.add(new Monster("El rey de rosado", 11, badConsequence, prize,0));
               
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles",2,0,0);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Flecher", 2, badConsequence, prize,0));
                   
        badConsequence = new DeathBadConsequence("Estos unusedMonster resultan bastante superficiales y te aburren mortalmente. Estás muerto",true);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Los Hondos", 8, badConsequence, prize,0));
                   
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize,0));
                   
        badConsequence = new SpecificBadConsequence("Pasa algo e intentas escaquear. Pierdes 1 mano visible",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Dameargo", 1, badConsequence, prize,0));
                   
        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles",3,0,0);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Pollipólipo volante", 3, badConsequence, prize,0));
                   
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto",true);
        prize = new Prize(3,1);
        unusedMonster.add(new Monster("Yskhtihyssg-Goth", 14, badConsequence, prize,0));
                   
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estás muerto",false);
        prize = new Prize(3,1);
        unusedMonster.add(new Monster("Familia Feliz", 1, badConsequence, prize,0));
                   
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Roboggoth", 8, badConsequence, prize,0));
                   
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("El espía sordo", 5, badConsequence, prize,0));
        
        // Monstruos para sectarios
        
        badConsequence = new SpecificBadConsequence("Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("El mal indecile impronunciable", 10, badConsequence, prize,2));
        
        badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajajajaxddd",0,5,0);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Testigos oculares", 6, badConsequence, prize,4));
        
        badConsequence = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.", true);
        prize = new Prize(2,5);
        unusedMonster.add(new Monster("El gran cthulu", 20, badConsequence, prize,4));
        
        badConsequence = new NumericBadConsequence("El gobierno te recorta 2 niveles",0,0,-2);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Serpiente Político", 10, badConsequence, prize,2));
        
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Bicéfalo", 10, badConsequence, prize,0));
        
    }
    
    private void initCultistCardDeck() {
      Cultist cultist = new Cultist("Sectario: +1 por cada sectario en juego",1);
      unusedCultist.add(cultist);
      unusedCultist.add(cultist);
      unusedCultist.add(cultist);
      unusedCultist.add(cultist);
      
      cultist = new Cultist("Sectario: +2 por cada sectario en juego",2);
      unusedCultist.add(cultist);
      unusedCultist.add(cultist);
    }
    
    private void shuffleTreasures() { Collections.shuffle(unusedTreasures); }    
    private void shuffleMonster() { Collections.shuffle(unusedMonster); }
    private void shuffleCultist() { Collections.shuffle(unusedCultist); }
    
    public static CardDealer getInstance() {
        if (instance == null)
            instance = new CardDealer();
        return instance;
    }
    
    
    public Treasure nextTreasure() {           

        if(unusedTreasures.isEmpty()){
            ArrayList<Treasure> aux_t = usedTreasures;
            usedTreasures = unusedTreasures;
            unusedTreasures = aux_t;            
            shuffleTreasures();
        }
        
        Treasure aux;
        aux = unusedTreasures.get(0);
        usedTreasures.add(aux);
        unusedTreasures.remove(0);
        return aux;
    }
    
    public Monster nextMonster() {
         
       if(unusedMonster.isEmpty()){
            ArrayList<Monster> aux_t = usedMonster;
            usedMonster = unusedMonster;
            unusedMonster = aux_t;      
            shuffleMonster();
        }
        
        Monster aux = unusedMonster.get(0);
        usedMonster.add(aux);
        unusedMonster.remove(0);
        return aux;
        
    }
    
    public Cultist nextCultist() {
        if(unusedCultist.isEmpty()){
            ArrayList<Cultist> aux_c = usedCultist;
            usedCultist = unusedCultist;
            unusedCultist = aux_c;
            shuffleCultist();
        }
        Cultist aux = unusedCultist.get(0);
        usedCultist.add(aux);
        return aux;
    }
    
    public void giveTreasureBack (Treasure t) { usedTreasures.add(t); }    
    public void giveMonsterBack (Monster m) { usedMonster.add(m); }
    
    public void initCards() {
        initMonsterCardDeck();
        initTreasureCardDeck();
        initCultistCardDeck();
    }
    
    
}
