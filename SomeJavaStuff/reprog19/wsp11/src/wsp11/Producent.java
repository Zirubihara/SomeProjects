/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp11;

/**
 *
 * @author wlasciciel
 */
public class Producent extends Thread {

    private Bufor bufor;

    public Producent(Bufor bufor) {
        this.bufor = bufor;

    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {

            }

            try {
                int x = (int) (Math.random() * 100);

                bufor.wstaw(x);

                System.out.println("producent " + x);
            } catch (InterruptedException e) {

            }

        }

    }

}
