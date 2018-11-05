package LP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import LN.clsGestor;
import LN.clsUsuario;

/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario principal de la aplicación con el objetivo de abrir la página principal del administrador 
 * o la del usuario, dependiendo de con qué nickname y contraseña se entre.
 *
 */
public class frmPaginaPrincipal extends JFrame implements ActionListener 
{

	
	private static final long serialVersionUID = 1L;

	
	
	LinkedList<clsUsuario> usus=new LinkedList<clsUsuario>();
	
	
	JPanel contentPane;
	
	JLabel lblNickname;
	JLabel lblContraseña;
	JLabel lblCodigosDeAdministrador;
	JLabel lblNicknameAdministrador;
	JLabel lblContraseñaAdmi;
	
	static JTextField txtNickname;
	JPasswordField txtContraseña;
	
	JButton btnEntrar;
	JButton btnSalir;
	
	
	JDesktopPane nuevop;
	
	
	 JLabel fondo;
	
	 static final int desktopWidth = 720;
	 static final int desktopHeight = 415;
	
	
	private final String ENTRAR="ENTRAR";
	private final String SALIR="SALIR";

	/**
	 * Constructor de la clase
	 * @param String title
	 */
	public frmPaginaPrincipal(String title)
	{
		super(title);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		nuevop=new JDesktopPane();
		
		
		
		lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(66, 29, 70, 14);

		
		txtNickname = new JTextField();
		txtNickname.setBounds(66, 55, 86, 20);
		txtNickname.setColumns(10);
		
		lblContraseña = new JLabel("Contraseña");
		lblContraseña.setBounds(66, 117, 70, 14);

		
		txtContraseña = new JPasswordField();
		txtContraseña.setEchoChar('*');
		txtContraseña.setBounds(66, 142, 86, 20);
		txtContraseña.setColumns(10);
		
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(296, 87, 89, 23);
		btnEntrar.addActionListener(this);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(296, 157, 89, 23);
		btnSalir.addActionListener(this);

		lblCodigosDeAdministrador = new JLabel("Códigos de administrador:");
		lblCodigosDeAdministrador.setBounds(29, 204, 159, 14);
		
		
		lblNicknameAdministrador = new JLabel("Nickname: administrador");
		lblNicknameAdministrador.setBounds(39, 218, 159, 14);
		
		
		lblContraseñaAdmi = new JLabel("Contraseña: admi");
		lblContraseñaAdmi.setBounds(39, 229, 133, 14);
		
		
		
		
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
	public void createAndShowGUI()
	{
		
		
		 	
		
		addComponentsToPane(this.getContentPane());

		this.setVisible(true);
		this.setResizable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		this.setClosable(true);
	}


	
	
	/**
	 * Método que añade los elementos inicializados al panel de tipo null.
	 * @return void
	 * @param Container pane
	 */
	public void addComponentsToPane(Container pane)
	{
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		

		this.getContentPane().add(lblNickname);
		this.getContentPane().add(lblContraseña);
		this.getContentPane().add(txtNickname);
		this.getContentPane().add(txtContraseña);
		this.getContentPane().add(btnEntrar);
		this.getContentPane().add(btnSalir);
		this.getContentPane().add(lblCodigosDeAdministrador);
		this.getContentPane().add(lblNicknameAdministrador);
		this.getContentPane().add(lblContraseñaAdmi);



		
	}


	
	
	
	
	
	
	
	/**
	 * Método para gestionar la escucha de eventos, la escucha de los botones en esta caso.
	 * Obligatorio al implementar la interfaz ActionListener.
	 * Lee la lista de los usuarios introducidos, y si no coinciden el nickname y la contraseña, nos advierte de ello.
	 * @return void
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
		clsGestor objGestor=new clsGestor();
		usus=objGestor.ListaUsuarios();
		
		String comando=e.getActionCommand();
		int g=0;
		
		switch(comando)
		{
		
		
		case ENTRAR:
				
			if(txtNickname.getText().equals("administrador")&&txtContraseña.getText().equals("admi"))
			{
				g++;
				frmPrincipalAdministrador frame = new frmPrincipalAdministrador("Menú de administrador");
	            frame.CreateAndShowGUI(); 
	            frame.setVisible(true);//necessary as of 1.3
	            frame.setSelected(true);
	            
	            
	            txtContraseña.setText("");
	            
				
			}
			
			else
			{
				for(clsUsuario aux:usus)
				{
					if((txtNickname.getText().equals(aux.getNickname()))&&(txtContraseña.getText().equals(aux.getContraseña())))
					{
						g++;
						
						frmPrincipalUsuario frame = new frmPrincipalUsuario("Menú de usuario");
			            frame.createAndShowGUI(); 
			            frame.setVisible(true);//necessary as of 1.3
			            frame.setSelected(true);
			            
			            txtContraseña.setText("");
					}
				}
				
				
				if(g==0)
				{
					JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
				}

				
				
				
			}
			
			break;

		
		
		
		
		case SALIR:
				this.dispose();
		break;	
		
		
		
		}
		
		
		
		
		
	}
	
	
	
	private void setMaximizable(boolean b) {
		// TODO Auto-generated method stub
		
	}




	private void setClosable(boolean b) {
		// TODO Auto-generated method stub
		
	}




	private void setIconifiable(boolean b) {
		// TODO Auto-generated method stub
		
	}
}