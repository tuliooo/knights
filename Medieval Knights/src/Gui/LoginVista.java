package Gui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;

import javax.swing.*;

import BD.Conector;
import Dominio.Usuario;
import Logica.Jugabilidad;

public class LoginVista extends JFrame {
private String name;
private String pass;
public Usuario elUsuario;
public int cantidad;
//public ArrayList<Usuario> listaUsuarios;
public LoginVista(int Cantidad, final Jugabilidad elJuego)  {
	cantidad = Cantidad;
    JFrame main = new JFrame("LOGIN");
    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.setResizable(false);
    main.setLayout(null);
    main.setPreferredSize(new Dimension(200, 300));
    main.setLocation(400, 200);

    // Heading: LOGIN
    JLabel heading = new JLabel("LOGIN");
    heading.setBounds(80, 20, 50, 20);
    main.add(heading);

    // Label Username
    JLabel username_label = new JLabel("Usuario: ");
    username_label.setBounds(5, 70, 80, 20);
    main.add(username_label);
    
    // Textfield Username
    final JTextField username_field = new JTextField();
    username_field.setBounds(70, 70, 120, 20);
    main.add(username_field);
    this.name = username_field.getText();
    
    // Label Password
    JLabel password_label = new JLabel("Clave: ");
    password_label.setBounds(5, 100, 80, 20);
    main.add(password_label);
    
    // Textfield Username
    final JPasswordField password_field = new JPasswordField();
    password_field.setBounds(70, 100, 120, 20);
    main.add(password_field);
    this.pass = String.valueOf(password_field.getPassword());

    // Button Login
    JButton loginBtn = new JButton("LOGIN");
    loginBtn.setBounds(40, 150, 120, 25);
    main.add(loginBtn);
    
    JButton registBtn = new JButton("Registrarse");
    registBtn.setBounds(40, 180, 120, 25);
    main.add(registBtn);
    
    
    main.pack();
    main.setVisible(true);
    
    Conector co = new Conector();
  	 co.connect();
      
  	
  	final ArrayList<Usuario> listaUsuarios = co.traeUsuarios();
  	co.close();
    loginBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	name = username_field.getText();
        	pass = String.valueOf(password_field.getPassword());
        	Usuario unUsuario = new Usuario(name, pass);
        	if(buscaUsuario(unUsuario, listaUsuarios))
        	{
        		System.out.println("Login");
        		elUsuario = unUsuario;
        		System.out.println(unUsuario);
        		elJuego.listaUsuarios.add(elUsuario);
        		EligePersonajes(elUsuario, cantidad);
        		
        	}else{
        		//Ofrece registrarse
        	}
        }
    });
    
    registBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	name = username_field.getText();
        	pass = String.valueOf(password_field.getPassword());
        	Usuario unUsuario = new Usuario(name, pass);
        	if(!buscaUsuario(unUsuario, listaUsuarios))
        	{
        		if(!name.equals(""))
        		{
        			registraUsuario(unUsuario);
        			elUsuario = unUsuario;
        			elJuego.listaUsuarios.add(elUsuario);
            		EligePersonajes(elUsuario, cantidad);
        			
        		}else
        		{
        			System.out.println("Ingrese un nombre");
        		}
        		
        	}else{
        		System.out.println("El usuario ya existe");
        	}
        }
    });
    
    
  
    
}


public void print() {
    System.out.println(name);
}

public boolean buscaUsuario(Usuario unUsuario, ArrayList<Usuario> lista)
{
	for (Usuario usuario : lista) {
		if (usuario.getNombre().compareTo(unUsuario.getNombre()) == 0)
		{
			if(usuario.getPassword().compareTo(unUsuario.getPassword()) == 0)
			{
				return true;
				
			}else
			{
				System.out.println("El password ingresado es incorrecto");
			}
		}
	}
	return false;
}

public void registraUsuario(Usuario unUsuario)
{
	Conector co = new Conector();
 	 co.connect();
 	 if(co.saveUsuario(unUsuario))
 		{
 		System.out.println("Usuario Grabado");
 		}
 
}

public Usuario TraeUsuario()
{
	return elUsuario;
 
}

public void EligePersonajes(Usuario unUsuario, int cantidad)
{
	/*UsuarioPersonajesVista EligePersonaje;
	EligePersonaje = new UsuarioPersonajesVista(unUsuario);
	 */
	
	UsuarioPersonajesVista seleccionPersonajes;
	seleccionPersonajes = new UsuarioPersonajesVista(unUsuario);
	this.setVisible(false);//oculta el jFrame que estes usando
}
 		 

}