/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp09;

/**
 *
 * @author wlasciciel
 */
public class Wsp09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Bufor bufor = new Bufor(10);

        new Producent(bufor).start();
        new Konsument(bufor).start();

    }

}
