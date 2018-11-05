package LN;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que hereda de Exception y que devuelve un mensaje si el nickname de un usuario est� repetido.
 */
public class clsUsuarioRepetido extends Exception
{

	
	private static final long serialVersionUID = 1L;

	
	
	private final String mensaje="Lo siento... Ya existe un usuario con ese nickname. Tendr� que introducir una nueva opci�n";



	public String getMessage()
	{
		
		return mensaje;
	}
	
	
	
}