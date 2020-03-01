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
public class Filozof extends Thread {

    private Semaphore[] widelec;
    private int nr;
    private Semaphore miejsca;

    public Filozof(int nr, Semaphore[] widelec,Semaphore miejsca) {
        this.nr = nr;
        this.widelec = widelec;
        this.miejsca=miejsca;
    }

    @Override
    public void run() {

        while (true) {

            try {
               Thread.sleep((long) (10 * Math.random()));
            } catch (InterruptedException e) {

            }
            miejsca.acquireUninterruptibly();
            widelec[nr].acquireUninterruptibly();
            widelec[(nr + 1) % 5].acquireUninterruptibly();
            System.out.println("START " + nr);
            try {
                Thread.sleep((long) (10 * Math.random()));
            } catch (InterruptedException e) {

            }
            System.out.println("STOP " + nr);
            widelec[nr].release();
            widelec[(nr + 1) % 5].release();
            miejsca.release();

        }

    }

}
