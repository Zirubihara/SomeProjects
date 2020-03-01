/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverechowsp;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author wlasciciel
 */
public class Serverechowsp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                ServerSocket ssok = null;
        
        try{
            ssok = new ServerSocket(1237);
            System.out.println("Serwer działa na porcie 1237");
            
            while(true){
                Socket s = ssok.accept();

                new Obsluga(s).start();
               
            }
            
        }catch(Exception e){
            System.out.println("Błąd serwera: "+e.getMessage());
        }
        
    }
    
}
