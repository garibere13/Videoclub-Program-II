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
 * Formulario principal de la aplicaci�n con el objetivo de abrir la p�gina principal del administrador 
 * o la del usuario, dependiendo de con qu� nickname y contrase�a se entre.
 *
 */
public class frmPaginaPrincipal extends JFrame implements ActionListener 
{

	
	private static final long serialVersionUID = 1L;

	
	
	LinkedList<clsUsuario> usus=new LinkedList<clsUsuario>();
	
	
	JPanel contentPane;
	
	JLabel lblNickname;
	JLabel lblContrase�a;
	JLabel lblCodigosDeAdministrador;
	JLabel lblNicknameAdministrador;
	JLabel lblContrase�aAdmi;
	
	static JTextField txtNickname;
	JPasswordField txtContrase�a;
	
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
		
		lblContrase�a = new JLabel("Contrase�a");
		lblContrase�a.setBounds(66, 117, 70, 14);

		
		txtContrase�a = new JPasswordField();
		txtContrase�a.setEchoChar('*');
		txtContrase�a.setBounds(66, 142, 86, 20);
		txtContrase�a.setColumns(10);
		
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(296, 87, 89, 23);
		btnEntrar.addActionListener(this);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(296, 157, 89, 23);
		btnSalir.addActionListener(this);

		lblCodigosDeAdministrador = new JLabel("C�digos de administrador:");
		lblCodigosDeAdministrador.setBounds(29, 204, 159, 14);
		
		
		lblNicknameAdministrador = new JLabel("Nickname: administrador");
		lblNicknameAdministrador.setBounds(39, 218, 159, 14);
		
		
		lblContrase�aAdmi = new JLabel("Contrase�a: admi");
		lblContrase�aAdmi.setBounds(39, 229, 133, 14);
		
		
		
		
		nuevop.setLayout(new BorderLayout());
		nuevop.setBackground(Color.ORANGE);
		nuevop.repaint();

		

		
		this.setContentPane(nuevop);
		
	}
	
	
	
	/**
	 * 
	 * M�todo que llama al m�todo addComponentsToPane()
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
	 * M�todo que a�ade los elementos inicializados al panel de tipo null.
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
		this.getContentPane().add(lblContrase�a);
		this.getContentPane().add(txtNickname);
		this.getContentPane().add(txtContrase�a);
		this.getContentPane().add(btnEntrar);
		this.getContentPane().add(btnSalir);
		this.getContentPane().add(lblCodigosDeAdministrador);
		this.getContentPane().add(lblNicknameAdministrador);
		this.getContentPane().add(lblContrase�aAdmi);



		
	}


	
	
	
	
	
	
	
	/**
	 * M�todo para gestionar la escucha de eventos, la escucha de los botones en esta caso.
	 * Obligatorio al implementar la interfaz ActionListener.
	 * Lee la lista de los usuarios introducidos, y si no coinciden el nickname y la contrase�a, nos advierte de ello.
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
				
			if(txtNickname.getText().equals("administrador")&&txtContrase�a.getText().equals("admi"))
			{
				g++;
				frmPrincipalAdministrador frame = new frmPrincipalAdministrador("Men� de administrador");
	            frame.CreateAndShowGUI(); 
	            frame.setVisible(true);//necessary as of 1.3
	            frame.setSelected(true);
	            
	            
	            txtContrase�a.setText("");
	            
				
			}
			
			else
			{
				for(clsUsuario aux:usus)
				{
					if((txtNickname.getText().equals(aux.getNickname()))&&(txtContrase�a.getText().equals(aux.getContrase�a())))
					{
						g++;
						
						frmPrincipalUsuario frame = new frmPrincipalUsuario("Men� de usuario");
			            frame.createAndShowGUI(); 
			            frame.setVisible(true);//necessary as of 1.3
			            frame.setSelected(true);
			            
			            txtContrase�a.setText("");
					}
				}
				
				
				if(g==0)
				{
					JOptionPane.showMessageDialog(this, "Usuario o contrase�a incorrectos");
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