package test;

import java.util.ArrayList;
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
//        mc.borrar(otro);
//        mc.crearCriaturita(nombre,id);
        mc.listaCriaturitas(mc.getCriaturitas());
        System.out.println("\n---------------------------\n");
        mr.listaRegalos(mr.getRegalos());
//        mc.cambiarNombre(nombre, id);
        System.out.println("\n---------------------------\n"+mc.cadenaCriaturita(mc.recuperar(id)));
        System.out.println("\n---------------------------\n"+mr.cadenaRegalo(mr.recuperar(id)));
    }
}
