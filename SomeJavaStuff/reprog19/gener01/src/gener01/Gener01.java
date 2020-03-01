/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gener01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wlasciciel
 */
public class Gener01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Box<Integer> box1 = new Box<>();
//        Box<String> box2 = new Box<>();
//        
//        Box box = new Box();
//        
//        box1.put(777);
//        box2.put("ala");
//        
//        box.put("aaaaa");
//        
//        
//        System.out.println("box="+box1.get());
//        System.out.println("box="+box2.get());
//        OrderedPair<Integer,String> p1 = new OrderedPair<>(11,"ola"); 
//        OrderedPair<Integer,String> p2 = new OrderedPair<>(22,"ala"); 
//
//        OrderedPair<Integer,Integer> p3 = new OrderedPair<>(11,44);
//        
//        System.out.println("wynik="+Utils.compare(p1,p2));
//        Integer i = new Integer(77);
//        Double d = new Double(77);
//        System.out.println("x="+Utils.valueOfNumber(d));

//         NaturalNumber<Integer> n = new NaturalNumber<>(52);
//         
//         System.out.println(""+n.isEven());

//           Liczba<BigInteger> x = new Liczba<>("777777");
//           
//           System.out.println("x="+x.value());

//             Utils.test2(55);

             List<Number> list = new ArrayList<>();
//             
//             list.add(44);
//             list.add(33);
             
    //        System.out.println("suma="+Utils.sumList(list));

            Utils.sumList2(list);

             Utils.printList2(list);
             
             
    }

}
