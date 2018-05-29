/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Augusto
 */
public class ExcepcionCamposVacios extends Exception {
    
    public String DescripcionError(){
        return ("Ningún campo puede quedar vacío.");
    }
}
