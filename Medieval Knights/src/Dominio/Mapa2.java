package Dominio;

public class Mapa2 {
	private int largo;
	private int alto;
	
	
	
	public int getLargo() {
		return largo;
	}

    public int getAlto() {
		return alto;
	}

	public Mapa2(int x, int y)
	{
		largo = x-1;
		alto = y-1;
		Personaje [][] grilla = new Personaje[x][y];
		setMapa(grilla);
	}
	
	public Personaje[][] getMapa() {
		return mapa;
	}
	
	public void imprimir() {
		Personaje[][] grilla = getMapa();
		for (int i = 0; i <= largo; i++) {
			for (int j = 0; j <= alto; j++) {
				System.out.print(grilla[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void setMapa(Personaje[][] grilla) {
		this.mapa = grilla;
	}

	private Personaje[][] mapa;
	
	public boolean casilleroDisponible(Posicion unaPosicion)
	{
		Personaje[][] grilla = getMapa();
		if(grilla[unaPosicion.getX()][unaPosicion.getY()] == null)
		{
			return true;
		}else{ return false;}
	}	
		public boolean ocuparPosicion(Posicion posPartida, Posicion posFinal, Personaje unPersonaje)
		{
			if(casilleroDisponible(posFinal))
			{
				Personaje[][] grilla = getMapa();
				grilla[posFinal.getX()][posFinal.getY()] = unPersonaje;
				grilla[posPartida.getX()][posPartida.getY()] = null;
				setMapa(grilla);
				return true;
			}
			return false;
		}
		
		public void ocuparPosicionIncial(Posicion posFinal, Personaje unPersonaje)
		{
				Personaje[][] grilla = getMapa();
				grilla[posFinal.getX()][posFinal.getY()] = unPersonaje;
				setMapa(grilla);
		}
		
		public Posicion ubicaPersonaje(Personaje elPersonaje)
		{
			int rndX;
			int rndy;
			Posicion unaPosicion;
			do {
				rndX = (int)(Math.random()*this.largo +1);
				rndy = (int)(Math.random()*this.alto +1);
				unaPosicion = new Posicion(rndX,rndy);
			} while (!casilleroDisponible(unaPosicion));
			ocuparPosicionIncial(unaPosicion, elPersonaje);
			return unaPosicion;
		}

	}
