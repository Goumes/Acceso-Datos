
package test;
import java.util.*;
import org.hibernate.*;
import persistente.*;
import acceso.*;
import javax.persistence.TypedQuery;
/**
 *
 * @author Leo
 */
public class ManejadorCriaturitas {
    public Criaturitas crearCriaturita (Session ses, String nombre, short id){
        Transaction tran;
        tran = ses.beginTransaction();
        Criaturitas nene = new Criaturitas();
        nene.setNombre(nombre);
        nene.setId(id);
		// Al ejecutar el método save el objeto se convierte en persistente
        ses.save(nene);
        tran.commit();
        
        return nene;
    }
    public void cambiarNombre (Session ses, String nombre, short id){
        Criaturitas nene;
        Transaction tran;
        tran = ses.beginTransaction();
        nene = new Criaturitas (id);
        nene.setNombre (nombre);
        ses.update (nene);
        tran.commit();
    }
    public void borrar (Session ses, short id){
        Criaturitas nene;
        Transaction tran;
        tran = ses.beginTransaction();
        nene = new Criaturitas (id);
        ses.delete (nene);
        tran.commit();
    }
    public Criaturitas recuperar (Session ses, short id){
        Criaturitas nene;
        nene = (Criaturitas)ses.get(Criaturitas.class, id);
        return nene;
    }
    public List<Criaturitas> getCriaturitas(Session ses){
        TypedQuery  consulta;
        List<Criaturitas> todasCria;
        // No necesitamos datos de la conexion porque ya están definidos en el hibernate.cfg.xml
        String ordenConsulta ="from Criaturitas";
        consulta = ses.createQuery(ordenConsulta);
        todasCria=consulta.getResultList();
        return todasCria;

    }
    public void listaCriaturitas (Session ses, List<Criaturitas> lista){
        for (Criaturitas actual:lista){
            // El objeto es detached y con esto pasa a persistent
            ses.update(actual);
            System.out.println(cadenaCriaturita(actual));
        }
    }
    public String cadenaCriaturita (Criaturitas c){
        String cad;
        cad = "ID: "+c.getId() + "  Nombre: " + c.getNombre();
        return cad;
    }

}
