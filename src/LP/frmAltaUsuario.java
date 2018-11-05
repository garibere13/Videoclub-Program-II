package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LN.clsGestor;
import LN.clsUsuario;
import LN.clsUsuarioRepetido;






/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para dar de alta a los usuarios.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmAltaUsuario extends JInternalFrame implements ActionListener{

	
	
	
	

	JLabel lblNombre;
	JLabel lblap1;
	JLabel lblap2;
	JLabel lblDNI;
	JLabel lblNickname;
	JLabel lblContraseña;
	JLabel lblCod_socio;
	JLabel lblFecha;
	
	JTextField txtNombre;
	JTextField txtap1;
	JTextField txtap2;
	JTextField txtDNI;
	JTextField txtNickname;
	JTextField txtContraseña;
	JTextField txtCod_socio;
	
	JButton btnFecha;
	
	JButton btnAceptar;
	JButton btnCancelar;
	
	Container pane;

	
	private final String ACEPTAR="ACEPTAR";
	private final String CANCELAR="CANCELAR";
	private final String FECHA="FECHA";
	
	
	int indice;
	
	static final int desktopWidth = 500;
	static final int desktopHeight = 300;

	JDesktopPane nuevop;
	JPanel jpContent;
	
	
	
	
	
	/**
	 * Constructor de la clase
	 * Inicializa las JLabel, los JTextField, los JButton
	 * @param String title
	 */
	public frmAltaUsuario(String title)
	{
		
		super(title);
		
		
		
		setBounds(100, 100, 450, 350);
		
		
		lblNombre=new JLabel("Nombre");
		lblap1=new JLabel("Apellido 1");
		lblap2=new JLabel("Apellido 2");
		lblDNI=new JLabel("DNI");
		lblNickname=new JLabel("Nickname");
		lblContraseña=new JLabel("Contraseña");
		lblFecha=new JLabel("Fecha de matriculación");
		
		
		txtNombre=new JTextField("");
		txtap1=new JTextField("");
		txtap2=new JTextField("");
		txtDNI=new JTextField("");
		txtNickname=new JTextField("");
		txtContraseña=new JTextField("");
				
		
		btnFecha=new JButton("Seleccione la fecha de alta");
		btnFecha.addActionListener(this);
		btnFecha.setActionCommand(FECHA);
		
		
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
	 * @param clsUsuario a
	 */
	public frmAltaUsuario(String title, clsUsuario a)
	{
		
		super(title);
		
		
		
		setBounds(100, 100, 450, 350);
		
		
		lblNombre=new JLabel("Nombre");
		lblap1=new JLabel("Apellido 1");
		lblap2=new JLabel("Apellido 2");
		lblDNI=new JLabel("DNI");
		lblNickname=new JLabel("Nickname");
		lblContraseña=new JLabel("Contraseña");
		lblFecha=new JLabel("Fecha de matriculación");
		
		
		txtNombre=new JTextField(a.getNombre());
		txtap1=new JTextField(a.getApellido1());
		txtap2=new JTextField(a.getApellido2());
		txtDNI=new JTextField(a.getDNI());
		txtNickname=new JTextField(a.getNickname());
		txtContraseña=new JTextField(a.getContraseña());
		
		
		txtNickname.setEnabled(false);
				
		
		btnFecha=new JButton("Seleccione la fecha de matriculación");
		btnFecha.addActionListener(this);
		btnFecha.setActionCommand(FECHA);
		
		
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
	 * @param Container pane
	 */
	public void addComponentsToPane(Container pane)
	{
		
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		
		this.getContentPane().add(lblNombre);
		this.getContentPane().add(txtNombre);
		this.getContentPane().add(lblap1);
		this.getContentPane().add(txtap1);
		this.getContentPane().add(lblap2);
		this.getContentPane().add(txtap2);
		this.getContentPane().add(lblDNI);
		this.getContentPane().add(txtDNI);
		this.getContentPane().add(lblNickname);
		this.getContentPane().add(txtNickname);
		this.getContentPane().add(lblContraseña);
		this.getContentPane().add(txtContraseña);
		this.getContentPane().add(lblFecha);
		this.getContentPane().add(btnFecha);
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
		
		
		case FECHA:
			frmFechas.Empezar();
		break;

		
		case ACEPTAR:
			
			
			if(txtNombre.getText().length()>0&&txtap1.getText().length()>0&&txtap2.getText().length()>0&&txtDNI.getText().length()>0&&txtNickname.getText().length()>0&&txtContraseña.getText().length()>0)
			{
			
				
				
				if((txtDNI.getText()).length()!=9)
				{
					JOptionPane.showMessageDialog(this, "El DNI ha de contener 9 caracteres");
				}
				
			else
			{
				
				
			
				
			if(txtNickname.getText().equals("administrador"))
			{
				JOptionPane.showMessageDialog(this, "Un usuario no puede tener nickname '"+txtNickname.getText()+"'");

			}
			else
			{
			
			try
			{
				
				objGestor.CrearUsuario(txtNombre.getText(), txtap1.getText(), txtap2.getText(), txtDNI.getText(), txtNickname.getText(), txtContraseña.getText(), frmFechas.getFec());
				this.dispose();
			}			
			catch(clsUsuarioRepetido p)
			{	
				JOptionPane.showMessageDialog(this, p.getMessage());
			}
			try {
				frmModificarUsuario.ActualizarTabla();
			} catch (NullPointerException e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace();
			}
			
			}
			}
			}
			
			
			else
			{
				JOptionPane.showMessageDialog(this, "Introduzca todos los datos");
				break;
			}
			break;
		
		
		case CANCELAR:
				this.dispose();
		break;	
		
		
		
		}
		
		
		
		
		
	}
	
	
	
	
}
