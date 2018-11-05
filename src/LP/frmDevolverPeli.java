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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import LN.clsGestor;
import LN.clsPeli_Alquilada;
import LN.clsPelicula;
import LN.clsUsuario;
import LN.clsVideojuego;
import LP.frmModificarPelicula.TablaPeliculasModel;





/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para devolver pel�culas
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmDevolverPeli extends JInternalFrame implements ActionListener
{
	
	
	
	
	private static final long serialVersionUID = 1L;



	CopyOnWriteArrayList<clsPelicula>pelis;
	CopyOnWriteArrayList<clsPelicula>pelis1;

	
	CopyOnWriteArrayList<clsPeli_Alquilada> a;
	
	JTable TablaPeliculas;
	JScrollPane jsp;
	
	JButton btnDevolver;
	JButton btnCancelar;
	
	JLabel lblTexto;
	
	JPanel PanelPeliculas;
	clsPelicula pelialqui;
	
	
	
	
	
	JPanel PanelBotones;
	
	
	private final String DEVOLVER="DEVOLVER";
	private final String CANCELAR="CANCELAR";
	public final static int COL_PELIS_COD=4;
	public final static int ROW_NO_SELECTED=-1;
	
	
	
	
	

	/**
	 * Constructor de la clase
	 * Llama al m�todo CreateAndShowGUI()
	 * @param String title
	 */
	public frmDevolverPeli(String title)
	{
		
		super(title);
		
		setTitle("Lista de pel�culas que ha alquilado");
		
		TablaPeliculas=new JTable();


		

		
		
		
		

		CreateAndShowGUI();

		
	}
	
	
	
	
	/**
	 * 
	 * M�todo que llama al m�todo de crearTablaPeliculas()
	 * Inicializa las JLabel, los JTextField, los JButton.
	 * A�ade los elementos inicializados al panel de tipo BorderLayout y FlowLayout.
	 * Define las propiedades que vaya a tener la internal frame(maximizar, minimizar...)
	 * @return void
	 */
	public void CreateAndShowGUI()
	{
		
		
		
		crearTablaPeliculas();
		
		jsp=new JScrollPane(TablaPeliculas);
	
		
		lblTexto=new JLabel("Seleccione la pel�cula que desee devolver");
		
		PanelPeliculas=new JPanel(new BorderLayout());
		
		PanelPeliculas.add(lblTexto,BorderLayout.NORTH);
		PanelPeliculas.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelPeliculas,BorderLayout.CENTER);
	
			
		
		//creaci�n de los botones de la parte inferior de la pantalla.		
		PanelBotones =new JPanel(new FlowLayout());
		
		
		btnDevolver=new JButton("Devolver");
		btnDevolver.setActionCommand(DEVOLVER);
		btnDevolver.addActionListener(this);

		btnCancelar=new JButton("Cancelar");
		btnCancelar.setActionCommand(CANCELAR);
		btnCancelar.addActionListener(this);

		
		PanelBotones.add(btnDevolver);
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
	 * M�todo que crea la tabla de pel�culas.
	 * Lee de fichero la lista de todos los alquileres hechos.
	 * A continuaci�n, los filtra en base al usuario que est� en la aplicaci�n en ese momento, eliminando los dem�s.
	 * Por �ltimo, regoge la informaci�n de esas pel�culas mediante el m�todo BuscarPelicula().
	 * @return void
	 */
	private void crearTablaPeliculas()
	{
		
		
		TablaPeliculas=null;
		
		pelis1=new CopyOnWriteArrayList<clsPelicula>();
		pelialqui=new clsPelicula();
		clsGestor objGestor= new clsGestor();
		
		a=objGestor.ListaAlquileresPeli();
		
		

		
		
		String refusu=frmPaginaPrincipal.txtNickname.getText();

		
		for(clsPeli_Alquilada aux:a)
		{
			if(aux.getNickname().equals(refusu))
			{
				
			}
			else
			{
				a.remove(aux);
			}
		}

		
		for(clsPeli_Alquilada aux:a)
		{
			pelialqui=objGestor.BuscarPelicula(aux.getCod());
			pelis1.add(pelialqui);
		}

		TablaDevolverPeliculasModel tcm=new TablaDevolverPeliculasModel(pelis1);
	
		TablaPeliculas = new JTable(tcm);
		TablaPeliculas.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaPeliculas.setFillsViewportHeight(true);
		TablaPeliculas.setEnabled(true);
		TablaPeliculas.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();
		
		
		
		
	}
	
	
	
	/**
	 * M�todo que borra un alquiler de pel�cula en caso de haber escogido un elemento de la tabla.
	 * El elemento escogido pasar� a tener condici�n true y no aparecer� m�s en la tabla de devoluciones, apareciendo en la de alquileres.
	 * @return void
	 */
	private void A�adirListaAlquiler()
	{


		clsGestor objGestor=new clsGestor();

		
		String cod;
		String id;
		int rowPelis;
		rowPelis=TablaPeliculas.getSelectedRow();
		if((rowPelis!=ROW_NO_SELECTED) )
		{
			
			pelis=new CopyOnWriteArrayList<clsPelicula>();
			pelis=objGestor.ListaPeliculas();
			cod=(String)TablaPeliculas.getValueAt(rowPelis, COL_PELIS_COD);
			id=frmPaginaPrincipal.txtNickname.getText();
			objGestor.EliminarAlquilerPeli(id, cod);

			
			
			
			int i;
			for(i=0;i<pelis.size();i++)
			{
				if(pelis.get(i).getCodigop().equals(cod))
				{
					pelis.get(i).setCondicion(true);
					objGestor.GuardarPelis(pelis);
				}
			}
			
			
			
			
			
			
			

			
			pelis=new CopyOnWriteArrayList<clsPelicula>();
			pelis=objGestor.ListaPeliculas();
			
			
			for(clsPelicula aux:pelis)
			{
				if(aux.getTipo().equals("Venta") || (aux.getTipo().equals("Alquiler") && aux.isCondicion() == true))
				{
					pelis.remove(aux);
				}
				
			}
			
			
			TablaDevolverPeliculasModel tam=(TablaDevolverPeliculasModel)TablaPeliculas.getModel();
			tam.setData(pelis);
			tam.fireTableDataChanged();
			
			

		}

	}
	

	

	
	

	/**
	 * M�todo para gestionar la escucha de eventos, la escucha de los botones en este caso.
	 * Obligatorio al implementar la interfaz ActionListener
	 * @return void
	 */
	public void actionPerformed(ActionEvent e)
	{
		
		
		String comando=e.getActionCommand();
		
		
		switch(comando)
		{

		case DEVOLVER:
			
			A�adirListaAlquiler();
			
			this.repaint();
			this.dispose();
			break;
			

			
			
			
			

		case CANCELAR:
				this.dispose();
				break;	

			
		}
		
	}
	
	
	
	
	
	/**
	 * 
	 *	Clase que se encarga de la creaci�n de un JTable de pel�culas.
	 */
	class TablaDevolverPeliculasModel extends AbstractTableModel
    {
        private String[] columnNames = {"T�tulo", "Precio", "Categor�a", "Duraci�n", "C�digo", "Tipo"};
        Object[][] data;
        
        public TablaDevolverPeliculasModel(CopyOnWriteArrayList<clsPelicula> pelis1)
        {
        	
        	super();
        	
    		int filas = pelis1.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		for (clsPelicula aux : pelis1)
    		{
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

        
        
        public void setData(CopyOnWriteArrayList<clsPelicula> pelis1) 
        {
        	int filas = pelis1.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		
    		for (clsPelicula aux : pelis1)
    		{
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
