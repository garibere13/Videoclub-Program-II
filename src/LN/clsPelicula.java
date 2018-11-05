package LN;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que hereda de clsProducto
 */
public class clsPelicula extends clsProducto
{

	private static final long serialVersionUID = 1L;
	
	
	
	private String categor�a;
	private int duraci�n;
	private String codigop;
	
	
	public boolean isCondicion() {
		return condicion;
	}
	public void setCondicion(boolean condicion) {
		this.condicion = condicion;
	}



	boolean condicion;
	
	
	
	public String getCategor�a() {
		return categor�a;
	}
	public void setCategor�a(String categor�a) {
		this.categor�a = categor�a;
	}
	public int getDuraci�n() {
		return duraci�n;
	}
	public void setDuraci�n(int duraci�n) {
		this.duraci�n = duraci�n;
	}
	public String getCodigop() {
		return codigop;
	}
	public void setCodigop(String codigop) {
		this.codigop = codigop;
	}


	
	
	
	
	/**
	 * Constructor sin par�metros
	 */
	public clsPelicula()
	{
		super();
		categor�a=null;
		duraci�n=0;
		codigop=null;
		
	}
	
	
	
	/**
	 * Constructor con par�metros
	 * @param String n para fijar el t�tulo de la pel�cula.
	 * @param String cat para fijar la categor�a de la pel�cula.
	 * @param int d para fijar la duraci�n de la pel�cula.
	 * @param String cod para fijar el c�digo de la pel�cula.
	 * @param String t para fijar el tipo de la pel�cula.
	 * @param int p para fijar el precio de la pel�cula.
	 * @param boolean condi para fijar la condici�n de la pel�cula.
	 */
	public clsPelicula(String n, String cat, int d, String cod, String t, int p, boolean condi)
	{
		super(n, p, t);
		categor�a=cat;
		duraci�n=d;
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
		return super.toString()+" // Categor�a: "+this.getCategor�a()+" // Duraci�n: "+this.getDuraci�n()+" // C�digo: "+this.getCodigop()+" // Condici�n: "+this.isCondicion() ;
	}
	
	

	


}
