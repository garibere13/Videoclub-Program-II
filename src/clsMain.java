import LP.frmPaginaPrincipal;

/**
 * 
 * @author Garikoitz.Bereciartua
 * Clase principal que contiene el m�todo main para poder inicializar el programa
 *
 */

public class clsMain {

	
	
	/**
	 * Llamada al m�todo invokelater() de Swing
	 * @param Creaci�n de un objeto Runnable y un m�todo run() para la creaci�n de un hilo nuevo 
	 * 
	 */
	public static void main(String[] args) 
	{
        
		
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
            	//Create and set up the window.
            	frmPaginaPrincipal frame = new frmPaginaPrincipal("Aplicaci�n para Gesti�n de Videoclub (AGV)");
                frame.createAndShowGUI();
               
            }
            });
    }

}



