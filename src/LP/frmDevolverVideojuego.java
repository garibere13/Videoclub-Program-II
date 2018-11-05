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
import LN.clsVideojuego_Alquilado;
import LP.frmDevolverPeli.TablaDevolverPeliculasModel;
import LP.frmModificarPelicula.TablaPeliculasModel;





/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para devolver videojuegos.
 * Hereda de JInternalFrame, implementa ActionListener
 */
public class frmDevolverVideojuego extends JInternalFrame implements ActionListener
{
	
	
	
	
	private static final long serialVersionUID = 1L;



	CopyOnWriteArrayList<clsVideojuego>juegos;
	CopyOnWriteArrayList<clsVideojuego>juegos1;
	
	CopyOnWriteArrayList<clsVideojuego_Alquilado> a;
	
	JTable TablaJuegos;
	JScrollPane jsp;
	
	JButton btnDevolver;
	JButton btnCancelar;
	
	JLabel lblTexto;
	
	
	JPanel PanelPeliculas;
	
	
	clsVideojuego juegoalqui;
	
	
	
	JPanel PanelBotones;
	
	
	private final String DEVOLVER="DEVOLVER";
	private final String CANCELAR="CANCELAR";
	public final static int COL_PELIS_COD=3;
	public final static int ROW_NO_SELECTED=-1;
	
	
	
	
	

	/**
	 * Constructor de la clase
	 * Llama al método CreateAndShowGUI()
	 * @param String title
	 */
	public frmDevolverVideojuego(String title)
	{
		
		super(title);
		
		setTitle("Lista de videojuegos que ha alquilado");
		
		TablaJuegos=new JTable();
		
		

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
		
		jsp=new JScrollPane(TablaJuegos);
	
		
		lblTexto=new JLabel("Seleccione el videojuego que desee devolver");
		
		PanelPeliculas=new JPanel(new BorderLayout());
		
		PanelPeliculas.add(lblTexto,BorderLayout.NORTH);
		PanelPeliculas.add(jsp,BorderLayout.CENTER);
		
		this.getContentPane().add(PanelPeliculas,BorderLayout.CENTER);
	
			
		
		//creación de los botones de la parte inferior de la pantalla.		
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
	 * Método que crea la tabla de videojuegos.
	 * Lee de fichero la lista de todos los alquileres hechos.
	 * A continuación, los filtra en base al usuario que está en la aplicación en ese momento, eliminando los demás.
	 * Por último, regoge la información de esos videojuegos mediante el método BuscarVideojuego().
	 * @return void
	 */
	private void crearTablaVideojuegos()
	{
		
		
		TablaJuegos=null;
		
		juegos1=new CopyOnWriteArrayList<clsVideojuego>();
		juegoalqui=new clsVideojuego();
		clsGestor objGestor= new clsGestor();
		
		a=objGestor.ListaAlquileresVideojuegos();
		
		

		
		
		String refusu=frmPaginaPrincipal.txtNickname.getText();

		
		for(clsVideojuego_Alquilado aux:a)
		{
			if(aux.getNickname().equals(refusu))
			{
				
			}
			else
			{
				a.remove(aux);
			}
		}

		
		for(clsVideojuego_Alquilado aux:a)
		{
			juegoalqui=objGestor.BuscarVideojuego(aux.getCod());
			juegos1.add(juegoalqui);
		}
		
		


		TablaDevolverVideojuegosModel tcm=new TablaDevolverVideojuegosModel(juegos1);
	
		TablaJuegos = new JTable(tcm);
		TablaJuegos.setPreferredScrollableViewportSize(new Dimension(500, 70));
		TablaJuegos.setFillsViewportHeight(true);
		TablaJuegos.setEnabled(true);
		TablaJuegos.setRowSelectionAllowed(true);
		tcm.fireTableDataChanged();
		
		
		
		
		
	
				
	}
	
	
	
	/**
	 * Método que borra un alquiler de videojuego en caso de haber escogido un elemento de la tabla.
	 * El elemento escogido pasará a tener condición true y no aparecerá más en la tabla de devoluciones, apareciendo en la de alquileres.
	 * @return void
	 */
	private void AñadirListaAlquiler()
	{

		clsGestor objGestor=new clsGestor();

		
		String cod;
		String id;
		int rowPelis;
		rowPelis=TablaJuegos.getSelectedRow();
		if((rowPelis!=ROW_NO_SELECTED) )
		{
			
			juegos=new CopyOnWriteArrayList<clsVideojuego>();
			juegos=objGestor.ListaVideojuegos();
			cod=(String)TablaJuegos.getValueAt(rowPelis, COL_PELIS_COD);
			id=frmPaginaPrincipal.txtNickname.getText();
			objGestor.EliminarAlquilerVideojuego(id, cod);

			
			
			
			int i;
			for(i=0;i<juegos.size();i++)
			{
				if(juegos.get(i).getCodigov().equals(cod))
				{
					juegos.get(i).setCondicion(true);
					objGestor.GuardarVideojuegos(juegos);
				}
			}
			
			
			
			
			
			
			

			
			juegos=new CopyOnWriteArrayList<clsVideojuego>();
			juegos=objGestor.ListaVideojuegos();
			
			
			for(clsVideojuego aux:juegos)
			{
				if(aux.getTipo().equals("Venta") || (aux.getTipo().equals("Alquiler") && aux.isCondicion() == true))
				{
					juegos.remove(aux);
				}
				
			}
			
			
			TablaDevolverVideojuegosModel tam=(TablaDevolverVideojuegosModel)TablaJuegos.getModel();
			tam.setData(juegos);
			tam.fireTableDataChanged();
			
			

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

		case DEVOLVER:
			
			AñadirListaAlquiler();
			
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
	 *	Clase que se encarga de la creación de un JTable de videojuegos.
	 */
	class TablaDevolverVideojuegosModel extends AbstractTableModel
    {
        private String[] columnNames = {"Título","Precio","Consola","Código", "Descripción", "Tipo"};
        Object[][] data;
        
        public TablaDevolverVideojuegosModel(CopyOnWriteArrayList<clsVideojuego> juegosalqui)
        {
        	
        	super();
        	
    		int filas = juegosalqui.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
    		
    		
    		for (clsVideojuego aux : juegosalqui)
    		{
    			Object[]n={new String(aux.getNombre()),	
    					   new Integer(aux.getPrecio()),
    					   new String(aux.getConsola()),	    			
    					   new String(aux.getCodigov()),
    					   new String(aux.getDescripción()),
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
    			Object[]n={new String(aux.getNombre()),	
 					   	   new Integer(aux.getPrecio()),
 					       new String(aux.getConsola()),	    			
 					       new String(aux.getCodigov()),
 					       new String(aux.getDescripción()),
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
        
        
        
        
//        public Class getColumnClass(int c) {
//            return getValueAt(0, c).getClass();
//        }
        
        
//        public boolean isCellEditable(int row, int col) {
//            
//            return false;
//       
//        }
        
        
        
        
        public void setValueAt(Object value, int row, int col) 
        {
            
            data[row][col] = value;
            fireTableCellUpdated(row, col);

        }


    }
}
