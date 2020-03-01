package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandler {
    Socket s;
    InputStream is;
    OutputStream os;
    PrintWriter out;
    Scanner in;
    public SocketHandler(Socket s) throws IOException {
        is = s.getInputStream();
        os = s.getOutputStream();
          in = new Scanner(is);
          out = new PrintWriter(os,true);
    }




}
