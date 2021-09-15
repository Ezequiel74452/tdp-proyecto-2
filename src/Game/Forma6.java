package Game;

public class Forma6 extends Tetrimino {

	//"S"
	
	public Forma6(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(cubo1, 0, 2);
		setCubo(cubo2, 0, 3);
		setCubo(cubo3, 1, 1);
		setCubo(cubo4, 1, 2);
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		
	}
	
}
