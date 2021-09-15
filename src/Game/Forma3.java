package Game;

public class Forma3 extends Tetrimino {

	//"L" invertida,
	
	public Forma3(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(cubo1, 0, 1);
		setCubo(cubo2, 0, 2);
		setCubo(cubo3, 0, 3);
		setCubo(cubo4, 1, 3);
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		
	}

}