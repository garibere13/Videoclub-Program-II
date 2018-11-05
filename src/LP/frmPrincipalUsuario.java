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
import LN.clsPelicula;
import LN.clsVideojuego;




/**
 * 
 * @author Garikoitz.Bereciartua
 * Ventana principal del usuario, desde la cual se podrán ejecutar diferentes opciones.
 * Hereda de JFrmae e implementa ActionListener
 *
 */
public class frmPrincipalUsuario extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;

	
	
	
	
	
    JPanel desktop;
    JDesktopPane panel;
    
    static final int desktopWidth = 800;
    static final int desktopHeight = 400;

    
    JInternalFrame displayWindow;
    JInternalFrame listenedToWindow;
    
    JLabel fondo;
	
	static final String ALQUILARPELI = "Alquilar película";
	static final String ALQUILARJUEGO = "Alquilar videojuego";
	static final String DEVOLVERPELI="Devolver película";
	static final String DEVOLVERJUEGO="Devolver videojuego";
	static final String COMPRARPELI="Comprar película";
	static final String COMPRARJUEGO="Comprar videojuego";
	static final String ORDENARPELI="Ordenar películas";
	static final String ORDENARJUEGO="Ordenar videojuego";


	
	CopyOnWriteArrayList<clsPelicula> pelisalqui;
	CopyOnWriteArrayList<clsPelicula> peliscompra;
	CopyOnWriteArrayList<clsVideojuego> juegosalqui;
	CopyOnWriteArrayList<clsVideojuego> juegoscompra;



	

    
	 /**
     * Constructor de la clase.
     * Añade la imagen de fondo.
     * @param String title
     */
    public frmPrincipalUsuario(String title) 
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
      public void createAndShowGUI() 
  	{
  	       

//  	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
     * Método que abre una internal frame para poder alquilar una película.
     * En caso de no haber películas para alquilar, salta la excepción clsNoDatos.
     * @throws clsNoDatos
     * @return void	
     */
    protected void AlquilarPeli() 
    {
    		
    	
    	
     		clsGestor objGestor= new clsGestor();
    		pelisalqui=objGestor.ListaPeliculas();		
    		
    		
    		
    		
    		for(clsPelicula aux:pelisalqui)
    		{
    				if(aux.getTipo().equals("Venta"))
    				{
    					pelisalqui.remove(aux);
    				}
    				
    				
    		}
    		
    		
    		if(pelisalqui.size()==0)
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

    		frmAlquilarPeli frame = new frmAlquilarPeli("Alquiler de películas");
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
     * Método que abre una internal frame para poder alquilar un videojuego.
     * En caso de no haber videojuegos para alquilar, salta la excepción clsNoDatos.
     * @throws clsNoDatos
     * @return void	
     */
    protected void AlquilarVideojuego() 
    {
    	
    	clsGestor objGestor= new clsGestor();
		juegosalqui=objGestor.ListaVideojuegos();		
		
		
		
		
		for(clsVideojuego aux:juegosalqui)
		{
				if(aux.getTipo().equals("Venta"))
				{
					juegosalqui.remove(aux);
					
				}
				
				
		}
		
		
		if(juegosalqui.size()==0)
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

    		frmAlquilarVideojuego frame = new frmAlquilarVideojuego("Alquiler de videojuegos");
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
     * Método que abre una internal frame para poder devolver una película.
     * @return void	
     */
    protected void DevolverPeli() 
	   {
    		

    		frmDevolverPeli frame = new frmDevolverPeli("Devolución de película");
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
     * Método que abre una internal frame para devolver un videojuego.
     * @return void	
     */	
    protected void DevolverVideojuego() 
	   {
    		

    		frmDevolverVideojuego frame = new frmDevolverVideojuego("Devolución de videojuegos");
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
     * Método que abre una internal frame para poder comprar una película.
     * En caso de no haber películas para comprar, salta la excepción clsNoDatos.
     * @throws clsNoDatos
     * @return void	
     */		
    protected void ComprarPeli() 
    {
    		
    	
    	clsGestor objGestor= new clsGestor();
		peliscompra=objGestor.ListaPeliculas();		
		
		
		
		
		for(clsPelicula aux:peliscompra)
		{
				if(aux.getTipo().equals("Alquiler"))
				{
					peliscompra.remove(aux);
					
				}
				
				
		}
		
		
		if(peliscompra.size()==0)
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

    		frmComprarPeli frame = new frmComprarPeli("Compra de película");
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
     * Método que abre una internal frame para poder comprar un videojuego.
     * En caso de no haber videojuegos para comprar, salta la excepción clsNoDatos.
     * @throws clsNoDatos
     * @return void	
     */		
    protected void ComprarVideojuego() 
    {
    		
    	
    	
    	
    	clsGestor objGestor= new clsGestor();
		juegoscompra=objGestor.ListaVideojuegos();		
		
		
		
		
		for(clsVideojuego aux:juegoscompra)
		{
				if(aux.getTipo().equals("Alquiler"))
				{
					juegoscompra.remove(aux);
					
				}
				
				
		}
		
		
		if(juegoscompra.size()==0)
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

    		frmComprarVideojuego frame = new frmComprarVideojuego("Compra de videojuego");
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
    		
    		
    		
      		CopyOnWriteArrayList<clsPelicula> listam = new CopyOnWriteArrayList<clsPelicula>();
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
     * Método que crea la estructura de la ventana principal de usuario.
     * Añade el JMenuBar, los JMenu y los JMenuItem.
     * @return JMenuBar
     */
    protected JMenuBar createMenuBar() 
    {
	        JMenuBar menuBar = new JMenuBar();

	        //Set up the lone menu.
	        JMenu menualqui = new JMenu("Alquilar");
	        menualqui.setMnemonic(KeyEvent.VK_Q);
	        menuBar.add(menualqui);
	        
	        JMenu menudev=new JMenu("Devolver");
	        menudev.setMnemonic(KeyEvent.VK_W);
	        menuBar.add(menudev);
	        
	        JMenu menucompra=new JMenu("Comprar");
	        menucompra.setMnemonic(KeyEvent.VK_E);
	        menuBar.add(menucompra);
	        
	        JMenu menuorden=new JMenu("Ordenar");
	        menuorden.setMnemonic(KeyEvent.VK_R);
	        menuBar.add(menuorden);
	        
	       
	        

	        //Set up the first menu item.
	        JMenuItem AlquilarPeli = new JMenuItem("Película");
	        AlquilarPeli.setMnemonic(KeyEvent.VK_T);
	        AlquilarPeli.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_T, ActionEvent.ALT_MASK));
	        AlquilarPeli.setActionCommand("Alquilar película");
	        AlquilarPeli.addActionListener(this);
	        menualqui.add(AlquilarPeli);
	        
	        
	        JMenuItem AlquilarJuego = new JMenuItem("Videojuego");
	        AlquilarJuego.setMnemonic(KeyEvent.VK_T);
	        AlquilarJuego.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_Y, ActionEvent.ALT_MASK));
	        AlquilarJuego.setActionCommand("Alquilar videojuego");
	        AlquilarJuego.addActionListener(this);
	        menualqui.add(AlquilarJuego);
	        
	        
	        JMenuItem DevolverPeli = new JMenuItem("Película");
	        DevolverPeli.setMnemonic(KeyEvent.VK_Y);
	        DevolverPeli.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_U, ActionEvent.ALT_MASK));
	        DevolverPeli.setActionCommand("Devolver película");
	        DevolverPeli.addActionListener(this);
	        menudev.add(DevolverPeli);
	        
	        JMenuItem DevolverJuego = new JMenuItem("Videojuego");
	        DevolverJuego.setMnemonic(KeyEvent.VK_Y);
	        DevolverJuego.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_I, ActionEvent.ALT_MASK));
	        DevolverJuego.setActionCommand("Devolver videojuego");
	        DevolverJuego.addActionListener(this);
	        menudev.add(DevolverJuego);
	        
	        
	        JMenuItem CompraPeli = new JMenuItem("Película");
	        CompraPeli.setMnemonic(KeyEvent.VK_U);
	        CompraPeli.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_O, ActionEvent.ALT_MASK));
	        CompraPeli.setActionCommand("Comprar película");
	        CompraPeli.addActionListener(this);
	        menucompra.add(CompraPeli);
	        
	        JMenuItem CompraJuego = new JMenuItem("Videojuego");
	        CompraJuego.setMnemonic(KeyEvent.VK_U);
	        CompraJuego.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_P, ActionEvent.ALT_MASK));
	        CompraJuego.setActionCommand("Comprar videojuego");
	        CompraJuego.addActionListener(this);
	        menucompra.add(CompraJuego);
	    
	 
        
	        JMenuItem OrdenarPeli = new JMenuItem("Película");
	        OrdenarPeli.setMnemonic(KeyEvent.VK_I);
	        OrdenarPeli.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_A, ActionEvent.ALT_MASK));
	        OrdenarPeli.setActionCommand("Ordenar películas");
	        OrdenarPeli.addActionListener(this);
	        menuorden.add(OrdenarPeli);
	        
	        JMenuItem OrdenarJuego = new JMenuItem("Videojuego");
	        OrdenarJuego.setMnemonic(KeyEvent.VK_I);
	        OrdenarJuego.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_S, ActionEvent.ALT_MASK));
	        OrdenarJuego.setActionCommand("Ordenar videojuego");
	        OrdenarJuego.addActionListener(this);
	        menuorden.add(OrdenarJuego);
	        
	        
	       
	        
	       
	 

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
	        

	        	
	        
	        case ALQUILARPELI:
					AlquilarPeli();
	        break;
	        
	        case ALQUILARJUEGO:
				AlquilarVideojuego();
				break;
	        
	        
	        
	        case DEVOLVERPELI:
	        		DevolverPeli();
	        	break;
	        	
	        case DEVOLVERJUEGO:
        		DevolverVideojuego();
        	break;
	        	
	        case COMPRARPELI:
	        	ComprarPeli();
	        	break;
	        	
	        case COMPRARJUEGO:
	        	ComprarVideojuego();
	        	break;
	        	
	  
	        	
	        case ORDENARPELI:
	        	OrdenarPeli();
	        	break;
	        	
	        case ORDENARJUEGO:
	        	OrdenarVideojuego();
	        	break;
	   

	        
	        }
	    	


	    }








		public void setSelected(boolean b) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
