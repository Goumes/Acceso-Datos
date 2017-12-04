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
            Avion oAvion;
            Incidencia oIncidencia;
            GestoraExamen gestora = new GestoraExamen ();
            ConexionBD conexionBD = new ConexionBD (); //En el constructor vacío de mi clase conexión se conecta automáticamente al usuario 'prueba' y pass '123'.
            Connection conexion = conexionBD.getConexion ();
            Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            sentencia.execute("USE AirSafety");
            String incidencia = "INSERT INTO AS_Incidencias (Avion, Latitud, Longitud, Descripcion, Tipo) VALUES (?, ?, ?, ?, ?)";
            CallableStatement senllamableIncidencias =  conexion.prepareCall (incidencia);
            String procedure = "EXECUTE buscarIdFabricante ?, ?";
            CallableStatement senllamableProcedure = conexion.prepareCall (procedure);
            String procedure2 = "Execute bajaAvion ?";
            CallableStatement senllamableProcedure2 = conexion.prepareCall (procedure2);
            String actualizacionesString = "SELECT MatriculaAvion, Latitud, Longitud, Descripcion, Tipo, AccidenteDefinitivo, NombreAvion, Fabricante, Modelo, Fecha_Fabricacion, Fecha_Entrada, Filas, Asientos_x_Fila, Autonomia FROM EX_Actualizaciones";
            Statement sentencia3 = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet aviones = sentencia3.executeQuery ("SELECT Matricula, Nombre, ID_Fabricante, Modelo, Fecha_Fabricacion, Fecha_Entrada, Filas, Asientos_x_Fila, Autonomia, Activo FROM AS_Aviones");
            //CallableStatement senllamableFabricante = conexion.prepareCall (fabricante);
            int id = 0;
            
            
            ResultSet actualizaciones = sentencia.executeQuery (actualizacionesString);    
            while (actualizaciones.next ())
            {
                //Insercion Avion
                if (actualizaciones.getString ("NombreAvion") != null)
                {
                    id = gestora.buscarIdFabricante(senllamableProcedure, conexion, actualizaciones.getString ("Fabricante"));
                    oAvion = new Avion (actualizaciones.getString ("MatriculaAvion"),  actualizaciones.getString("NombreAvion"), id, actualizaciones.getString ("Modelo"), actualizaciones.getDate("Fecha_Fabricacion"),
                    actualizaciones.getDate("Fecha_Entrada"), actualizaciones.getInt ("Filas"), actualizaciones.getInt ("Asientos_x_Fila"), actualizaciones.getInt ("Autonomia"));
                    //He tenido un problema al hacer el procedimiento que devuelve la id del fabricante en el apartado de SQL. He dejado el metodo
                    //de java hecho como si funcionara el de sql, pero no va a insertar correctamente porque va a ser 0. Si quieres comprobar si
                    //este insert funciona correctamente, cambia la variable id por un 3.
                    gestora.insertarAvion(aviones, conexion, oAvion);
                }
                
                //Dar de baja avion
                if (actualizaciones.getBoolean ("AccidenteDefinitivo") == true)
                {
                    gestora.darBajaAvion(senllamableProcedure2, conexion, actualizaciones.getString("MatriculaAvion"));
                }
                
                //Insercion Incidencia
                
                oIncidencia = new Incidencia (actualizaciones.getString("MatriculaAvion"), actualizaciones.getBigDecimal ("Latitud"), actualizaciones.getBigDecimal ("Longitud"),
                actualizaciones.getString("Descripcion"), actualizaciones.getString("Tipo"));
                gestora.insertarIncidencia(senllamableIncidencias, conexion, oIncidencia);
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
