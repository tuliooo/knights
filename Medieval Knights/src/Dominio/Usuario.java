package Dominio;

import java.util.ArrayList;

import BD.Conector;

public class Usuario {
private String nombre;
private String password;
private ArrayList<Personaje> listaPersonajes;

public Usuario(String nombre, String password)
{
	this.nombre = nombre;
	this.password = password;
	this.listaPersonajes = new ArrayList<Personaje>();
}

public Usuario()
{
	this.listaPersonajes = new ArrayList<Personaje>();
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public ArrayList<Personaje> getListaPersonajes() {
	return listaPersonajes;
}
public void setListaPersonajes(ArrayList<Personaje> listaPersonajes) {
	this.listaPersonajes = listaPersonajes;
}

public void save(){
    Conector con = new Conector();
    con.connect();
    con.saveUsuario(this);
    con.close();
}

public void verificar(String nombre, String pass)
{
	
}

public void verPersonajes(){
    Conector con = new Conector();
    con.connect();
    con.mostrarPersonajes();
    con.close();
}

public String toString() {
	return "Nombre: " + nombre;
}
}
