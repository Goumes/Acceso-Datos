package practicasax_xml;


/**
 *
 * @author Leo
 */
import java.util.ArrayList;
import org.xml.sax.helpers.*;
import org.xml.sax.*;
public class GestionContenido extends DefaultHandler {
    private String cad;
    private ArrayList<Book> books;
    private Book book;

    public GestionContenido() {
        super();
    }
    @Override
    public void startDocument(){
        System.out.println("Comienzo del documento XML");
        books = new ArrayList <Book> ();
    }
    @Override
    public void endDocument(){
        System.out.println("Fin del documento XML");
    }
    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes att)
    {
        if (nombre.equals ("book"))
        {
            book = new Book ();
            
            if (att != null)
            {
                book.setCategory (att.getValue(0));
            }
        }
        System.out.println("\t< "+nombre +">");
    }
    @Override
    public void endElement(String uri, String nombre, String nombreC){
        
        switch (nombre)
        {
            case "title":
                book.setTitle (cad);
                break;
                
            case "author":
                book.setAuthor (cad);
                break;
            case "year":
                book.setYear(Integer.valueOf(cad));
                //book.setYear (2);
                break;
                
            case "price":
                //book.setPrice (2.0);
                book.setPrice(Double.valueOf(cad));
                break;
            case "book":
                books.add (book);
                break;
        }
        
        System.out.println("\t</ "+nombre +">");
    }
    @Override
    public void characters (char[] ch, int inicio, int longitud)
            throws SAXException{
        cad = new String(ch, inicio, longitud);
        cad = cad.replaceAll("[\t\n]",""); // Quitamos tabuladores y saltos de linea
        System.out.println("\t\t" + cad);
    }
    
    public ArrayList <Book> getBooks ()
    {
        return books;
    }
}
// FIN GestionContenido
