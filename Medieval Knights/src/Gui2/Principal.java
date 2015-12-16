package Gui2;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal extends JFrame{

	public static void main(String[] arg){
		//Creo la ventana
		Principal f= new Principal();
	
		//Tamanio de pantalla
		f.setSize(700, 600);
		
		//cuando cerramos la ventana que muera el proceso
	    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		//La hago visible
	    f.setVisible(true);
	
	    //Le pongo un titulo
	    f.setTitle("Titulo");
	}
	
	public Principal(){
		Fondo fondo= new Fondo();
		this.add(fondo, BorderLayout.CENTER);
		this.pack();
		
	}
}
