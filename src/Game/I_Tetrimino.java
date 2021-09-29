package Game;

public class I_Tetrimino extends Tetrimino {
	
	//"I".
	
	public I_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 0);
		setCubo(bloques[1], 0, 1);
		setCubo(bloques[2], 0, 2);
		setCubo(bloques[3], 0, 3);
		ejeDeRotacion = 2;
	}
}
