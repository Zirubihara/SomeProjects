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
public class NaturalNumber <T extends Integer> {
    
    private T x;
    
    public boolean isEven(){
        return x.intValue()%2==0;
    }

    public NaturalNumber(T x) {
        this.x = x;
    }
    
    
    
}
