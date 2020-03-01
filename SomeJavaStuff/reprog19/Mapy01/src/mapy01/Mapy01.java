/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapy01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wlasciciel
 */
public class Mapy01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Zosia",21);
        mapa.put("Jan", 34);
        
        mapa.computeIfAbsent("Kasia", imie->0);
        
        mapa.replaceAll((imie,wiek)->wiek+1);
        
        mapa.forEach((imie,wiek)->System.out.println(imie+" "+wiek));
        
       
        
        List<String> lista = Arrays.asList("AA","BBB","CC");
        
        lista.stream().sorted((e1,e2)->e1.length()-e2.length()).mapToInt(e->e.length()).distinct().forEach(System.out::println);

    }

}
