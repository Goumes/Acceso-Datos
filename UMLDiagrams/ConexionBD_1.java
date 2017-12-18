/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_alejandro_gomez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author agomez
 */
public class ConexionBD 
{
    private  String sourceURL;
    private  String usuario;
    private String password;
    private Connection conexion;
    
    public ConexionBD (String sourceURL, String usuario, String password) throws SQLException
    {
        this.sourceURL = sourceURL;
        this.usuario = usuario;
        this.password = password;
        this.conexion = connect ();
    }
    
    public ConexionBD () throws SQLException
    {
        this.sourceURL = "jdbc:sqlserver://localhost";
        this.usuario = "prueba";
        this.password = "123";
        this.conexion = connect ();
    }
    
    public Connection getConexion ()
    {
        return this.conexion;
    }
    
    public Connection connect () throws SQLException
    {
        Connection conexionB;
        conexionB = DriverManager.getConnection(this.sourceURL,this.usuario, this.password);

        
        return conexionB;
    }
    
    public void close () throws SQLException
    {
        this.conexion.close ();
    }
}
