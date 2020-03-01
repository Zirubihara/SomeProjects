/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gener01;

/**
 *
 * @author wlasciciel
 * @param <T>
 */
public class Liczba<T extends Number> {
    private T x;

    public Liczba(T x) {
        this.x = x;
    }
    
    public double value(){
        return x.doubleValue();
    }
}
