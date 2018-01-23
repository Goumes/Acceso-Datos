package coranzoncitos;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.helpers.*;
import org.xml.sax.*;
import clases.PersonaType;
import clases.CorazoncitosType;
import clases.GustoType;
import clases.PreferenciasType;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


public class clsGestionContenido extends DefaultHandler {
    private String caracteres;
    private CorazoncitosType corazones;
    private PersonaType personas;
    private PreferenciasType preferencias;
    private GustoType gusto;
    XMLGregorianCalendar result;
    
    
    public clsGestionContenido() {
        super(); 
    }
    @Override
    public void startDocument(){
        System.out.println("Comienzo del documentoh XML");
        corazones = new CorazoncitosType ();
    }
    @Override
    public void endDocument(){
        System.out.println("Fin del documento XML");
        
        
    }
    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes att){
        System.out.println("\t< "+nombre +">");
        switch (nombre)
        {
            case "Persona":
                personas = new PersonaType ();
            break;
                     
            case "Gusto":
                gusto = new GustoType ();
            break;
                               
            case "Preferencias":
                preferencias = new PreferenciasType ();
            break;
        }
        
    }
    @Override
    public void endElement(String uri, String nombre, String nombreC){
        System.out.println("\t< "+nombre +"/>");
        switch (nombre)
        {
            case "Persona":
                corazones.getPersona().add(personas);
                System.out.println(personas.toString ());
                personas.getPreferencias ().imprimir();
            break;
            
            case "ID":
                personas.setID(Short.valueOf(caracteres));
            break;
            
            case "nombre":
                personas.setNombre (caracteres);
            break;
                
            case "sexo":
                personas.setSexo (caracteres);
            break;
                
            case "sexoBuscado":
                personas.setSexoBuscado (caracteres);
            break;
                    
            case "fechaNacimiento":
                try
                {
                    result = DatatypeFactory.newInstance().newXMLGregorianCalendar(caracteres);
                }
                catch (Exception e)
                {
                    e.printStackTrace ();
                }
                
                personas.setFechaNacimiento (result);
            break;
                
            case "ingresos":
                personas.setIngresos (Float.valueOf(caracteres));
            break;
                
            case "Gusto":
                preferencias.getGusto().add (gusto);
            break;
                
            case "Descripcion":
                gusto.setDescripcion (caracteres);
            break;
                
            case "Valor":
                gusto.setValor (Byte.valueOf(caracteres));
            break;
            
            case "Preferencias":
                personas.setPreferencias(preferencias);
                break;
        }
    }
    @Override
    public void characters (char[] ch, int inicio, int longitud)
            throws SAXException{
        caracteres = new String(ch, inicio, longitud);
        caracteres = caracteres.replaceAll("[\t\n]",""); // Quitamos tabuladores y saltos de linea
        System.out.println("\t\t" + caracteres);
    }
    
    public CorazoncitosType getCorazones ()
    {
        return this.corazones;
    }
}
// FIN GestionContenido
