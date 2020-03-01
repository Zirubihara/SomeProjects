/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp06;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

/**
 *
 * @author wlasciciel
 */
public class Wsp06 extends Thread{

    /**
     * @param args the command line arguments
     */
    
    static Semaphore s = new Semaphore(1);
    private int n;

    public Wsp06(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        
        while(true){
            
            try{
                Thread.sleep((long)(4000*Math.random()));
            }catch(InterruptedException e){
                
            }
            s.acquireUninterruptibly();
            System.out.println("IN "+n);
            try{
                Thread.sleep((long)(4000*Math.random()));
            }catch(InterruptedException e){
                
            }
            System.out.println("OUT "+n);
            s.release();
            
            
        }
        
        
    }
   
    
    
    
    public static void main(String[] args) {
        
        new Wsp06(0).start();
        new Wsp06(1).start();
        new Wsp06(3).start();
        new Wsp06(2).start();        
    }
    
}
