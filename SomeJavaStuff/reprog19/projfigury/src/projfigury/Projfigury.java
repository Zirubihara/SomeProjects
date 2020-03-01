/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfigury;

/**
 *
 * @author wlasciciel
 */
public class Projfigury {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Figura f=null ; //= new Trojkat();
        //f.rysuj();
        Figura f1 = new Trojkat();
        f1.rysuj();
        IFigura ff = new Kolo();
        ff.rysuj();
        
    }
    
}
