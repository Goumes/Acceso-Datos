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
    public int insertarAvion (Connection conexion, String matricula, String nombre, int idFabricante, String modelo, Date fechaFabricacion, Date fechaEntrada, int fila, int asientoFila, int autonomia)
    {
        int resultado = 1;
        try
        {
            Statement sentencia2 = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet aviones = sentencia2.executeQuery ("SELECT * FROM AS_Aviones");
            aviones.moveToInsertRow ();
            aviones.updateString ("Matricula", matricula);
            aviones.updateString ("Nombre", nombre);
            aviones.updateInt ("ID_Fabricante", idFabricante);
            aviones.updateString ("Modelo", modelo);
            aviones.updateDate ("Fecha_Fabricacion", fechaFabricacion);
            aviones.updateDate ("Fecha_Entrada", fechaEntrada);
            aviones.updateInt ("Filas", fila);
            aviones.updateInt ("Asientos_x_Fila", asientoFila);
            aviones.updateInt ("Autonomia", autonomia);
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
    public int darBajaAvion (Connection conexion, String matricula)
    {
        int resultado = 1;
        try
        {
            String procedure = "Execute bajaAvion ?";
            CallableStatement senllamableProcedure = conexion.prepareCall (procedure);
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
    public int insertarIncidencia (Connection conexion, String matricula, BigDecimal latitud, BigDecimal longitud, String descripcion, String tipo)
    {
        int resultado = 1;
        try
        {
            String incidencia = "INSERT INTO AS_Incidencias (Avion, Latitud, Longitud, Descripcion, Tipo) VALUES (?, ?, ?, ?, ?)";
            CallableStatement senllamableIncidencias =  conexion.prepareCall (incidencia);
            senllamableIncidencias.setString (1, matricula);
            senllamableIncidencias.setBigDecimal(2, latitud);
            senllamableIncidencias.setBigDecimal (3, longitud);
            senllamableIncidencias.setString (4, descripcion);
            senllamableIncidencias.setString (5, tipo);
            senllamableIncidencias.executeUpdate ();
        }
        
        catch (SQLException e)
        {
            e.printStackTrace ();
            resultado = 0;
        }
        
        return resultado;
    }
    
    public int buscarIdFabricante (Connection conexion, String nombre)
    {
        int resultado = 0;
        try
        {
            String procedure = "EXECUTE buscarIdFabricante ?, ?";
            CallableStatement senllamableProcedure = conexion.prepareCall (procedure);
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
