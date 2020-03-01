/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp05;

/**
 *
 * @author wlasciciel
 */
public class Watek extends Thread {

    private Licznik licz;

    public Watek(Licznik licz) {
        this.licz = licz;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            licz.inc1();

        }

    }
}