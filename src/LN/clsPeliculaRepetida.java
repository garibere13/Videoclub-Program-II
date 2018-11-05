package LN;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que hereda de Exception y que devuelve un mensaje si el c�digo de una pel�cula est� repetido.
 */
public class clsPeliculaRepetida extends Exception
{

	
	private static final long serialVersionUID = 1L;

	
	
	private final String mensaje="Lo siento... Ya existe una pel�cula con ese c�digo. Tendr� que introducir una nueva opci�n";



	public String getMessage()
	{
		
		return mensaje;
	}
	
	
	
}