/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthoserv.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Calendar;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.time.DateFormatUtils;
/**
 * Clase que permite  generar códigos de seguridad
 * @author anthoserv
 */
public class SecurityImpl  {

    public static String NUMEROS = "0123456789";
    public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    public static String ESPECIALES = "#@%/?";
  /**
     *
     * @return
     */
  
 
    public static  SecurityImpl newInstance() {
        return new SecurityImpl();
    }

    /**
     * Permite generar un SHA-256 en base una cadena de carácteres
     * @param args
     * @return 
     */
    public String SHA256(String args) {
        if (args == null) {
            return "";
        }
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(args.getBytes());
            md.digest();
            String hash = Base64.encodeBase64String(md.digest(args.getBytes()));
            return hash.trim();

        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

   
    /**
     *
     * @param key
     * @param length
     * @return
     */
    private  String getPassword(String key, int length) {
        String pswd = "";

        for (int i = 0; i < length; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }

        return pswd;
    }

    /**
     *Permite obterner un código basado en caracteres de acuerdo a la longitud de las cadenas
     * @param length
     * @return
     */
    public  String getPinLetters(int length) {
        return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS + ESPECIALES,
                length);
    }

    //

    /**
     *Permite generar un codigo de acuerdo a números 
     * @param length
     * @return
     */
    public  String getPinNumber(int length) {
        return getPassword(NUMEROS, length);
    }

   /**
     * Permite generar un código de acuerdo a la fecha
     *
     * @return
     */
   
    public String getPinFecha() {
        String patron = "yyMMddHHmmss";
        String timestamp = DateFormatUtils.format(Calendar.getInstance(), patron);
        StringBuilder utfi = new StringBuilder();
        utfi.append(timestamp).append("");
        return utfi.toString();
    }
    /**
     * Permite generar un token de acuerdo a una cadena de carácteres 
     * @param secureLength
     * @param pos_secret
     * @return 
     */
     public String nextToken(int secureLength,String pos_secret) {
        char[] buf = new char[secureLength];
        SecureRandom random = new SecureRandom();
        char[] symbols = pos_secret.toCharArray();
        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }    
}
