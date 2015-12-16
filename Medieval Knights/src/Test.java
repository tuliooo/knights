import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Caballero;
import Dominio.Direccion;
import Dominio.Hechizo;
import Dominio.Mago;
import Dominio.Mapa;
import Dominio.Mapa2;
import Dominio.Personaje;
import Dominio.Posicion;
import Dominio.Raza;
import Dominio.Usuario;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Posicion posMago = new Posicion (1,1);
		Posicion posCab =new Posicion (0,0);
		Usuario unUsuario = new Usuario("Julian", "1234");
        ArrayList<Personaje> listaParaUsuario = new ArrayList<Personaje>();
        Mapa elMapa = new Mapa(5, 5);
        elMapa.imprimir();
        int rnd = (int)(Math.random()*10 + 1);
        Mago elMago= new Mago("Gino " + rnd, Raza.ENANO, 15, 17, 100, 100, 2, posMago);
        listaParaUsuario.add(elMago);
        //elMago.save();
        Caballero elCaba = new Caballero("Pepe " +rnd, Raza.ELFO, 18, 12, 100, 100, 1, posCab);
        //elCaba.save();
        listaParaUsuario.add(elCaba);
        elMago.setPos(elMapa.ubicaPersonaje(elMago));
        
        elCaba.setPos(elMapa.ubicaPersonaje(elCaba));
        System.out.println(elMago);       
        elMapa.imprimir();
        unUsuario.setListaPersonajes(listaParaUsuario);
        unUsuario.verPersonajes();

        
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        do {
        	
            switch (entradaTeclado) {
    		case "izq":
    			elMago.Mover(elMapa, Direccion.IZQUIERDA);
    			break;

    		case "der":
    			elMago.Mover(elMapa, Direccion.DERECHA);
    			break;

    		case "arr":
    			elMago.Mover(elMapa, Direccion.ARRIBA);
    			break;

    		case "aba":
    			elMago.Mover(elMapa, Direccion.ABAJO);
    			break;
    		default:
    			System.out.println("Ingrese un movimiento valido");
    			break;

    		}
            elMapa.imprimir();
            entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
            entradaTeclado = entradaEscaner.next(); //Invocamos un método sobre un objeto Scanner
            
           
            
        
        } while (entradaTeclado != "ja");
        //elMago.Mover(elMapa, Direccion.ABAJO);
        
        
	}
}
