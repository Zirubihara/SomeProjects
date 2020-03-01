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
public class Owad {

    protected int rozmiar=3;
    
    public Owad(int rozmiar) {
        this.rozmiar=rozmiar;
        System.out.println("Tworzę owada orozmiarze "+rozmiar);
    }

    public Owad() {
        System.out.println("Tworzę owada orozmiarze "+rozmiar);
    }
    
    public void rysuj(){
        System.out.println("Rysuję odwłok i głowę owada o rozmiarze "+rozmiar);
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }
    
    
    
}
