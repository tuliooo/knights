package Dominio;

import java.sql.PreparedStatement;

import BD.Conector;

public class Caballero extends Personaje {

	public Caballero(String nombre, Raza raza, int fuerza, int inteligencia,
			int vidaMax, int vida, int distancia, Posicion pos) {
		super(nombre, raza, fuerza, inteligencia, vidaMax, vida, distancia, pos);
		// TODO Auto-generated constructor stub
	}
	//Usar interfaces y atachar el metodo intefaces en el controlador. Clase en el medio para asegurarse llegar
	public void Atacar(Personaje unPersonaje)
	{
		int rnd = (int)(Math.random()*10 + 1);
		int da�o;
		if(rnd < 3)
		{
			da�o = 5;
		}else if (rnd < 6) {
			da�o = 10;
		}else if (rnd <9) {
			da�o = 15;
		}else{
			da�o = 20;
		}
		
		if (unPersonaje.getVida() < da�o)
		{
			unPersonaje.setVida(0); //Lleva la vida a 0
		}else{
			unPersonaje.setVida(getVida()-da�o); //Disminuye la vida en 10 unidades
		}
	}
	
	public void save(){
        Conector con = new Conector();
        con.connect();
        con.savePersonaje(this,"Caballero");
        con.close();
    }

}
