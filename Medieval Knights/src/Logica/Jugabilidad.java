package Logica;

import java.util.ArrayList;

import Dominio.Mapa;
import Dominio.Usuario;

public class Jugabilidad {
	public int cantidadUsuarios;
	public int cantidadPersonajes;
	public Mapa map;
	public Usuario usrActual;
	public ArrayList<Usuario> listaUsuarios;

	public Jugabilidad(){
		map = new Mapa(10, 10);
		listaUsuarios = new ArrayList<Usuario>();
	}

	public void inicioJuego() {
		usrActual.getListaPersonajes();
		
	}

}
