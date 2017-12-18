/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_alejandro_gomez;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author agomez
 */
public class GestoraExamen 
{
    /* Entradas: 3 strings, una connection, 4 ints y 2 sql.Date
    Salidas: 1 entero
    Descripcion: Metodo dedicado a insertar un avion en la badat.
    Postcondiciones: un entero indicando si el insert ha sido exitoso o no 
    */
    public int insertarAvion (ResultSet aviones, Connection conexion, Avion avion)
    {
        int resultado = 1;
        try
        {
            aviones.moveToInsertRow ();
            aviones.updateString ("Matricula", avion.getMatricula ());
            aviones.updateString ("Nombre", avion.getNombre ());
            aviones.updateInt ("ID_Fabricante", avion.getIdFabricante ());
            aviones.updateString ("Modelo", avion.getModelo ());
            aviones.updateDate ("Fecha_Fabricacion", avion.getFechaFabricacion ());
            aviones.updateDate ("Fecha_Entrada", avion.getFechaEntrada ());
            aviones.updateInt ("Filas", avion.getFila ());
            aviones.updateInt ("Asientos_x_Fila", avion.getAsientoFila ());
            aviones.updateInt ("Autonomia", avion.getAutonomia ());
            aviones.insertRow ();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            resultado = 0;
        }
        
        return resultado;
    }
    
    /* Entradas: 1 String y una connection
    Salidas: 1 entero
    Descripcion: Metodo dedicado a dar de baja un avion en la badat.
    Postcondiciones: un entero indicando si el insert ha sido exitoso o no 
    */
    public int darBajaAvion (CallableStatement senllamableProcedure, Connection conexion, String matricula)
    {
        int resultado = 1;
        try
        {
            senllamableProcedure.setString (1, matricula);
            senllamableProcedure.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace ();
            resultado = 0;
        }
        
        return resultado;
    }
    
    /* Entradas: 3 strings, una connection y 2 BigDecimals
    Salidas: 1 entero
    Descripcion: Metodo dedicado a insertar una incidencia en la badat.
    Postcondiciones: un entero indicando si el insert ha sido exitoso o no 
    */
    public int insertarIncidencia (CallableStatement senllamableIncidencias, Connection conexion, Incidencia incidencia)
    {
        int resultado = 1;
        try
        {
            senllamableIncidencias.setString (1, incidencia.getMatricula ());
            senllamableIncidencias.setBigDecimal(2, incidencia.getLatitud ());
            senllamableIncidencias.setBigDecimal (3, incidencia.getLongitud ());
            senllamableIncidencias.setString (4, incidencia.getDescripcion());
            senllamableIncidencias.setString (5, incidencia.getTipo());
            senllamableIncidencias.executeUpdate ();
        }
        
        catch (SQLException e)
        {
            e.printStackTrace ();
            resultado = 0;
        }
        
        return resultado;
    }
    
    public int buscarIdFabricante (CallableStatement senllamableProcedure, Connection conexion, String nombre)
    {
        int resultado = 0;
        try
        {
            senllamableProcedure.setString (1, nombre);
            senllamableProcedure.registerOutParameter (2,java.sql.Types.INTEGER); 
            senllamableProcedure.executeUpdate();
            resultado = senllamableProcedure.getInt(2);
        }
        catch (SQLException e)
        {
            e.printStackTrace ();
        }
        
        return resultado;
    }
    
}
