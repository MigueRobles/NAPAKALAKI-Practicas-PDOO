/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Robles Urquiza
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Prize premio = new Prize(2,1);
        BadConsequence consecuencia = new BadConsequence("Mueres aplastado por una Descomposicion Cíclica Primaia", true);
        Monster cegarra= new Monster("Congruencia Asesina", 15, premio, consecuencia);
       
        System.out.println (cegarra.toString());
    }
    
}

