/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDatos.AccesoMateria;
import Entidades.Materia;
import Excepciones.ExcepcionBaseDeDatos;
import java.sql.ResultSet;

/**
 *
 * @author Augusto
 */
public class CN_Materias {
    public ResultSet mostrarMateriasHabilitadas() throws ExcepcionBaseDeDatos{
        AccesoMateria accesoMateria = new AccesoMateria();
        return accesoMateria.mostrarMateriasHabilitadas();
    }
    
    public Materia buscarMateriaPorCodigo(int cod) throws ExcepcionBaseDeDatos{
        AccesoMateria accesoMateria = new AccesoMateria();
        return accesoMateria.buscarMateriaPorCodigo(cod);
    }
}
