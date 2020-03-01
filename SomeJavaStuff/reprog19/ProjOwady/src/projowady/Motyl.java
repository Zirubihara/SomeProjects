/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projowady;

/**
 *
 * @author wlasciciel
 */
public class Motyl extends Owad{
    
    public void rysuj(){
        super.rysuj();
        System.out.println("Rysuję skrzydła i czułki motyla o rozmiarze "+rozmiar);
    }

    public Motyl() {
        super(8);
        System.out.println("Torzę motyla o rozmiarze "+rozmiar);
    }
    
    
}
