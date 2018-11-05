package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
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
import javax.swing.text.html.HTMLDocument.Iterator;

import LN.clsGestor;
import LN.clsPelicula;
import LN.clsVideojuego;
import LP.frmEliminarPelicula.TablaPeliculasModel;




/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para comprar un videojuego.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmComprarVideojuego extends JInternalFrame implements ActionListener
{
	
	
	
	
	private static final long serialVersionUID = 1L;




	CopyOnWriteArrayList<clsVideojuego> pelis;
	static CopyOnWriteArrayList<clsVideojuego> pelisalqui;
	
	
	static JTable TablaPeliculas;
	JScrollPane jsp;
	
	JButton btnComprar;
	JButton btnCancelar;
	
	JLabel lblTexto;
	
	
	JPanel PanelPeliculas;
	
	
	
	
	
	JPanel PanelBotones;
	
	
	private final String COMPRAR="COMPRAR";
	private final String CANCELAR="CANCELAR";
	public final static int COL_PELIS_COD=4;
	public final static int ROW_NO_SELECTED=-1;
	
	
	
	
	

	/**
	 * Constructor de la clase
	 * Lee de fichero la lista de videojuegos y elimina aquellos que sean para alquilar dejando los de tipo venta.
	 * Llama al método CreateAndShowGUI()
	 * @param title
	 */
	public frmComprarVideojuego(String title)
	{
		
		super(title);
		
		setTitle("Lista de videojuegos introducidos para ser comprados");
		
		
		clsGestor objGestor= new clsGestor();
		pelisalqui=objGestor.ListaVideojuegos();		
		
		
		
		
		for(clsVideojuego aux:pelisalqui)
			{
				if(aux.getTipo().equals("Alquiler"))
				{
					pelisalqui.remove(aux);
					
				}
				
				
			}
		

		CreateAndShowGUI();
		

		
		
	}
	
	
	
	
	/**
	 * Método que llama al método de crearTablaVideojuegos()
	 * Inicializa las JLabel, los JTextField, los JButton.
	 * Añade los elementos inicializados al panel de tipo BorderLayout y FlowLayout.
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		
		
		crearTablaVideojuegos();
		
		jsp=new JScrollPane(TablaPeliculas);
	
		
		lblTexto=new JLabel("Seleccione la película que desee comprar");
		
		PanelPeliculas=new JPanel(new BorderLayout());
		
		PanelPeliculas.add(lblTexto,BorderLayout.NORTH);
		PanelPeliculas.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelPeliculas,BorderLayout.CENTER);
	
			
		
		//creación de los botones de la parte inferior de la pantalla.		
		PanelBotones =new JPanel(new FlowLayout());
		
		
		btnComprar=new JButton("Comprar");
		btnComprar.setActionCommand(COMPRAR);
		btnComprar.addActionListener(this);

		btnCancelar=new JButton("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);

		
		PanelBotones.add(btnComprar);
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
		
		
		TablaPeliculas=null;
		
		

		TablaVideojuegosModel tcm=new TablaVideojuegosModel(pelisalqui);
	
		TablaPeliculas = new JTable(tcm);
		TablaPeliculas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaPeliculas.setFillsViewportHeight(true);
		TablaPeliculas.setEnabled(true);
		TablaPeliculas.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();
				
	}
	

	
	
	/**
	 * Método que llama al método EliminarVideojuego() en caso de haber escogido un elemento de la tabla.
	 * Crea también una compra de videojuego.
	 * Además, actualiza la tabla.
	 * @return void
	 */
	private void EliminarPelicula()
	{
		
		
		clsGestor objGestor=new clsGestor();
		
		
		
			
		String cod;
		String id;
		int rowPelis;
		rowPelis=TablaPeliculas.getSelectedRow();
		if((rowPelis!=ROW_NO_SELECTED) )
		{
			cod=(String)TablaPeliculas.getValueAt(rowPelis, COL_PELIS_COD);
			id=frmPaginaPrincipal.txtNickname.getText();
			objGestor.EliminarVideojuego(cod);
			objGestor.CrearCompraVideojuego(id, cod);
			pelisalqui=objGestor.ListaVideojuegos();
			
			for(clsVideojuego aux:pelisalqui)
			{
				if(aux.getTipo().equals("Alquiler"))
				{
					pelisalqui.remove(aux);
				}
				
				
			}


			TablaVideojuegosModel tcm=(TablaVideojuegosModel)TablaPeliculas.getModel();
			tcm.setData(pelisalqui);
			tcm.fireTableDataChanged();
			
		

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

		case COMPRAR:
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
	 *	Clase que se encarga de la creación de un JTable de videojuegos.
	 */
	class TablaVideojuegosModel extends AbstractTableModel
    {
        private String[] columnNames = {"Nombre", "Precio", "Consola","Descripcion","Código", "Tipo"};
        Object[][] data;
        
        public TablaVideojuegosModel(CopyOnWriteArrayList<clsVideojuego> a)
        {
        	
        	super();
        	
    		int filas = a.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		//Nos recorremos el map para cargar la variable data[][]
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

        
        
        public void setData(CopyOnWriteArrayList<clsVideojuego> a) 
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