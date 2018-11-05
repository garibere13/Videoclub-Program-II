import LP.frmPaginaPrincipal;

/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase principal que contiene el método main para poder inicializar el programa
 *
 */

public class clsMain {

	
	
	/**
	 * Llamada al método invokelater() de Swing
	 * @param Creación de un objeto Runnable y un método run() para la creación de un hilo nuevo 
	 * 
	 */
	public static void main(String[] args) 
	{
        
		
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
            	//Create and set up the window.
            	frmPaginaPrincipal frame = new frmPaginaPrincipal("Aplicación para Gestión de Videoclub (AGV)");
                frame.createAndShowGUI();
               
            }
            });
    }

}



