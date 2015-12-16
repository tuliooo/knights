package Dominio;

import BD.Conector;

public class Clerigo extends Personaje {
	
	private String dios;

	public Clerigo(String nombre, Raza raza, int fuerza, int inteligencia,
			int vidaMax, int vida, int distancia, Posicion pos) {
		super(nombre, raza, fuerza, inteligencia, vidaMax, vida, distancia, pos);
	}

	public void Curar(Personaje unPersonaje)
	{
		if (unPersonaje.getVida() +10 >= unPersonaje.getVidaMax())
		{
			unPersonaje.setVida(getVidaMax()); //Lleva la vida al maximo
		}else{
			unPersonaje.setVida(getVida()+10); //Aumenta la vida en 10 unidades
		}
	}

	
	public void save(){
        Conector con = new Conector();
        con.connect();
        con.savePersonaje(this,"Clerigo");
        con.close();
    }
}