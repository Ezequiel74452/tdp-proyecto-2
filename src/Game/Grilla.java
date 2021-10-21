package Game;



public class Grilla {

	protected Bloque[][] grilla;
	
	public Grilla() {
			
			grilla = new Bloque[23][12];
			
			//crear bordes
			Bloque borde = new Bloque(0);
			for (int i=0; i<23; i++) {
				grilla[i][0] = borde;
				grilla[i][11] = borde;
			}
			for (int j=1; j<11; j++) {
				grilla[0][j] = borde;
				grilla[22][j] = borde;
			}
			
			//crear resto de bloques
			Bloque empty = new Bloque(1);
			for(int i=1; i<22; i++) 
				for(int j=1; j<11; j++) 
					grilla[i][j] = empty;	
	
	}
	
	public void setBloque( int f, int c, Bloque b) {
		grilla[f][c] = b;
	}
	
	public Bloque getBloque(int f, int c) {
		return grilla[f][c];
	}

	public Tetrimino setTetrimino(int forma, int color) {
		
		Tetrimino tetrimino; 
		
		switch (forma) {
		case 0: tetrimino= new T_Tetrimino(color);
		break;
		case 1: tetrimino= new J_Tetrimino(color);
		break;
		case 2: tetrimino= new L_Tetrimino(color);
		break;
		case 3: tetrimino= new O_Tetrimino(color);
		break;
		case 4: tetrimino= new I_Tetrimino(color);
		break;
		case 5: tetrimino= new S_Tetrimino(color);
		break;
		case 6: tetrimino= new Z_Tetrimino(color);
		break;
		default: tetrimino= new I_Tetrimino(color);
		}
		return tetrimino;
	}

}
