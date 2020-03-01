/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author wlasciciel
 */
public class Wsp04 extends Thread{

    /**
     * @param args the command line arguments
     */
    
    static AtomicInteger licznik = new AtomicInteger();

    @Override
    public void run() {
               for(int i=0;i<10000000;i++){
            licznik.incrementAndGet();
        }
    }
    
    
    
    
    public static void main(String[] args) throws InterruptedException {
       
        Thread w1 = new Wsp04();
        Thread w2 = new Wsp04();
        
        w1.start();
        w2.start();
        
        w1.join();
        w2.join();
        
        System.out.println("licznik="+licznik.get());
        
    }
    
}
