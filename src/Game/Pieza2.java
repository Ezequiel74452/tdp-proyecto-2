package Game;

public class Pieza2 extends Pieza {
	
	//"L"
	
	public void acomodarCubos() {
		setCubo(cubo1, 1, 0);
		setCubo(cubo2, 2, 0);
		setCubo(cubo1, 3, 0);
		setCubo(cubo1, 3, 1);
	}

}
