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
import LP.frmModificarPelicula.TablaPeliculasModel;





/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para alquilar una película.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmAlquilarPeli extends JInternalFrame implements ActionListener
{
	
	
	
	
	private static final long serialVersionUID = 1L;




	CopyOnWriteArrayList<clsPelicula> pelis;
	
	
	static JTable TablaPeliculas;
	JScrollPane jsp;
	
	JButton btnAlquilar;
	JButton btnCancelar;
	
	JLabel lblTexto;
	
	
	JPanel PanelPeliculas;
	
	
	
	
	
	JPanel PanelBotones;
	
	
	private final String ALQUILAR="ALQUILAR";
	private final String CANCELAR="CANCELAR";
	public final static int COL_PELIS_COD=4;
	public final static int ROW_NO_SELECTED=-1;
	
	
	
	
	

	/**
	 * Constructor de la clase.
	 * Llama al método CreateAndShowGUI()
	 * @param title
	 */
	public frmAlquilarPeli(String title)
	{
		
		super(title);
		
		setTitle("Lista de peliculas introducidas para ser alquiladas");
		


		CreateAndShowGUI();
		

		
		
	}
	
	
	
	
	/**
	 * 
	 * Método que llama al método de crearTablaPeliculas().
	 * Inicializa las JLabel, los JTextField, los JButton.
	 * Añade los elementos inicializados al panel de tipo BorderLayout y FlowLayout.
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		
		
		crearTablaPeliculas();
		
		jsp=new JScrollPane(TablaPeliculas);
	
		
		lblTexto=new JLabel("Seleccione la película que desee alquilar");
		
		PanelPeliculas=new JPanel(new BorderLayout());
		
		PanelPeliculas.add(lblTexto,BorderLayout.NORTH);
		PanelPeliculas.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelPeliculas,BorderLayout.CENTER);
	
			
		
		//creación de los botones de la parte inferior de la pantalla.		
		PanelBotones =new JPanel(new FlowLayout());
		
		
		btnAlquilar=new JButton("Alquilar");
		btnAlquilar.setActionCommand(ALQUILAR);
		btnAlquilar.addActionListener(this);

		btnCancelar=new JButton("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);

		
		PanelBotones.add(btnAlquilar);
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
	 * En la tabla solo aparecerán las películas que sean para alquilar y que estén libres(condición true).
	 * @return void
	 */
	private void crearTablaPeliculas()
	{
		
		clsGestor objGestor=new clsGestor();
		TablaPeliculas=null;
		
		pelis=objGestor.ListaPeliculas();

		
		for(clsPelicula aux:pelis)
		{
			if(aux.getTipo().equals("Venta"))
			{
					pelis.remove(aux);
			}
			if((aux.getTipo().equals("Alquiler"))&&(aux.isCondicion() == false))
			{
				pelis.remove(aux);
			}
			
		}

		TablaPeliculasModel tcm=new TablaPeliculasModel(pelis);
	
		TablaPeliculas = new JTable(tcm);
		TablaPeliculas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaPeliculas.setFillsViewportHeight(true);
		TablaPeliculas.setEnabled(true);
		TablaPeliculas.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();
				
	}
	
	

	

	
	

	
	
	
	
	
	/**
	 * Método que crea un nuevo alquiler de película en caso de haber escogido un elemento de la tabla.
	 * El elemento escogido pasará a tener condición false y no aparecerá más en la tabla de alquileres de películas hasta que sea devuelta.
	 * @return void
	 */
	private void BorrarListaAlquiler()
	{


		clsGestor objGestor=new clsGestor();

		
		String cod;
		String id;
		int rowPelis;
		rowPelis=TablaPeliculas.getSelectedRow();
		if((rowPelis!=ROW_NO_SELECTED) )
		{
			
			pelis=objGestor.ListaPeliculas();
			cod=(String)TablaPeliculas.getValueAt(rowPelis, COL_PELIS_COD);
			id=frmPaginaPrincipal.txtNickname.getText();
			objGestor.CrearAlquilerPeli(id, cod);
		
			
			
			for(clsPelicula aux: pelis)
			{
				if(aux.getCodigop().equals(cod))
				{
					aux.setCondicion(false);
					objGestor.GuardarPelis(pelis);

				}
				
			}

			
			pelis=new CopyOnWriteArrayList<clsPelicula>();
			pelis=objGestor.ListaPeliculas();
			
			
			for(clsPelicula aux:pelis)
			{
				if(aux.getTipo().equals("Venta") || (aux.getTipo().equals("Alquiler") && aux.isCondicion() == false))
				{
					pelis.remove(aux);
				}
				
			}
			
			
			TablaPeliculasModel tam=(TablaPeliculasModel)TablaPeliculas.getModel();
			tam.setData(pelis);
			tam.fireTableDataChanged();
			
			

		}

	}
	
	
	
	
	


	/**
	 * Método para gestionar la escucha de eventos, la escucha de los botones en esta caso.
	 * Obligatorio al implementar la interfaz ActionListener
	 * @return void
	 */
	public void actionPerformed(ActionEvent e)
	{
		
		
		String comando=e.getActionCommand();
		
		
		switch(comando)
		{

		case ALQUILAR:
			
			BorrarListaAlquiler();
			
			this.repaint();
			break;
			

			
			
			
			

		case CANCELAR:
				this.dispose();
				break;	

			
		}
		
	}
	
	
	
	
	
	/**
	 * 
	 *	Clase que se encarga de la creación de un JTable de películas.
	 */
	class TablaPeliculasModel extends AbstractTableModel
    {
        private String[] columnNames = {"Título", "Precio", "Categoría", "Duración", "Código", "Tipo"};
        Object[][] data;
        
        public TablaPeliculasModel(CopyOnWriteArrayList<clsPelicula> pelis)
        {
        	
        	super();
        	
    		int filas = pelis.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		for (clsPelicula aux : pelis)
    		{
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
