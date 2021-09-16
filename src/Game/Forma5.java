package Game;

public class Forma5 extends Tetrimino {
	
	//"I".
	
	public Forma5(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 0);
		setCubo(bloques[1], 0, 1);
		setCubo(bloques[2], 0, 2);
		setCubo(bloques[3], 0, 3);
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		
	}
}
