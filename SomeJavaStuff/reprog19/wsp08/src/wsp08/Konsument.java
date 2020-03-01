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
public class Konsument extends Thread {

    public Konsument(Bufor bufor, Semaphore miejsca, Semaphore elementy) {
        this.bufor = bufor;
        this.miejsca = miejsca;
        this.elementy = elementy;
    }

    private Bufor bufor;

    private Semaphore miejsca;
    private Semaphore elementy;

    @Override
    public void run() {

        while (true) {

            elementy.acquireUninterruptibly();

            int x = bufor.buf[bufor.iwy];

            bufor.iwy = (bufor.iwy + 1) % bufor.n;

            miejsca.release();

            System.out.println("konsument " + x);

            try {
                Thread.sleep((long) (3000 * Math.random()));
            } catch (InterruptedException e) {

            }

        }

    }

}
