/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2016;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aleja
 */
public class Examen2016 {

    public static void main(String[] args) 
    {
        try
        {
         ConexionBD conexionBD = new ConexionBD ();
         Connection conexion = conexionBD.getConexion ();
         Statement sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
         Statement sentencia2 = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         String sql = "EXECUTE insertarMascotaEnfermedad ?,?,?";
         String sql2 = "INSERT INTO BI_Visitas (Fecha, Temperatura, Peso, Mascota) VALUES (?,?,?,?)";
         CallableStatement senllamable = conexion.prepareCall (sql);
         CallableStatement senllamable2 = conexion.prepareCall (sql2);
         
         sentencia.execute("USE Bichos");
         
         ResultSet actualizaciones = sentencia.executeQuery ("SELECT * FROM BI_Actualizaciones");
         ResultSet mascotas = sentencia2.executeQuery ("SELECT * FROM BI_Mascotas");
         
          while (actualizaciones.next ())
            {
                //Insercion mascotas
                mascotas.moveToInsertRow();
                if (actualizaciones.getString ("CodigoMascota") != null
                    && actualizaciones.getString ("Raza") != null
                    && actualizaciones.getString ("Especie") != null
                    && actualizaciones.getDate ("FechaNacimiento") != null
                    && actualizaciones.getString ("Alias") != null
                    && actualizaciones.getInt ("CodigoPropietario") != 0)
                {
                    mascotas.updateString("Codigo", actualizaciones.getString ("CodigoMascota"));
                    mascotas.updateString("Raza", actualizaciones.getString ("Raza"));
                    mascotas.updateString("Especie", actualizaciones.getString ("Especie"));
                    mascotas.updateDate("FechaNacimiento", actualizaciones.getDate ("FechaNacimiento"));
                    mascotas.updateDate("FechaFallecimiento", actualizaciones.getDate ("FechaFallecimiento"));
                    mascotas.updateString("Alias", actualizaciones.getString ("Alias"));
                    mascotas.updateInt("CodigoPropietario", actualizaciones.getInt ("CodigoPropietario"));
                    mascotas.insertRow ();
                }
                //Fin insercion mascotas
                
                //Insercion Mascotas-Enfermedades
                if (actualizaciones.getString ("Enfermedad") != null
                    && actualizaciones.getDate ("FechaNacimiento") != null
                    && actualizaciones.getString("CodigoMascota") != null)
                {
                    senllamable.setString (1,actualizaciones.getString ("Enfermedad"));
                    senllamable.setDate (2,actualizaciones.getDate ("FechaNacimiento")); //No se cual es la fecha a la que se refiere asi que pongo esta mientras.
                    senllamable.setString (3,actualizaciones.getString("CodigoMascota"));
                    senllamable.executeUpdate();
                }
                //Fin insercion Mascotas-Enfermedades
                
                //Insercion Visitas
                if (actualizaciones.getTimestamp ("Fecha") != null
                    && actualizaciones.getInt ("Temperatura") != 0
                    && actualizaciones.getInt ("Peso") != 0
                    && actualizaciones.getString ("CodigoMascota") != null)
                {
                    senllamable2.setTimestamp(1, actualizaciones.getTimestamp ("Fecha"));
                    senllamable2.setInt (2, actualizaciones.getInt ("Temperatura"));
                    senllamable2.setInt (3, actualizaciones.getInt ("Peso"));
                    senllamable2.setString (4, actualizaciones.getString ("CodigoMascota"));
                    senllamable2.executeUpdate();
                }
                //Fin insercion visitas
            }
            
            conexion.close ();
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    
}
