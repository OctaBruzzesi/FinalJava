/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package CapaDatos;

import Entidades.Materia;
import Excepciones.ExcepcionBaseDeDatos;

import java.sql.*;


/**
*
* @author octas
*/
public class AccesoMateria extends Conexion {

    private ResultSet resultado;



    public AccesoMateria() //constructor invoca método Conectar para establecer comunicacion a la DB
    {
        Conectar();
    }

    public ResultSet mostrarMateriasHabilitadas() throws ExcepcionBaseDeDatos {
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM materia where habilitado <> 0 ORDER BY año");
            resultado = query.executeQuery();
            return resultado;
        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }

    }

    public ResultSet mostrarTodasMaterias() throws ExcepcionBaseDeDatos {
        try {
            resultado = stmt.executeQuery("SELECT * FROM materia ORDER BY año");
            return resultado;
        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }

    }

    public Materia buscarMateriaPorCodigo (int cod) throws ExcepcionBaseDeDatos {
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM materia where codMateria = ?");
            query.setInt(1, cod);
            resultado = query.executeQuery();
            resultado.next();
            Materia materia = new Materia(resultado.getInt(1),resultado.getString(2),resultado.getInt(3), resultado.getBoolean(4));
            return materia;
            
        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

    public ResultSet ultimoCodMateria() throws ExcepcionBaseDeDatos{
        try
        {
            getStmt();
            resultado=stmt.executeQuery(" SELECT max(codMateria) from materia");
            return resultado;

        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

    public void agregarMateria(String nombre, int anio, String [] selec) throws ExcepcionBaseDeDatos{
        try {
            stmt.executeUpdate("INSERT INTO materia (nombre, año, habilitado) VALUES('"+ nombre +"'," + anio + ", 1)");
            ResultSet rs = ultimoCodMateria();
            int codmat=0;
            if (rs.next())
            {
                codmat=rs.getInt(1);
            }
            for (int i=0; i<= (selec.length -1); i++)
            {
                stmt.executeUpdate("INSERT INTO materiaprof VALUES("+ codmat +"," + Integer.parseInt(selec[i]) + ")");
            }

        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

    public void habilitarMateria (String[] materia) throws ExcepcionBaseDeDatos{
        try {
            stmt.executeUpdate("UPDATE materia SET habilitado=0");
            for(int i=0; i<= (materia.length - 1); i++) {
                stmt.executeUpdate("UPDATE materia SET habilitado=1 where codMateria = " + Integer.parseInt(materia[i]));
            }

        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }
}
