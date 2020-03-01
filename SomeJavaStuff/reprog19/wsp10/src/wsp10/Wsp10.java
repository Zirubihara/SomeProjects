/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author wlasciciel
 */
public class Wsp10 extends Thread{

    /**
     * @param args the command line arguments
     */
    
    private int nr;
    
    static Lock lock = new ReentrantLock();

    public Wsp10(int nr) {
        this.nr = nr;
    }

    
    
    
    @Override
    public void run() {
        
        while(true){
            try{
                Thread.sleep((long)(2000*Math.random()));
            }catch(InterruptedException e){
                
            }
            
            lock.lock();
            try{
                System.out.println("IN "+nr);
                Thread.sleep((long)(2000*Math.random()));
                System.out.println("OUT "+nr);
            }catch(Exception e){
                System.out.println("błąd w sekcji krytycznej "+nr);
            }finally{
                lock.unlock();
            }
            
        }
        
    }
    
    
    
    
    public static void main(String[] args) {
        
        new Wsp10(0).start();
        new Wsp10(1).start();
        new Wsp10(2).start();
        new Wsp10(3).start();  
        new Wsp10(4).start();
        new Wsp10(5).start();
        new Wsp10(6).start();
        new Wsp10(7).start();        
    }
    
}
