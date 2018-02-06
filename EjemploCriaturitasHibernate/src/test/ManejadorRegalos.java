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
     public Regalos crearRegalo (Session ses, short id, Criaturitas criaturitas, String denominacion, short ancho, 
             short largo, short alto, Character tipo, short edadMinima, BigDecimal precio){
        Transaction tran;
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
        
        return regalazo;
    }
     
     public void cambiarPropietario (Session ses, Regalos regalazo, Criaturitas  criaturita)
     {
        Transaction tran;
        tran = ses.beginTransaction();
        
        regalazo.setGoesTo(criaturita);
        
        ses.update (regalazo);
        tran.commit();
     }
     
      public Regalos recuperar (Session ses, short id){
        Regalos regalazo;
        regalazo = (Regalos)ses.get(Regalos.class, id);
        return regalazo;
    }
      
    public void borrar (Session ses, short id){
      Regalos regalazo;
      Transaction tran;
      tran = ses.beginTransaction();
      regalazo = new Regalos (id);
      ses.delete (regalazo);
      tran.commit();
    }
    
    public List<Regalos> getRegalos(Session ses){
        TypedQuery  consulta;
        List<Regalos> todosRegalos;
        // No necesitamos datos de la conexion porque ya están definidos en el hibernate.cfg.xml
        String ordenConsulta ="from Regalos";
        consulta = ses.createQuery(ordenConsulta);
        todosRegalos=consulta.getResultList();
        return todosRegalos;

    }
    
    public void listaRegalos (Session ses, List<Regalos> lista){
        for (Regalos actual:lista){
            // El objeto es detached y con esto pasa a persistent
            ses.update(actual);
            System.out.println(cadenaRegalo(actual));
        }
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
