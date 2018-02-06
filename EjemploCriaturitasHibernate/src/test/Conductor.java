package test;

import acceso.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Session;
import persistente.Criaturitas;

/**
 *
 * @author Leo
 */
public class Conductor {
    public static void main(String[] args) {
        final byte id = 6, otro = 15;
        final String nombre = "Violeta";
        ManejadorCriaturitas mc = new ManejadorCriaturitas();
        ManejadorRegalos mr = new ManejadorRegalos ();
        Session ses = HibernateUtil.getSessionFactory().openSession();
//        mc.borrar(otro);
//        mc.crearCriaturita(nombre,id);
        mc.listaCriaturitas(ses, mc.getCriaturitas(ses));
        System.out.println("\n---------------------------\n");
        mr.listaRegalos(ses, mr.getRegalos(ses));
//        mc.cambiarNombre(nombre, id);
        System.out.println("\n---------------------------\n"+mc.cadenaCriaturita(mc.recuperar(ses, id)));
        System.out.println("\n---------------------------\n"+mr.cadenaRegalo(mr.recuperar(ses, id)));
    }
}
