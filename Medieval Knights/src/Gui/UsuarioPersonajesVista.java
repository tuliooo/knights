package Gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import BD.Conector;
import Dominio.Arquero;
import Dominio.Caballero;
import Dominio.Clerigo;
import Dominio.Mago;
import Dominio.Personaje;
import Dominio.Posicion;
import Dominio.Raza;
import Dominio.Usuario;
import Logica.Jugabilidad;

public class UsuarioPersonajesVista extends JFrame implements ActionListener {
	JFrame frame;
	JPanel panelSuperior, panelInferior;
	JButton btnCrear;
	Jugabilidad unJuego;
	JLabel pantalla, nombreUser, nombreLabel, razaLabel, tipoLabel,
			creaPersonaje, personajeCreado, fuerzaLabel, inteligenciaLabel, fuerzaText, inteligenciaText;
	JTextField nombreText;
	String personajeNombre, personajeTipo;
	String[] inteligencia,fuerza;
	int personajeFuerza;
	int personajeInteligencia;
	String Dios;
	
	public static Usuario unUsuario;
	Personaje unPersonaje;
	ArrayList<Personaje> listaPersonajes;
	JComboBox<String> comboRazas, comboTipos, comboInteligencia, comboFuerza;
	Raza personajeRaza;
	Posicion posPersonaje;

	public UsuarioPersonajesVista(Usuario unUsuario) {
		construyePanelSuperior(unUsuario);
		construyePanelInferior();
		construyeVentana();
	}

