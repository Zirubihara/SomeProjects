/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp02;

/**
 *
 * @author wlasciciel
 */
public class Wsp02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Thread w = new Thread(new Watek());
        w.start();
        System.out.println("hello z main");
        
    }
    
}
