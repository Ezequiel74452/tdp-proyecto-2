package Game;

import javax.swing.ImageIcon;

public abstract class Tetrimino {
	
	protected Bloque[][] grilla;
	protected Bloque[] bloques;
	protected int ejeDeRotacion;
	protected ImageIcon imagen;
	protected String figuras[];
	
	public Tetrimino(int rndm) {
		grilla = new Bloque[4][4];
		Bloque cubo1 = new Bloque(rndm);
		Bloque cubo2 = new Bloque(rndm);
		Bloque cubo3 = new Bloque(rndm);
		Bloque cubo4 = new Bloque(rndm);
		bloques = new Bloque[] {cubo1, cubo2, cubo3, cubo4};
	}
	
	
	protected abstract void acomodarCubos();
	public void setCubo(Bloque b, int f, int c) {
		grilla[f][c] = b;
	}
	
	
	public int[][] rotar() {

        int i =0;
        int xbAux, ybAux,xb,yb,xbRotacion,ybRotacion;
        int aux;
        
        int xt,yt;

        int[][] MatrizRotada;

        MatrizRotada = new int[4][2];

        xt=bloques[ejeDeRotacion].getX();
        yt=bloques[ejeDeRotacion].getY();

        for (i=0; i<4; i++) {
                xb=bloques[i].getX();
                yb=bloques[i].getY();

                xbAux=xb-xt; 

                ybAux=yb-yt; 

                aux=ybAux;
                ybAux=-xbAux;
                xbAux=aux;

                xbRotacion = xt + xbAux;
                ybRotacion = yt + ybAux;

                MatrizRotada[i][0]=xbRotacion;
                MatrizRotada[i][1]=ybRotacion;

                }

        return MatrizRotada;
    }
	
	public Bloque getBloquePos(int f, int c) {
		return grilla[f][c];
	}
	public Bloque getBloque(int pos) {
		return bloques[pos];
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
