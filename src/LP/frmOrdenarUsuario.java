package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import LN.clsGestor;
import LN.clsOrdenarAp1;
import LN.clsUsuario;


/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para ordenar los usuarios.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmOrdenarUsuario extends JInternalFrame implements ActionListener {

	
	
	private static final long serialVersionUID = 1L;

	LinkedList<clsUsuario> usus;

	JTable TablaUsuarios;
	JScrollPane jsp;
	
	
	
	JPanel PanelUsuarios;
	JPanel PanelBotones;
	
	JRadioButton RB_Ap1;
    JRadioButton RB_Nickname;
    JButton btnCambios;
	JButton btnCancelar;
	JLabel lblTexto;
	
	
	private final String CAMBIOS="CAMBIOS";
	private final String CANCELAR="CANCELAR";
    final String N = "Ordenar por primer apellido";
    final String D = "Ordenar por nickname";
	public final static int COL_ALUMNOS_ID=0;
	public final static int ROW_NO_SELECTED=-1;
	
	String id;
	
	
	
	
	/**
	 * Constructor de la clase
	 * Lee de fichero la lista de usuarios.
	 * Llama al método CreateAndShowGUI()
	 * @param title
	 */
	public frmOrdenarUsuario(String title)
	{
		super(title);
		
		setTitle("Lista de usuarios introducidos");
		
		clsGestor objGestor= new clsGestor();
		usus=objGestor.ListaUsuarios();
		
		CreateAndShowGUI();
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * Método que llama al método de crearTablaUsuarios()
	 * Inicializa las JLabel, los JTextField, los JButton y los JRadioButton.
	 * Añade los elementos inicializados al panel de tipo BorderLayout y FlowLayout.
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		
		
		crearTablaUsuarios();
		
		jsp=new JScrollPane(TablaUsuarios);
	
		
		lblTexto=new JLabel("Ordenados según su criterio");
		
		
		PanelUsuarios=new JPanel(new BorderLayout());
		
		PanelUsuarios.add(lblTexto,BorderLayout.NORTH);
		PanelUsuarios.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelUsuarios,BorderLayout.CENTER);
	
			
		
		//creación de los botones de la parte inferior de la pantalla.		
		PanelBotones =new JPanel(new FlowLayout());
		
		
		btnCambios=new JButton("Aplicar criterio");
		btnCambios.setActionCommand(CAMBIOS);
		btnCambios.addActionListener(this);

		btnCancelar=new JButton("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);
		
		
		RB_Ap1=new JRadioButton("Ordenar por primer apellido");
		RB_Ap1.setActionCommand(N);
		RB_Ap1.setSelected(true);
		
		RB_Nickname=new JRadioButton("Ordenar por nickname");
		RB_Nickname.setActionCommand(D);
		
		
		final ButtonGroup group = new ButtonGroup();
        group.add(RB_Ap1);
        group.add(RB_Nickname);
		
        
        
        
		PanelBotones.add(RB_Ap1);
		PanelBotones.add(RB_Nickname);  
		PanelBotones.add(btnCambios);
		PanelBotones.add(btnCancelar);
		

		
		this.getContentPane().add(PanelBotones,BorderLayout.PAGE_END);
		

		
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,250);
		this.setVisible(true);
		this.setResizable(true);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		
		

		
	}
	
	
	
	
	
	
	
	
	/**
	 * Método que crea la tabla de usuarios.
	 * @return void
	 */
	private void crearTablaUsuarios()
	{

		TablaUsuarios=null;
		
		

		TablaUsuariosModel tam=new TablaUsuariosModel(usus);
	
		TablaUsuarios = new JTable(tam);
		TablaUsuarios.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaUsuarios.setFillsViewportHeight(true);
		TablaUsuarios.setEnabled(true);
		TablaUsuarios.setRowSelectionAllowed(true);
		tam.fireTableDataChanged();
				
	}
	
	
	
	
	
	/**
	 * Método para gestionar la escucha de eventos, la escucha de los botones en esta caso.
	 * Obligatorio al implementar la interfaz ActionListener.
	 * El orden de la tabla variará dependiendo de qué JRadioButton se haya escogido.
	 * @return void
	 */
	public void actionPerformed(ActionEvent e)
	{
		
		
		String comando=e.getActionCommand();
		
		
		switch(comando)
		{

		case CAMBIOS:
			
			

				if (RB_Ap1.isSelected())
				{
					clsGestor objGestor=new clsGestor();
					
					usus=objGestor.ListaUsuarios();
					Collections.sort(usus, new clsOrdenarAp1());

					TablaUsuariosModel tam=(TablaUsuariosModel)TablaUsuarios.getModel();
					tam.setData(usus);
					tam.fireTableDataChanged();
					
				}
				
			
				

			
			
			
			
			else 
			{
				
				
				
				clsGestor objGestor=new clsGestor();

				usus=objGestor.ListaUsuarios();
				

	
				
				Collections.sort(usus);

				TablaUsuariosModel tam=(TablaUsuariosModel)TablaUsuarios.getModel();
				tam.setData(usus);
				tam.fireTableDataChanged();
			}

			
			break;
			
			
		case CANCELAR:
			this.dispose();
			break;
			
			
		}
		
		
		
	}
	

	
	
	
	
	
	
	
	
	
	

	/**
	 * 
	 *	Clase que se encarga de la creación de un JTable de usuarios.
	 */
	class TablaUsuariosModel extends AbstractTableModel
    {
        private String[] columnNames = {"Nombre","Apellido 1","Apellido 2","DNI", "Nickname", "Contraseña", "Fecha matriculación"};
        Object[][] data;
        
        public TablaUsuariosModel(LinkedList<clsUsuario> a)
        {
        	
        	super();
        	
    		int filas = a.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		//Nos recorremos el map para cargar la variable data[][]
    		for (clsUsuario aux : a)
    		{
    		    //System.out.println(entry.getKey() + "/" + entry.getValue());
    			Object[]n={new String(aux.getNombre()),	    					
    					   new String(aux.getApellido1()),	    			
    					   new String(aux.getApellido2()),
    					   new String(aux.getDNI()),
    					   new String(aux.getNickname()),
    					   new String(aux.getContraseña()),
    					   new String(aux.getFechamatricula())};
    			data[cont]=n;
    			cont++;
    		}
    		
        	
        }

        
        
        public void setData(LinkedList<clsUsuario> a) 
        {
        	int filas = a.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (clsUsuario aux : a)
    		{
    		    //System.out.println(entry.getKey() + "/" + entry.getValue());
    			Object[]n={new String(aux.getNombre()),	    					
    					   new String(aux.getApellido1()),	    			
    					   new String(aux.getApellido2()),
    					   new String(aux.getDNI()),
    					   new String(aux.getNickname()),
    					   new String(aux.getContraseña()),
    					   new String(aux.getFechamatricula())};
    			data[cont]=n;
    			cont++;
    		}
        }
        
        
        
        public int getColumnCount() 
        {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }
        
        
        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        
        
        
        
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        
        public boolean isCellEditable(int row, int col) {
            
            return false;
       
        }
        
        
        
        
        public void setValueAt(Object value, int row, int col) 
        {
            
            data[row][col] = value;
            fireTableCellUpdated(row, col);

        }


    }



	
	
	
	

	
	
	

}
