package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, AWTException {
        Socket s = new Socket("localhost", 8189);


        //Socket incoming = s.accept();
        InputStream inStream = s.getInputStream();
        OutputStream outStream = s.getOutputStream();
        Scanner in = new Scanner(inStream);
        PrintWriter out = new PrintWriter(outStream, true/*autoFlush */);
       //System.out.println(in.nextLine());
       //System.out.println(in.nextLine());

        Scanner sckeyboard = new Scanner(System.in);

            Thread th1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    while(true) {
                        String myLine = sckeyboard.nextLine();
                        out.println(myLine);
                        out.flush();
                        if(myLine.equals("bye"))
                            break;
                    }
                }
            });
            th1.start();
            Thread th2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        System.out.println(in.nextLine());
                        System.out.flush();
                    }
                }
            });
            th2.start();

        }

        /*
         *  tutaj petla do wpisywania tekstu i wysylania na serwer
         *
         */

    }



        // out.println("You connected with "+incoming.getLocalSocketAddress());
        //out.println("Enter bye to exit");
        /*
        boolean bye=false;
        while(!bye && in.hasNextLine()){
            String line = in.nextLine();
            out.println("message:"+line);
            if(line.trim().equals("bye"))
                bye =true;
        }
        */


