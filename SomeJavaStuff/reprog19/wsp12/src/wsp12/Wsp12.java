/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsp12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author wlasciciel
 */
public class Wsp12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        
        InputStream in = new FileInputStream("ja02.jpg");
        OutputStream out = new FileOutputStream("kopia.jpg");
        
        long ile=0;
        int b;
        while((b=in.read())!=-1){
            out.write(b);
            ile++;
        }
        in.close();
        out.close();
        System.out.println("przekopiowano bajtów "+ile);
                
        
        
        
    }
    
}
