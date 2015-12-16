package Dominio;

public class Hechizo {
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Hechizo: " + getNombre();
	}
}
