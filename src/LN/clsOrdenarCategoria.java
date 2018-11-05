package LN;

import java.util.Comparator;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que implementa la interfaz Comparator<clsPelicula>
 * Ordena la lista de las asignaturas según su categoría.
 * En caso de que dos películas sean de la misma categoría, los ordena en base al título de la película.
 */
public class clsOrdenarCategoria implements Comparator<clsPelicula> {



	
	public int compare(clsPelicula arg0, clsPelicula arg1)
	{
		
		int result=arg0.getCategoría().compareTo(arg1.getCategoría());
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
