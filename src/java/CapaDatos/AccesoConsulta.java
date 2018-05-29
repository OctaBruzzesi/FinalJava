/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package CapaDatos;

import Excepciones.ExcepcionBaseDeDatos;

import java.sql.*;


/**
*
* @author octas
*/
public class AccesoConsulta extends Conexion {

    private ResultSet resultado;



    public AccesoConsulta() //constructor invoca método Conectar para establecer comunicacion a la DB
    {
        Conectar();
    }

    public ResultSet mostrarConsultas(int id_mat) throws ExcepcionBaseDeDatos{
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM consulta where codMateria=?");
            query.setInt(1, id_mat);
            resultado = query.executeQuery();
            return resultado;
        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

    public void agregarConsulta(String titulo, String cuerpo, String etiquetas, int codMateria, int legAlumno) throws ExcepcionBaseDeDatos{
        try {

            stmt.executeUpdate("INSERT INTO consulta (estado, titulo, cuerpo, etiquetas, respuesta, codMateria, legajoAlumno, legajoProfesor, fecha) VALUES(" + "'abierto'," + "'" + titulo + "'," + "'" + cuerpo + "'," + "'" + etiquetas + "', ''," + codMateria + "," + legAlumno + ",null, CURDATE())");
        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

    public void agregarImagenConsulta(int codTema, String file) throws ExcepcionBaseDeDatos{
        try {
            stmt.executeUpdate("UPDATE consulta set imagen='" + file + "' where codTema =" + codTema);
        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

    public void responderConsulta(String respuesta, int legajoProfesor, int codTema) throws ExcepcionBaseDeDatos{
        try {
            stmt.executeUpdate("UPDATE consulta SET respuesta = '" + respuesta + "',  legajoProfesor = " + legajoProfesor + " WHERE codTema =" + codTema );
        }catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

    public ResultSet ultimoCodConsulta() throws ExcepcionBaseDeDatos {
        try
        {
            getStmt();
            resultado=stmt.executeQuery(" SELECT max(codTema) from consulta");
            return resultado;

        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }
}
