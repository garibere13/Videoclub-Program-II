package LN;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que hereda de Exception y que devuelve un mensaje si el código de un videojuego está repetido.
 */
public class clsVideojuegoRepetido extends Exception
{

	
	private static final long serialVersionUID = 1L;

	
	
	private final String mensaje="Lo siento... Ya existe un videojuego con ese código. Tendrá que introducir una nueva opción";



	public String getMessage()
	{
		
		return mensaje;
	}
	
	
	
}