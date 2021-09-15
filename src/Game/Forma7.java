package Game;

public class Forma7 extends Tetrimino {

	//"S" invertida
	
	public Forma7(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(cubo1, 0, 1);
		setCubo(cubo2, 0, 2);
		setCubo(cubo3, 1, 2);
		setCubo(cubo4, 1, 3);
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		
	}
	
}
