/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda01;

import java.util.Date;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author wlasciciel
 */
public class Lambda01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Sprawdzacz<Integer> dodatnia = (x)-> x>0;
        
        Sprawdzacz<Number> dodatniaN = x-> x.doubleValue()>0;
        
        Predicate<Number> dodatniaP = x-> x.doubleValue()>0;
        
        System.out.println("wynik="+dodatniaN.sprawdz(-12));
        
        System.out.println("wynik="+dodatniaP.test(12.9));
        
        Function <String,Integer> dlugosc = napis -> napis.length();
        
        String str = "Ala ma kota";
        System.out.println("dlugosc="+dlugosc.apply(str));
        
        Supplier<String> data = ()-> new Date().toString();
        
        System.out.println("dzis="+data.get());
        
    }
    
}
