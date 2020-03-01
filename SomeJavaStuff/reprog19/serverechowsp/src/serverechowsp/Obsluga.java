/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverechowsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author wlasciciel
 */
public class Obsluga extends Thread {

    private Socket s;

    public Obsluga(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {

        BufferedReader in = null;
        PrintWriter out = null;

        try {

            System.out.println("przyjęto połączenie");
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);

            out.println("hello z serwera");
            
            String line = in.readLine();

            out.println(line +" " +(new Date()));

            in.close();
            out.close();
            s.close();

            System.out.println("koniec obsługi");
        } catch (IOException e) {
            System.out.println("Błąd obsługi: " + e.getMessage());
        }

    }

}
