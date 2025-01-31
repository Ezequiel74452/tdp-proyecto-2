package Game;

import java.util.Random;

import javax.swing.ImageIcon;

import TetrisGUI.GUI1;



public class Juego {
	
	private static GUI1 miVentana;
	private Grilla grilla;
	private int puntos;
	private Tetrimino tactual;
	private boolean gameOver;
	public static final int MoverI = 1;
	public static final int MoverD = 2;
	public static final  int MoverA = 3;
	public static final  int Rotar = 4;
	private int alturaMax=21;
	private int siguiente;
	
	public Juego(GUI1 mv) {
		miVentana = mv;
		miVentana.registrarJuego(this);
		grilla = new Grilla(this);
		puntos = 0;
		
		tactual = crearTetrimino(getNext());
		setTetrimino(tactual);
		siguiente = getNext();
		actualizarNext(siguiente);
		gameOver=false;			
	}
	
	private int getNext() {
		Random ran = new Random();
		int num = ran.nextInt(7);
		return num;
	}
	
	public synchronized void operarJuego(int operacion) {
		if(!gameOver)
		switch (operacion) {
		case MoverI: {moverIzq();break;}
		case MoverD: {moverDer();break;}
		case MoverA: {descender();break;}
		case Rotar: {rotar();break;}
		}
	}
		
	private Tetrimino crearTetrimino(int num) {
		Tetrimino t = null;
		switch (num) {
		case 0: t= new T_Tetrimino(grilla.getBloque(2, 5), grilla.getBloque(1, 6), grilla.getBloque(1, 5), grilla.getBloque(1, 4), 2, grilla);
		break;
		case 1: t= new O_Tetrimino(grilla.getBloque(1, 5), grilla.getBloque(1, 6), grilla.getBloque(2, 5), grilla.getBloque(2, 6), 0, grilla);
		break;
		case 2: t= new I_Tetrimino(grilla.getBloque(1, 4), grilla.getBloque(1, 5), grilla.getBloque(1, 6), grilla.getBloque(1, 7), 1, grilla);
		break;
		case 3: t= new S_Tetrimino(grilla.getBloque(1, 5), grilla.getBloque(1, 6), grilla.getBloque(2, 4), grilla.getBloque(2, 5), 0, grilla);
		break;
		case 4: t= new Z_Tetrimino(grilla.getBloque(1, 4), grilla.getBloque(1, 5), grilla.getBloque(2, 5), grilla.getBloque(2, 6), 0, grilla);
		break;
		case 5: t= new J_Tetrimino(grilla.getBloque(1, 4), grilla.getBloque(1, 5), grilla.getBloque(1, 6), grilla.getBloque(2, 6), 0, grilla);
		break;
		case 6: t= new L_Tetrimino(grilla.getBloque(2, 4), grilla.getBloque(1, 6), grilla.getBloque(1, 5), grilla.getBloque(1, 4), 2, grilla);
		break;
		}
		return t;
	}
		
	private void setTetrimino(Tetrimino tr) {
		if(grilla.getBloque(tr.getW().getX(), tr.getW().getY()).ocupado() ||
				grilla.getBloque(tr.getX().getX(), tr.getX().getY()).ocupado() ||
					grilla.getBloque(tr.getY().getX(), tr.getY().getY()).ocupado() ||
						grilla.getBloque(tr.getZ().getX(), tr.getZ().getY()).ocupado())
			gameOver=true;
		else	
		tactual.ocuparBloques();
		if(gameOver)
			miVentana.gameOver();		
	}
		
	private void moverIzq() {
		tactual.moverIzq();
	}
	
	private void moverDer() {
		tactual.moverDer();
	}
	
	private void rotar() {	   
		tactual.rotar();		
	}
	
	private void descender() {
		if(!tactual.descender()) {
			if(tactual.getAltMax()<alturaMax)
				alturaMax=tactual.getAltMax();
			checkLineas(tactual.getAltMin(),tactual.getAltMax());
			if(!gameOver) {
				tactual=crearTetrimino(siguiente);			
				setTetrimino(tactual);
				siguiente = getNext();
				actualizarNext(siguiente);
			}
		}			
	}
		
	private void checkLineas(int min, int max) {
		int cant=0;
		boolean seLimpia = true;
		for(int i=max; i<=min; i++) {
			for(int j=1; j<11 && seLimpia; j++) {
				if(!grilla.getBloque(i, j).ocupado()) {
					seLimpia = false;
				}
			}
			if (seLimpia) {
				limpiar(i);
				bajarBloques(i);
				cant++;
				alturaMax++;
			}
			seLimpia = true;
		}
		switch(cant){
		case 1: puntos += 100;break;
		case 2: puntos += 200;break;
		case 3: puntos += 500;break;
		case 4: puntos += 800;break;}
		miVentana.actualizarPuntuación(puntos);		
	}
	
	private void limpiar(int linea) {
		for(int i=1; i<11; i++) 
			grilla.getBloque(linea, i).desOcupar();
	}
	
	private void bajarBloques(int l)
	{
		for(int j=l; j>=alturaMax; j--) {
			for(int i=1; i<11; i++) {
				swap(grilla.getBloque(j, i),grilla.getBloque(j-1,i));
			}
		}
	}
	
	private void swap(Bloque b1, Bloque b2)
	{
		int x=b1.getX();
		int y=b1.getY();
		
		Bloque aux = grilla.getBloque(b1.getX(), b1.getY());
		grilla.setBloque(b1.getX(), b1.getY(), b2);
		grilla.setBloque(b2.getX(), b2.getY(), aux);
		
		b1.setX(b2.getX());
		b1.setY(b2.getY());
		
		b2.setX(x);
		b2.setY(y);
		
	}
			
	public boolean getGameOver() {		
		return gameOver;
	}
	
	public void actualizarVentana(int i, int j, ImageIcon textura) {
		miVentana.actualizar(i,j,textura);		
	}

	public void actualizarTiempo(int tiempo) {
		miVentana.actualizarTiempo(tiempo);		
	}
	
	private void actualizarNext(int s) {
		miVentana.actualizarNext(s);
	}
}
