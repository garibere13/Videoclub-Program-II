package LN;

import java.io.Serializable;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que implementa la interfaz Serializable
 *
 */
public class clsVideojuego_Alquilado implements Serializable{

	

	
	
	private static final long serialVersionUID = 1L;
	
	

	private String nickname;
	private String cod;
	

	
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}



	/**
	 * Constructor sin par�metros
	 */
	public clsVideojuego_Alquilado()
	{
		nickname=null;
		cod=null;
	}
	
	/**
	 * Constructor con par�metros
	 * @param String nick para fijar el nickname del usuario.
	 * @param String cod para fijar el c�digo del videojuego.
	 */
	public clsVideojuego_Alquilado(String nick, String codi)
	{
		nickname=nick;
		cod=codi;
	}
	

	
	
	



	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
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
		clsVideojuego_Alquilado other = (clsVideojuego_Alquilado) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	public String toString()
	{
		String e="Nickname de usuario: "+this.getNickname()+" // C�digo de videojuego: "+this.getCod();
		
		return e;
	}

	
	
	

}
