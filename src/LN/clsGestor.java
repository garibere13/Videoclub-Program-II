package LN;


import java.io.IOException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.LinkedList;














import java.util.concurrent.CopyOnWriteArrayList;

import COMUN.clsConstantes.enFicDatos;
import LD.clsDatos;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase que gestiona todos los datos provenientes del paquete de lógica de presentación (LP)
 */
public class clsGestor implements Serializable 
{


	private static final long serialVersionUID = 1L;


	

	
	/**
	 * Método que sirve para leer los datos que hay en el fichero de usuarios.
	 * @return LinkedList<clsUsuario>
	 */
	public LinkedList<clsUsuario> ListaUsuarios()	
	{	
		
		LinkedList<clsUsuario> lista = new LinkedList <clsUsuario>();
		
		clsDatos objDatos = new clsDatos();
	
		try 
		{
			objDatos.ComenzarRead(enFicDatos.FICHERO_USUARIOS);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		LinkedList<Serializable> listar=new LinkedList<Serializable>();
		listar=objDatos.Read();
		for (Serializable o: listar)
		{
			lista.add((clsUsuario)o);
		}
		objDatos.TerminarRead();
	
	
	
		return lista;

	
	}
	
	
	/**
	 * Método que sirve para leer los datos que hay en el fichero de películas.
	 * @return CopyOnWriteArrayList<clsPelicula>
	 */
	public CopyOnWriteArrayList<clsPelicula> ListaPeliculas()
	{
		
		CopyOnWriteArrayList<clsPelicula> lista=new CopyOnWriteArrayList <clsPelicula>();
		
		clsDatos objDatos=new clsDatos();
	
		try 
		{
			objDatos.ComenzarRead(enFicDatos.FICHERO_PELICULAS);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		LinkedList<Serializable> listar=new LinkedList<Serializable>();
		listar=objDatos.Read();
		for(Serializable o: listar)
		{
			lista.add((clsPelicula)o);
		}
		objDatos.TerminarRead();
	


	
		return lista;
		
		
	}
	

	
	
	
	/**
	 * Método que sirve para leer los datos que hay en el fichero de películas alquiladas.
	 * @return CopyOnWriteArrayList<clsPeli_Alquilada>
	 */
	public CopyOnWriteArrayList<clsPeli_Alquilada>ListaAlquileresPeli()
 	{
		CopyOnWriteArrayList<clsPeli_Alquilada>alqui=new CopyOnWriteArrayList<clsPeli_Alquilada>();
  		
 		clsDatos objDatos=new clsDatos();
 		
 		
 		try
 		{
 			objDatos.ComenzarRead(enFicDatos.FICHERO_ALQUILER_PELI);
 		}
 		catch(IOException e)
 		{
 			e.printStackTrace();
 		}
 		
 		
 		
 		LinkedList<Serializable> matri1=new LinkedList<Serializable>();
 		matri1=objDatos.Read();
 		
 		for(Serializable o: matri1)
 		{
 			if (o instanceof clsPeli_Alquilada)
 			{
 				alqui.add((clsPeli_Alquilada)o);
 			}
 		}
 		
 		objDatos.TerminarRead();
 		
 		return alqui;
	
 	}
	
	
	/**
	 * Método que sirve para leer los datos que hay en el fichero de compras de películas.
	 * @return LinkedList<clsComprada>
	 */
	public LinkedList<clsPeli_Comprada>ListaComprasPeli()
 	{
 		LinkedList<clsPeli_Comprada>comp=new LinkedList<clsPeli_Comprada>();
  		
 		clsDatos objDatos=new clsDatos();
 		
 		
 		try
 		{
 			objDatos.ComenzarRead(enFicDatos.FICHERO_COMPRAS_PELI);
 		}
 		catch(IOException e)
 		{
 			e.printStackTrace();
 		}
 		
 		
 		
 		LinkedList<Serializable> matri1=new LinkedList<Serializable>();
 		matri1=objDatos.Read();
 		
 		for(Serializable o: matri1)
 		{
 			if (o instanceof clsPeli_Comprada)
 			{
 				comp.add((clsPeli_Comprada)o);
 			}
 		}
 		
 		objDatos.TerminarRead();
 		
 		return comp;

 		
 	
 		
 		
 	}
	
	
	/**
	 * Método que sirve para leer los datos que hay en el fichero de videojuegos alquilados.
	 * @return CopyOnWriteArrayList<clsVideojuego_Alquilado>
	 */
	public CopyOnWriteArrayList<clsVideojuego_Alquilado> ListaAlquileresVideojuegos()
 	{
		CopyOnWriteArrayList<clsVideojuego_Alquilado>alqui=new CopyOnWriteArrayList<clsVideojuego_Alquilado>();
  		
 		clsDatos objDatos=new clsDatos();
 		
 		
 		try
 		{
 			objDatos.ComenzarRead(enFicDatos.FICHERO_ALQUILER_JUEGO);
 		}
 		catch(IOException e)
 		{
 			e.printStackTrace();
 		}
 		
 		
 		
 		LinkedList<Serializable> matri1=new LinkedList<Serializable>();
 		matri1=objDatos.Read();
 		
 		for(Serializable o: matri1)
 		{
 			if (o instanceof clsVideojuego_Alquilado)
 			{
 				alqui.add((clsVideojuego_Alquilado)o);
 			}
 		}
 		
 		objDatos.TerminarRead();
 		
 		return alqui;
	
 	}
	
	
	/**
	 * Método que sirve para leer los datos que hay en el fichero de compras de videojuegos.
	 * @return LinkedList<clsVideojuego_Comprado>
	 */
	public LinkedList<clsVideojuego_Comprado>ListaComprasVideojuego()
 	{
 		LinkedList<clsVideojuego_Comprado>comp=new LinkedList<clsVideojuego_Comprado>();
  		
 		clsDatos objDatos=new clsDatos();
 		
 		
 		try
 		{
 			objDatos.ComenzarRead(enFicDatos.FICHERO_COMPRAS_JUEGO);
 		}
 		catch(IOException e)
 		{
 			e.printStackTrace();
 		}
 		
 		
 		
 		LinkedList<Serializable> matri1=new LinkedList<Serializable>();
 		matri1=objDatos.Read();
 		
 		for(Serializable o: matri1)
 		{
 			if (o instanceof clsVideojuego_Comprado)
 			{
 				comp.add((clsVideojuego_Comprado)o);
 			}
 		}
 		
 		objDatos.TerminarRead();
 		
 		return comp;

 		
 	
 		
 		
 	}
	
	

	
	/**
	 * Método que sirve para leer los datos que hay en el fichero de videojuegos.
	 * @return CopyOnWriteArrayList<clsVideojuego>
	 */
	public CopyOnWriteArrayList<clsVideojuego> ListaVideojuegos()
	{
		
		CopyOnWriteArrayList<clsVideojuego> lista=new CopyOnWriteArrayList <clsVideojuego>();
		
		clsDatos objDatos=new clsDatos();
	
		try 
		{
			objDatos.ComenzarRead(enFicDatos.FICHERO_VIDEOJUEGOS);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		LinkedList<Serializable> listar=new LinkedList<Serializable>();
		listar=objDatos.Read();
		for(Serializable o: listar)
		{
			lista.add((clsVideojuego)o);
		}
		objDatos.TerminarRead();
	


	
		return lista;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Método utilizado para crear un nuevo usuario en fichero.
	 * @param String n para fijar el nombre del usuario.
	 * @param String ap1 para fijar el primer apellido del usuario.
	 * @param String ap2 para fijar el segundo apellido del usuario.
	 * @param String dni para fijar el DNI del usuario.
	 * @param String nick para fijar el nickname del usuario.
	 * @param String cont para fijar la contraseña del usuario.
	 * @param String fec para fijar la fecha de matriculación del usuario.
	 * @return void
	 * @throws clsUsuarioRepetido
	 */
	public boolean CrearUsuario (String n, String ap1, String ap2, String dni, String nick, String cont, String fec) throws clsUsuarioRepetido
	{
		
		clsUsuario nuevo=new clsUsuario(n, ap1, ap2, dni, nick, cont, fec);
		
		LinkedList<clsUsuario> listausuarios=new LinkedList<clsUsuario>();
		listausuarios=ListaUsuarios();
		
		if(listausuarios.size()!=0)
		{
			HashSet<clsUsuario> set=new HashSet<clsUsuario>();
			set.addAll(listausuarios);
			
			
			if(set.add(nuevo)==false)
			{
				
				throw new clsUsuarioRepetido();
			}
		
		
		}
		
		
			clsDatos objDatos=new clsDatos();
			
			
			objDatos.ComenzarSave(enFicDatos.FICHERO_USUARIOS);
			objDatos.Save(nuevo);
			objDatos.TerminarSave();
		

		
	return false;
	
	}
	
	
	
	
	/**
	 * Método utilizado para crear una nueva película en fichero.
	 * @param String t para fijar el nombre de la película.
	 * @param String cat para fijar la categoría de la película.
	 * @param int dur para fijar la duración de la película.
	 * @param String cod para fijar el código de la película.
	 * @param String tipo para fijar el tipo de la película.
	 * @param int p para fijar el precio de la película.
	 * @return void
	 * @throws clsPeliculaRepetida
	 */
	public boolean CrearPelicula(String t, String cat, int dur, String cod, String tipo, int p) throws clsPeliculaRepetida
	{
		
		
		clsPelicula nuevo=new clsPelicula(t, cat, dur, cod, tipo, p, true);
		CopyOnWriteArrayList<clsPelicula> asig=new CopyOnWriteArrayList <clsPelicula>();
		asig=ListaPeliculas();
		
		
		
		if(asig.size()!=0)
		{
			HashSet<clsPelicula>set=new HashSet<clsPelicula>();
			set.addAll(asig);
			
			if(set.add(nuevo)==false)
			{
				throw new clsPeliculaRepetida();
			}
		}
		
		clsDatos objDatos=new clsDatos();
		
		
		
		
		objDatos.ComenzarSave(enFicDatos.FICHERO_PELICULAS);
		objDatos.Save(nuevo);
		objDatos.TerminarSave();

		
	return false;
	
	
	}
	
	
	
	
	
	/**
	 * Método utilizado para crear un nuevo alquiler de película en fichero.
	 * @param String id para fijar el ID del usuario.
	 * @param String cod para fijar el código de la película.
	 * @return void
	 */
	public void CrearAlquilerPeli(String id, String cod)
 	{
 		
		clsPeli_Alquilada nuevo=new clsPeli_Alquilada(id, cod);
		CopyOnWriteArrayList<clsPeli_Alquilada>alqui=new CopyOnWriteArrayList<clsPeli_Alquilada>();
 		alqui=ListaAlquileresPeli();
 		
 		if(alqui.size()!=0)
 		{

 			HashSet<clsPeli_Alquilada> set=new HashSet<clsPeli_Alquilada>();
 			set.addAll(alqui);
 			


 		}
 		
 		
 		clsDatos objDatos=new clsDatos();
 		
 		objDatos.ComenzarSave(enFicDatos.FICHERO_ALQUILER_PELI);
 		objDatos.Save(nuevo);
 		objDatos.TerminarSave();
 		
 	
 	}
	
	
	
	
	
	/**
	 * Método utilizado para crear una nueva compra de película en fichero.
	 * @param String id para fijar el ID del usuario.
	 * @param String cod para fijar el código de la película.
	 * @return void
	 */
	public void CrearCompraPeli(String id, String cod) 
 	{
 		
		clsPeli_Comprada nuevo=new clsPeli_Comprada(id, cod);
 		LinkedList<clsPeli_Comprada>com=new LinkedList<clsPeli_Comprada>();
 		com=ListaComprasPeli();
 		
 		if(com.size()!=0)
 		{

 			HashSet<clsPeli_Comprada> set=new HashSet<clsPeli_Comprada>();
 			set.addAll(com);


 		}
 		
 		
 		clsDatos objDatos=new clsDatos();
 		
 		objDatos.ComenzarSave(enFicDatos.FICHERO_COMPRAS_PELI);
 		objDatos.Save(nuevo);
 		objDatos.TerminarSave();
 		
 	
 	}
	
	
	
	
	/**
	 * Método utilizado para crear un nuevo alquiler de videojuego en fichero.
	 * @param String id para fijar el ID del usuario.
	 * @param String cod para fijar el código del videojuego.
	 * @return void
	 */
	public void CrearAlquilerVideojuego(String id, String cod)
 	{
 		
		clsVideojuego_Alquilado nuevo=new clsVideojuego_Alquilado(id, cod);
		CopyOnWriteArrayList<clsVideojuego_Alquilado>alqui=new CopyOnWriteArrayList<clsVideojuego_Alquilado>();
 		alqui=ListaAlquileresVideojuegos();
 		
 		if(alqui.size()!=0)
 		{

 			HashSet<clsVideojuego_Alquilado> set=new HashSet<clsVideojuego_Alquilado>();
 			set.addAll(alqui);

 		}
 		
 		
 		clsDatos objDatos=new clsDatos();
 		
 		objDatos.ComenzarSave(enFicDatos.FICHERO_ALQUILER_JUEGO);
 		objDatos.Save(nuevo);
 		objDatos.TerminarSave();
 		
 	
 	}
	
	
	
	
	
	/**
	 * Método utilizado para crear una nueva compra de videojuego en fichero.
	 * @param String id para fijar el ID del usuario.
	 * @param String cod para fijar el código del videojuego.
	 * @return void
	 */
	public void CrearCompraVideojuego(String id, String cod) 
 	{
 		
		clsVideojuego_Comprado nuevo=new clsVideojuego_Comprado(id, cod);
 		LinkedList<clsVideojuego_Comprado>com=new LinkedList<clsVideojuego_Comprado>();
 		com=ListaComprasVideojuego();
 		
 		if(com.size()!=0)
 		{

 			HashSet<clsVideojuego_Comprado> set=new HashSet<clsVideojuego_Comprado>();
 			set.addAll(com);


 		}
 		
 		
 		clsDatos objDatos=new clsDatos();
 		
 		objDatos.ComenzarSave(enFicDatos.FICHERO_COMPRAS_JUEGO);
 		objDatos.Save(nuevo);
 		objDatos.TerminarSave();
 		
 	
 	}
	
	

	

	/**
	 * Método utilizado para crear un nuevo videojuego en fichero.
	 * @param String t para fijar el nombre del videojuego.
	 * @param String con para fijar la consola del videojuego.
	 * @param String des para fijar la descripción del videojuego.
	 * @param String cod para fijar el código del videojuego.
	 * @param String tipo para fijar el tipo del videojuego.
	 * @param int tipo p fijar el precio del videojuego.
	 * @return void
	 * @throws clsVideojuegoRepetido
	 */
	public boolean CrearVideojuego(String t, String con, String des, String cod, String tipo, int p) throws clsVideojuegoRepetido
	{
		
		
		clsVideojuego nuevo=new clsVideojuego(t, p, tipo, con, cod, des, true);
		CopyOnWriteArrayList<clsVideojuego> asig=new CopyOnWriteArrayList <clsVideojuego>();
		asig=ListaVideojuegos();
		
		
		
		if(asig.size()!=0)
		{
			HashSet<clsVideojuego>set=new HashSet<clsVideojuego>();
			set.addAll(asig);
			
			if(set.add(nuevo)==false)
			{
				throw new clsVideojuegoRepetido();
			}
		}
		
		clsDatos objDatos=new clsDatos();
		
		
		
		
		objDatos.ComenzarSave(enFicDatos.FICHERO_VIDEOJUEGOS);
		objDatos.Save(nuevo);
		objDatos.TerminarSave();

		
	return false;
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Método utilizado para eliminar un usuario de fichero a partir de su nickname.
	 * @param String nick.
	 * @return void
	 */
	public void EliminarUsuario(String nick)
	{
		LinkedList<Serializable>l;
		LinkedList<clsUsuario>esc = null;
		clsDatos objDatos = new clsDatos();
		try {
			objDatos.ComenzarRead(enFicDatos.FICHERO_USUARIOS);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l=objDatos.Read();
		objDatos.TerminarRead();
		
		esc=new LinkedList<clsUsuario>();
				
		for(Serializable s:l)
		{
			clsUsuario c=(clsUsuario)s;
			if(!c.getNickname().equals(nick))
				esc.add(c);
		}
		objDatos.ResetFile(enFicDatos.FICHERO_USUARIOS);
		objDatos.ComenzarSave(enFicDatos.FICHERO_USUARIOS);
		for(clsUsuario c:esc)
			objDatos.Save(c);
		objDatos.TerminarSave();
	}
	
	
	
	
	

	/**
	 * Método utilizado para eliminar una película de fichero a partir de su código.
	 * @param String cod.
	 * @return void
	 */
	public void EliminarPeli(String cod)
	{
		LinkedList<Serializable>l;
		LinkedList<clsPelicula>esc = null;
		clsDatos objDatos = new clsDatos();
		try {
			objDatos.ComenzarRead(enFicDatos.FICHERO_PELICULAS);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l=objDatos.Read();
		objDatos.TerminarRead();
		
		esc=new LinkedList<clsPelicula>();
				
		for(Serializable s:l)
		{
			clsPelicula c=(clsPelicula)s;
			if(!c.getCodigop().equals(cod))
				esc.add(c);
		}
		objDatos.ResetFile(enFicDatos.FICHERO_PELICULAS);
		objDatos.ComenzarSave(enFicDatos.FICHERO_PELICULAS);
		for(clsPelicula c:esc)
			objDatos.Save(c);
		objDatos.TerminarSave();
	}
	
	
	
	/**
	 * Método utilizado para eliminar un videojuego de fichero a partir de su código.
	 * @param String cod.
	 * @return void
	 */
	public void EliminarVideojuego(String cod)
	{
		LinkedList<Serializable>l;
		LinkedList<clsVideojuego>esc = null;
		clsDatos objDatos = new clsDatos();
		try {
			objDatos.ComenzarRead(enFicDatos.FICHERO_VIDEOJUEGOS);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l=objDatos.Read();
		objDatos.TerminarRead();
		
		esc=new LinkedList<clsVideojuego>();
				
		for(Serializable s:l)
		{
			clsVideojuego c=(clsVideojuego)s;
			if(!c.getCodigov().equals(cod))
				esc.add(c);
		}
		objDatos.ResetFile(enFicDatos.FICHERO_VIDEOJUEGOS);
		objDatos.ComenzarSave(enFicDatos.FICHERO_VIDEOJUEGOS);
		for(clsVideojuego c:esc)
			objDatos.Save(c);
		objDatos.TerminarSave();
	}

	

	
	
	/**
	 * Método utilizado para eliminar un alquiler de película de fichero a partir de su id y código
	 * @param String id
	 * @param String cod
	 * @return void
	 */
	public void EliminarAlquilerPeli(String id, String cod)
	{
		LinkedList<Serializable>l;
		LinkedList<clsPeli_Alquilada>esc = null;
		clsDatos objDatos = new clsDatos();
		try 
		{
			objDatos.ComenzarRead(enFicDatos.FICHERO_ALQUILER_PELI);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l=objDatos.Read();
		objDatos.TerminarRead();
		
		esc=new LinkedList<clsPeli_Alquilada>();
				
		for(Serializable s:l)
		{
			clsPeli_Alquilada c=(clsPeli_Alquilada)s;
			if((!c.getNickname().equals(id))||(!c.getCod().equals(cod)))
				esc.add(c);
				
		}
		objDatos.ResetFile(enFicDatos.FICHERO_ALQUILER_PELI);
		objDatos.ComenzarSave(enFicDatos.FICHERO_ALQUILER_PELI);
		for(clsPeli_Alquilada c:esc)
			objDatos.Save(c);
		objDatos.TerminarSave();
	}
	

	
	
	/**
	 * Método utilizado para eliminar un alquiler de videojuego de fichero a partir de su id y código
	 * @param String id
	 * @param String cod
	 * @return void
	 */
	public void EliminarAlquilerVideojuego(String id, String cod)
	{
		LinkedList<Serializable>l;
		LinkedList<clsVideojuego_Alquilado>esc = null;
		clsDatos objDatos = new clsDatos();
		try 
		{
			objDatos.ComenzarRead(enFicDatos.FICHERO_ALQUILER_JUEGO);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l=objDatos.Read();
		objDatos.TerminarRead();
		
		esc=new LinkedList<clsVideojuego_Alquilado>();
				
		for(Serializable s:l)
		{
			clsVideojuego_Alquilado c=(clsVideojuego_Alquilado)s;
			if((!c.getNickname().equals(id))||(!c.getCod().equals(cod)))
				esc.add(c);
				
		}
		objDatos.ResetFile(enFicDatos.FICHERO_ALQUILER_JUEGO);
		objDatos.ComenzarSave(enFicDatos.FICHERO_ALQUILER_JUEGO);
		for(clsVideojuego_Alquilado c:esc)
			objDatos.Save(c);
		objDatos.TerminarSave();
	}
	
	

	
	

	
	


	
	
	
	
	
	
	

	
	
	
	
	
	

	
	
	
	


	
 
	
	
 
	
	
	

	
	
	
	
	
 	/**
 	 * Método que lanza la excepción en caso de no haber datos suficientes
 	 * @return void
 	 * @throws clsNoDatos
 	 */
 	public void NoHayDatos() throws clsNoDatos
 	{
 		throw new clsNoDatos();
 		
 	}
 	
 	

 	
 	
 	
 	
 	
 	/**
 	 * Método que devuelve todos los atributos de un usuario al pasarle por parámetro su nickname.
 	 * @param String nick
 	 * @return clsUsuario
 	 */
	public clsUsuario BuscarUsuario(String nick)
 	{
 		
 		LinkedList<clsUsuario> lista=new LinkedList<clsUsuario>();
 		lista=ListaUsuarios();
 		
 		for(clsUsuario aux:lista)
 		{
 			if(aux.getNickname().equals(nick))
 			{
 				return aux;
 			}
 		}
 		
 		
 		
		return null;
 		
 	}
	
	
	
	
	
	
	
	
	/**
 	 * Método que devuelve todos los atributos de una película al pasarle por parámetro su código.
 	 * @param String cod
 	 * @return clsPelicula
 	 */
	public clsPelicula BuscarPelicula(String cod)
 	{
 		
		CopyOnWriteArrayList<clsPelicula> lista=new CopyOnWriteArrayList<clsPelicula>();
 		lista=ListaPeliculas();
 		
 		for(clsPelicula aux:lista)
 		{
 			if(aux.getCodigop().equals(cod))
 			{
 				return aux;
 			}
 		}
 		
 		
 		
		return null;
 		
 	}
	
	
	/**
 	 * Método que devuelve todos los atributos de un videojuego al pasarle por parámetro su código.
 	 * @param String cod
 	 * @return clsVideojuego
 	 */
	public clsVideojuego BuscarVideojuego(String cod)
 	{
 		
		CopyOnWriteArrayList<clsVideojuego> lista=new CopyOnWriteArrayList<clsVideojuego>();
 		lista=ListaVideojuegos();
 		
 		for(clsVideojuego aux:lista)
 		{
 			if(aux.getCodigov().equals(cod))
 			{
 				return aux;
 			}
 		}
 		
 		
 		
		return null;
 		
 	}
	
	
	
	
	
	
	/**
	 * Método para elimina el fichero de películas y que guarda la lista que se le pasa por parámetro.
	 * @param CopyOnWriteArrayList<clsPelicula> a
	 */
	public void GuardarPelis(CopyOnWriteArrayList<clsPelicula> a)
	{
		clsDatos objDatos=new clsDatos();
		
		objDatos.ResetFile(enFicDatos.FICHERO_PELICULAS);
		objDatos.ComenzarSave(enFicDatos.FICHERO_PELICULAS);
		for(clsPelicula aux:a)
		{
			objDatos.Save(aux);
		}
		objDatos.TerminarSave();
	}
	
	
	
	
	
	/**
	 * Método para elimina el fichero de videojuegos y que guarda la lista que se le pasa por parámetro.
	 * @param CopyOnWriteArrayList<clsVideojuego> juegos
	 */
	public void GuardarVideojuegos(CopyOnWriteArrayList<clsVideojuego> a)
	{
		clsDatos objDatos=new clsDatos();
		
		objDatos.ResetFile(enFicDatos.FICHERO_VIDEOJUEGOS);
		objDatos.ComenzarSave(enFicDatos.FICHERO_VIDEOJUEGOS);
		for(clsVideojuego aux:a)
		{
			objDatos.Save(aux);
		}
		objDatos.TerminarSave();
	}
	
	
	
	
}
