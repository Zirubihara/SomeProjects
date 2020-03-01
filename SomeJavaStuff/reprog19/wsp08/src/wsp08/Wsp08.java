/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp08;

import java.util.concurrent.Semaphore;

/**
 *
 * @author wlasciciel
 */
public class Wsp08 {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        
        Semaphore miejsca = new Semaphore(10);
        Semaphore elementy = new Semaphore(0);
        
        Bufor bufor = new Bufor(10);
        
        new Producent(bufor,miejsca,elementy).start();
        new Konsument(bufor,miejsca,elementy).start();
        
        
    }
    
}
