package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket s =new ServerSocket(8189);


        Socket incoming = s.accept();
        InputStream inStream = incoming.getInputStream();
        OutputStream outStream = incoming.getOutputStream();
        Scanner in =new Scanner(inStream);
        PrintWriter out =new PrintWriter(outStream,true/*autoFlush */);
        out.println("You connected with "+incoming.getLocalSocketAddress());
        out.println("Enter bye to exit");

        boolean bye=false;
        while(!bye && in.hasNextLine()){
            String line = in.nextLine();

            out.println("message:"+line);
            if(line.trim().equals("bye"))
                bye =true;
        }



/*

        for (int i=0;i<5;i++){
            Thread th = new Thread(new Runnable() {

                @Override
                public void run() {
                    for(int j=0;j<10;j++)
                        System.out.println("Watek 1"+this.toString()+" dziala "+j);
                }
            });
            th.start();
        }

	// write your code here
	*/
    }

}
