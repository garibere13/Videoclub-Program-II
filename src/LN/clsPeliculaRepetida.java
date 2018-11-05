package LN;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que hereda de Exception y que devuelve un mensaje si el código de una película está repetido.
 */
public class clsPeliculaRepetida extends Exception
{

	
	private static final long serialVersionUID = 1L;

	
	
	private final String mensaje="Lo siento... Ya existe una película con ese código. Tendrá que introducir una nueva opción";



	public String getMessage()
	{
		
		return mensaje;
	}
	
	
	
}