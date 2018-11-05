package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import LN.clsGestor;
import LN.clsPelicula;
import LN.clsPeliculaRepetida;






/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para dar de alta a las películas.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmAltaPelicula extends JInternalFrame implements ActionListener
{

	
	
	

	JLabel lblTitulo;
	JLabel lblDuracion;
	JLabel lblCodigo;
	JLabel lblTipo;
	JLabel lblCategoria;
	JLabel lblPrecio;
	
	
	JTextField txtTitulo;
	JTextField txtDuracion;
	JTextField txtCodigo;
	JTextField txtCategoria;
	JTextField txtPrecio;
	
	
	JRadioButton cat_comedia;
	JRadioButton cat_terror;
	JRadioButton cat_accion;
	JRadioButton cat_ciencia_ficcion;
	JRadioButton cat_dibujos;
	JRadioButton cat_otro;

	JRadioButton tipo_venta;
	JRadioButton tipo_alqui;

	
	
	
	JButton btnAceptar;
	JButton btnCancelar;
	
	Container pane;

	
	private final String ACEPTAR="ACEPTAR";
	private final String CANCELAR="CANCELAR";
	
	
	
	static final int desktopWidth = 500;
	static final int desktopHeight = 300;

	JDesktopPane nuevop;
	JPanel jpContent;
	
	
	
	
	
	
	
	/**
	 * Constructor de la clase
	 * Inicializa las JLabel, los JTextField, los JButton
	 * @param String title
	 */
	public frmAltaPelicula(String title)
	{
		
		super(title);
		
		
		
		setBounds(100, 100, 450, 500);
		
		
		lblTitulo=new JLabel("Título");
		lblDuracion=new JLabel("Duración");
		lblCodigo=new JLabel("Código");
		lblCategoria=new JLabel("Categoría");
		lblTipo=new JLabel("Tipo");
		lblPrecio=new JLabel("Precio");
		
		
		txtTitulo=new JTextField("");
		txtDuracion=new JTextField("");
		txtCodigo=new JTextField("");
		txtCategoria=new JTextField("");
		txtPrecio=new JTextField("");
	
		
		
		cat_comedia=new JRadioButton("Comedia");
		cat_terror=new JRadioButton("Terror");
		cat_accion=new JRadioButton("Acción");
		cat_ciencia_ficcion=new JRadioButton("Ciencia-Ficción");
		cat_dibujos=new JRadioButton("Dibujos");
		cat_otro=new JRadioButton("Otra");
		
		
		final ButtonGroup group = new ButtonGroup();
        group.add(cat_comedia);
        group.add(cat_terror);
        group.add(cat_accion);
        group.add(cat_ciencia_ficcion);
        group.add(cat_dibujos);
        group.add(cat_otro);
        
        
        
		
		tipo_venta=new JRadioButton("Para vender");
		tipo_alqui=new JRadioButton("Para alquilar");
		
		final ButtonGroup group1 = new ButtonGroup();
        group1.add(tipo_venta);
        group1.add(tipo_alqui);
		
		btnAceptar=new JButton("Aceptar");
		btnCancelar=new JButton("Cancelar");
		btnAceptar.addActionListener(this);
		btnAceptar.setActionCommand(ACEPTAR);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand(CANCELAR);
	
		nuevop=new JDesktopPane();
		
		
         
		
		
		
		nuevop.setLayout(new BorderLayout());
		nuevop.setBackground(Color.ORANGE);
		nuevop.repaint();

	
		
		this.setContentPane(nuevop);
		
	}
	
	
	
	
	
	
	
	
	/**
	 * Constructor de la clase utilizado únicamente para modificar.
	 * Inicializa las JLabel, los JTextField, los JButton.
	 * @param String title
	 * @param clsPelicula a
	 */
	public frmAltaPelicula(String title, clsPelicula a)
	{
		
		super(title);
		
		
		
		setBounds(100, 100, 450, 500);
		
		
		lblTitulo=new JLabel("Título");
		lblDuracion=new JLabel("Duración");
		lblCodigo=new JLabel("Código");
		lblCategoria=new JLabel("Categoría");
		lblTipo=new JLabel("Tipo");
		lblPrecio=new JLabel("Precio");
		
		
		txtTitulo=new JTextField(a.getNombre());
		String s = Integer.toString(a.getPrecio());
		txtPrecio=new JTextField(s);
		String string = Integer.toString(a.getDuración());
		txtDuracion=new JTextField(string);
		txtCodigo=new JTextField(a.getCodigop());
		txtCategoria=new JTextField(a.getCategoría());
		
		txtCodigo.setEnabled(false);
		
		
	
		
		
		cat_comedia=new JRadioButton("Comedia");
		cat_terror=new JRadioButton("Terror");
		cat_accion=new JRadioButton("Acción");
		cat_ciencia_ficcion=new JRadioButton("Ciencia-Ficción");
		cat_dibujos=new JRadioButton("Dibujos");
		cat_otro=new JRadioButton("Otra");
		
		
		final ButtonGroup group = new ButtonGroup();
        group.add(cat_comedia);
        group.add(cat_terror);
        group.add(cat_accion);
        group.add(cat_ciencia_ficcion);
        group.add(cat_dibujos);
        group.add(cat_otro);
        
        
        
        if(a.getCategoría().equals("Comedia"))
		{
        	cat_comedia.setSelected(true);
		}
        if(a.getCategoría().equals("Terror"))
		{
        	cat_terror.setSelected(true);
		}
        if(a.getCategoría().equals("Acción"))
		{
        	cat_accion.setSelected(true);
		}
        if(a.getCategoría().equals("Ciencia-Ficción"))
		{
        	cat_ciencia_ficcion.setSelected(true);
		}
        if(a.getCategoría().equals("Dibujos"))
		{
        	cat_dibujos.setSelected(true);
		}
        if(a.getCategoría().equals("Otra"))
		{
        	cat_otro.setSelected(true);
		}
        
        
        
		
		tipo_venta=new JRadioButton("Para vender");
		tipo_alqui=new JRadioButton("Para alquilar");
		
		final ButtonGroup group1 = new ButtonGroup();
        group1.add(tipo_venta);
        group1.add(tipo_alqui);
        
        
        if(a.getTipo().equals("Venta"))
		{
			tipo_venta.setSelected(true);
		}
        if(a.getTipo().equals("Alquiler"))
		{
        	tipo_alqui.setSelected(true);
		}
		
		btnAceptar=new JButton("Aceptar");
		btnCancelar=new JButton("Cancelar");
		btnAceptar.addActionListener(this);
		btnAceptar.setActionCommand(ACEPTAR);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand(CANCELAR);
	
		nuevop=new JDesktopPane();
		
		
         
		

		
		nuevop.setLayout(new BorderLayout());
		nuevop.setBackground(Color.ORANGE);
		nuevop.repaint();

		
		
		

		this.setContentPane(nuevop);
		
	}
	
	
	
	
	
	/**
	 * 
	 * Método que llama al método addComponentsToPane()
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		addComponentsToPane(this.getContentPane());

		this.setVisible(true);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		this.setClosable(true);
		
	}
	
	
	
	
	/**
	 * Método que añade los elementos inicializados al panel de tipo BoxLayout
	 * @return void
	 * @param Container pane
	 */
	public void addComponentsToPane(Container pane)
	{
		
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		
		this.getContentPane().add(lblTitulo);
		this.getContentPane().add(txtTitulo);
		this.getContentPane().add(lblPrecio);
		this.getContentPane().add(txtPrecio);
		this.getContentPane().add(lblCategoria);
		this.getContentPane().add(cat_comedia);
		this.getContentPane().add(cat_terror);
		this.getContentPane().add(cat_accion);
		this.getContentPane().add(cat_ciencia_ficcion);
		this.getContentPane().add(cat_dibujos);
		this.getContentPane().add(cat_otro);


		
		this.getContentPane().add(lblDuracion);
		this.getContentPane().add(txtDuracion);
		this.getContentPane().add(lblCodigo);
		this.getContentPane().add(txtCodigo);
		this.getContentPane().add(lblTipo);
		this.getContentPane().add(tipo_venta);
		this.getContentPane().add(tipo_alqui);



		this.getContentPane().add(btnAceptar);
		this.getContentPane().add(btnCancelar);

		
	}
	
	
	
	/**
	 * Método para gestionar la escucha de eventos, la escucha de los botones en esta caso.
	 * Obligatorio al implementar la interfaz ActionListener
	 * @return void
	 */
	public void actionPerformed(ActionEvent e)
	{
		
		
		String comando=e.getActionCommand();
		clsGestor objGestor=new clsGestor();
		
		switch(comando)
		{
		
		
		

		
		case ACEPTAR:
			
			
			
			if(txtTitulo.getText().length()>0&&txtPrecio.getText().length()>0&&txtDuracion.getText().length()>0&&txtCodigo.getText().length()>0&&(cat_comedia.isSelected()||cat_terror.isSelected()||cat_accion.isSelected()||cat_ciencia_ficcion.isSelected()||cat_dibujos.isSelected()||cat_otro.isSelected())&&(tipo_venta.isSelected()||tipo_alqui.isSelected()))
			{
			

			if(tipo_venta.isSelected()&&cat_comedia.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Comedia", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}

			}
			
			
			
			
			
			if(tipo_venta.isSelected()&&cat_terror.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Terror", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
			
			}
			
			
			
			
			
			
			
			if(tipo_venta.isSelected()&&cat_accion.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Acción", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
		
			}
			
			
			
			if(tipo_venta.isSelected()&&cat_ciencia_ficcion.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Ciencia-Ficción", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
			
			}
			
		
			
			if(tipo_venta.isSelected()&&cat_dibujos.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Dibujos", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
			
			}
			
			
			
			if(tipo_venta.isSelected()&&cat_otro.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Otra", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
			
			}
			
			
			
			
			
			
			
			
			
			if(tipo_alqui.isSelected()&&cat_comedia.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Comedia", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
			
			}
			
			
			
			
			
			if(tipo_alqui.isSelected()&&cat_terror.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Terror", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
			
			}
			
			
			
			
			
			
			
			if(tipo_alqui.isSelected()&&cat_accion.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Acción", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
			
			}
			
			
			
			if(tipo_alqui.isSelected()&&cat_ciencia_ficcion.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Ciencia-Ficción", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
		
			}
			
		
			
			if(tipo_alqui.isSelected()&&cat_dibujos.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Dibujos", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
			
			}
			
			
			
			if(tipo_alqui.isSelected()&&cat_otro.isSelected())
			{
			
			try
			{
				
				objGestor.CrearPelicula(txtTitulo.getText(), "Otra", Integer.parseInt(txtDuracion.getText()), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsPeliculaRepetida p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en duración y precio");
			}
		
			}
			
			
			
			
			
			
			try {
				frmModificarPelicula.ActualizarTabla();
			} catch (NullPointerException e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace();
			}
			
			
			
			
			
			}
			
			
			else
			{
				JOptionPane.showMessageDialog(this, "Introduzca todos los datos");
				break;
			}
			
			
			
			
			
		case CANCELAR:
				this.dispose();
		break;	
		
		
		
		}
		
		
		
		
		
	}
}
