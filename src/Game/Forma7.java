package Game;

public class Forma7 extends Tetrimino {

	//"S" invertida
	
	public Forma7(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 1);
		setCubo(bloques[1], 0, 2);
		setCubo(bloques[2], 1, 2);
		setCubo(bloques[3], 1, 3);
	}

	@Override
	public void rotar() {
		
	}
	
}
