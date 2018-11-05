package LN;

import java.io.Serializable;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que implementa Serializable y Comparable<clsProducto>
 */
public class clsProducto implements Serializable, Comparable<clsProducto>{

	
	private static final long serialVersionUID = 1L;
	
	
	
	
	private String nombre;
	private int precio;
	private String tipo;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	/**
	 * Constructor sin parámetros
	 */
	public clsProducto()
	{
		nombre=null;
		precio=0;
		tipo=null;
	}
	
	
	
	/**
	 * Constructor con parámetros
	 * @param String n para fijar el título del producto.
	 * @param int p para fijar el precio del producto.
	 * @param String t para fijar el tipo del producto.
	 */
	public clsProducto(String n, int p, String t)
	{
		nombre=n;
		precio=p;
		tipo=t;
	}
	
	
	
	
	public String toString()
	{
		return "Nombre: "+this.getNombre()+"  // Precio: :"+this.getPrecio()+"  // Código: "+this.getPrecio()+" // Tipo: "+this.getTipo();
	}

	
	
	public int compareTo(clsProducto arg0) {
		// TODO Auto-generated method stub
		return this.getNombre().compareTo(arg0.getNombre());
	}
}
