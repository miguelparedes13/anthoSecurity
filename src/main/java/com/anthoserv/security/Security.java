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

  
    String SHA256(String args);

    String getPinLetters(int length);

    String getPinNumber(int length);

    String getPinFecha();

    String nextToken(int secureLength, String pos_secret);
}
