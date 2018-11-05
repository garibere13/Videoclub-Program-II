package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import LN.clsGestor;
import LN.clsPelicula;
import LN.clsUsuario;
import LN.clsVideojuego;
import LP.frmEliminarUsuario.TablaUsuariosModel;
import LP.frmModificarVideojuego.TablaVideojuegosModel;





/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para eliminar las videojuegos.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmEliminarVideojuego extends JInternalFrame implements ActionListener
{
	
	
	
	
	private static final long serialVersionUID = 1L;




	static CopyOnWriteArrayList<clsVideojuego> pelis;
	
	
	
	
	static JTable TablaVideojuegos;
	JScrollPane jsp;
	
	JButton btnAceptar;
	JButton btnCancelar;
	
	JLabel lblTexto;
	
	
	JPanel PanelVideojuegos;
	
	
	
	
	
	JPanel PanelBotones;
	
	
	private final String ACEPTAR="ACEPTAR";
	private final String CANCELAR="CANCELAR";
	public final static int COL_PELIS_COD=4;
	public final static int ROW_NO_SELECTED=-1;
	
	
	
	
	

	/**
	 * Constructor de la clase
	 * Lee de fichero la lista de videojuegos.
	 * Llama al método CreateAndShowGUI()
	 * @param String title
	 */
	public frmEliminarVideojuego(String title)
	{
		
		super(title);
		
		setTitle("Lista de videojuegos introducidos");
		

		clsGestor objGestor= new clsGestor();
		pelis=objGestor.ListaVideojuegos();
		
		
		
		
		CreateAndShowGUI();
		

		
		
	}
	
	
	
	
	/**
	 * 
	 * Método que llama al método de crearTablaVideojuegos()
	 * Inicializa las JLabel, los JTextField, los JButton.
	 * Añade los elementos inicializados al panel de tipo BorderLayout y FlowLayout.
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		
		
		crearTablaVideojuegos();
		
		jsp=new JScrollPane(TablaVideojuegos);
	
		
		lblTexto=new JLabel("Seleccione el videojuego del cual desee eliminar los datos");
		
		PanelVideojuegos=new JPanel(new BorderLayout());
		
		PanelVideojuegos.add(lblTexto,BorderLayout.NORTH);
		PanelVideojuegos.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelVideojuegos,BorderLayout.CENTER);
	
			
		
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
	 * Método que crea la tabla de videojuegos.
	 * @return void
	 */
	private void crearTablaVideojuegos()
	{
		
		
		TablaVideojuegos=null;
		
		

		TablaEliminarVideojuegosModel tcm=new TablaEliminarVideojuegosModel(pelis);
	
		TablaVideojuegos = new JTable(tcm);
		TablaVideojuegos.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaVideojuegos.setFillsViewportHeight(true);
		TablaVideojuegos.setEnabled(true);
		TablaVideojuegos.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();
				
	}
	
	
	
	
	/**
	 * Método que llama al método EliminarVideojuego() en caso de haber escogido un elemento de la tabla.
	 * Renueva el contenido de la tabla.
	 * @return void
	 */
	private void EliminarPelicula()
	{
		String cod;
		int rowPelis;
		rowPelis=TablaVideojuegos.getSelectedRow();
		if((rowPelis!=ROW_NO_SELECTED) )
		{
			cod=(String)TablaVideojuegos.getValueAt(rowPelis, COL_PELIS_COD);
			clsGestor objGestor=new clsGestor();
			objGestor.EliminarVideojuego(cod);
			pelis=objGestor.ListaVideojuegos();
			TablaVideojuegosModel tcm=(TablaVideojuegosModel)TablaVideojuegos.getModel();
			tcm.setData(pelis);
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
			
			EliminarPelicula();
			this.repaint();
			break;


		case CANCELAR:
				this.dispose();
				break;	

			
		}
		
	}
	
	
	
	

	/**
	 * 
	 *	Clase que se encarga de la creación de un JTable de videojuegos
	 */
	class TablaEliminarVideojuegosModel extends AbstractTableModel
    {
        private String[] columnNames = {"Nombre", "Precio", "Consola","Descripcion","Código", "Tipo"};
        Object[][] data;
        
        public TablaEliminarVideojuegosModel(CopyOnWriteArrayList<clsVideojuego> pelis)
        {
        	
        	super();
        	
    		int filas = pelis.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		//Nos recorremos el map para cargar la variable data[][]
    		for (clsVideojuego aux : pelis)
    		{
    		    //System.out.println(entry.getKey() + "/" + entry.getValue());
    			Object[]n={new String(aux.getNombre()),	
    					   new Integer(aux.getPrecio()),	
    					   new String(aux.getConsola()),	    			
    					   new String(aux.getDescripción()),
    					   new String(aux.getCodigov()),
    					   new String(aux.getTipo())};
    			data[cont]=n;
    			cont++;
    		}
    		
        	
        }

        
        
        public void setData(LinkedList<clsVideojuego> a) 
        {
        	int filas = a.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (clsVideojuego aux : a)
    		{
    		    //System.out.println(entry.getKey() + "/" + entry.getValue());
    			Object[]n={new String(aux.getNombre()),	
    					   new Integer(aux.getPrecio()),	
    					   new String(aux.getConsola()),	    			
    					   new String(aux.getDescripción()),
    					   new String(aux.getCodigov()),
    					   new String(aux.getTipo())};
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
