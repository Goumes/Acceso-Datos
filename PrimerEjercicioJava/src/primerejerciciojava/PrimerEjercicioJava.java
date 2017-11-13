/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerejerciciojava;

import java.sql.*;

/**
 *
 * @author agomez
 */
public class PrimerEjercicioJava 
{
    public static void main(String[] args) 
    {
         try
        {
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "pepejava";
            String password = "123";
            Connection conexion = DriverManager.getConnection(sourceURL,usuario, password);
            Statement sentencia = conexion.createStatement();
            
            sentencia.execute("USE Primitiva");
            
            ResultSet numeros = sentencia.executeQuery ("SELECT Valor FROM NumerosSorteo");
            
            while (numeros.next ())
            {
                System.out.println (numeros.getInt ("Valor"));
            }
            
            conexion.close ();
        }
        
        catch (SQLException e)
        {
            System.out.println(e);
        }

    }
    
}
