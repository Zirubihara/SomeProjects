/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream04;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author wlasciciel
 */
public class Osoba {
    
    private String imie;
    private Set<String> miasta;

    public Osoba(String imie) {
        this.imie = imie;
        miasta = new HashSet<>();
    }
    
    public void dodajMiasto(String miasto){
        miasta.add(miasto);
    }

    public Set<String> getMiasta() {
        return miasta;
    }
    
    
    
}
