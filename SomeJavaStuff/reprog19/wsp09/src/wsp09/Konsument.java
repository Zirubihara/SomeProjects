/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp09;

import java.util.concurrent.Semaphore;

/**
 *
 * @author wlasciciel
 */
public class Konsument extends Thread {

    public Konsument(Bufor bufor) {
        this.bufor = bufor;
    }

    private Bufor bufor;

    @Override
    public void run() {

        while (true) {

            try {

                int x = bufor.pobierz();

                System.out.println("konsument " + x);

            } catch (InterruptedException e) {

            }

            try {
                Thread.sleep((long) (3000 * Math.random()));
            } catch (InterruptedException e) {

            }

        }

    }

}
