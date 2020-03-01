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
public class Licznik {

    private long c1 = 0;
    private long c2 = 0;

    private Object o1 = new Object();
    private Object o2 = new Object();

    public void inc1() {
        synchronized (o1) {
            c1++;
        }
    }

    public void inc2() {
        synchronized (o2) {
            c2++;
        }
    }

}
