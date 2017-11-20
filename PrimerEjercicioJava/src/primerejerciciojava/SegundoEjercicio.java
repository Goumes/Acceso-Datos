/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerejerciciojava;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;
import java.text.ParseException;

/**
 *
 * @author agomez
 */
public class SegundoEjercicio 
{
    public static void main (String [] args)
    {
        Random random = new Random ();
        
        try
        {
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "pepejava";
            String password = "123";
           
            String sql = "Execute GrabaSencilla ?, ?, ?, ?, ?, ? ,?";
            Connection conexion = DriverManager.getConnection(sourceURL,usuario, password);
            CallableStatement senllamable = conexion.prepareCall (sql);
            Calendar cal = Calendar.getInstance();
            cal.set (Calendar.YEAR, 2018);
            cal.set (Calendar.MONTH, 9);
            cal.set (Calendar.DAY_OF_MONTH, 27);
            cal.set (Calendar.HOUR_OF_DAY, 15);
            cal.set (Calendar.MINUTE, 34);
            cal.set (Calendar.SECOND, 9);
            cal.set (Calendar.MILLISECOND, 0);
            
            //senllamable.setString (1, "20181027 15:34:09");
            
            senllamable.setTimestamp (1, new Timestamp (cal.getTimeInMillis ())); // Funciona bien
            
            System.out.println(cal.getTimeInMillis ());
            
            for (int i = 0; i < 4; i++)
            {
                for (int j = 2; j < 8; j++)
                {
                    senllamable.setInt (j, random.nextInt(49) + 1);
                }
                senllamable.executeUpdate();
            }
            
            conexion.close ();
        }
        
        catch (SQLException e)
        {
            e.printStackTrace ();
        }
        
        
    }
}
