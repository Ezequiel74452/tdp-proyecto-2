package Game;

import java.util.Random;

import javax.swing.ImageIcon;

import TetrisGUI.GUI1;



public class Juego {
	
	protected static GUI1 miVentana;
	protected Grilla grilla;
	private int puntos;
	private Tetrimino tactual, tsiguiente;
	private boolean GameOver;
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
		
		//tactual = crearTetrimino(getNext());
		tactual = crearTetrimino(4);
		setTetrimino(tactual);
		siguiente = getNext();
		//tsiguiente= crearTetrimino();
		actualizarNext(siguiente);
		GameOver=false;			
	}
	
	public int getNext() {
		Random ran = new Random();
		int num = ran.nextInt(5);
		return num;
	}
	
	public synchronized void operarJuego(int operacion) {
		if(!GameOver)
		switch (operacion) {
		case MoverI: {moverIzq();break;}
		case MoverD: {moverDer();break;}
		case MoverA: {descender();break;}
		case Rotar: {rotar();break;}
		}
	}
	
	
	/*
	public Tetrimino crearTetrimino() {
		Random ran = new Random();
		int num = ran.nextInt(7);
		Tetrimino t = null;
		switch (num) {
		case 0: t= new T_Tetrimino(grilla.getBloque(2, 5), grilla.getBloque(1, 6), grilla.getBloque(1, 5), grilla.getBloque(1, 4), 2, grilla);
		break;
		case 1: t= new J_Tetrimino(grilla.getBloque(1, 4), grilla.getBloque(1, 5), grilla.getBloque(1, 6), grilla.getBloque(2, 6), 0, grilla);
		break;
		case 2: t= new L_Tetrimino(grilla.getBloque(2, 4), grilla.getBloque(1, 6), grilla.getBloque(1, 5), grilla.getBloque(1, 4), 2, grilla);
		break;
		case 3: t= new O_Tetrimino(grilla.getBloque(1, 5), grilla.getBloque(1, 6), grilla.getBloque(2, 5), grilla.getBloque(2, 6), 0, grilla);
		break;
		case 4: t= new I_Tetrimino(grilla.getBloque(1, 4), grilla.getBloque(1, 5), grilla.getBloque(1, 6), grilla.getBloque(1, 7), 1, grilla);
		break;
		case 5: t= new S_Tetrimino(grilla.getBloque(1, 5), grilla.getBloque(1, 6), grilla.getBloque(2, 4), grilla.getBloque(2, 5), 0, grilla);
		break;
		case 6: t= new Z_Tetrimino(grilla.getBloque(1, 4), grilla.getBloque(1, 5), grilla.getBloque(2, 5), grilla.getBloque(2, 6), 0, grilla);
		break;
		}
		return t;
	}
	*/
	public Tetrimino crearTetrimino(int num) {
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
		}
		return t;
	}
	
	/*
	public Tetrimino crearSiguiente() {
		Random ran = new Random();
		int num = ran.nextInt(7);
		Random ran2 = new Random();
		int col = ran2.nextInt(7)+2;
		switch (num) {
		case 0: tsiguiente= new T_Tetrimino(col);
		break;
		case 1: tsiguiente= new J_Tetrimino(col);
		break;
		case 2: tsiguiente= new L_Tetrimino(col);
		break;
		case 3: tsiguiente= new O_Tetrimino(col);
		break;
		case 4: tsiguiente= new I_Tetrimino(col);
		break;
		case 5: tsiguiente= new S_Tetrimino(col);
		break;
		case 6: tsiguiente= new Z_Tetrimino(col);
		break;
		}
		return tsiguiente;
	}*/
	
	/*private void setTetrimino(Tetrimino tr) {
		
		for(int i=1; i<3; i++) {
			for(int j=4; j<8 ; j++) {
				if (tr!=null && tr.getBloquePos(i-1, j-4)!=null) {
					
					if(!grilla[i][j].esSobre())
					{
						GameOver=true;
						GUI2.actualizar();
						GUI2.gameOver();	
						break;
					}												
					setBloque(tr.getBloquePos(i-1, j-4), i, j);					
					grilla[i][j].setX(i);
					grilla[i][j].setY(j);
					
				}
				
			}
			if(GameOver)
				break;
		}
	
	}*/
	
	private void setTetrimino(Tetrimino tr) {
		tactual.ocuparBloques();
	}
	
	public Tetrimino getSiguiente() {
		return tsiguiente;
	}	
	
	private void moverIzq() {
		tactual.moverIzq();

	}
	
	private void moverDer() {
		tactual.moverDer();
	}
	
	public void rotar() {	   
		tactual.rotar();		
	}
	
	private void descender() {
		if(!tactual.descender()) {
			tactual=crearTetrimino(siguiente);			
			setTetrimino(tactual);
			siguiente = getNext();
			actualizarNext(siguiente);
		}
			
	}
	
	/*
	private void descender() {
		if(tactual.mover(grilla, 0, 1))
		{	
			if(tactual.getAltMax()<alturaMax)
			alturaMax=tactual.getAltMax();
			for(int i=0; i<4; i++) {
				tactual.getBloque(i).setSobre(false);
				int x = tactual.getBloque(i).getX();
				int y = tactual.getBloque(i).getY();
				grilla[x][y].setSobre(false);
			}
			checkLineas(tactual.getAltMin(), tactual.getAltMax());
			if(!GameOver)
			{
			tactual = tsiguiente;
			tsiguiente = crearSiguiente();
			setTetrimino(tactual);
			GUI2.actualizar();
			GUI2.actualizarNext();
			}
		}
		else
			GUI2.actualizar();
				
	}
	*/
	public int getPuntos() {
		return puntos;
	}
	
	public Tetrimino getTetrimino() {
		return tactual;
	}
	
	/*
	public void checkLineas(int min, int max) {
		int cant=0;
		boolean seLimpia = true;
		for(int i=max; i<=min; i++) {
			for(int j=1; j<11 && seLimpia; j++) {
				if(grilla[i][j].esSobre()) {
					seLimpia = false;
				}
			}
			if (seLimpia) {
				limpiar(i);
				bajarBloques(i);
				cant++;
			}
			seLimpia = true;
		}
		switch(cant){
		case 1: puntos += 100;break;
		case 2: puntos += 200;break;
		case 3: puntos += 500;break;
		case 4: puntos += 800;}
		GUI2.actualizarPuntuación();
		
	}
	private void limpiar(int linea) {
		for(int i=1; i<11; i++) {
			grilla[linea][i] = new Bloque(1);
		}
		GUI2.actualizarLinea(linea);
	}
	
	private void bajarBloques(int l)
	{
		for(int j=l; j>=alturaMax; j--) {
			for(int i=1; i<11; i++) {
				grilla[j][i] = grilla[j-1][i];
			}
			GUI2.actualizarLinea(j);
		}
	}
	
	*/
	
	

	public boolean getGameOver() {
		
		return GameOver;
	}
	
	public void actualizarVentana(int i, int j, ImageIcon textura) {
		GUI1.actualizar(i,j,textura);
		
	}

	public Grilla getGrilla() {
		return grilla;
	}

	public void actualizarTiempo(int tiempo) {
		miVentana.actualizarTiempo(tiempo);
		
	}
	/*
	private void actualizarNext(Tetrimino ts) {
		
		ImageIcon icon =new ImageIcon(getClass().getResource("/Texturas/Bloques/Gris.png"));
		
		int x = ts.getW().getX();
		int y = ts.getW().getY()-4;
		
		int x1= ts.getX().getX();
		int y1= ts.getX().getY()-4;
		
		int x2 = ts.getY().getX();
		int y2 = ts.getY().getY()-4;
		
		int x3 = ts.getZ().getX();
		int y3 = ts.getZ().getY()-4;
			
		miVentana.actualizarNext(x,y,x1,y1,x2,y2,x3,y3,icon);		
	}	*/
	
	private void actualizarNext(int s) {
		miVentana.actualizarNext(s);
	}
}
