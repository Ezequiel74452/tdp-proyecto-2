package Game;

import java.awt.Image;

public abstract class Pieza {

	//Parámetros y métodos de referencia, es posible que el tipo de la textura y color cambien así como los métodos que dependen de estos.
	protected Cubo[][] pieza; 
	protected Image textura;
	protected String color;
	protected Cubo cubo1, cubo2, cubo3, cubo4;
	
	public Image getTextura() {
		return textura;
	}
	public void setTextura(String color) {
		switch (color) {
		case "Rojo": textura = texturaRoja.png;
		break;
		case "Amarillo": textura = texturaAmarilla.png;
		break;
		case "Azul": textura = texturaAzul.png;
		break;
		case "Verde": textura = texturaVerde.png;
		}
	}
	public String getColor() {
		return color;
	}
	public void setColor(int num) {
		switch (num) {
		case 1: color = "Rojo";
		break;
		case 2: color = "Amarillo";
		break;
		case 3: color = "Azul";
		break;
		case 4: color = "Verde";
		}
	}
	public void setCubo(Cubo cu, int f, int c) {
		pieza[f][c] = cu;
	}
	private void eliminarFila(int pos) {
		for (int i=0; i<pieza[pos].length; i++) {
			pieza[pos][i] = null;
		}
	}
	public void eliminarFilas(int cant) {
		// Probablemente puede mejorarse si se implementa recursivamente.
		if (cant == 1) {
			eliminarFila(3);
		}
		if (cant == 2) {
			eliminarFila(3);
			eliminarFila(2);
		}
		if (cant == 3) {
			eliminarFila(3);
			eliminarFila(2);
			eliminarFila(1);
		}
		if (cant == 3) {
			eliminarFila(3);
			eliminarFila(2);
			eliminarFila(1);
			eliminarFila(0);
		}
	}
	public abstract void acomodarCubos();
	
}
