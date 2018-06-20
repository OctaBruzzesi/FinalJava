/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDatos.AccesoConsulta;
import Excepciones.ExcepcionBaseDeDatos;
import java.sql.ResultSet;

/**
 *
 * @author Augusto
 */
public class CN_Consultas {
       
    
    public ResultSet mostrarConsultas(int id_materia) throws ExcepcionBaseDeDatos{
        AccesoConsulta accesoConsulta = new AccesoConsulta();
        return accesoConsulta.mostrarConsultas(id_materia);
    }
}
