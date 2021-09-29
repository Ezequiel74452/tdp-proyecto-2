package Game;

public class S_Tetrimino extends Tetrimino {

	//"S"
	
	public S_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 2);
		setCubo(bloques[1], 0, 3);
		setCubo(bloques[2], 1, 1);
		setCubo(bloques[3], 1, 2);
		ejeDeRotacion = 3;
	}
}
