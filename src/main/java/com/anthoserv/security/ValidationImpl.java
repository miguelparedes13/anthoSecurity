/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anthoserv.security;

import java.io.IOException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 * Clase que permite generar códigos de seguridad
 *
 * @author anthoserv
 */
public class ValidationImpl  {

    /**
     *
     * @return
     */
    public static ValidationImpl newInstance() {
        return new ValidationImpl();
    }

    /**
     * Permite validar un archivo mediante xml con un archivo xls
     * @param rutaXSD
     * @param rutaArchivoValidar
     * @return
     * @throws Exception 
     */
    public Boolean validarXSD(String rutaXSD, String rutaArchivoValidar) throws Exception  {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema sch = schemaFactory.newSchema(new StreamSource(rutaXSD));
            Validator validator = sch.newValidator();
            validator.validate(new StreamSource(rutaArchivoValidar));
            return true;
        } catch (SAXException | IOException ex) {
          throw  new Exception(ex.getMessage());
        }
    }

}
