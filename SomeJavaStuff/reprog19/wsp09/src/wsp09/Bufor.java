/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp09;

/**
 *
 * @author wlasciciel
 */
public class Bufor {

    private int[] buf;

    private int iwe = 0;
    private int iwy = 0;
    private int n;
    private int licz = 0;

    public Bufor(int n) {
        this.n = n;
        buf = new int[n];
    }

    public synchronized void wstaw(int x) throws InterruptedException {

        while (licz == n) {
            wait();
        }
        
        buf[iwe]=x;
        iwe=(iwe+1)%n;
        licz++;
        notifyAll();

    }

    public synchronized int pobierz() throws InterruptedException {
        while (licz == 0) {
            wait();
        }
        int x = buf[iwy];
        iwy=(iwy+1)%n;
        licz--;
        notifyAll();
        return x;
    }

}
