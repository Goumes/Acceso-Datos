/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import acceso.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import persistente.*;

/**
 *
 * @author agomez
 */
public class Main {
    
    public static void main (String [] args)
    {
        /*
        ManejadorCriaturitas mc = new ManejadorCriaturitas ();
        ManejadorRegalos mr = new ManejadorRegalos ();
        ManejadoraMain mm = new ManejadoraMain();
        Criaturitas criaturita = null;
        Criaturitas criaturita2 = null;
        List<Regalos> regalos = null;
        List<Regalos> regalos2 = null;
        Regalos regalo1 = null;
    
        //Borrar una criaturita y todos sus regalos
        mc.borrar (Short.parseShort("3"));
        
        //Crear una criaturita con dos nuevos regalos
        mc.crearCriaturita("pepejava", Short.parseShort("11"));
        criaturita = mc.recuperar(Short.parseShort("12"));
        
        regalo1 = mr.crearRegalo(Short.parseShort("50"), criaturita, "denominacion", Short.parseShort("20"), Short.parseShort("10"), Short.parseShort("40"), 'A', Short.valueOf("15"), BigDecimal.valueOf(15.5));
        regalos.add(regalo1);
        regalos.add(mr.crearRegalo(Short.parseShort("120"), criaturita, "denominaçao", Short.parseShort("220"), Short.parseShort("410"), Short.parseShort("430"), 'C', Short.valueOf("153"), BigDecimal.valueOf(125.5)));
        
        criaturita.setRegalosList(regalos);
        
        //Cambiar propietario
        mr.cambiarPropietario(regalo1, criaturita);
        
        //Crear un nuevo regalo y asignarlo a una criaturita existente
        criaturita2 = mc.recuperar(Short.parseShort("2"));
        criaturita2.setRegalosList(regalos2);
        
        regalo1 = mr.crearRegalo(Short.parseShort("50"), criaturita2, "denominacion", Short.parseShort("20"), Short.parseShort("10"), Short.parseShort("40"), 'A', Short.valueOf("15"), BigDecimal.valueOf(15.5));
        */
        
        ManejadorCriaturitas mc = new ManejadorCriaturitas ();
        ManejadorRegalos mr = new ManejadorRegalos ();
        ManejadoraMain mm = new ManejadoraMain();
        
        Criaturitas criaturita = null;
        Regalos regalo = null;
        List<Regalos> regalos = null;
        
        Session ses = HibernateUtil.getSessionFactory().openSession();
        
        //Borrar una criaturita y todos sus regalos
        mc.borrar (ses, Short.parseShort("3"));
        
        //Crear un nuevo regalo y asignarlo a una criaturita existente
        criaturita = mc.recuperar(ses, Short.parseShort("2"));
        regalo = mr.crearRegalo(ses, Short.parseShort("50"), criaturita, "denominacion", Short.parseShort("20"), Short.parseShort("10"), Short.parseShort("40"), 'A', Short.valueOf("15"), BigDecimal.valueOf(15.5));
        regalos.add (regalo);
        criaturita.setRegalosList(regalos);
        
        ses.close ();
    }
}
