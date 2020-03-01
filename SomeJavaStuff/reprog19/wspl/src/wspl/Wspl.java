/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wspl;

/**
 *
 * @author wlasciciel
 */
public class Wspl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new Thread(new Watek()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Hello z W2");
            }

        }).start();

        Runnable w3 = () -> {
            System.out.println("Hello z W3");
        };

        new Thread(w3).start();

        new Thread(()->System.out.println("Hello z W4")).start();
    }

}
