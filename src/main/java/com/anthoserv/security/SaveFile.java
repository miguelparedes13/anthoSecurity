/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthoserv.security;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author anthoserv
 */
public class SaveFile {

    public static SaveFile newInstance() {
        return new SaveFile();
    }

    /**
     *
     * @param directorio
     * @param nombreArchivo
     * @param inputStream
     * @return
     * @throws Exception
     */
    public String crearDirectorio(String directorio, String nombreArchivo, InputStream inputStream) throws Exception {
        FileOutputStream fileOutputStream;
        try {
            File f = new File(".");
            String url = f.getCanonicalPath();
            String urlFinal = url + File.separator + "welcome-content" + directorio;
            java.io.File directorioInicial = new File(urlFinal);
            if (!directorioInicial.exists()) {
                directorioInicial.mkdirs();
            }
            if (!directorioInicial.canWrite()) {
                directorioInicial.setWritable(true);
            }
            if (!directorioInicial.canRead()) {
                directorioInicial.setReadable(true);
            }
            directorioInicial.list();
            String archivo = urlFinal + File.separator + nombreArchivo;
            fileOutputStream = new FileOutputStream(
                    archivo);
            byte[] buffer = new byte[6124];
            int bulk;
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();
            return archivo;
        } catch (FileNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }

    }

    /**
     *
     * @param directorio
     * @param nombreArchivo
     * @return
     * @throws Exception
     */
    public String crearDirectorioString(String directorio, String nombreArchivo) throws Exception {
        try {
            File f = new File(".");
            String url = f.getCanonicalPath();
            String urlFinal = url + File.separator + directorio;
            java.io.File directorioInicial = new File(urlFinal);
            if (!directorioInicial.exists()) {
                directorioInicial.mkdir();
            }
            if (!directorioInicial.canWrite()) {
                directorioInicial.setWritable(true);
            }
            if (!directorioInicial.canRead()) {
                directorioInicial.setReadable(true);
            }
            directorioInicial.list();
            String archivo = urlFinal + File.separator + nombreArchivo;

            return archivo;
        } catch (FileNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }

    }

    public String extensionFile(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i >= 0) {
            extension = fileName.substring(i + 1);
        }
        return "."+extension;
    }
}
