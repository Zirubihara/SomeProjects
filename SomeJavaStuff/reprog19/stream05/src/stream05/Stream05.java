/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

/**
 *
 * @author wlasciciel
 */
public class Stream05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        Stream<String> str = new BufferedReader(new FileReader("dane.txt")).lines();
        
        str.mapToInt(e->e.length()).forEach(System.out::println);
        
    }
    
}
