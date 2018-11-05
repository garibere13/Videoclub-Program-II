package LN;



import java.io.Serializable;



/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que implementa la interfaz Comparable<clsUsuario> y Serializable
 *
 */
public class clsUsuario implements Serializable, Comparable<clsUsuario> {

	
	private static final long serialVersionUID = 1L;
	
	
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String DNI;
	private String nickname;
	private String contrase�a;
	private String fechadealta;
	
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getFechamatricula() {
		return fechadealta;
	}
	public void setFechamatricula(String fechamatricula) {
		this.fechadealta = fechamatricula;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	
	
	
	/**
	 * Constructor con par�metros
	 * @param String n para fijar el nombre del usuario.
	 * @param String ap1 para fijar el primer apellido del usuario.
	 * @param String ap2 para fijar el segundo apellido del usuario.
	 * @param String dni para fijar el DNI del usuario.
	 * @param String nick para fijar el nickname del usuario.
	 * @param String cont para fijar la contrase�a del usuario.
	 * @param String fec para fijar la fecha de matriculaci�n del usuario.
	 *
	 */
	public clsUsuario(String n, String ap1, String ap2, String dni, String nick, String cont, String fec)
	{
		nombre=n;
		apellido1=ap1;
		apellido2=ap2;
		DNI=dni;
		nickname=nick;
		contrase�a=cont;
		fechadealta=fec;
	}
	
	/**
	 * Constructor sin par�metros
	 */
	public clsUsuario()
	{
		nombre=null;
		apellido1=null;
		apellido2=null;
		DNI=null;
		nickname=null;
		contrase�a=null;
		fechadealta=null;
		
	}
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
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
		clsUsuario other = (clsUsuario) obj;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		return true;
	}
	
	
	
	public String toString()
	{
		String e="Nombre: "+this.getNombre()+" // Apellido 1: "+this.getApellido1()+" // Apellido 2: "+this.getApellido2()+" // DNI: "+this.getDNI()+" // Nicknmae: "+this.getNickname()+" // Contrase�a: "+this.getContrase�a()+" // Fecha de matriculaci�n: "+this.getFechamatricula();
		
		return e;
	}
	
	
	
	public int compareTo(clsUsuario arg0) {
		// TODO Auto-generated method stub
		return this.getNickname().compareTo(arg0.getNickname());
	}
	
	
	
	
	
	

	
	
}
