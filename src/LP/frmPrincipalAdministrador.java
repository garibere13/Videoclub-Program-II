package LP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.JPanel;

import LN.clsGestor;
import LN.clsNoDatos;
import LN.clsPeli_Alquilada;
import LN.clsPeli_Comprada;
import LN.clsPelicula;
import LN.clsUsuario;
import LN.clsVideojuego;
import LN.clsVideojuego_Alquilado;
import LN.clsVideojuego_Comprado;




/**
 * 
 * @author Garikoitz.Bereciartua
 * Ventana principal del administrador, desde la cual se podrán ejecutar diferentes opciones.
 * Hereda de JFrmae e implementa ActionListener
 *
 */
public class frmPrincipalAdministrador extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;

	
	
	
	
    JPanel desktop;
    JDesktopPane panel;
    
    static final int desktopWidth = 800;
    static final int desktopHeight = 400;

    
    JInternalFrame displayWindow;
    JInternalFrame listenedToWindow;
    
    
    JLabel fondo;
	
	static final String CREARUSUARIO = "Nuevo usuario";
	static final String CREARPELI="Nueva película";
	static final String CREARJUEGO="Nuevo videojuego";
	static final String MODIUSUARIO="Modificar usuario";
	static final String MODIPELI="Modificar película";
	static final String MODIJUEGO="Modificar videojuego";
	static final String ELIMINARUSUARIO="Eliminar usuario";
	static final String ELIMINARPELI="Eliminar película";
	static final String ELIMINARJUEGO="Eliminar videojuego";
	static final String ORDENUSUARIO="Ordenar usuario";
	static final String ORDENPELI="Ordenar película";
	static final String ORDENJUEGO="Ordenar videojuego";
	static final String REGISALQUIPELI="Registro alquileres pelis";
	static final String REGISCOMPRASPELI="Registro compras pelis";
	static final String REGISALQUIJUEGO="Registro alquileres videojuegos";
	static final String REGISCOMPRASJUEGO="Registro compras videojuegos";
	


	

	

    
    /**
     * Constructor de la clase.
     * Añade la imagen de fondo.
     * @param String title
     */
    public frmPrincipalAdministrador(String title) 
    {
    
    	super(title);

        //Set up the GUI.
       
        
        
        ImageIcon aga=new ImageIcon("C:/Users/ALUMNO/Desktop/aga.jpg");
        JLabel fondo=new JLabel();
        fondo.setIcon(aga);
        

        
        
        panel = new JDesktopPane();
        panel.add(fondo);
        
        panel.setPreferredSize(new Dimension(desktopWidth, desktopHeight));
        setContentPane(panel);
        
    
       
       
        

        
     }
    
    
    
    
    
    
    
    
    /**
  	 * 
  	 * Pasa como parámetro el método createJMenuBar() al setJMenuBar()
  	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
  	 * @return void
  	 */
      public void CreateAndShowGUI() 
  	{
  	       
  	        
  	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  	        this.setJMenuBar(createMenuBar());
  	        //Display the window.
  	        this.pack();
  	        this.setVisible(true);
  	        
  	        
  	        
  	        fondo=new JLabel(new ImageIcon("C:/Users/ALUMNO/workspace/Videoclub/src/imagen/AGV.gif"));
	        fondo.setBounds(0, 0, desktopWidth, desktopHeight);
		    panel.add(fondo);
  	        
  			this.setResizable(true);
  			this.setClosable(false);
  			this.setIconifiable(true);
  			this.setMaximizable(true);
  	        
  	 }
    
    
    








	/**
     * Método que abre una internal frame para poder dar de alta un nuevo usuario.
     * @return void	
     */
    protected void CrearUsuario() 
    {
    		

    		frmAltaUsuario frame = new frmAltaUsuario("Alta usuario");
            frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
			try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


           
            
	   }
	    
    
    
    /**
     * Método que abre una internal frame para poder dar de alta una nueva película.
     * @return void	
     */	
    protected void CrearPeli() 
	   {
    		

    		frmAltaPelicula frame = new frmAltaPelicula("Alta Película");
            frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
            try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	   }
    
    /**
     * Método que abre una internal frame para poder dar de alta un nuevo videojuego.
     * @return void	
     */
    protected void CrearVideojuego() 
	   {
 		

 		frmAltaVideojuego frame = new frmAltaVideojuego("Alta Videojuego");
         frame.CreateAndShowGUI(); 
         frame.setVisible(true);//necessary as of 1.3
         panel.add(frame);
         try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
	   }
    	
    
    	
    
	
	
	
	
	
	/**
     * Método que abre una internal frame para poder modificar un usuario.
     * En caso de no haber introducido usuarios, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */	
    protected void ModiUsuario()
   	{
    		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		LinkedList<clsUsuario> listam = new LinkedList <clsUsuario>();
    		listam=objGestor.ListaUsuarios();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			}
    		}
    		
    		else
    		{
    		frmModificarUsuario frame=new frmModificarUsuario("Modificar usuario");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
            try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		}
   }
    	
    	
    	
    /**
     * Método que abre una internal frame para poder modificar una película.
     * En caso de no haber introducido películas, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */		
    protected void ModiPeli()
    {
    		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		CopyOnWriteArrayList<clsPelicula> listam = new CopyOnWriteArrayList <clsPelicula>();
    		listam=objGestor.ListaPeliculas();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			
    			}
    		}
    		
    
    		
    		else
    		{
    		frmModificarPelicula frame=new frmModificarPelicula("Modificar película");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
			try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		}
	
   }
    	
    
    
    
    
    
    /**
     * Método que abre una internal frame para poder modificar un videojuego.
     * En caso de no haber introducido videojuegos, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */		
    protected void ModiVideojuego()
    {
    		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		CopyOnWriteArrayList<clsVideojuego> listam = new CopyOnWriteArrayList <clsVideojuego>();
    		listam=objGestor.ListaVideojuegos();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			
    			}
    		}
    		
    
    		
    		else
    		{
    		frmModificarVideojuego frame=new frmModificarVideojuego("Modificar videojuego");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
			try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		}
	
   }
    	
    
    
  
    
    
    
    
    
    
    /**
     * Método que abre una internal frame para poder eliminar un usuario.
     * En caso de no haber introducido usuarios, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */		
    protected void EliminarUsuario()
   	{
    		
    		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		LinkedList<clsUsuario> listam = new LinkedList <clsUsuario>();
    		listam=objGestor.ListaUsuarios();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			
    			}
    		}
    		
    		
    		else
    		{
    		frmEliminarUsuario frame=new frmEliminarUsuario("Eliminar usuario");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
            try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		}
   }
    	
    	
    
    /**
     * Método que abre una internal frame para poder eliminar una película.
     * En caso de no haber introducido películas, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */
    protected void EliminarPeli() 
   	{
    		
    		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		CopyOnWriteArrayList<clsPelicula> listam = new CopyOnWriteArrayList <clsPelicula>();
    		listam=objGestor.ListaPeliculas();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    		
    			}
    		}
    		
    		else
    		{
    		frmEliminarPelicula frame=new frmEliminarPelicula("Eliminar película");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
            try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		}
   	}
    
    
    
    
    
    
    
    
    /**
     * Método que abre una internal frame para poder eliminar un videojuego.
     * En caso de no haber introducido videojuegos, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */
    protected void EliminarVideojuego() 
   	{
    		
    		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		CopyOnWriteArrayList<clsVideojuego> listam = new CopyOnWriteArrayList <clsVideojuego>();
    		listam=objGestor.ListaVideojuegos();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    		
    			}
    		}
    		
    		else
    		{
    		frmEliminarVideojuego frame=new frmEliminarVideojuego("Eliminar videojuego");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
            try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		}
   	}
    	
    	
    	

    
    
    
    
    
    /**
     * Método que abre una internal frame para poder ordenar la lista de usuarios.
     * En caso de no haber introducido usuarios, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */	
    protected void OrdenarUsuario()
    {

       		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		LinkedList<clsUsuario> listam = new LinkedList <clsUsuario>();
    		listam=objGestor.ListaUsuarios();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			
    			}
    		}
       		
       		
    		else
    		{
       		
    		frmOrdenarUsuario frame=new frmOrdenarUsuario("Ordenación de usuarios");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
            try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
    		}
  }
       	
       	
     
    /**
     * Método que abre una internal frame para poder ordenar la lista de películas.
     * En caso de no haber introducido películas, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */
    protected void OrdenarPeli()
   	{
    		
      		
      		
      		clsGestor objGestor=new clsGestor();
    		
    		
    		
      		CopyOnWriteArrayList<clsPelicula> listam = new CopyOnWriteArrayList <clsPelicula>();
    		listam=objGestor.ListaPeliculas();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			
    			}
    		}
      		
      		
      		
      		
    		else
    		{
    		frmOrdenarPelicula frame=new frmOrdenarPelicula("Ordenación de películas");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
			try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		}
			
	
   }
    
    
    
    
    
    
    
    /**
     * Método que abre una internal frame para poder ordenar la lista de videojuegos.
     * En caso de no haber introducido videojuegos, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */
    protected void OrdenarVideojuego()
   	{
    		
      		
      		
      		clsGestor objGestor=new clsGestor();
    		
    		
    		
      		CopyOnWriteArrayList<clsVideojuego> listam = new CopyOnWriteArrayList <clsVideojuego>();
    		listam=objGestor.ListaVideojuegos();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			
    			}
    		}
      		
      		
      		
      		
    		else
    		{
    		frmOrdenarVideojuego frame=new frmOrdenarVideojuego("Ordenación de videojuegos");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
			try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		}
			
	
   }
    
    
    
    
    
    
    
      	

    
    
 	
    /**
     * Método que abre una internal frame para poder ver los alquileres de películas.
     * En caso de no haber introducido ningún alquiler de películas, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */		
    protected void RegistroAlquiPeli()
    {
    		
    		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		CopyOnWriteArrayList<clsPeli_Alquilada> listam = new CopyOnWriteArrayList <clsPeli_Alquilada>();
    		listam=objGestor.ListaAlquileresPeli();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			}
    		}
    		
    		else
    		{
    		
    		
    		frmRegistroAlquiPeli frame=new frmRegistroAlquiPeli("Registro de alquileres de películas");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
            try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
    		}
    	
    	
   }
    	
    
    
    
    /**
     * Método que abre una internal frame para poder ver las compras de películas.
     * En caso de no haber introducido ninguna compra de película, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */		
    protected void RegistroComprasPeli()
    {
    		
    		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		LinkedList<clsPeli_Comprada> listam = new LinkedList <clsPeli_Comprada>();
    		listam=objGestor.ListaComprasPeli();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			}
    		}
    		
    		else
    		{
    		
    		
    		frmRegistroCompraPeli frame=new frmRegistroCompraPeli("Registro de compras de películas");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
            try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
    		}
    	
    	
   }
    
    
    
    
    
    
    /**
     * Método que abre una internal frame para poder ver los alquileres de videojuegos.
     * En caso de no haber introducido ningún alquiler de videojuegos, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */		
    protected void RegistroAlquiJuego()
    {
    		
    		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		CopyOnWriteArrayList<clsVideojuego_Alquilado> listam = new CopyOnWriteArrayList <clsVideojuego_Alquilado>();
    		listam=objGestor.ListaAlquileresVideojuegos();
    	
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			}
    		}
    		
    		else
    		{
    		
    		
    		frmRegistroAlquiVideojuego frame=new frmRegistroAlquiVideojuego("Registro de alquileres de videojuegos");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
            try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
    		}
    	
    	
   }
    	
    
    
    
    /**
     * Método que abre una internal frame para poder ver las compras de videojuegos.
     * En caso de no haber introducido ninguna compra de videojuegos, salta la excepción clsNoDatos
     * @throws clsNoDatos
     * @return void	
     */	
    protected void RegistroComprasJuego()
    {
    		
    		clsGestor objGestor=new clsGestor();
    		
    		
    		
    		LinkedList<clsVideojuego_Comprado> listam = new LinkedList <clsVideojuego_Comprado>();
    		listam=objGestor.ListaComprasVideojuego();
    	

    		if(listam.size()==0)
    		{
    			try
    			{
    				objGestor.NoHayDatos();
    			} 
    			catch (clsNoDatos e) 
    			{
    				
    				JOptionPane.showMessageDialog(this, e.getMessage());    			
    			}
    		}
    		
    		else
    		{
    		
    		
    		frmRegistroCompraVideojuego frame=new frmRegistroCompraVideojuego("Registro de compras de videojuegos");
    		frame.CreateAndShowGUI(); 
            frame.setVisible(true);//necessary as of 1.3
            panel.add(frame);
            try {
				frame.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
    		}
    	
    	
   }
    
    
    
    
    
    
    
    
    
    /**
     * Método que crea la estructura de la ventana principal de administrador.
     * Añade el JMenuBar, los JMenu y los JMenuItem.
     * @return JMenuBar
     */
    protected JMenuBar createMenuBar() 
    {
	        JMenuBar menuBar = new JMenuBar();

	        //Set up the lone menu.
	        JMenu menualta = new JMenu("Dar de alta");
	        menualta.setMnemonic(KeyEvent.VK_Q);
	        menuBar.add(menualta);
	        
	        JMenu menumodi=new JMenu("Modificar");
	        menumodi.setMnemonic(KeyEvent.VK_W);
	        menuBar.add(menumodi);
	        
	        JMenu menuelim=new JMenu("Eliminar");
	        menuelim.setMnemonic(KeyEvent.VK_E);
	        menuBar.add(menuelim);
	        
	        JMenu menuorden=new JMenu("Ordenar");
	        menuorden.setMnemonic(KeyEvent.VK_R);
	        menuBar.add(menuorden);
	        
	        JMenu menuregistro=new JMenu("Registro");
	        menuregistro.setMnemonic(KeyEvent.VK_T);
	        menuBar.add(menuregistro);
	        
	       
	        

	        //Set up the first menu item.
	        JMenuItem CrearUsuario = new JMenuItem("Usuario");
	        CrearUsuario.setMnemonic(KeyEvent.VK_N);
	        CrearUsuario.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_Y, ActionEvent.ALT_MASK));
	        CrearUsuario.setActionCommand("Nuevo usuario");
	        CrearUsuario.addActionListener(this);
	        menualta.add(CrearUsuario);
	        
	        
	        JMenuItem CrearPeli = new JMenuItem("Película");
	        CrearPeli.setMnemonic(KeyEvent.VK_N);
	        CrearPeli.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_U, ActionEvent.ALT_MASK));
	        CrearPeli.setActionCommand("Nueva película");
	        CrearPeli.addActionListener(this);
	        menualta.add(CrearPeli);
	        
	        JMenuItem CrearJuego = new JMenuItem("Videojuego");
	        CrearJuego.setMnemonic(KeyEvent.VK_N);
	        CrearJuego.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_I, ActionEvent.ALT_MASK));
	        CrearJuego.setActionCommand("Nuevo videojuego");
	        CrearJuego.addActionListener(this);
	        menualta.add(CrearJuego);
	        
	  
	        
	        
	        
	        JMenuItem ModificarUsuario = new JMenuItem("Usuario");
	        ModificarUsuario.setMnemonic(KeyEvent.VK_N);
	        ModificarUsuario.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_O, ActionEvent.ALT_MASK));
	        ModificarUsuario.setActionCommand("Modificar usuario");
	        ModificarUsuario.addActionListener(this);
	        menumodi.add(ModificarUsuario);
	        
	        
	        JMenuItem ModificarPeli = new JMenuItem("Película");
	        ModificarPeli.setMnemonic(KeyEvent.VK_N);
	        ModificarPeli.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_P, ActionEvent.ALT_MASK));
	        ModificarPeli.setActionCommand("Modificar película");
	        ModificarPeli.addActionListener(this);
	        menumodi.add(ModificarPeli);
	        
	        
	        JMenuItem ModificarJuego = new JMenuItem("Videojuego");
	        ModificarJuego.setMnemonic(KeyEvent.VK_N);
	        ModificarJuego.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_A, ActionEvent.ALT_MASK));
	        ModificarJuego.setActionCommand("Modificar videojuego");
	        ModificarJuego.addActionListener(this);
	        menumodi.add(ModificarJuego);
	        

	        
	        
	        
	        
	        JMenuItem EliminarUsuario = new JMenuItem("Usuario");
	        EliminarUsuario.setMnemonic(KeyEvent.VK_N);
	        EliminarUsuario.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_S, ActionEvent.ALT_MASK));
	        EliminarUsuario.setActionCommand("Eliminar usuario");
	        EliminarUsuario.addActionListener(this);
	        menuelim.add(EliminarUsuario);
	        
	        
	        JMenuItem EliminarPeli = new JMenuItem("Película");
	        EliminarPeli.setMnemonic(KeyEvent.VK_N);
	        EliminarPeli.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_D, ActionEvent.ALT_MASK));
	        EliminarPeli.setActionCommand("Eliminar película");
	        EliminarPeli.addActionListener(this);
	        menuelim.add(EliminarPeli);
	        
	        JMenuItem EliminarJuego = new JMenuItem("Videojuego");
	        EliminarJuego.setMnemonic(KeyEvent.VK_N);
	        EliminarJuego.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_F, ActionEvent.ALT_MASK));
	        EliminarJuego.setActionCommand("Eliminar videojuego");
	        EliminarJuego.addActionListener(this);
	        menuelim.add(EliminarJuego);
	        
	        
	
	        
        
	        JMenuItem OrdenarUsuario = new JMenuItem("Usuario");
	        OrdenarUsuario.setMnemonic(KeyEvent.VK_N);
	        OrdenarUsuario.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_G, ActionEvent.ALT_MASK));
	        OrdenarUsuario.setActionCommand("Ordenar usuario");
	        OrdenarUsuario.addActionListener(this);
	        menuorden.add(OrdenarUsuario);
	        
	        
	        JMenuItem OrdenarPeli = new JMenuItem("Película");
	        OrdenarPeli.setMnemonic(KeyEvent.VK_N);
	        OrdenarPeli.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_H, ActionEvent.ALT_MASK));
	        OrdenarPeli.setActionCommand("Ordenar película");
	        OrdenarPeli.addActionListener(this);
	        menuorden.add(OrdenarPeli);
	        
	        JMenuItem OrdenarJuego = new JMenuItem("Videojuego");
	        OrdenarJuego.setMnemonic(KeyEvent.VK_N);
	        OrdenarJuego.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_J, ActionEvent.ALT_MASK));
	        OrdenarJuego.setActionCommand("Ordenar videojuego");
	        OrdenarJuego.addActionListener(this);
	        menuorden.add(OrdenarJuego);
	        
	  
	        
	        
	        
	        
	        JMenuItem RegistroAlquileresPeli = new JMenuItem("Alquileres películas");
	        RegistroAlquileresPeli.setMnemonic(KeyEvent.VK_N);
	        RegistroAlquileresPeli.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_K, ActionEvent.ALT_MASK));
	        RegistroAlquileresPeli.setActionCommand("Registro alquileres pelis");
	        RegistroAlquileresPeli.addActionListener(this);
	        menuregistro.add(RegistroAlquileresPeli);
	        
	        
	        JMenuItem RegistroComprasPeli = new JMenuItem("Compras películas");
	        RegistroComprasPeli.setMnemonic(KeyEvent.VK_N);
	        RegistroComprasPeli.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_L, ActionEvent.ALT_MASK));
	        RegistroComprasPeli.setActionCommand("Registro compras pelis");
	        RegistroComprasPeli.addActionListener(this);
	        menuregistro.add(RegistroComprasPeli);
	        
	        JMenuItem RegistroAlquileresJuego = new JMenuItem("Alquileres videojuegos");
	        RegistroAlquileresJuego.setMnemonic(KeyEvent.VK_N);
	        RegistroAlquileresJuego.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_Z, ActionEvent.ALT_MASK));
	        RegistroAlquileresJuego.setActionCommand("Registro alquileres videojuegos");
	        RegistroAlquileresJuego.addActionListener(this);
	        menuregistro.add(RegistroAlquileresJuego);
	        
	        
	        JMenuItem RegistroComprasJuego = new JMenuItem("Compras videojuegos");
	        RegistroComprasJuego.setMnemonic(KeyEvent.VK_N);
	        RegistroComprasJuego.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_X, ActionEvent.ALT_MASK));
	        RegistroComprasJuego.setActionCommand("Registro compras videojuegos");
	        RegistroComprasJuego.addActionListener(this);
	        menuregistro.add(RegistroComprasJuego);
	        
	 

	        return menuBar;
	        
   }
	   
	    
	    
	    
	    
  
	
	
	
	   

    
		private void setIconifiable(boolean b) {
			// TODO Auto-generated method stub
			
		}


		private void setClosable(boolean b) {
			// TODO Auto-generated method stub
			
		}

	    
	    private void setMaximizable(boolean b) {
			// TODO Auto-generated method stub
			
		}

	    
	    
	    
	    

	    /**
		 * Método para gestionar la escucha de eventos, la escucha de los diferentes JMenuItem en este caso.
		 * Obligatorio al implementar la interfaz ActionListener
		 * @return void
		 */
		public void actionPerformed(ActionEvent e) 
	    {
	        switch(e.getActionCommand())
	        {
	        

	        	
	        
	        case CREARUSUARIO:
				CrearUsuario();
	        break;
	        
	        
	        
	        case CREARPELI:
	        		CrearPeli();
	        	break;
	        	
	        case CREARJUEGO:
	        	CrearVideojuego();
	        	break;
	        	
	        case MODIUSUARIO:
	        	ModiUsuario();
	        	break;
	        	
	        	
	        case MODIPELI:
	        	ModiPeli();
	        	break;
	        	
	        case MODIJUEGO:
	        	ModiVideojuego();
	        	break;
	        	
	        	
	        case ELIMINARUSUARIO:
	        	EliminarUsuario();
	        	break;
	        	
	        	
	        	
	        case ELIMINARPELI:
	        	EliminarPeli();
	        	break;
	        	
	        case ELIMINARJUEGO:
	        	EliminarVideojuego();
	        	break;
	        	
	        case ORDENUSUARIO:
	        	OrdenarUsuario();
	        	break;
	        	
	        	
	        case ORDENPELI:
	        	OrdenarPeli();
	        	break;
	        	
	        	
	        case ORDENJUEGO:
	        	OrdenarVideojuego();
	        	break;
	        	
	        	
	        case REGISALQUIPELI:
	        	RegistroAlquiPeli();
	        	break;
	        	
	        	
	        case REGISCOMPRASPELI:
	        	RegistroComprasPeli();
	        	break;
	        	
	        	
	        case REGISALQUIJUEGO:
	        	RegistroAlquiJuego();
	        	break;
	        	
	        	
	        case REGISCOMPRASJUEGO:
	        	RegistroComprasJuego();
	        	break;
	   

	        
	        }
	    	


	    }








		public void setSelected(boolean b) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}