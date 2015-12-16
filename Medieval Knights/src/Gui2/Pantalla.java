package Gui2;
import javax.swing.JFrame;


public class Pantalla extends JFrame {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int alto;
	private int ancho;
	
	
	public Pantalla(String titulo,int ancho,int alto){
		this.alto = alto;
		this.ancho = ancho;
		this.setAlwaysOnTop(true);
		this.setTitle(titulo);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public void mostrar(){
		this.setSize(ancho, alto);
		this.setVisible(true);
	}

}
