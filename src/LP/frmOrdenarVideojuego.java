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
import LN.clsOrdenarConsola;
import LN.clsPelicula;
import LN.clsUsuario;
import LN.clsVideojuego;




/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para ordenar los videojuegos.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmOrdenarVideojuego extends JInternalFrame implements ActionListener
{
	
	

	private static final long serialVersionUID = 1L;

	CopyOnWriteArrayList<clsVideojuego> pelis;

	JTable TablaVideojuegos;
	JScrollPane jsp;
	
	
	
	JPanel PanelVideojuegos;
	JPanel PanelBotones;
	
	JRadioButton RB_Titulo;
    JRadioButton RB_Consola;
    JButton btnCambios;
	JButton btnCancelar;
	JLabel lblTexto;
	
	
	private final String CAMBIOS="CAMBIOS";
	private final String CANCELAR="CANCELAR";
    final String N = "Ordenar por título";
    final String D = "Ordenar por consola";
	public final static int COL_ALUMNOS_ID=0;
	public final static int ROW_NO_SELECTED=-1;
	
	String cod;
	
	
	
	
	
	
	/**
	 * Constructor de la clase
	 * Lee de fichero la lista de videojuegos.
	 * Llama al método CreateAndShowGUI()
	 * @param title
	 */
	public frmOrdenarVideojuego(String title)
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
	 * Inicializa las JLabel, los JTextField, los JButton y los JRadioButton.
	 * Añade los elementos inicializados al panel de tipo BorderLayout y FlowLayout.
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		
		
		crearTablaVideojuegos();
		
		jsp=new JScrollPane(TablaVideojuegos);
	
		
		lblTexto=new JLabel("Ordenados según su criterio");
		
		
		PanelVideojuegos=new JPanel(new BorderLayout());
		
		PanelVideojuegos.add(lblTexto,BorderLayout.NORTH);
		PanelVideojuegos.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelVideojuegos,BorderLayout.CENTER);
	
			
		
		//creación de los botones de la parte inferior de la pantalla.		
		PanelBotones =new JPanel(new FlowLayout());
		
		
		btnCambios=new JButton("Aplicar criterio");
		btnCambios.setActionCommand(CAMBIOS);
		btnCambios.addActionListener(this);

		btnCancelar=new JButton("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);
		
		
		RB_Titulo=new JRadioButton("Ordenar por título");
		RB_Titulo.setActionCommand(N);
		RB_Titulo.setSelected(true);
		
		RB_Consola=new JRadioButton("Ordenar por consola");
		RB_Consola.setActionCommand(D);
		
		
		final ButtonGroup group = new ButtonGroup();
        group.add(RB_Titulo);
        group.add(RB_Consola);
		
        
        
        
		PanelBotones.add(RB_Titulo);
		PanelBotones.add(RB_Consola);  
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
	 * Método que crea la tabla de videojuegos.
	 * @return void
	 */
	private void crearTablaVideojuegos()
	{

		TablaVideojuegos=null;
		
		

		TablaOrdenarVideojuegosModel tpm=new TablaOrdenarVideojuegosModel(pelis);
	
		TablaVideojuegos = new JTable(tpm);
		TablaVideojuegos.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaVideojuegos.setFillsViewportHeight(true);
		TablaVideojuegos.setEnabled(true);
		TablaVideojuegos.setRowSelectionAllowed(true);
		tpm.fireTableDataChanged();
				
	}
	
	
	
	
	
	/**
	 * Método para gestionar la escucha de eventos, la escucha de los botones en esta caso.
	 * Obligatorio al imlementar la interfaz ActionListener.
	 * El orden de la tabla variará dependiendo de qué JRadioButton se haya escogido.
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
					
					pelis=objGestor.ListaVideojuegos();
					Collections.sort(pelis);

					TablaOrdenarVideojuegosModel tam=(TablaOrdenarVideojuegosModel)TablaVideojuegos.getModel();
					tam.setData(pelis);
					tam.fireTableDataChanged();
					
				}
				
			
				

			
			
			
			
			else 
			{
				
				
				
				clsGestor objGestor=new clsGestor();

				pelis=objGestor.ListaVideojuegos();
				

	
				
				Collections.sort(pelis, new clsOrdenarConsola());

				TablaOrdenarVideojuegosModel tam=(TablaOrdenarVideojuegosModel)TablaVideojuegos.getModel();
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
	 *	Clase que se encarga de la creación de un JTable de videojuegos.
	 */
	class TablaOrdenarVideojuegosModel extends AbstractTableModel
    {
        private String[] columnNames = {"Nombre", "Precio", "Consola","Descripcion","Código", "Tipo"};
        Object[][] data;
        
        public TablaOrdenarVideojuegosModel(CopyOnWriteArrayList<clsVideojuego> pelis)
        {
        	
        	super();
        	
    		int filas = pelis.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		for (clsVideojuego aux : pelis)
    		{
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

        
        
        public void setData(CopyOnWriteArrayList<clsVideojuego> pelis) 
        {
        	int filas = pelis.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
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
