/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gener01;

/**
 *
 * @author wlasciciel
 */
public class Box<T> {
    
    private T obj;
    
    public T get(){
        return obj;
    }
    
    public void put(T obj){
        this.obj=obj;
    }
    
}
