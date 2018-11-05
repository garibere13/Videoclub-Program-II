package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
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





/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para modificar las películas.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmModificarPelicula extends JInternalFrame implements ActionListener
{
	
	
	
	
	private static final long serialVersionUID = 1L;




	static CopyOnWriteArrayList<clsPelicula> pelis;
	
	
	
	
	static JTable TablaPeliculas;
	JScrollPane jsp;
	
	JButton btnAceptar;
	JButton btnCancelar;
	
	JLabel lblTexto;
	
	
	JPanel PanelPeliculas;
	
	
	
	
	
	JPanel PanelBotones;
	
	
	private final String ACEPTAR="ACEPTAR";
	private final String CANCELAR="CANCELAR";
	public final static int COL_PELIS_COD=4;
	public final static int ROW_NO_SELECTED=-1;
	
	
	
	
	

	/**
	 * Constructor de la clase.
	 * Lee de fichero la lista de alumnos.
	 * Llama al método CreateAndShowGUI()
	 * @param String title
	 */
	public frmModificarPelicula(String title)
	{
		
		super(title);
		
		setTitle("Lista de peliculas introducidas");
		

		clsGestor objGestor= new clsGestor();
		pelis=objGestor.ListaPeliculas();
		
		
		
		
		CreateAndShowGUI();
		

		
		
	}
	
	
	
	
	/**
	 * 
	 * Método que llama al método de crearTablaPeliculas()
	 * Inicializa las JLabel, los JTextField, los JButton.
	 * Añade los elementos inicializados al panel de tipo BorderLayout y FlowLayout.
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		
		
		crearTablaPeliculas();
		
		jsp=new JScrollPane(TablaPeliculas);
	
		
		lblTexto=new JLabel("Seleccione la película de la cual desee modificar los datos");
		
		PanelPeliculas=new JPanel(new BorderLayout());
		
		PanelPeliculas.add(lblTexto,BorderLayout.NORTH);
		PanelPeliculas.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelPeliculas,BorderLayout.CENTER);
	
			
		
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
	 * Método que crea la tabla de películas.
	 * @return void
	 */
	private void crearTablaPeliculas()
	{
		
		
		TablaPeliculas=null;
		
		

		TablaPeliculasModel tcm=new TablaPeliculasModel(pelis);
	
		TablaPeliculas = new JTable(tcm);
		TablaPeliculas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaPeliculas.setFillsViewportHeight(true);
		TablaPeliculas.setEnabled(true);
		TablaPeliculas.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();
				
	}
	
	
	
	
	/**
	 * Método que se encarga de actualizar la JTable
	 * @return void
	 */
	public static void ActualizarTabla()
	{
		
		clsGestor objGestor=new clsGestor();
		
		pelis=objGestor.ListaPeliculas();
		
		TablaPeliculasModel tam=(TablaPeliculasModel)TablaPeliculas.getModel();
		tam.setData(pelis);
		tam.fireTableDataChanged();
	}
	
	
	
	
	

	/**
	 * Método para gestionar la escucha de eventos, la escucha de los botones en esta caso.
	 * Obligatorio al implementar la interfaz ActionListener.
	 * En caso de pulsar aceptar, borra de fichero ese objeto y abre la ventana de nueva película.
	 * @return void
	 */
	public void actionPerformed(ActionEvent e)
	{
		
		
		String comando=e.getActionCommand();
		
		
		switch(comando)
		{

		case ACEPTAR:
			

			String cod;
			int rowPelis;
			rowPelis=TablaPeliculas.getSelectedRow();
			clsPelicula peli=new clsPelicula(); 
			
			if((rowPelis!=ROW_NO_SELECTED) )
			{
				
				cod=(String)TablaPeliculas.getValueAt(rowPelis, COL_PELIS_COD);
				clsGestor objGestor=new clsGestor();
				peli=objGestor.BuscarPelicula(cod);
				objGestor.EliminarPeli(cod);
				
				frmAltaPelicula frame = new frmAltaPelicula("Alta Pelicula", peli);
	            frame.CreateAndShowGUI(); 
	            frame.setVisible(true);
	          

	            
	            getParent().add(frame); 
	            
	            try {
					this.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
	            
			}
     

			
			break;
			
			
			

		case CANCELAR:
				this.dispose();
				break;	

			
		}
		
	}
	
	
	
	
	
	/**
	 * 
	 *	Clase que se encarga de la creación de un JTable de películas
	 */
	class TablaPeliculasModel extends AbstractTableModel
    {
        private String[] columnNames = {"Título", "Precio", "Categoría","Duración","Código", "Tipo"};
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
    					   new String(aux.getCategoría()),	    			
    					   new Integer(aux.getDuración()),
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
    					   new String(aux.getCategoría()),	    			
    					   new Integer(aux.getDuración()),
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
