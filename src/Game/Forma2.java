package Game;

public class Forma2 extends Tetrimino {
	
	//"L"
	
	public Forma2(int rndm) {
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
