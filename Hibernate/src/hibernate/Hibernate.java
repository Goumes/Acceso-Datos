/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Iterator;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author agomez
 */
public class Hibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory instancia = HibernateUtil.buildSessionFactory();
        Session session = instancia.openSession();
        TypedQuery q = session.createQuery("from BiMascotas");
 
        List<BiMascotas> lista = q.getResultList();
 
        BiMascotas e;
        for (int i = 0; i < lista.size(); i++)
        {
            System.out.println(lista.get(i).getAlias()+ " " + lista.get(i).getRaza());
        }
 
        session.close();
        instancia.close ();
        StandardServiceRegistryBuilder.destroy(instancia.getSessionFactoryOptions().getServiceRegistry());
    }
    
}
