/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gener01;

import java.util.List;

/**
 *
 * @author wlasciciel
 */
public class Utils {

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey())
                && p1.getValue().equals(p2.getValue());
    }

    public static <T extends Number> double valueOfNumber(T x) {
        return x.doubleValue();
    }

    public static <T extends Comparable> int countGreater(T[] array, T v) {
        int count = 0;
        for (T x : array) {
            if (x.compareTo(v) > 0) {
                count++;
            }
        }
        return count;
    }

    public static void test1(Number x) {

    }

    public static void test2(Box<Number> x) {

    }
    
    public static double sumList(List<? extends Number> list){
        double sum=0;
        for(Number x:list){
          sum+=x.doubleValue();
        }
        return sum;
    }

    public static void sumList2(List<? super Number> list){

    }
    
    public static void printList1(List<Object> list){
        for(Object o:list){
            System.out.print(o+" ");
        }
        System.out.println("");
    }
    
        public static void printList2(List<?> list){
        for(Object o:list){
            System.out.print(o+" ");
        }
        System.out.println("");
    }
}