	void construyePanelSuperior(Usuario unUsuario) {
		
		panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(2,2));
		pantalla = new JLabel("Usuario");
		nombreUser = new JLabel(unUsuario.getNombre());
		panelSuperior.add(pantalla);
		panelSuperior.add(nombreUser);
		personajeCreado = new JLabel("Pantalla para creacion de personajes");
		panelSuperior.add(personajeCreado);
	}

	void construyePanelInferior() {
		fuerza = llenaVector(0, 20);
		inteligencia = llenaVector(0, 20);
		panelInferior = new JPanel();
		panelInferior.setLayout(new GridLayout(6, 1));
		creaPersonaje = new JLabel("Crea Personaje");
		personajeCreado = new JLabel("Pesonaje Creado");
		// Nombre Personaje
		nombreLabel = new JLabel("Nombre");
		nombreText = new JTextField();
		panelInferior.add(nombreLabel);
		panelInferior.add(nombreText);
		// Fila de razas
		
		String razas[] = { Raza.ELFO.toString(), Raza.ENANO.toString(),
				Raza.HUMANO.toString(), Raza.ORCO.toString() };
		comboRazas = new JComboBox<String>(razas);
		ItemListener itemListener1 = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					System.out.println(itemEvent.getItem());
					String unItem = (String) itemEvent.getItem();
					personajeRaza = Raza.valueOf(unItem);
				}
				// System.out.println((state == ItemEvent.SELECTED) ? "Selected"
				// : "Deselected");
				// System.out.println("Item: " + itemEvent.getItem());

			}
		};
		comboRazas.addItemListener(itemListener1);
		razaLabel = new JLabel("Raza");
		personajeRaza= Raza.valueOf(comboRazas.getSelectedItem().toString());
		
		panelInferior.add(razaLabel);
		panelInferior.add(comboRazas);		

		// Tipo de personaje
		tipoLabel = new JLabel("Tipo de Personaje");

		String tipos[] = { "Arquero", "Caballero", "Clerigo", "Mago" };
		comboTipos = new JComboBox<String>(tipos);

		ItemListener itemListener2 = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					System.out.println(itemEvent.getItem());
					personajeTipo = (String) itemEvent.getItem();
					if(personajeTipo == "Clerigo")
					{
						String fuerzaInput, inteligenciaInput; 
						int fuerzaInputI = 0;
						int inteligenciaInputI = 0;
						do {
							fuerzaInput = JOptionPane.showInputDialog(frame, "Ingrese fuerza entre 18 y 20");
							System.out.println(fuerzaInput);
							if (isNumeric(fuerzaInput))
								{
									fuerzaInputI = Integer.parseInt(fuerzaInput);
								}
						} while (fuerzaInputI < 18 || fuerzaInputI > 20 );
						
						do {
							inteligenciaInput = JOptionPane.showInputDialog(frame, "Ingrese inteligencia entre 12 y 16");
							System.out.println(inteligenciaInput);
							if (isNumeric(inteligenciaInput))
								{
								inteligenciaInputI = Integer.parseInt(inteligenciaInput);
								}
						} while (inteligenciaInputI < 12 || inteligenciaInputI > 16 );
						
						personajeInteligencia = inteligenciaInputI;
						personajeFuerza = fuerzaInputI;
						Dios = JOptionPane.showInputDialog(frame, "Ingrese el nombre de su Dios");
						fuerzaText.setText(String.valueOf(personajeFuerza));
						inteligenciaText.setText(String.valueOf(personajeInteligencia));
					}
					System.out.println(personajeTipo);
					if(personajeTipo == "Mago")
					{
						String fuerzaInput, inteligenciaInput; 
						int fuerzaInputI = 0;
						int inteligenciaInputI = 0;
						do {
							fuerzaInput = JOptionPane.showInputDialog(frame, "Ingrese fuerza entre 0 y 15");
							System.out.println(fuerzaInput);
							if (isNumeric(fuerzaInput))
								{
									fuerzaInputI = Integer.parseInt(fuerzaInput);
								}
						} while (fuerzaInputI < 0 || fuerzaInputI > 15 );
						
						do {
							inteligenciaInput = JOptionPane.showInputDialog(frame, "Ingrese inteligencia entre 17 y 20");
							System.out.println(inteligenciaInput);
							if (isNumeric(inteligenciaInput))
								{
								inteligenciaInputI = Integer.parseInt(inteligenciaInput);
								}
						} while (inteligenciaInputI < 17 || inteligenciaInputI > 20 );
						
						personajeInteligencia = inteligenciaInputI;
						personajeFuerza = fuerzaInputI;
						fuerzaText.setText(String.valueOf(personajeFuerza));
						inteligenciaText.setText(String.valueOf(personajeInteligencia));
					}
					
					if(personajeTipo == "Arquero")
					{
						Random rnd = new Random();
						int fuerza = (int)(rnd.nextDouble() * 5 + 15);
						int inteligencia = (int)(rnd.nextDouble() * 5 + 10);
						personajeFuerza = fuerza;
						personajeInteligencia = inteligencia;
						fuerzaText.setText(String.valueOf(personajeFuerza));
						inteligenciaText.setText(String.valueOf(personajeInteligencia));
					}
					
					if(personajeTipo == "Caballero")
					{
						Random rnd = new Random();
						int fuerza = (int)(rnd.nextDouble() * 5 + 15);
						int inteligencia = (int)(rnd.nextDouble() * 5 + 10);
						personajeFuerza = fuerza;
						personajeInteligencia = inteligencia;
						fuerzaText.setText(String.valueOf(personajeFuerza));
						inteligenciaText.setText(String.valueOf(personajeInteligencia));
					}
				}

			}
		};
		comboTipos.addItemListener(itemListener2);
		personajeTipo= comboTipos.getSelectedItem().toString();
		panelInferior.add(tipoLabel);
		panelInferior.add(comboTipos);
		
		fuerzaLabel = new JLabel("Fuerza");
		fuerzaText = new JLabel(String.valueOf(personajeFuerza));
		
		
		panelInferior.add(fuerzaLabel);
		panelInferior.add(fuerzaText);

		inteligenciaLabel = new JLabel("Inteligencia");
		inteligenciaText = new JLabel(String.valueOf(personajeInteligencia));

		panelInferior.add(inteligenciaLabel);
		panelInferior.add(inteligenciaText);

		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(this);
		panelInferior.add(btnCrear);
		

	}

	void construyeVentana() {
		frame = new JFrame("Personaje");
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setLocation(400, 200);
		frame.add(panelSuperior);
		frame.add(panelInferior);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == btnCrear) {
			personajeNombre = nombreText.getText();
			//personajeRaza = 
			personajeInteligencia = Integer.parseInt(inteligenciaText.getText());
			personajeFuerza = Integer.parseInt(fuerzaText.getText());
			posPersonaje = new Posicion(0, 0);
			// ACA CREO EL PERSONAJE
			switch (personajeTipo) {
			case "Caballero":
				unPersonaje = new Caballero(personajeNombre,personajeRaza , personajeFuerza, personajeInteligencia, 100, 100, 1, posPersonaje);
				break;

			case "Mago":
				unPersonaje = new Mago(personajeNombre,personajeRaza , personajeFuerza, personajeInteligencia, 100, 100, 1, posPersonaje);
				break;

			case "Clerigo":
				unPersonaje = new Clerigo(personajeNombre,personajeRaza , personajeFuerza, personajeInteligencia, 100, 100, 1, posPersonaje);	
				break;
			default:
				break;
			}
			save(unPersonaje, personajeTipo);
			//unJuego.
		}

	}

	public boolean isNumeric(String s) {
		return s.matches("[-+]?\\d*\\.?\\d+");
	}
	public String[] llenaVector(int Minimo, int Maximo)
	{
		String[] Vector = new String[20];
		int j = 0;
		for (int i = Minimo; i < Maximo; i++) {
			Vector[j] = String.valueOf(i);
			j++;
		}
		return Vector;
	}
	
	public void save(Personaje unPersonaje, String tipo){
        Conector con = new Conector();
        con.connect();
        con.savePersonaje(unPersonaje,tipo);
        con.close();
    }
	
	
	/*Mago
	 * Inteligencia Minimo 17
	 * Fuerza Maximo 15
	 * 
	 * Clerigo
	 * Fuerza Minimo 18
	 * Inteligencia entre 12 y 16
	 */
}