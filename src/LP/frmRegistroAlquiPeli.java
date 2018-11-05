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
import LN.clsPeli_Alquilada;
import LN.clsPeli_Comprada;




/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para ver los registros de películas alquiladas.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmRegistroAlquiPeli extends JInternalFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;

	
	

	CopyOnWriteArrayList<clsPeli_Alquilada> alqui;
	
	
	
	
	JTable TablaAlqui;
	JScrollPane jsp;
	
	JButton btnAceptar;
	JButton btnCancelar;
	
	JLabel lblTexto;
	
	
	JPanel PanelAlqui;
	
	
	
	
	
	JPanel PanelBotones;
	
	
	private final String ACEPTAR="ACEPTAR";
	public final static int COL_ALUMNOS_ID=0;
	public final static int COL_ASIGS_COD=1;
	public final static int ROW_NO_SELECTED=-1;
	
	String cod;
	
	
	
	
	/**
	 * Constructor de la clase.
	 * Lee de fichero la lista de alquileres de películas.
	 * Llama al método CreateAndShowGUI()
	 * @param title
	 */
	public frmRegistroAlquiPeli(String title)
	{
		
		super(title);
		
		setTitle("Lista de alquileres de películas realizadas");
		

		clsGestor objGestor= new clsGestor();
		alqui=objGestor.ListaAlquileresPeli();
		
		
		CreateAndShowGUI();
	
	}
	
	
	
	/**
	 * Método que crea la tabla de alquileres de películas.
	 * @return void
	 */
	private void crearTablaAlquileres()
	{
		
		
		TablaAlqui=null;
		
		

		TablaAlquileresPelisModel tcm=new TablaAlquileresPelisModel(alqui);
	
		TablaAlqui = new JTable(tcm);
		TablaAlqui.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaAlqui.setFillsViewportHeight(true);
		TablaAlqui.setEnabled(true);
		TablaAlqui.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();
				
	}
	
	
	
	
	/**
	 * 
	 * Método que llama al método de crearTablaAlquileres()
	 * Inicializa las JLabel, los JTextField, los JButton.
	 * Añade los elementos inicializados al panel de tipo BorderLayout y FlowLayout.
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		
		
		crearTablaAlquileres();
		
		jsp=new JScrollPane(TablaAlqui);
	
		
		
		PanelAlqui=new JPanel(new BorderLayout());
		
		PanelAlqui.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelAlqui,BorderLayout.CENTER);
	
			
		
		//creación de los botones de la parte inferior de la pantalla.		
		PanelBotones =new JPanel(new FlowLayout());
		
		
		btnAceptar=new JButton("Atrás");
		btnAceptar.setActionCommand(ACEPTAR);
		btnAceptar.addActionListener(this);

		

		
		PanelBotones.add(btnAceptar);

		
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
	 * Método para gestionar la escucha de eventos, la escucha de los botones en esta caso.
	 * Obligatorio al implementar la interfaz ActionListener.
	 * @return void
	 */
	public void actionPerformed(ActionEvent e)
	{
		
		
		String comando=e.getActionCommand();
		
		
		switch(comando)
		{

	
		case ACEPTAR:
			this.dispose();
			break;	

		
		}
	
	}
	
	
	
	
	
	
	/**
	 * 
	 *	Clase que se encarga de la creación de un JTable de películas alquiladas.
	 */
	class TablaAlquileresPelisModel extends AbstractTableModel
    {
        private String[] columnNames = {"Nickname usuario", "Código película"};
        Object[][] data;
        
        public TablaAlquileresPelisModel(CopyOnWriteArrayList<clsPeli_Alquilada> alqui)
        {
        	
        	super();
        	
    		int filas = alqui.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		//Nos recorremos el map para cargar la variable data[][]
    		for (clsPeli_Alquilada aux : alqui)
    		{
    		    //System.out.println(entry.getKey() + "/" + entry.getValue());
    			
    			Object[]n={new String(aux.getNickname()),	    					
     					   new String(aux.getCod())};
     			data[cont]=n;
     			cont++;
    		}
    		
        	
        }

        
        
        public void setData(LinkedList<clsPeli_Alquilada> a) 
        {
        	int filas = a.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (clsPeli_Alquilada aux : a)
    		{
    			Object[]n={new String(aux.getNickname()),	    					
    					   new String(aux.getCod())};
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