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
public class Licznik {
    
    private long s =0;
    
    public synchronized void inc(){
        s++;
    }
    
    public synchronized long get(){
        return s;
    }
    
}
