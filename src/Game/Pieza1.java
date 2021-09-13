package Game;

public class Pieza1 extends Pieza {
	
	// "Pirámide".
	
	public void acomodarCubos() {
		setCubo(cubo1, 3, 0);
		setCubo(cubo2, 3, 1);
		setCubo(cubo3, 3, 2);
		setCubo(cubo4, 2, 1);
	}
}
