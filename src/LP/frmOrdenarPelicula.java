package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

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
import LN.clsOrdenarCategoria;
import LN.clsPelicula;
import LN.clsUsuario;




/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para ordenar las pel�culas.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmOrdenarPelicula extends JInternalFrame implements ActionListener
{
	
	

	private static final long serialVersionUID = 1L;

	static CopyOnWriteArrayList<clsPelicula> pelis;

	static JTable TablaPeliculas;
	JScrollPane jsp;
	
	
	
	JPanel PanelPeliculas;
	JPanel PanelBotones;
	
	JRadioButton RB_Titulo;
    JRadioButton RB_Categoria;
    JButton btnCambios;
	JButton btnCancelar;
	JLabel lblTexto;
	
	
	private final String CAMBIOS="CAMBIOS";
	private final String CANCELAR="CANCELAR";
    final String N = "Ordenar por t�tulo";
    final String D = "Ordenar por categor�a";
	public final static int COL_ALUMNOS_ID=0;
	public final static int ROW_NO_SELECTED=-1;
	
	String cod;
	
	
	
	
	
	
	/**
	 * Constructor de la clase
	 * Lee de fichero la lista de pel�culas.
	 * Llama al m�todo CreateAndShowGUI()
	 * @param title
	 */
	public frmOrdenarPelicula(String title)
	{
		super(title);
		
		setTitle("Lista de pel�culas introducidas");
		
		clsGestor objGestor= new clsGestor();
		pelis=objGestor.ListaPeliculas();
		
		CreateAndShowGUI();
	}
	
	
	
	
	
	

	/**
	 * 
	 * M�todo que llama al m�todo de crearTablaPeliculas()
	 * Inicializa las JLabel, los JTextField, los JButton y los JRadioButton.
	 * A�ade los elementos inicializados al panel de tipo BorderLayout y FlowLayout.
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		
		
		crearTablaPeliculas();
		
		jsp=new JScrollPane(TablaPeliculas);
	
		
		lblTexto=new JLabel("Ordenados seg�n su criterio");
		
		
		PanelPeliculas=new JPanel(new BorderLayout());
		
		PanelPeliculas.add(lblTexto,BorderLayout.NORTH);
		PanelPeliculas.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelPeliculas,BorderLayout.CENTER);
	
			
		
		//creaci�n de los botones de la parte inferior de la pantalla.		
		PanelBotones =new JPanel(new FlowLayout());
		
		
		btnCambios=new JButton("Aplicar criterio");
		btnCambios.setActionCommand(CAMBIOS);
		btnCambios.addActionListener(this);

		btnCancelar=new JButton("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);
		
		
		RB_Titulo=new JRadioButton("Ordenar por t�tulo");
		RB_Titulo.setActionCommand(N);
		RB_Titulo.setSelected(true);
		
		RB_Categoria=new JRadioButton("Ordenar por categor�a");
		RB_Categoria.setActionCommand(D);
		
		
		final ButtonGroup group = new ButtonGroup();
        group.add(RB_Titulo);
        group.add(RB_Categoria);
		
        
        
        
		PanelBotones.add(RB_Titulo);
		PanelBotones.add(RB_Categoria);  
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
	 * M�todo que crea la tabla de pel�culas.
	 * @return void
	 */
	private void crearTablaPeliculas()
	{

		TablaPeliculas=null;
		
		

		TablaPeliculasModel tpm=new TablaPeliculasModel(pelis);
	
		TablaPeliculas = new JTable(tpm);
		TablaPeliculas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaPeliculas.setFillsViewportHeight(true);
		TablaPeliculas.setEnabled(true);
		TablaPeliculas.setRowSelectionAllowed(true);
		tpm.fireTableDataChanged();
				
	}
	
	
	
	
	
	/**
	 * M�todo para gestionar la escucha de eventos, la escucha de los botones en esta caso.
	 * Obligatorio al implementar la interfaz ActionListener.
	 * El orden de la tabla variar� dependiendo de qu� JRadioButton se haya escogido.
	 * @return void
	 */
	public void actionPerformed(ActionEvent e)
	{
		
		
		String comando=e.getActionCommand();
		
		
		switch(comando)
		{

		case CAMBIOS:
			
			

				if (RB_Titulo.isSelected())
				{
					clsGestor objGestor=new clsGestor();
					
					pelis=objGestor.ListaPeliculas();
					Collections.sort(pelis);

					TablaPeliculasModel tam=(TablaPeliculasModel)TablaPeliculas.getModel();
					tam.setData(pelis);
					tam.fireTableDataChanged();
					
				}
		
			else 
			{
				
				
				
				clsGestor objGestor=new clsGestor();

				pelis=objGestor.ListaPeliculas();
				

	
				
				Collections.sort(pelis, new clsOrdenarCategoria());

				TablaPeliculasModel tam=(TablaPeliculasModel)TablaPeliculas.getModel();
				tam.setData(pelis);
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
		 *	Clase que se encarga de la creaci�n de un JTable de pel�culas
		 */
		class TablaPeliculasModel extends AbstractTableModel
	    {
	        private String[] columnNames = {"T�tulo", "Precio", "Categor�a","Duraci�n","C�digo", "Tipo"};
	        Object[][] data;
	        
	        public TablaPeliculasModel(CopyOnWriteArrayList<clsPelicula> pelis)
	        {
	        	
	        	super();
	        	
	    		int filas = pelis.size();
	    		int cont;
	    		data=new Object[filas][];
	    		cont=0;
	    		
	    		
	    		//Nos recorremos el map para cargar la variable data[][]
	    		for (clsPelicula aux : pelis)
	    		{
	    		    //System.out.println(entry.getKey() + "/" + entry.getValue());
	    			Object[]n={new String(aux.getNombre()),
	    					   new Integer(aux.getPrecio()),	
	    					   new String(aux.getCategor�a()),	    			
	    					   new Integer(aux.getDuraci�n()),
	    					   new String(aux.getCodigop()),
	    					   new String(aux.getTipo())};
	    			data[cont]=n;
	    			cont++;
	    		}
	    		
	        	
	        }

	        
	        
	        public void setData(CopyOnWriteArrayList<clsPelicula> pelis) 
	        {
	        	int filas = pelis.size();
	    		int cont;
	    		data=new Object[filas][];
	    		cont=0;
	    		
	    		
	    		
	    		for (clsPelicula aux : pelis)
	    		{
	    		    //System.out.println(entry.getKey() + "/" + entry.getValue());
	    			Object[]n={new String(aux.getNombre()),
	    					   new Integer(aux.getPrecio()),	
	    					   new String(aux.getCategor�a()),	    			
	    					   new Integer(aux.getDuraci�n()),
	    					   new String(aux.getCodigop()),
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
