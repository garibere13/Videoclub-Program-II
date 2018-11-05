package LN;

import java.util.Comparator;



/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que implementa la interfaz Comparator<clsUsuario>.
 * Ordena la lista de los usuarios según su primer apellido.
 * En caso de que dos usuarios tengan el mismo primer apellido, los ordena en base a su nombre.
 *
 *
 */
public class clsOrdenarAp1 implements Comparator<clsUsuario> {

	@Override
	public int compare(clsUsuario arg0, clsUsuario arg1) {

		int result=arg0.getApellido1().compareTo(arg1.getApellido1());
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

