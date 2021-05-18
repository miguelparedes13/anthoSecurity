/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthoserv.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anthoserv
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     

        try {
            URL whatismyip = new URL("https://www.whatismyip.com/");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            
            String ip = in.readLine();
            System.out.println("My Public ip is = " + ip);
            in.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
