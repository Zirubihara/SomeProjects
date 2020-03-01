/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverecho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author wlasciciel
 */
public class Serverecho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ServerSocket ssok = null;
        
        try{
            ssok = new ServerSocket(1237);
            System.out.println("Serwer działa na porcie 12");
            
            while(true){
                Socket s = ssok.accept();
                
                BufferedReader in=null;
                PrintWriter out = null;
                
                try{
                    
                    System.out.println("przyjęto połączenie");
                    in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    out = new PrintWriter(s.getOutputStream(),true);
                    
                    String line= in.readLine();
                    
                    out.println(line+(new Date()));
                    
                    in.close();
                    out.close();
                    s.close();
                    
                    System.out.println("koniec obsługi");
                }catch(IOException e){
                    System.out.println("Błąd obsługi: "+e.getMessage());
                }
            }
            
        }catch(Exception e){
            System.out.println("Błąd serwera: "+e.getMessage());
        }
        
    }
    
}
