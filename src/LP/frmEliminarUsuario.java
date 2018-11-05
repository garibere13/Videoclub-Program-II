package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import LN.clsGestor;
import LN.clsUsuario;









/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para eliminar los usuarios.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmEliminarUsuario extends JInternalFrame implements ActionListener 
{
	
	
	private static final long serialVersionUID = 1L;




	LinkedList<clsUsuario> usus;
	
	
	
	
	JTable TablaUsuarios;
	JScrollPane jsp;
	
	JButton btnAceptar;
	JButton btnCancelar;
	
	JLabel lblTexto;
	
	
	JPanel PanelUsuarios;
	
	
	
	
	
	JPanel PanelBotones;
	
	
	private final String ACEPTAR="ACEPTAR";
	private final String CANCELAR="CANCELAR";
	public final static int COL_USUARIOS_NICKNAME=4;
	public final static int ROW_NO_SELECTED=-1;
	
	
	
	
	
	
	
	
	
	/**
	 * Constructor de la clase
	 * Lee de fichero la lista de usuarios
	 * Llama al método CreateAndShowGUI()
	 * @param String title
	 */
	public frmEliminarUsuario(String title)
	{
		
		super(title);
		
		setTitle("Lista de usuarios introducidos");
		

		clsGestor objGestor= new clsGestor();
		usus=objGestor.ListaUsuarios();
		
		
		
		
		CreateAndShowGUI();
		

		
		
	}
	
	
	
	
	
	/**
	 * Método que llama al método de crearTablaUsuarios()
	 * Inicializa las JLabel, los JTextField, los JButton.
	 * Añade los elementos inicializados al panel de tipo BorderLayout y FlowLayout.
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		
		
		crearTablaUsuarios();
		
		jsp=new JScrollPane(TablaUsuarios);
	
		
		lblTexto=new JLabel("Seleccione el usuario del cual desee eliminar los datos");
		
		PanelUsuarios=new JPanel(new BorderLayout());
		
		PanelUsuarios.add(lblTexto,BorderLayout.NORTH);
		PanelUsuarios.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelUsuarios,BorderLayout.CENTER);
	
			
		
		//creación de los botones de la parte inferior de la pantalla.		
		PanelBotones =new JPanel(new FlowLayout());
		
		
		btnAceptar=new JButton("Aceptar");
		btnAceptar.setActionCommand(ACEPTAR);
		btnAceptar.addActionListener(this);

		btnCancelar=new JButton("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);

		
		PanelBotones.add(btnAceptar);
		PanelBotones.add(btnCancelar);
		
		this.getContentPane().add(PanelBotones,BorderLayout.PAGE_END);
			
		
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
		
		

		TablaUsuariosModel tcm=new TablaUsuariosModel(usus);
	
		TablaUsuarios = new JTable(tcm);
		TablaUsuarios.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaUsuarios.setFillsViewportHeight(true);
		TablaUsuarios.setEnabled(true);
		TablaUsuarios.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();
				
	}
	
	
	
	
	
	
	
	/**
	 * Método que llama al método EliminarUsuario() en caso de haber escogido un elemento de la tabla.
	 * Renueva el contenido de la tabla.
	 * @return void
	 */
	private void EliminarUsuario()
	{
		String id;
		int rowUsuarios;
		rowUsuarios=TablaUsuarios.getSelectedRow();
		if((rowUsuarios!=ROW_NO_SELECTED) )
		{
			id=(String)TablaUsuarios.getValueAt(rowUsuarios, COL_USUARIOS_NICKNAME);
			clsGestor objGestor=new clsGestor();
			objGestor.EliminarUsuario(id);
			usus=objGestor.ListaUsuarios();
			TablaUsuariosModel tcm=(TablaUsuariosModel)TablaUsuarios.getModel();
			tcm.setData(usus);
			tcm.fireTableDataChanged();
		}
	}
	
	
	
	
	
	/**
	 * Método para gestionar la escucha de eventos, la escucha de los botones en este caso.
	 * Obligatorio al implementar la interfaz ActionListener
	 * @return void
	 */
	public void actionPerformed(ActionEvent e)
	{
		
		
		String comando=e.getActionCommand();
		
		
		switch(comando)
		{

		case ACEPTAR:
			
			EliminarUsuario();
			this.repaint();
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
