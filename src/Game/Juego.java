package Game;

import java.util.Random;

public class Juego {
	
	private Bloque[][] grilla;
	private int puntos;
	private Tetrimino tactual;
	
	public Juego() {
		grilla = new Bloque[23][12];
		crearPerimetro();
		crearGrillaInicial();
		puntos = 0;
		tactual = null;
	}
	
	private void crearPerimetro() {
		Bloque borde = new Bloque(0, true);
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
		Bloque empty = new Bloque(1, false);
		for(int i=0; i<23; i++) {
			for(int j=0; j<12; j++) {
				if(grilla[i][j] == null) {
					grilla[i][j] = empty;
				}
			}
		}
	}
	
	public void crearTetrimino() {
		Random ran = new Random();
		int num = ran.nextInt(7);
		Random ran2 = new Random();
		int col = ran2.nextInt(7)+2;
		switch (num) {
		case 0: tactual= new Forma1(col);
		setTetrimino();
		break;
		case 1: tactual= new Forma2(col);
		setTetrimino();
		break;
		case 2: tactual= new Forma3(col);
		setTetrimino();
		break;
		case 3: tactual= new Forma4(col);
		setTetrimino();
		break;
		case 4: tactual= new Forma5(col);
		setTetrimino();
		break;
		case 5: tactual= new Forma6(col);
		setTetrimino();
		break;
		case 6: tactual= new Forma7(col);
		setTetrimino();
		break;
		}
	}
	
	private void setTetrimino() {
		for(int i=1; i<3; i++) {
			for(int j=4; j<8; j++) {
				if (tactual!=null && tactual.getBloque(i-1, j-4)!=null) {
					setBloque(tactual.getBloque(i-1, j-4), i, j);
				}
			}
		}
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
}
