/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    public Bufor(int n) {
        this.n = n;
        buf = new int[n];
    }

    public void wstaw(int x) throws InterruptedException {

        lock.lock();
        try {
            while (licz == n) {
                notFull.await();
            }

            buf[iwe] = x;
            iwe = (iwe + 1) % n;
            licz++;
            notEmpty.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public int pobierz() throws InterruptedException {
        int x=-1;
        lock.lock();
        try {
            while (licz == 0) {
                notEmpty.await();
            }
             x= buf[iwy];
            iwy = (iwy + 1) % n;
            licz--;
            notFull.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
        return x;
    }

}
