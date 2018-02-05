/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.math.BigDecimal;
import java.util.List;
import persistente.Criaturitas;
import persistente.Regalos;

/**
 *
 * @author agomez
 */
public class ManejadoraMain {
    
    public Regalos crearRegalo (Short id, String denominacion, Short edadMinima, BigDecimal precio)
    {
        Regalos regalo = new Regalos ();
        
        regalo.setId(id);
        regalo.setDenominacion(denominacion);
        regalo.setEdadMinima(edadMinima);
        regalo.setPrecio(precio);
        
        return regalo;
    }
    
    public Criaturitas crearCriaturita (Short id, String nombre, List<Regalos> regalos)
    {
        Criaturitas criaturita = new Criaturitas ();
        criaturita.setId (id);
        criaturita.setNombre(nombre);
        criaturita.setRegalosList(regalos);
        
        return criaturita;
    }
    
}
