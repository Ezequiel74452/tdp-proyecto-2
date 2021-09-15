package Game;

public class Forma5 extends Tetrimino {
	
	//"I".
	
	public Forma5(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(cubo1, 0, 0);
		setCubo(cubo2, 0, 1);
		setCubo(cubo3, 0, 2);
		setCubo(cubo4, 0, 3);
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		
	}
}
