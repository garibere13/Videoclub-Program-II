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
import LN.clsVideojuego;
import LN.clsVideojuegoRepetido;






/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para dar de alta a los videojuegos.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmAltaVideojuego extends JInternalFrame implements ActionListener
{

	
	
	

	JLabel lblNombre;
	JLabel lblDescripcion;
	JLabel lblCodigo;
	JLabel lblTipo;
	JLabel lblConsola;
	JLabel lblPrecio;
	
	
	JTextField txtNombre;
	JTextField txtDescripcion;
	JTextField txtCodigo;
	JTextField txtConsola;
	JTextField txtPrecio;
	
	
	JRadioButton ps3;
	JRadioButton ps4;
	JRadioButton xbox360;
	JRadioButton xboxone;
	JRadioButton pc;
	JRadioButton otro;

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
	public frmAltaVideojuego(String title)
	{
		
		super(title);
		
		
		
		setBounds(100, 100, 450, 500);
		
		
		lblNombre=new JLabel("Nombre");
		lblDescripcion=new JLabel("Descripcion");
		lblCodigo=new JLabel("Código");
		lblConsola=new JLabel("Consola");
		lblTipo=new JLabel("Tipo");
		lblPrecio=new JLabel("Precio");
		
		
		txtNombre=new JTextField("");
		txtDescripcion=new JTextField("");
		txtCodigo=new JTextField("");
		txtConsola=new JTextField("");
		txtPrecio=new JTextField("");
	
		
		
		ps3=new JRadioButton("PS3");
		ps4=new JRadioButton("PS4");
		xbox360=new JRadioButton("XBOX-360");
		xboxone=new JRadioButton("XBOX-ONE");
		pc=new JRadioButton("PC");
		otro=new JRadioButton("Otra");
		
		
		final ButtonGroup group = new ButtonGroup();
        group.add(ps3);
        group.add(ps4);
        group.add(xbox360);
        group.add(xboxone);
        group.add(pc);
        group.add(otro);
        
        
        
		
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
	 * @param clsVideojuego a
	 */
	public frmAltaVideojuego(String title, clsVideojuego a)
	{
		
		super(title);
		
		
		
		setBounds(100, 100, 450, 500);
		
		
		lblNombre=new JLabel("Nombre");
		lblDescripcion=new JLabel("Descripcion");
		lblCodigo=new JLabel("Código");
		lblConsola=new JLabel("Consola");
		lblTipo=new JLabel("Tipo");
		lblPrecio=new JLabel("Precio");
		
		
		txtNombre=new JTextField(a.getNombre());
		String s = Integer.toString(a.getPrecio());
		txtPrecio=new JTextField(s);
		txtDescripcion=new JTextField(a.getDescripción());
		txtCodigo=new JTextField(a.getCodigov());
		txtConsola=new JTextField(a.getConsola());
		
		txtCodigo.setEnabled(false);
		
		
	
		
		
		ps3=new JRadioButton("PS3");
		ps4=new JRadioButton("PS4");
		xbox360=new JRadioButton("XBOX-360");
		xboxone=new JRadioButton("XBOX-ONE");
		pc=new JRadioButton("PC");
		otro=new JRadioButton("Otra");
		
		
		final ButtonGroup group = new ButtonGroup();
        group.add(ps3);
        group.add(ps4);
        group.add(xbox360);
        group.add(xboxone);
        group.add(pc);
        group.add(otro);
        
        
        
        if(a.getConsola().equals("PS3"))
		{
        	ps3.setSelected(true);
		}
        if(a.getConsola().equals("PS4"))
		{
        	ps4.setSelected(true);
		}
        if(a.getConsola().equals("XBOX-360"))
		{
        	xbox360.setSelected(true);
		}
        if(a.getConsola().equals("XBOX-ONE"))
		{
        	xboxone.setSelected(true);
		}
        if(a.getConsola().equals("PC"))
		{
        	pc.setSelected(true);
		}
        if(a.getConsola().equals("Otra"))
		{
        	otro.setSelected(true);
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
	 * Método que añade los elementos inicializados al panel de tipo BoxLayout.
	 * @return void
	 * @param pane
	 */
	public void addComponentsToPane(Container pane)
	{
		
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		
		this.getContentPane().add(lblNombre);
		this.getContentPane().add(txtNombre);
		this.getContentPane().add(lblPrecio);
		this.getContentPane().add(txtPrecio);
		this.getContentPane().add(lblConsola);
		this.getContentPane().add(ps3);
		this.getContentPane().add(ps4);
		this.getContentPane().add(xbox360);
		this.getContentPane().add(xboxone);
		this.getContentPane().add(pc);
		this.getContentPane().add(otro);


		
		this.getContentPane().add(lblDescripcion);
		this.getContentPane().add(txtDescripcion);
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
			
			
			
			if(txtNombre.getText().length()>0&&txtPrecio.getText().length()>0&&txtDescripcion.getText().length()>0&&txtCodigo.getText().length()>0&&(ps3.isSelected()||ps4.isSelected()||xbox360.isSelected()||xboxone.isSelected()||pc.isSelected()||otro.isSelected())&&(tipo_venta.isSelected()||tipo_alqui.isSelected()))
			{
			

			if(tipo_venta.isSelected()&&ps3.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "PS3", txtDescripcion.getText(), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
			
			
			
			
			if(tipo_venta.isSelected()&&ps4.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "PS4", txtDescripcion.getText(), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
			
			
			
			
			
			
			if(tipo_venta.isSelected()&&xbox360.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "XBOX-360", txtDescripcion.getText(), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
			
			
			if(tipo_venta.isSelected()&&xboxone.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "XBOX-ONE", txtDescripcion.getText(), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
		
			
			if(tipo_venta.isSelected()&&pc.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "PC", txtDescripcion.getText(), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
			
			
			if(tipo_venta.isSelected()&&otro.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "Otra", txtDescripcion.getText(), txtCodigo.getText(), "Venta", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
			
			
			
			
			
			
			
			if(tipo_alqui.isSelected()&&ps3.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "PS3", txtDescripcion.getText(), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
			
			
			
			
			if(tipo_alqui.isSelected()&&ps4.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "PS4", txtDescripcion.getText(), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
			
			
			
			
			
			
			if(tipo_alqui.isSelected()&&xbox360.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "XBOX-360", txtDescripcion.getText(), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
			
			
			if(tipo_alqui.isSelected()&&xboxone.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "XBOX-ONE", txtDescripcion.getText(), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
		
			
			if(tipo_alqui.isSelected()&&pc.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "PC", txtDescripcion.getText(), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
			
			
			if(tipo_alqui.isSelected()&&otro.isSelected())
			{
			
			try
			{
				
				objGestor.CrearVideojuego(txtNombre.getText(), "Otra", txtDescripcion.getText(), txtCodigo.getText(), "Alquiler", Integer.parseInt(txtPrecio.getText()));
				this.dispose();
			}			
			catch(clsVideojuegoRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			catch (NumberFormatException e1) 
			{					
				JOptionPane.showMessageDialog(this, "Introduzca un número entero en y precio");
			}

			}
			
			
			
			
			
			
			try {
				frmModificarVideojuego.ActualizarTabla();
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
