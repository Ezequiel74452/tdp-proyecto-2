package Game;

public class J_Tetrimino extends Tetrimino {
	
	//"L"
	
	public J_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 3);
		setCubo(bloques[1], 1, 1);
		setCubo(bloques[2], 1, 2);
		setCubo(bloques[3], 1, 3);
		ejeDeRotacion = 2;
	}
}
