package Game;

public abstract class Tetrimino {
	
	protected Bloque[][] grilla;
	protected Bloque[] bloques;
	
	public Tetrimino(int rndm) {
		grilla = new Bloque[4][4];
		Bloque cubo1 = new Bloque(rndm, true);
		Bloque cubo2 = new Bloque(rndm, true);
		Bloque cubo3 = new Bloque(rndm, true);
		Bloque cubo4 = new Bloque(rndm, true);
		bloques = new Bloque[] {cubo1, cubo2, cubo3, cubo4};
	}
	
	
	/* private void eliminarFila(int pos) {
		for (int i=0; i<forma[pos].length; i++) {
			forma[pos][i] = null;
		}
	}
	public void eliminarFilas(int cant) {
		// Probablemente puede mejorarse si se implementa recursivamente.
		if (cant == 1) {
			eliminarFila(3);
		}
		if (cant == 2) {
			eliminarFila(3);
			eliminarFila(2);
		}
		if (cant == 3) {
			eliminarFila(3);
			eliminarFila(2);
			eliminarFila(1);
		}
		if (cant == 3) {
			eliminarFila(3);
			eliminarFila(2);
			eliminarFila(1);
			eliminarFila(0);
		}
	} */
	protected abstract void acomodarCubos();
	public void setCubo(Bloque b, int f, int c) {
		grilla[f][c] = b;
	}
	public void moverIzquierda() {
		
	}
	public void moverDerecha() {
		
	}
	public abstract void rotar();
	public Bloque getBloquePos(int f, int c) {
		return grilla[f][c];
	}
	public Bloque getBloque(int pos) {
		return bloques[pos];
	}
}
