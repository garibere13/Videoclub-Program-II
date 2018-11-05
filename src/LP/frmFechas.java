package LP;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;																																		
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;




//http://stackoverflow.com/questions/26794698/how-do-i-implement-jdatepicker
//https://search.maven.org/#search%7Cga%7C1%7Cjdatepicker



/**
 * 
 * @author Garikoitz.Bereciartua
 * Formulario utilizado para poder escoger la fecha desde una nueva ventana
 * Hereda de JFrame, implementa ActionListener
 */
public class frmFechas extends JFrame implements ActionListener
{
	private JPanel contentPane;
	JButton btnFecha;
	JDatePickerImpl datePicker;
	JButton btnAceptar;
	JButton btnCancelar;
	
	private static String fec;
	
	
	public static String getFec() {
		return fec;
	}

	public void setFec(String fec) {
		this.fec = fec;
	}


	private final String ACEPTAR="ACEPTAR";

	/**
	 * Método por donde empieza a ejecutarse esta ventana
	 */
	public static void Empezar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFechas frame = new frmFechas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la clase
	 */
	public frmFechas() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);

		
		
		
		this.getContentPane().add(datePicker,BorderLayout.PAGE_START);
		this.getContentPane().add(btnAceptar,BorderLayout.PAGE_END);
		
		
	}

	
	/**
	 * Método para gestionar la escucha de eventos, la escucha de los botones en esta caso.
	 * Obligatorio al implementar la interfaz ActionListener
	 * @return void
	 */
	public void actionPerformed(ActionEvent e) 
	{
		
		
		DateFormat miFormato;
		String fecha;
		
		miFormato=DateFormat.getDateInstance(DateFormat.SHORT);
		fecha=miFormato.format(datePicker.getModel().getValue());

		setFec(fecha);
		
		this.dispose();
		
	}

	
	
	
}
