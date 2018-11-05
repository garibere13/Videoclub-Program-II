package LN;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que hereda de Exception y que devuelve un mensaje si el c�digo de un videojuego est� repetido.
 */
public class clsVideojuegoRepetido extends Exception
{

	
	private static final long serialVersionUID = 1L;

	
	
	private final String mensaje="Lo siento... Ya existe un videojuego con ese c�digo. Tendr� que introducir una nueva opci�n";



	public String getMessage()
	{
		
		return mensaje;
	}
	
	
	
}