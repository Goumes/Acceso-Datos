package coranzoncitos;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
public class clsSAX {
    XMLReader procesadorXML;
    clsGestionContenido gestor;
    InputSource archivoXML;
    public clsSAX (String nombreArchivo){
        try {
            procesadorXML = XMLReaderFactory.createXMLReader();
        } catch (SAXException ex) {
            Logger.getLogger(clsSAX.class.getName()).log(Level.SEVERE, null, ex);
        }
        gestor = new clsGestionContenido();
        procesadorXML.setContentHandler(gestor);
        archivoXML = new InputSource(nombreArchivo);
    }
    void andale(){
        try {
            procesadorXML.parse(archivoXML);
        } catch (IOException ex) {
            Logger.getLogger(clsSAX.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(clsSAX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
// Fin PruebaSAX1
