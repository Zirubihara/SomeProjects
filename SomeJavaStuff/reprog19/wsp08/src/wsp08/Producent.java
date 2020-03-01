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


public class Producent extends Thread{
    
    private Bufor bufor;
    
    private Semaphore miejsca;
    private Semaphore elementy;

    public Producent(Bufor bufor, Semaphore miejsca, Semaphore elementy) {
        this.bufor = bufor;
        this.miejsca = miejsca;
        this.elementy = elementy;
    }

    @Override
    public void run() {
        
        while(true){
            
            try{
                Thread.sleep((long) (1000 * Math.random()));
            }catch(InterruptedException e){
                
            }
            
            int x = (int)(Math.random()*100);
            
            miejsca.acquireUninterruptibly();
            
            bufor.buf[bufor.iwe]=x;
            
            bufor.iwe=(bufor.iwe+1)%bufor.n;
            
            elementy.release();
            
            System.out.println("producent "+x);
            
            
        }
        
    }
    
    
    
    
}
