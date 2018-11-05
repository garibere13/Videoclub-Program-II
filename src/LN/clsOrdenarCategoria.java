package LN;

import java.util.Comparator;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que implementa la interfaz Comparator<clsPelicula>
 * Ordena la lista de las asignaturas seg�n su categor�a.
 * En caso de que dos pel�culas sean de la misma categor�a, los ordena en base al t�tulo de la pel�cula.
 */
public class clsOrdenarCategoria implements Comparator<clsPelicula> {



	
	public int compare(clsPelicula arg0, clsPelicula arg1)
	{
		
		int result=arg0.getCategor�a().compareTo(arg1.getCategor�a());
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
