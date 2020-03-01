/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wlasciciel
 */
public class Stream2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Map<String,Integer> map = new HashMap<>();
        
        map.put("Lublin", 360);
        map.put("Warszawa",1300);
        map.put("Kraków",800);
        map.put("Lubartów",40);
        
        map.replaceAll((k,v)->v+5);
        
        map.computeIfPresent("Warszawa", (k,v)->v-20);
        
        map.computeIfAbsent("Lublin", (k)->500);
        
        map.forEach((k,v)->System.out.println(k+": "+v));
        
        System.out.println(""+map.getOrDefault("Lubin", 1000));
        
    }
    
}
