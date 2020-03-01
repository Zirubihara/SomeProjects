/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream06;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wlasciciel
 */
public class Stream06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        
        List<Double> lista = new ArrayList<>();
        for(int i=0;i<10000000;i++){
           lista.add(Math.random());
        }
        
        ForkJoinPool fjp = new ForkJoinPool(8);
        
        System.out.println("#procs="+fjp.getParallelism());
        
        long start = System.currentTimeMillis();
        
        try {
            //        lista.parallelStream().sorted().reduce((e1,e2)->e1+e2).ifPresent(System.out::println);
            
            Optional<Double> x = fjp.submit(
                    () -> lista.parallelStream().sorted().reduce((e1,e2)->e1+e2)).get();
        } catch (ExecutionException ex) {
            Logger.getLogger(Stream06.class.getName()).log(Level.SEVERE, null, ex);
        }

        long stop = System.currentTimeMillis();
        System.out.println("czas="+(stop-start)/1000.0);
    }
    
}
