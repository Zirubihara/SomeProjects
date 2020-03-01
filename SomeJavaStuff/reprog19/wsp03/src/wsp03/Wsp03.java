/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp03;

/**
 *
 * @author wlasciciel
 */
public class Wsp03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        
        Licznik licz=new Licznik();
        Watek w = new Watek(licz);
        Watek v = new Watek(licz);
        w.start();
        v.start();
        w.join();
        v.join();
        System.out.println("Licznik="+licz.get());
        
    }
    
}
