package Dominio;

public abstract class Personaje {
	

	private String nombre;
	private Raza raza;
	private int fuerza;
	private int inteligencia;
	private int vidaMax;
	private int vida;
	private int distancia; //A que distancia tiene que estar para ser efectivo
	private Posicion pos;
	
	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	//Constructor
	public Personaje(String nombre, Raza raza, int fuerza, int inteligencia,
			int vidaMax, int vida, int distancia,Posicion pos) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.fuerza = fuerza;
		this.inteligencia = inteligencia;
		this.vidaMax = 100;
		this.vida = vidaMax;
		this.distancia = distancia;
		this.pos = pos;
	}
	
     public String toString() {
		return "Personaje [Nombre=" + nombre + ", Raza=" + raza + ", Fuerza="
				+ fuerza + ", Inteligencia=" + inteligencia + ", Vida Maxima="
				+ vidaMax + ", Vida=" + vida +  " posicion " + pos + "]";
	}

	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		if (fuerza >= 0 && fuerza <= 20 )
		this.fuerza = fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		if (inteligencia >= 0 && inteligencia <= 20 )
		this.inteligencia = inteligencia;
	}
  
	public int getVidaMax() {
		return vidaMax;
	}

	

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public Posicion getPos() {
		return pos;
	}

	public void setPos(Posicion pos) {
		this.pos = pos;
	}

	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
	}

	public boolean Caminar(Mapa elMapa, Direccion dire) {
		// Depende para donde mueva la flecha
		Posicion viejaPos = getPos();
		Posicion nuevaPos = viejaPos;
		boolean movio = true;
		
		switch (dire) {
		case IZQUIERDA:
			nuevaPos.setX(viejaPos.getX() - 1);
			if (elMapa.ocuparPosicion(viejaPos, nuevaPos, this)) {
				setPos(nuevaPos);
			} else {
				movio = false;
			}
			break;

		case DERECHA:
			int nueva = viejaPos.getX();
			nuevaPos.setX(nueva + 1);
			if (elMapa.ocuparPosicion(this.getPos(), nuevaPos, this)) {
				
				setPos(nuevaPos);
			} else {
				movio = false;
			}
			break;

		case ARRIBA:
			nuevaPos.setY(viejaPos.getY() - 1);
			if (elMapa.ocuparPosicion(viejaPos, nuevaPos, this)) {
				setPos(nuevaPos);
			} else {
				movio = false;
			}
			break;

		case ABAJO:
			nuevaPos.setY(viejaPos.getY() + 1);
			if (elMapa.ocuparPosicion(viejaPos, nuevaPos, this)) {
				setPos(nuevaPos);
			} else {
				movio = false;
			}
			break;
		default:
			break;

		}

		return movio;

	}
	
	public boolean Mover(Mapa elMapa, Direccion dire) {
		// Depende para donde mueva la flecha
		boolean movio = true;
		
		Posicion oldPos = this.getPos();
		Posicion nuevaPos = oldPos;
		switch (dire) {
		case IZQUIERDA:
			int izquierda = oldPos.getY();
			izquierda = izquierda -1;
			if(izquierda >=0)
			{
				nuevaPos = new Posicion(oldPos.getX(),izquierda);
			}
			break;

		case DERECHA:
			int derecha = oldPos.getY();
			derecha = derecha +1;
			if(derecha <= elMapa.getLargo())
			{
			nuevaPos = new Posicion(oldPos.getX(),derecha);
			}
			break;

		case ARRIBA:
			int arriba = oldPos.getX();
			arriba = arriba -1;
			if(arriba >= 0)
			{
				nuevaPos = new Posicion(arriba,oldPos.getY());
			}
			break;

		case ABAJO:
			int abajo = oldPos.getX();
			abajo = abajo +1;
			if(abajo <= elMapa.getAlto())
			{
				nuevaPos = new Posicion(abajo,oldPos.getY());
			}
			break;
		default:
			break;

		}
		if (elMapa.ocuparPosicion(oldPos,nuevaPos, this)) {
			setPos(nuevaPos);
		} else {
			movio = false;
			System.out.println("El personaje no se pudo mover");
		}

		return movio;

	}
	
	public int distancia(Personaje unPersonaje)
	{
		int distanciaTotal = -99;
		if(mismaColumna(unPersonaje))
		{
			distanciaTotal = this.getPos().getX() - unPersonaje.getPos().getX();
		}
		
		if(mismaFila(unPersonaje))
		{ 
			distanciaTotal = this.getPos().getY() - unPersonaje.getPos().getY();
		}
		
		if (distanciaTotal < 0 && distanciaTotal != -99)
		{
			distanciaTotal = distanciaTotal *-1;
		}
		
		return distanciaTotal;
		
		
	}
	
	public boolean mismaFila(Personaje unPersonaje)
	{
		if (this.getPos().getX() == unPersonaje.getPos().getX())
		{
			return true;
		}
		return false;
	}
	
	public boolean mismaColumna(Personaje unPersonaje)
	{
		if (this.getPos().getX() == unPersonaje.getPos().getX())
		{
			return true;
		}
		return false;
	}

	public void setRaza(String string) {
		// TODO Auto-generated method stub
		setRaza(Raza.valueOf(string));
	}

}
