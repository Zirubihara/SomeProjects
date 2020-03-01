/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author wlasciciel
 */
public class Clientecho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Socket s = null;

        BufferedReader in = null;
        PrintWriter out = null;

        try {

            s = new Socket("localhost", 1237);

            System.out.println("nazwiązano połączenie");
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);

            String line = in.readLine();
            System.out.println("Odczytano " + line);
            out.println("hello od clienta");
            line = in.readLine();
            System.out.println("odpowiedź: " + line);

            in.close();
            out.close();
            s.close();

        } catch (IOException e) {

        }

    }

}
