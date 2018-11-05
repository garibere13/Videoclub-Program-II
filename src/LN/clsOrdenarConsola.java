package LN;

import java.util.Comparator;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que implementa la interfaz Comparator<clsVideojuego>
 * Ordena la lista de los videojuegos según el tipo de consola. 
 * En caso de que dos películas sean para la misma consola, los ordena en base al nombre del videojuego.
 */
public class clsOrdenarConsola implements Comparator<clsVideojuego> {



	
	public int compare(clsVideojuego arg0, clsVideojuego arg1)
	{
		
		int result=arg0.getConsola().compareTo(arg1.getConsola());
		if (result != 0)
	        {
	            return result;
	        }
		result=arg0.getNombre().compareTo(arg1.getNombre());
		if (result != 0)
	        {
	            return result;
	        }
		
		return 0;
	}
	
	
	
	
}