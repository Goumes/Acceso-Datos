/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coranzoncitos;

/**
 *
 * @author agomez
 */
public class Coranzoncitos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String nombreArchivo = "src\\xml\\corazonesSolitarios.xml";
	clsSAX probando = new clsSAX(nombreArchivo);
        probando.andale();
    }
    
}
