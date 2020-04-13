/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthoserv.security;

/**
 *
 * @author anthoserv
 * @version 1.0
 */
public interface Security {

   /**
     * Permite generar un SHA-256 en base una cadena de carácteres
     * @param args
     * @return 
     */
    String SHA256(String args);
 /**
     *Permite obterner un código basado en caracteres de acuerdo a la longitud de las cadenas
     * @param length
     * @return
     */
    String getPinLetters(int length);
/**
     *Permite generar un codigo de acuerdo a números 
     * @param length
     * @return
     */
    String getPinNumber(int length);
 /**
     * Permite generar un código de acuerdo a la fecha
     *
     * @return
     */
    String getPinFecha();
  /**
     * Permite generar un token de acuerdo a una cadena de carácteres 
     * @param secureLength
     * @param pos_secret
     * @return 
     */
    String nextToken(int secureLength, String pos_secret);
}
