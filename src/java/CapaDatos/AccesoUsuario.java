 /*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package CapaDatos;

import Entidades.Usuario;
import Excepciones.ExcepcionBaseDeDatos;

import java.sql.*;


/**
*
* @author octas
*/
public class AccesoUsuario extends Conexion {

    private ResultSet resultado;



    public AccesoUsuario() //constructor invoca método Conectar para establecer comunicacion a la DB
    {
        Conectar();
    }

    public Usuario buscarUsuario(int leg,String cla) throws ExcepcionBaseDeDatos{
        try
        {
            PreparedStatement query = con.prepareStatement("SELECT * FROM usuario WHERE legajo= ? AND contraseña= ?");
            query.setInt(1, leg);
            query.setString(2, cla);
            resultado = query.executeQuery();
            
            if (resultado.next()){
                Usuario usuario = new Usuario(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4),resultado.getString(5), resultado.getBoolean(6));
                return usuario;
            }
            else{
                return null;
            }
            

        }
        catch(SQLException e)
        {
            throw new ExcepcionBaseDeDatos();
        }

    }

    public Usuario buscarUsuarioSinClave(int leg) throws ExcepcionBaseDeDatos {
        try
        {         
            PreparedStatement query = con.prepareStatement("SELECT * FROM usuario WHERE legajo=?");
            query.setInt(1, leg);
            resultado = query.executeQuery();
            resultado.next();

            Usuario usuario = new Usuario(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4),resultado.getString(5), resultado.getBoolean(6));          
            return usuario;

        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

        public ResultSet listarUsuarios () throws ExcepcionBaseDeDatos{
        try{
            resultado = stmt.executeQuery("SELECT * FROM usuario where tipo <> 'administrador'");
            return resultado;
        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

    public void agregarUsuario (int legajo, String contra, String nombre, String apellido, String tipo) throws ExcepcionBaseDeDatos{
        try {
            stmt.executeUpdate("INSERT INTO usuario VALUES(" + legajo + ", '" + contra + "', '" + nombre + "', '" + apellido + "', '" + tipo + "', 0)");
        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

    public void habilitarUsuarios (String[] usuarios) throws ExcepcionBaseDeDatos{
        try {
            stmt.executeUpdate("UPDATE usuario SET habilitado=0");
            stmt.executeUpdate("UPDATE usuario SET habilitado=1 where tipo= 'administrador'");
            for(int i=0; i<= (usuarios.length -1); i++)
            stmt.executeUpdate("UPDATE usuario SET habilitado=1 where legajo = " + usuarios[i]);

        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

    public ResultSet mostrarProfesores() throws ExcepcionBaseDeDatos{
        try {
            ResultSet profesores = stmt.executeQuery("select * from usuario where tipo = 'profesor' and habilitado <> 0");
            return profesores;
        }
        catch(SQLException e) {
            throw new ExcepcionBaseDeDatos();
        }
    }

}
