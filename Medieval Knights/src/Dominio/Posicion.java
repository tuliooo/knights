package Dominio;

public class Posicion {
private int x;
private int y;
public Posicion(int x, int y) {
	this.x = x;
	this.y = y;
	// TODO Auto-generated constructor stub
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}

public String toString()
{
	return "x=" + (x+1) + " y=" + (y+1);
}

}
