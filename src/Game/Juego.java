package Game;

import java.util.Random;

import TetrisGUI.GUI2;


public class Juego {
	
	protected Bloque[][] grilla;
	private int puntos;
	private Tetrimino tactual, tsiguiente;
	private boolean GameOver;
	public static final int MoverI = 1;
	public static final int MoverD = 2;
	public static final  int MoverA = 3;
	public static final  int Rotar = 4;
	
	public Juego() {
		grilla = new Bloque[23][12];
		crearPerimetro();
		crearGrillaInicial();
		puntos = 0;
		tactual = crearTetrimino();
		tsiguiente = crearSiguiente();
		GameOver=false;
			
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
	
	
	private void crearPerimetro() {
		Bloque borde = new Bloque(0);
		for (int i=0; i<23; i++) {
			grilla[i][0] = borde;
			grilla[i][11] = borde;
		}
		for (int j=0; j<12; j++) {
			grilla[0][j] = borde;
			grilla[22][j] = borde;
		}
	}
	
	private void crearGrillaInicial() {
		Bloque empty = new Bloque(1);
		for(int i=0; i<23; i++) {
			for(int j=0; j<12; j++) {
				if(grilla[i][j] == null) {
					grilla[i][j] = empty;
				}
			}
		}
	}
	
	public Tetrimino crearTetrimino() {
		Random ran = new Random();
		int num = ran.nextInt(7);
		Random ran2 = new Random();
		int col = ran2.nextInt(7)+2;
		switch (num) {
		case 0: tactual= new T_Tetrimino(col);
		setTetrimino(tactual);
		break;
		case 1: tactual= new J_Tetrimino(col);
		setTetrimino(tactual);
		break;
		case 2: tactual= new L_Tetrimino(col);
		setTetrimino(tactual);
		break;
		case 3: tactual= new O_Tetrimino(col);
		setTetrimino(tactual);
		break;
		case 4: tactual= new I_Tetrimino(col);
		setTetrimino(tactual);
		break;
		case 5: tactual= new S_Tetrimino(col);
		setTetrimino(tactual);
		break;
		case 6: tactual= new Z_Tetrimino(col);
		setTetrimino(tactual);
		break;
		}
		return tactual;
	}
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
	}
	
	private void setTetrimino(Tetrimino tr) {
		
		for(int i=1; i<3 && !GameOver; i++) {
			for(int j=4; j<8 && !GameOver; j++) {
				if (tr!=null && tr.getBloquePos(i-1, j-4)!=null) {
					
					if(!grilla[i][j].esSobre())
					{
						GameOver=true;
						GUI2.gameOver();
					}												
					setBloque(tr.getBloquePos(i-1, j-4), i, j);					
					grilla[i][j].setX(i);
					grilla[i][j].setY(j);
					
				}
				
			}
		}
	}
	
	public Tetrimino getSiguiente() {
		return tsiguiente;
	}	
	
	private void moverIzq() {
		tactual.mover(grilla,-1,0);
		GUI2.actualizar();
	}
	
	private void moverDer() {
		tactual.mover(grilla,1,0);
		GUI2.actualizar();
	}
	
	private void descender() {
		if(tactual.mover(grilla, 0, 1))
		{
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
			GUI2.actualizarNext();
			}
		}
		else
			GUI2.actualizar();
				
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	private void setBloque(Bloque b, int f, int c) {
		grilla[f][c] = b;
	}
	
	public Bloque obtenerBloque(int f, int c) {
		return grilla[f][c];
	}
	
	public Tetrimino getTetrimino() {
		return tactual;
	}
	
	
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
	private void bajarBloques(int l) {
		for(int j=l; j>1; j--) {
			for(int i=1; i<11; i++) {
				grilla[j][i] = grilla[j-1][i];
			}
		}
		GUI2.actualizarTodo();
	}
	public void rotar(){
		
		boolean solapado = false;
		int [][] matrizRotada;
		int i,j;
		
		matrizRotada = tactual.rotar();
		
		
		int min=matrizRotada[0][1];
		int max=matrizRotada[0][1];
		
		for( j=0;j<4;j++)
		{
			if (matrizRotada[j][1]<min)
				min=matrizRotada[j][1];
			if (matrizRotada[j][1]>max)
				max=matrizRotada[j][1];
		}
		
		if(min==0)
			for(j=0;j<4;j++) {
				matrizRotada[j][1]+=1;	
			}
		if(min==-1)
			for(j=0;j<4;j++) {
				matrizRotada[j][1]+=2;	
			}
		if(max==11)
			for(j=0;j<4;j++) {
				matrizRotada[j][1]-=1;	
			}
		if(max==12)
			for(j=0;j<4;j++) {
				matrizRotada[j][1]-=2;	
			}
				
		i=0;
		while(!solapado && (i<4) ) {
			
			solapado = Solapa(matrizRotada[i][0],matrizRotada[i][1]);
			i++;			
		}
		
		if (!solapado) {
			for( i=0;i<4;i++) {
				Bloque empty = new Bloque(1);
				grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()]=empty;
			}
			
			for(i=0;i<4;i++)
			{	
				tactual.getBloque(i).setX(matrizRotada[i][0]);
				tactual.getBloque(i).setY(matrizRotada[i][1]);
				grilla[matrizRotada[i][0]][matrizRotada[i][1]]=tactual.getBloque(i);
			}
			
		}
	} 
	
	 private boolean Solapa(int x, int y) {
		
		boolean solapado=false;
		
		if ((x<0) || (x>22) || y<0 || y>11 || (!grilla[x][y].esSobre()))
		solapado = true;
		
		return solapado;
		
	}


	public boolean getGameOver() {
		
		return GameOver;
	} 
	
	
	
	
}
