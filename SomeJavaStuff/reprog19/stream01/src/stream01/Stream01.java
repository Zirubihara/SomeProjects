/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 *
 * @author wlasciciel
 */
public class Stream01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<String> lista = Arrays.asList("a11111", "b2155555", "a322", "c153", "b5");

//        for(String e:lista){
//            System.out.println(e);
//        }
//       lista.stream().forEach(System.out::println);
//        lista.stream().forEach(e->S'ystem.out.println(e+" o dlugosci "+e.length()));
         lista.parallelStream().forEach(e->System.out.println(e+" o dlugosci "+e.length()));
         lista.stream().findFirst().ifPresent(System.out::println);
        Consumer<String> strcons = System.out::println;

           lista.stream().filter(e->e.startsWith("a")).forEach(strcons);
           lista.stream().filter(e->e.contains("2")).forEach(strcons);
           lista.stream().sorted().forEach(System.out::println);
        System.out.println("xxx+" +
                "");
        lista.stream().sorted((e1,e2)->e1.length()-e2.length()).forEach(System.out::println);
        System.out.println("comparare");
     //         lista.stream().sorted((e1,e2)->-e1.compareTo(e2)).forEach(System.out::println);
             lista.stream().map(e->e.length()).sorted().forEach(System.out::println);
        //     lista.stream().forEach(System.out::println);
             lista.stream().map(e->e.length()).reduce((e1,e2)->e1+e2).ifPresent(System.out::println);
             lista.stream().map(e->e.length()).forEach(System.out::println);
        //     Optional<Integer> x = lista.stream().map(e->e.length()).reduce((e1,e2)->e1+e2);
        //      System.out.println(x.get());
           lista.stream().reduce((e1,e2)->e1+" "+e2).ifPresent(System.out::println);
            String max =lista.stream().reduce("",(e1,e2)->e1.length()>e2.length() ? e1 : e2);
        System.out.println(max);
        //      System.out.println(max);
        List<Osoba> listaOs = new ArrayList<>();
//      
        listaOs.add(new Osoba("Jan", 45));
        listaOs.add(new Osoba("Maria", 15));
        listaOs.add(new Osoba("Zofia", 37));
        listaOs.add(new Osoba("Kazio", 5));
// 
//      Osoba neutr = new Osoba("",9999999);
//      
//      Osoba osoba = listaOs.stream().reduce(neutr, 
//              (res,e)-> res.getWiek() > e.getWiek() ? e : res  );
//      
//        System.out.println(osoba.getImie()+" "+osoba.getWiek());

        //     lista.stream().collect(Collectors.reducing((e1,e2)->e1+e2)).ifPresent(System.out::println);
//        Osoba neutr = new Osoba("", 0);
//
//        Osoba wynik = listaOs.stream().reduce(neutr,
//                (res, e) -> { res.setWiek(res.getWiek()+e.getWiek()); return res;}
//                );
//        System.out.println(wynik.getWiek());
//        
//        neutr = new Osoba("", 0);
//        Osoba wynik2 = listaOs.stream().collect(Collectors.reducing(neutr,
//                (res, e) -> { res.setWiek(res.getWiek()+e.getWiek()); return res;}
//                ));        
//        System.out.println(wynik2.getWiek());

       int suma = lista.stream().collect(Collectors.summingInt(String::length));
       System.out.println("suma="+suma);
       
       double srednia = lista.stream().collect(Collectors.averagingInt(String::length));
        System.out.println("srednia="+srednia);

    }

}
