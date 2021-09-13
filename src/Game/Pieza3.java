package Game;

public class Pieza3 extends Pieza{

	//"L" invertida,
	
	public void acomodarCubos() {
		setCubo(cubo1, 1, 1);
		setCubo(cubo2, 2, 1);
		setCubo(cubo1, 3, 1);
		setCubo(cubo1, 3, 0);
	}

}
