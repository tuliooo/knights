package Gui2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Dominio.Caballero;
import Dominio.Clerigo;
import Dominio.Mago;
import Dominio.Personaje;
import Dominio.Posicion;
import Dominio.Raza;
import Dominio.Usuario;

public class PersonajesVista extends JPanel implements ActionListener {
	JFrame frame;
	JPanel panelSuperior, panelInferior;
	JButton btnAgregar, btnCrear, btnConfirmar;
	JLabel pantalla, nombreUser, nombreLabel, personajeCreado;
	JList listaElegidos;
	JList listaDisponibles;
	ArrayList<Personaje> listaPersonajes;
	JComboBox<String> comboPersonajes;
	public Usuario elUsuario;
	
	
	public PersonajesVista(Usuario unUsuario) {
		elUsuario = unUsuario;
		construyePanelSuperior(unUsuario);
		construyePanelInferior();
		construyeVentana();
	}
	
	private void construyePanelSuperior(Usuario unUsuario2) {
		listaElegidos = new JList<>();
		panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(2,2));
		pantalla = new JLabel("Usuario");
		nombreUser = new JLabel(unUsuario2.getNombre());
		panelSuperior.add(pantalla);
		panelSuperior.add(nombreUser);
		panelSuperior.add(listaElegidos); 
		personajeCreado = new JLabel("Pantalla para creacion de personajes");
		panelSuperior.add(personajeCreado);
		
		
		//comboRazas = new JComboBox<String>(razas);
		ItemListener itemListener1 = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					System.out.println(itemEvent.getItem());
					String unItem = (String) itemEvent.getItem();
					//personajeRaza = Raza.valueOf(unItem);
				}
				// System.out.println((state == ItemEvent.SELECTED) ? "Selected"
				// : "Deselected");
				// System.out.println("Item: " + itemEvent.getItem());

			}
		};
		//comboRazas.addItemListener(itemListener1);
		//razaLabel = new JLabel("Raza");
		//personajeRaza= Raza.valueOf(comboRazas.getSelectedItem().toString());

		// Usuario   Nombre Usuario
		// Pantalla para creacion de personajes
		
		//Solo falta añadir el panel al FRAME
	}
	
	private void construyePanelInferior() {
		// TODO Auto-generated method stub
		panelInferior = new JPanel();
		panelInferior.setLayout(new GridLayout(1,3));
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(this);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(this);
		
		panelInferior.add(btnCrear);
		panelInferior.add(btnAgregar);
		panelInferior.add(btnConfirmar);
	}
	
	private void construyeVentana() {
		// TODO Auto-generated method stub
		frame = new JFrame("Pantalla para creacion de personajes");
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
			UsuarioPersonajesVista EligePersonaje;
			EligePersonaje = new UsuarioPersonajesVista(elUsuario);
		}
		
	}

}
