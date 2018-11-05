package LN;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que hereda de clsProducto
 */
public class clsVideojuego extends clsProducto
{

	private static final long serialVersionUID = 1L;
	
	
	
	private String codigov;
	private String consola;
	private String descripción;
	
	
	public boolean isCondicion() {
		return condicion;
	}
	public void setCondicion(boolean condicion) {
		this.condicion = condicion;
	}



	boolean condicion;
	
	public String getCodigov() {
		return codigov;
	}
	public void setCodigov(String codigov) {
		this.codigov = codigov;
	}
	public String getConsola() {
		return consola;
	}
	public void setConsola(String consola) {
		this.consola = consola;
	}
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

	
	
	
	
	
	/**
	 * Constructor sin parámetros
	 */
	public clsVideojuego()
	{
		super();
		consola=null;
		codigov=null;
		descripción=null;
		
	}
	
	
	
	
	/**
	 * Constructor con parámetros
	 * @param String n para fijar el título del videojuego.
	 * @param int p para fijar el precio del videojuego.
	 * @param String t para fijar el tipo del videojuego.
	 * @param String con para fijar la consola del videojuego.
	 * @param String cod para fijar el código del videojuego.
	 * @param String des para fijar la descripción del videojuego.
	 * @param boolean condi para fijar la condición del videojuego.
	 */
	public clsVideojuego(String n, int p, String t, String con, String cod, String des, boolean condi)
	{
		super(n, p, t);
		consola=con;
		descripción=des;
		codigov=cod;
		condicion=condi;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigov == null) ? 0 : codigov.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsVideojuego other = (clsVideojuego) obj;
		if (codigov == null) {
			if (other.codigov != null)
				return false;
		} else if (!codigov.equals(other.codigov))
			return false;
		return true;
	}
	
	
	public String toString()
	{		
		return super.toString()+" // Consola: "+this.getConsola()+" // Descripción: "+this.getDescripción()+" // Código: "+this.getCodigov()+" // Condición:"+this.isCondicion();
	}
	
	
	
	
}
