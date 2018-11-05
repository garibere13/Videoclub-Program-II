package LN;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que hereda de Exception y que devuelve un mensaje si no hay suficientes datos introducidos
 * 
 */
public class clsNoDatos extends Exception {


	private static final long serialVersionUID = 1L;

	
	private final String mensaje="No hay datos introducidos";
	
	public String getMessage()
	{
		return mensaje;
	}
	
}
