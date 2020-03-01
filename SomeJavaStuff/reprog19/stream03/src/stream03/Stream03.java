/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream03;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author wlasciciel
 */
public class Stream03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<String> lista = Arrays.asList("AA","BBB","C","DDDD","EE","AA");
        
    //    lista.forEach(System.out::println);
        
  //      Map<String,Integer> map = lista.stream().distinct().
    //          collect(Collectors.toMap(s->s, String::length));

//          Map<Integer,String> map = lista.stream().peek(e->System.out.println("("+e+")")).
//                  collect(Collectors.toMap(s->s.length(),s->s,(s1,s2)->s1+","+s2));
        
              Map<Integer,List<String>> map = lista.stream().
                  collect(Collectors.groupingBy(String::length));

                  
        map.forEach((k,v)->System.out.println(k+": "+v));
        
    }
    
}
