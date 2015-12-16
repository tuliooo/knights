package Dominio;

public class Mapa {
	private int largo;
	private int alto;
	public int getLargo() {
		return largo;
	}



	public int getAlto() {
		return alto;
	}

	

	
	public Mapa(int x, int y)
	{
		largo = x-1;
		alto = y-1;
		int [][] grilla = new int[x][y];
		setMapa(grilla);
	}
	
	public int[][] getMapa() {
		return mapa;
	}
	
	public void imprimir() {
		int [][] grilla = getMapa();
		for (int i = 0; i <= largo; i++) {
			for (int j = 0; j <= alto; j++) {
				System.out.print(grilla[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public void setMapa(int[][] mapa) {
		this.mapa = mapa;
	}

	private int [][] mapa;
	
	public boolean casilleroDisponible(Posicion unaPosicion)
	{
		int [][] grilla = getMapa();
		if(grilla[unaPosicion.getX()][unaPosicion.getY()] == 0)
		{
			return true;
		}else{ return false;}
	}	
		public boolean ocuparPosicion(Posicion posPartida, Posicion posFinal, Personaje unPersonaje)
		{
			if(casilleroDisponible(posFinal))
			{
				int [][] grilla = getMapa();
				grilla[posFinal.getX()][posFinal.getY()] = 1;
				grilla[posPartida.getX()][posPartida.getY()] = 0;
				setMapa(grilla);
				return true;
			}
			return false;
		}
		
		public void ocuparPosicionIncial(Posicion posFinal, Personaje unPersonaje)
		{
				int [][] grilla = getMapa();
				grilla[posFinal.getX()][posFinal.getY()] = 1;
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
