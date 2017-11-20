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
            Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // TYPE_SCROLL_SENSITIVE nos proporciona control total de los datos, e insensitive nos permite trabajar varios sobre
            // Los mismos datos, pues se hace una copia para cada uno. Puede ocasionar conflictos. Con estos dos se pueden utilizar
            // todos los métodos de posicionamiento.
            // CONCUR_READ_ONLY y CONCUR_UPDATABLE.
            
            sentencia.execute("USE Primitiva");
            
            ResultSet numeros = sentencia.executeQuery ("SELECT Valor FROM NumerosSorteo");
            
            //numeros.last ();
            numeros.absolute(1); //Las filas empiezan en el 1, no en el 0.
            //numeros.deleteRow ();
            System.out.println(numeros.getInt ("Valor"));
            
            numeros.beforeFirst (); //First me pone en la primera fila, pero el metodo next itera a la siguiente y no imprime la primera.
            
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
