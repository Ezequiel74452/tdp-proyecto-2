package Game;

import exceptions.ImposibleRotar;

public abstract class Tetrimino {
	
	protected Bloque[][] grilla;
	protected Bloque[] bloques;
	protected int xt;
	protected int yt;
	
	public Tetrimino(int rndm) {
		grilla = new Bloque[4][4];
		Bloque cubo1 = new Bloque(rndm);
		Bloque cubo2 = new Bloque(rndm);
		Bloque cubo3 = new Bloque(rndm);
		Bloque cubo4 = new Bloque(rndm);
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
	/*public void moverIzquierda() {
		if(checkMove()) {
			for(int i=0; i<bloques.length; i++) {
				bloques[i].setY(bloques[i].getY()-1);
			}
			actualizar();
		}
	}
	private boolean checkmove() {
		
	}
	public void moverDerecha() {
		if(checkMove()) {
			for(int i=0; i<bloques.length; i++) {
				bloques[i].setY(bloques[i].getY()+1);
			}
			actualizar();
		}
	}*/
	
	
	public int[][] rotar() {
	
		int i =0;
		int xbAux, ybAux,xb,yb,xbRotacion,ybRotacion;
		
		int[][] MatrizRotada;
		
		MatrizRotada = new int[4][2];
		
		for (i=0; i<4; i++) {
				xb=bloques[i].getX();
				yb=bloques[i].getY();
				
				xbAux=xt-xb; 
				if (xbAux >= 0) xbAux++; 
				
				ybAux=yt-yb; 
				if(ybAux >= 0) ybAux++;
				
				xbRotacion = xb + xbAux;
				ybRotacion = yb + ybAux;
				
				MatrizRotada[i][0]=xbRotacion;
				MatrizRotada[i][1]=ybRotacion;
				}
		
		if (i == 4)
			System.out.println("pieza rotada");
		
		return MatrizRotada;
	}
	
	public Bloque getBloquePos(int f, int c) {
		return grilla[f][c];
	}
	public Bloque getBloque(int pos) {
		return bloques[pos];
	}
	
	public int getXt() {
		return xt;
	}
	
	public int getYt() {
		return yt;
	}
	
	public void setXt(int x) {
		xt=x;
	}
	
	public void setYt(int y) {
		yt=y;
	}
	public int getAltMax() {
		int max = bloques[0].getX();
		for(int i=1; i<4; i++) {
			if(bloques[i].getX()<max) {
				max = bloques[i].getX();
			}
		}
		return max;
	}
	public int getAltMin() {
		int min = bloques[0].getX();
		for(int i=1; i<4; i++) {
			if(bloques[i].getX()>min) {
				min = bloques[i].getX();
			}
		}
		return min;
	}
	public int getBIzq() {
		int izq = bloques[0].getY();
		for(int i=1; i<4; i++) {
			if(bloques[i].getY()<izq) {
				izq = bloques[i].getY();
			}
		}
		return izq;
	}
	public int getBDer() {
		int der = bloques[0].getY();
		for(int i=1; i<4; i++) {
			if(bloques[i].getY()>der) {
				der = bloques[i].getY();
			}
		}
		return der;
	}
}
