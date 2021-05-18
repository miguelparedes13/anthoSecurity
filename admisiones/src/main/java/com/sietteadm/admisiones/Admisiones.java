/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sietteadm.admisiones;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

/**
 *
 * @author anthoserv
 */
public class Admisiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Admisiones admisiones = new Admisiones();
            admisiones.obtenerResultados("https://evl.grammata.es:443/siette/api/v1/results-by-test-ids?testIds=10474", "evs", "2367rty34");
            // TODO code application logic here
        } catch (Exception ex) {
            System.err.println("ex" + ex.getMessage());
        }
    }

    private void obtenerResultados(String url, String usuario, String password) throws Exception {

        String authString = usuario + ":" + password;
        System.out.println("auth string: " + authString);
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        System.out.println("Base64 encoded auth string: " + authStringEnc);
        URL urlApi = new URL(url);
        HttpURLConnection httpConnection = (HttpURLConnection) urlApi.openConnection();
        httpConnection.setDoOutput(true);
        httpConnection.setRequestMethod("GET");
        httpConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        httpConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
        httpConnection.setRequestProperty("Accept", "application/json");
        Integer responseCode = httpConnection.getResponseCode();
        BufferedReader bufferedReader;
        if (responseCode > 199 && responseCode < 300) {
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
        }
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        bufferedReader.close();
        JSONObject jsonObject = new JSONObject(content.toString());
        System.err.println("datos" + jsonObject.toString());
//        Map<String, Object> toMap = jsonObject.toMap();
//
//        System.err.println("datos" + toMap.toString());

    }

}
