/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_alejandro_gomez;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author agomez
 */
public class Examen_Alejandro_Gomez 
{
    public static void main(String[] args) 
    {
        try
        {
            GestoraExamen gestora = new GestoraExamen ();
            ConexionBD conexionBD = new ConexionBD (); //En el constructor vacío de mi clase conexión se conecta automáticamente al usuario 'prueba' y pass '123'.
            Connection conexion = conexionBD.getConexion ();
            Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement sentencia2 = conexion.createStatement (ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String actualizacionesString = "SELECT * FROM EX_Actualizaciones";
            //CallableStatement senllamableFabricante = conexion.prepareCall (fabricante);
            int id = 0;
            sentencia.execute("USE AirSafety");
            
            ResultSet actualizaciones = sentencia.executeQuery (actualizacionesString);    
            while (actualizaciones.next ())
            {
                //Insercion Avion
                if (actualizaciones.getString ("NombreAvion") != null)
                {
                    //He tenido un problema al hacer el procedimiento que devuelve la id del fabricante en el apartado de SQL. He dejado el metodo
                    //de java hecho como si funcionara el de sql, pero no va a insertar correctamente porque va a ser 0. Si quieres comprobar si
                    //este insert funciona correctamente, cambia la variable id por un 3.
                    id = gestora.darBajaAvion(conexion, actualizaciones.getString ("Fabricante"));
                    gestora.insertarAvion(conexion, actualizaciones.getString ("MatriculaAvion"), actualizaciones.getString("NombreAvion"),
                            id, actualizaciones.getString ("Modelo"), actualizaciones.getDate("Fecha_Fabricacion"), actualizaciones.getDate("Fecha_Entrada"),
                            actualizaciones.getInt ("Filas"), actualizaciones.getInt ("Asientos_x_Fila"), actualizaciones.getInt ("Autonomia"));
                }
                
                //Dar de baja avion
                if (actualizaciones.getBoolean ("AccidenteDefinitivo") == true)
                {
                    gestora.darBajaAvion(conexion, actualizaciones.getString("MatriculaAvion"));
                }
                
                //Insercion Incidencia
                
                gestora.insertarIncidencia(conexion, actualizaciones.getString("MatriculaAvion"), actualizaciones.getBigDecimal ("Latitud"),
                        actualizaciones.getBigDecimal ("Longitud"), actualizaciones.getString("Descripcion"), actualizaciones.getString("Tipo"));
            }
            
            conexionBD.close ();
            conexion.close ();
            
        }
        catch (SQLException e)
        {
            e.printStackTrace ();
        }
        
    } 
}
