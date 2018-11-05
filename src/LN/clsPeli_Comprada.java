package LN;

import java.io.Serializable;



	
	
/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que implementa la interfaz Serializable
 *
 */
public class clsPeli_Comprada implements Serializable
{

	

	
	
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
	 * Constructor sin parámetros
	 */
	public clsPeli_Comprada()
	{
		nickname=null;
		cod=null;
	}
	
	
	
	/**
	 * Constructor con parámetros
	 * @param String nick para fijar el nickname del usuario.
	 * @param String codi para fijar el código de la película.
	 */
	public clsPeli_Comprada(String nick, String codi)
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
		clsPeli_Comprada other = (clsPeli_Comprada) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	public String toString()
	{
		String e="Nickname de usuario: "+this.getNickname()+" // Código de película: "+this.getCod();
		
		return e;
	}

	


	
	
	
	
	
	
}

