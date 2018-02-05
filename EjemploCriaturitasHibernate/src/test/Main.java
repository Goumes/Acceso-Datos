/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.math.BigDecimal;
import java.util.List;
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
        List<Regalos> regalos = null;
    
        //Borrar una criaturita y todos sus regalos
        mc.borrar (Short.parseShort("3"));
        
        //Crear una criaturita con dos nuevos regalos
        mc.crearCriaturita("pepejava", Short.parseShort("12"));
        criaturita = mc.recuperar(Short.parseShort("12"));
        
        regalos.add(mr.crearRegalo(Short.parseShort("50"), criaturita, "denominacion", Short.parseShort("20"), Short.parseShort("10"), Short.parseShort("40"), 'A', Short.valueOf("15"), BigDecimal.valueOf(15.5));
    }
}
