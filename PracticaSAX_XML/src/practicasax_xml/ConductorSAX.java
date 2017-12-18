package practicasax_xml;

import java.util.ArrayList;



public class ConductorSAX {
public static void main (String[] args){
	String nombreArchivo = "src\\books.xml";
        ArrayList<Book> books;
	PruebaSAX1 probando = new PruebaSAX1 (nombreArchivo);
        books = probando.andale();
        
        for(int i = 0; i < books.size(); i++)
        {
            System.out.println (books.get(i).getCategory ());
            System.out.println (books.get(i).getTitle ());
            System.out.println (books.get(i).getAuthor ());
            System.out.println (books.get(i).getPrice ());
            System.out.println (books.get(i).getYear ());
        }
        
}// Fin main

} // Fin conductorSAX
