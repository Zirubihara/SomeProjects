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
public class Watek extends Thread {

    private int nr;

    @Override
    public void run() {

        System.out.println("Start wątku " + nr);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("wątek "+nr+": ktoś mnie obudził");
        } finally {
            System.out.println("Koniec wątku " + nr);
        }

    }

    public Watek(int nr) {
        this.nr = nr;
    }

}
