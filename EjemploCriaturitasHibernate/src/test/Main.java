/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import acceso.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistente.*;

/**
 *
 * @author agomez
 */
public class Main {
    
    public static void main (String [] args)
    {
        ManejadorCriaturitas mc = new ManejadorCriaturitas ();
        ManejadorRegalos mr = new ManejadorRegalos ();
        ManejadoraMain mm = new ManejadoraMain();
        
        Criaturitas criaturita = null;
        Criaturitas criaturita2 = null;
        Criaturitas criaturita3 = null;
        Regalos regalo = null;
        Regalos regalo2 = null;
        List<Regalos> regalos = new ArrayList<Regalos>();
        List<Regalos> regalos2 = new ArrayList<Regalos>();
        
        Session ses = HibernateUtil.getSessionFactory().openSession();
        
        
        //Borrar una criaturita y todos sus regalos
        mc.borrar (ses, Short.parseShort("3"));
        
        //Crear un nuevo regalo y asignarlo a una criaturita existente
        criaturita = mc.recuperar(ses, Short.parseShort("2")); //Aqui todavia no es persistente
        regalo = mr.crearRegalo(ses, Short.parseShort("50"), criaturita, "denominacion", Short.parseShort("20"), Short.parseShort("10"), Short.parseShort("40"), 'A', Short.valueOf("15"), BigDecimal.valueOf(15.5));
        //Este regalo si es persistente
        regalos.add (regalo);
        criaturita.setRegalosList(regalos);
       
        Transaction tran;
        tran = ses.beginTransaction();
        ses.update(criaturita); //Aqui criaturita se ha vuelto persistente y se ha sincronizado con la badat
        tran.commit ();
        
        //Cambiar el propietario de un regalo de una criaturita a otra
        regalo2 = mr.recuperar(ses, Short.valueOf("4"));
        criaturita2 = mc.recuperar(ses, Short.valueOf ("15"));
        
        mr.cambiarPropietario (ses, regalo2, criaturita2);
        
        //Crea una nueva criaturita con dos nuevos regalos
        
        criaturita3 = mc.crearCriaturita(ses, "Nueva criaturita", Short.valueOf("50"));
        regalos.add(mr.crearRegalo(ses, Short.parseShort("54"), criaturita3, "denominacion", Short.parseShort("20"), Short.parseShort("10"), Short.parseShort("40"), 'A', Short.valueOf("15"), BigDecimal.valueOf(15.5)));
        regalos.add(mr.crearRegalo(ses, Short.parseShort("21"), criaturita3, "denominacion321", Short.parseShort("13"), Short.parseShort("12"), Short.parseShort("12"), 'D', Short.valueOf("15"), BigDecimal.valueOf(12.5)));
        criaturita3.setRegalosList(regalos2);
        ses.update(criaturita3);
        
        
        
        ses.close ();
    }
}
