/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author wlasciciel
 */
public class Stream04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Osoba> lista = new ArrayList<>();
        Osoba o1 = new Osoba("Jan");
        Osoba o2 = new Osoba("Zofia");
        Osoba o3 = new Osoba("Kasia");

        o1.dodajMiasto("Lublin");
        o1.dodajMiasto("Berlin");
        o1.dodajMiasto("Madryd");

        o2.dodajMiasto("Lubartów");
        o2.dodajMiasto("Berlin");
        o2.dodajMiasto("Wrocław");
        
        o3.dodajMiasto("Oslo");
        o3.dodajMiasto("Berlin");
        o3.dodajMiasto("Rzym");        
        
        lista.add(o3);
        lista.add(o2);
        lista.add(o1);
        
        List<String> miasta = lista.stream().
                map(x->x.getMiasta()).flatMap(x->x.stream()).
                distinct().sorted().collect(Collectors.toList());
        
        miasta.forEach(System.out::println);

    }

}
