/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.Objects;

/* Propiedades.
 * 		B�sicas:		boolean Color 		----------			Consultable / Modificable
 * 						String Tipo			----------			Consultable / Modificable
 * 		Derivadas:
 * 		Compartidas:
 * 
 * Restricciones: Las piezas s�lo pueden ser del tipo: Rey, Dama, Torre, Alfil, Caballo, Peon.
 * 
 * Criterio de comparaci�n: El tipo y el color de la pieza.
 * Criterio de igualdad: El tipo y el color de la pieza.
 */

public class Pieza implements Cloneable, Comparable <Pieza>
{
	private boolean Color;
	private String Tipo;
	
	//Constructores
	public Pieza ()
	{
		Color = true;
		Tipo = "Peon";
	}
	
	public Pieza (Pieza pieza)
	{
		this.Color = pieza.Color;
		this.Tipo = pieza.Tipo;
	}
	
	public Pieza (boolean Color, String Tipo) throws ExceptionAjedrez
	{
		if (Tipo.equals ("Rey") == false
			&& Tipo.equals ("Dama") == false
			&& Tipo.equals ("Torre") == false
			&& Tipo.equals ("Alfil") == false
			&& Tipo.equals ("Caballo") == false
			&& Tipo.equals ("Peon") == false)
		{
			throw new ExceptionAjedrez ("Error. No se ha podido crear esta pieza.");
		}
		else
		{
			this.Tipo = Tipo;
		}
		
		this.Color = Color;
	}
	//Fin Constructores
	
	//Getters y setters
	public boolean getColor ()
	{
		return Color;
	}
	
	public void setColor (boolean Color)
	{
		this.Color = Color;
	}
	
	public String getTipo ()
	{
		return Tipo;
	}
	
	public void setTipo (String Tipo) throws ExceptionAjedrez
	{
		if	(Tipo.equals ("Rey") == false
				&& Tipo.equals ("Dama") == false
				&& Tipo.equals ("Torre") == false
				&& Tipo.equals ("Alfil") == false
				&& Tipo.equals ("Caballo") == false
				&& Tipo.equals ("Peon") == false)
			{
				throw new ExceptionAjedrez ("Error. No se ha podido definir este Tipo.");
			}
			else
			{
				this.Tipo = Tipo;
			}
	}
	//Fin Getters y setters
	
	//Metodos a�adidos
	@Override
	public String toString ()
	{
		String s = ""+this.getColor()+", "+this.getTipo(); 
		return s;
	}
	
	@Override
	public boolean equals (Object objeto)
	{
		boolean resultado = false;
		
		if (objeto != null && objeto instanceof Pieza)
		{
			Pieza pieza = (Pieza) objeto;
			if (this.getColor() == pieza.getColor()
				&& this.getTipo().equals (pieza.getTipo()))
			{
				resultado = true;
			}
		}
		return resultado;
	}
	
	@Override
	public int hashCode ()
	{
		return Objects.hash (this.getColor(), this.getTipo());
	}
	
	@Override
	public Pieza clone ()
	{
		Pieza copia = null;
		
		try
		{
			copia = (Pieza) super.clone ();
			copia.Tipo = (String) this.getTipo();
		}
		
		catch (CloneNotSupportedException error)
		{
			System.out.println("No se ha podido clonar el objeto");
		}
		
		return copia;
	}
	
	public int compareTo (Pieza pieza)
	{
		int resultado = 0;
		
		
		/*
		if (((Boolean) (this.getColor())).compareTo((Boolean) (pieza.getColor())) > 0		//Casteo el boolean a su clase de envoltura para poder usar el compareTo de Boolean.
			&& this.getTipo().compareTo(pieza.getTipo()) > 0)
		{
			resultado = 1;
		}
		
		else if (((Boolean) (this.getColor())).compareTo((Boolean) (pieza.getColor())) < 0
				&& this.getTipo().compareTo(pieza.getTipo()) < 0)
		{
			resultado = -1;
		} */
		
		if ((this.getColor() == true && pieza.getColor() == false)
			&& this.getTipo().compareTo(pieza.getTipo()) > 0)
		{
			resultado = 1;
		}
		
		if ((this.getColor() == false && pieza.getColor() == true)
				&& this.getTipo().compareTo(pieza.getTipo()) < 0)
		{
			resultado = -1;
		}
		
		return resultado;
	}
	//Fin Metodos a�adidos
	
}//Fin_clase