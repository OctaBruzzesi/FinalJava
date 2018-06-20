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
public class ExcepcionFormatoImagen extends Exception {
    
    public String DescripcionError(){
        return ("Solo se admiten imagenes con formato jpg, jpeg o png.");
    }
}
