package Game;

public class T_Tetrimino extends Tetrimino {
	
	// "Pirámide".
	
	public T_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 2);
		setCubo(bloques[1], 1, 1);
		setCubo(bloques[2], 1, 2);
		setCubo(bloques[3], 1, 3);
		ejeDeRotacion = 2;
	}
}
