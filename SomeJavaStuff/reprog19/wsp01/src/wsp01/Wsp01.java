/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp01;

/**
 *
 * @author wlasciciel
 */
public class Wsp01 {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
       
        System.out.println("start main");
        
        Watek [] w = new Watek[10];
        for(int i=0;i<10;i++){
           w[i]=new Watek(i); 
        }

        for(int i=0;i<10;i++){
           w[i].start(); 
        }        

        Thread.sleep(3000);
        w[5].interrupt();
        
        for(int i=0;i<10;i++){
           w[i].join(); 
        }         
        
        System.out.println("koniec main");
        
    }
    
}
