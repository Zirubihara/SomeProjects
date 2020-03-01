/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp07;

import java.util.concurrent.Semaphore;

/**
 *
 * @author wlasciciel
 */
public class Wsp07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Semaphore[] widelec = new Semaphore[5];
        Filozof[] filozof = new Filozof[5];
        Semaphore miejsca = new Semaphore(4);

        for (int i = 0; i < 5; i++) {
            widelec[i] = new Semaphore(1);
        }

        for (int i = 0; i < 5; i++) {
            filozof[i] = new Filozof(i, widelec,miejsca);
        }

        for (int i = 0; i < 5; i++) {
            filozof[i].start();
        }

    }

}
