package Game;

public class Forma4 extends Tetrimino {

	//"Cuadrado".
	
	public Forma4(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(cubo1, 0, 1);
		setCubo(cubo2, 0, 2);
		setCubo(cubo3, 1, 1);
		setCubo(cubo4, 1, 2);
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		
	}
	
}
