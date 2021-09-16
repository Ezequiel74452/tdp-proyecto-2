package Game;

public class Forma6 extends Tetrimino {

	//"S"
	
	public Forma6(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 2);
		setCubo(bloques[1], 0, 3);
		setCubo(bloques[2], 1, 1);
		setCubo(bloques[3], 1, 2);
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		
	}
	
}
