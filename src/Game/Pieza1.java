package Game;

public class Pieza1 extends Pieza {
	
	// "Pirámide".
	
	public void acomodarCubos() {
		setCubo(cubo1, 3, 0);
		setCubo(cubo2, 3, 1);
		setCubo(cubo1, 3, 2);
		setCubo(cubo1, 2, 1);
	}
}
