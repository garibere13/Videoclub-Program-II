package LN;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que hereda de clsProducto
 */
public class clsPelicula extends clsProducto
{

	private static final long serialVersionUID = 1L;
	
	
	
	private String categoría;
	private int duración;
	private String codigop;
	
	
	public boolean isCondicion() {
		return condicion;
	}
	public void setCondicion(boolean condicion) {
		this.condicion = condicion;
	}



	boolean condicion;
	
	
	
	public String getCategoría() {
		return categoría;
	}
	public void setCategoría(String categoría) {
		this.categoría = categoría;
	}
	public int getDuración() {
		return duración;
	}
	public void setDuración(int duración) {
		this.duración = duración;
	}
	public String getCodigop() {
		return codigop;
	}
	public void setCodigop(String codigop) {
		this.codigop = codigop;
	}


	
	
	
	
	/**
	 * Constructor sin parámetros
	 */
	public clsPelicula()
	{
		super();
		categoría=null;
		duración=0;
		codigop=null;
		
	}
	
	
	
	/**
	 * Constructor con parámetros
	 * @param String n para fijar el título de la película.
	 * @param String cat para fijar la categoría de la película.
	 * @param int d para fijar la duración de la película.
	 * @param String cod para fijar el código de la película.
	 * @param String t para fijar el tipo de la película.
	 * @param int p para fijar el precio de la película.
	 * @param boolean condi para fijar la condición de la película.
	 */
	public clsPelicula(String n, String cat, int d, String cod, String t, int p, boolean condi)
	{
		super(n, p, t);
		categoría=cat;
		duración=d;
		codigop=cod;
		condicion=condi;
	}
	
	
	
	
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigop == null) ? 0 : codigop.hashCode());
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
		clsPelicula other = (clsPelicula) obj;
		if (codigop == null) {
			if (other.codigop != null)
				return false;
		} else if (!codigop.equals(other.codigop))
			return false;
		return true;
	}
	
	
	
	public String toString()
	{
		return super.toString()+" // Categoría: "+this.getCategoría()+" // Duración: "+this.getDuración()+" // Código: "+this.getCodigop()+" // Condición: "+this.isCondicion() ;
	}
	
	

	


}
