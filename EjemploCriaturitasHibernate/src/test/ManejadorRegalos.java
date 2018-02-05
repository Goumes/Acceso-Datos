/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import acceso.HibernateUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistente.Criaturitas;
import persistente.Regalos;

/**
 *
 * @author agomez
 */
public class ManejadorRegalos 
{
     public void crearRegalo (short id, Criaturitas criaturitas, String denominacion, short ancho, 
             short largo, short alto, Character tipo, short edadMinima, BigDecimal precio){
        Transaction tran;
        Session ses = HibernateUtil.getSessionFactory().openSession();
        tran = ses.beginTransaction();
        Regalos regalazo = new Regalos();
        regalazo.setId(id);
        regalazo.setDenominacion(denominacion);
        regalazo.setAncho(ancho);
        regalazo.setLargo(largo);
        regalazo.setAlto(alto);
        regalazo.setTipo(tipo);
        regalazo.setEdadMinima(edadMinima);
        regalazo.setPrecio(precio);
        regalazo.setGoesTo(criaturitas);
       // Al ejecutar el método save el objeto se convierte en persistente
        ses.save(regalazo);
        tran.commit();
        ses.close();
    }
     
     public void cambiarPropietario (Regalos regalazo, Criaturitas  criaturita)
     {
        Transaction tran;
        Session ses = HibernateUtil.getSessionFactory().openSession();
        tran = ses.beginTransaction();
        
        regalazo.setGoesTo(criaturita);
        
        ses.update (regalazo);
        tran.commit();
        ses.close();
     }
     
      public Regalos recuperar (short id){
        Regalos regalazo;
        Session ses = HibernateUtil.getSessionFactory().openSession();
        regalazo = (Regalos)ses.get(Regalos.class, id);
        ses.close();
        return regalazo;
    }
      
    public void borrar (short id){
      Regalos regalazo;
      Transaction tran;
      Session ses = HibernateUtil.getSessionFactory().openSession();
      tran = ses.beginTransaction();
      regalazo = new Regalos (id);
      ses.delete (regalazo);
      tran.commit();
      ses.close();
    }
    
    public List<Regalos> getRegalos(){
        TypedQuery  consulta;
        List<Regalos> todosRegalos;
        // No necesitamos datos de la conexion porque ya están definidos en el hibernate.cfg.xml
        Session ses = HibernateUtil.getSessionFactory().openSession();
        String ordenConsulta ="from Regalos";
        consulta = ses.createQuery(ordenConsulta);
        todosRegalos=consulta.getResultList();
        ses.close();
        return todosRegalos;

    }
    
    public void listaRegalos (List<Regalos> lista){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        for (Regalos actual:lista){
            // El objeto es detached y con esto pasa a persistent
            ses.update(actual);
            System.out.println(cadenaRegalo(actual));
        }
        ses.close();
    }
    public String cadenaRegalo (Regalos r){
        String cad;
        cad = "ID: "+r.getId() 
                + "  Denominacion: " + r.getDenominacion() 
                + "  Edad minima: " + r.getEdadMinima () 
                + "   Precio: " + r.getPrecio ();
        return cad;
    }
}
