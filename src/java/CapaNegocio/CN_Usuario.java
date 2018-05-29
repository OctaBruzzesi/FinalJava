/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDatos.AccesoUsuario;
import Entidades.Usuario;
import Excepciones.ExcepcionBaseDeDatos;

/**
 *
 * @author Augusto
 */
public class CN_Usuario {
    
    public Usuario buscarUsarioSinClave(int legajo) throws ExcepcionBaseDeDatos{
 
        AccesoUsuario accesoUsuario = new AccesoUsuario();
        return accesoUsuario.buscarUsuarioSinClave(legajo);
    }
}
