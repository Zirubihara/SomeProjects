package com.company;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerWatki{

    public static void main(String[] args) throws IOException {
        // Replace with suitable executor
        List<SocketHandler> sockety = new ArrayList<>();
        ExecutorService executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8189);

        while (true) {
            final Socket socket = serverSocket.accept();
            SocketHandler sh = new SocketHandler(socket);
            sockety.add(sh);
            executor.execute(new Runnable() {

                public void run() {
                    try {

                        handleSocket(sh);
                    } catch (IOException e) {
                        // Handle exception
                    }

                }

                private void handleSocket(final SocketHandler hs) throws IOException {

                    boolean bye=false;
                    while(!bye && hs.in.hasNextLine()){
                        String line = hs.in.nextLine();
                        if(line.trim().equals("bye"))
                            bye = true;
                            for(int i=0;i<sockety.size();i++){
                                      sockety.get(i).out.println(line);
                                      sockety.get(i).out.flush();
                            }
                            //out.println(line);
                        }


                    }

            });
        }
    }
}