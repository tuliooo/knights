package Gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.bind.ParseConversionEvent;

import BD.Conector;
import Dominio.Raza;
import Dominio.Usuario;
import Logica.Jugabilidad;

public class InicioVista extends JFrame  {
public Jugabilidad elJuego;
private String usuarios;
private String personajes;
public Usuario elUsuario;
JComboBox<String> comboUsuarios, comboPersonajes;
JPanel panelSuperior, panelInferior;
//public ArrayList<Usuario> listaUsuarios;

public InicioVista()  {
	elJuego = new Jugabilidad();
	JFrame main = new JFrame("Inicio");
    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //main.setResizable(false);
    main.setLayout(new GridLayout(4,4));
    main.setPreferredSize(new Dimension(500, 500));
    main.setLocation(400, 200);
    panelSuperior = new JPanel();
	panelSuperior.setLayout(new GridLayout(1,1));
    // Heading: LOGIN
    JLabel heading = new JLabel("Medieval Knights");
    heading.setSize(1000,1000);
    heading.setAlignmentX(50);
    heading.setAlignmentY(50);
    panelSuperior.add(heading);
    main.add(panelSuperior);
    
    panelInferior = new JPanel();
    panelInferior.setLayout(new GridLayout(2, 2));
 // Label Personajes
    JLabel usuariosLabel = new JLabel("Cantidad de Usuarios: ");
    usuariosLabel.setBounds(5, 100, 80, 20);
    panelInferior.add(usuariosLabel);
    
    String cantUsuarios[] = {"2","3","4","5","6" };
	 comboUsuarios= new JComboBox<String>(cantUsuarios);
	 usuarios = comboUsuarios.getSelectedItem().toString();
	ItemListener itemListener = new ItemListener() {
		public void itemStateChanged(ItemEvent itemEvent) {
			int state = itemEvent.getStateChange();
			if (state == ItemEvent.SELECTED) {
				System.out.println(itemEvent.getItem());
				usuarios= (String) itemEvent.getItem();
			}
	
		}
	};
	comboUsuarios.addItemListener(itemListener);
	panelInferior.add(comboUsuarios);
    
    
    // Label Personajes
    JLabel personajesLabel = new JLabel("Cantidad de Personajes: ");
    personajesLabel.setBounds(5, 100, 80, 20);
    panelInferior.add(personajesLabel);
    
    
    String cantPersonajes[] = {"1","2","3","4","5","6" };
	 comboPersonajes= new JComboBox<String>(cantPersonajes);

	ItemListener itemListener1 = new ItemListener() {
		public void itemStateChanged(ItemEvent itemEvent) {
			int state = itemEvent.getStateChange();
			if (state == ItemEvent.SELECTED) {
				System.out.println(itemEvent.getItem());
				personajes= (String) itemEvent.getItem();
			}
	
		}
	};
	comboPersonajes.addItemListener(itemListener1);
	panelInferior.add(comboPersonajes);
	main.add(panelInferior);
	personajes = comboPersonajes.getSelectedItem().toString();
	// Button Login
    JButton generarBtn = new JButton("Generar Partida");
    generarBtn.setBounds(40, 150, 120, 25);
    
    generarBtn.addActionListener(new ActionListener() {
        @Override	
        public void actionPerformed(ActionEvent e) {
        	System.out.println(usuarios);
        	System.out.println(personajes);
        	elJuego.cantidadUsuarios = Integer.parseInt(usuarios);
        	elJuego.cantidadPersonajes = Integer.parseInt(personajes);
        	LoginUsuarios(elJuego);
        }
        });
    
    main.add(generarBtn);
    
    
    main.pack();
    main.setVisible(true);
    
}


public void print() {
    System.out.println(usuarios);
}

public int getUsuarios()
{
	return Integer.parseInt(usuarios);
}

public int getPersonajes()
{
	return Integer.parseInt(personajes);
}

public void LoginUsuarios(Jugabilidad elJuego)
{
	LoginVista login = new LoginVista(getPersonajes(), elJuego);	
	System.out.println("Personajesss " + getUsuarios());
	//this.setVisible(false);//oculta el jFrame que estes usando
	
}
 		 

}