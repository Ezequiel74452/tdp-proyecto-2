package Game;

public class Forma2 extends Tetrimino {
	
	//"L"
	
	public Forma2(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(cubo1, 0, 3);
		setCubo(cubo2, 1, 1);
		setCubo(cubo3, 1, 2);
		setCubo(cubo4, 1, 3);
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		
	}

}
