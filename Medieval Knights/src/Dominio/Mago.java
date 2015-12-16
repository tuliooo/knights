package Dominio;
import java.util.ArrayList;

import BD.Conector;



public class Mago extends Personaje{
	
	public Mago(String nombre, Raza raza, int fuerza, int inteligencia,
			int vidaMax, int vida, int distancia, Posicion pos) {
		super(nombre, raza, fuerza, inteligencia, vidaMax, vida, distancia,pos);
		// TODO Auto-generated constructor stub
		this.listaHechizos = new ArrayList<Hechizo>();
	}

	private ArrayList<Hechizo> listaHechizos;


	public ArrayList<Hechizo> getListaHechizos() {
		return listaHechizos;
	}

	public void setListaHechizos(ArrayList<Hechizo> listaHechizos) {
		this.listaHechizos = listaHechizos;
	}
	
	public void aprendeHechizo(Hechizo unHechizo)
	{
		if (listaHechizos.size() < 4)
		{
			listaHechizos.add(unHechizo); //Se aprendio un hechizo nuevo
		}else
		{
			//Cuando ya sabe cuatro hechizos, no aprende "Avisa que ya sabe cuatro hechizos"
		}
	}
	
	public void lanzaHechizo(Personaje unPersonaje, Hechizo unHechizo)
	{
		if (unPersonaje.getVida() < 10)
			{
				unPersonaje.setVida(0); //Lleva la vida a 0
			}else{
				unPersonaje.setVida(getVida()-10); //Disminuye la vida en 10 unidades
			}
		listaHechizos.remove(unHechizo);	//Saca el hechizo de la lista de hechizos
	}
	
	public void save(){
        Conector con = new Conector();
        con.connect();
        con.savePersonaje(this,"Mago");
        con.close();
    }
}