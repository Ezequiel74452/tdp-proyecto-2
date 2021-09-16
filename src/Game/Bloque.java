package Game;

import javax.swing.ImageIcon;

public class Bloque {
	
	private String[] imagenes;
	private ImageIcon textura;
	private boolean hayBloque;
	private boolean recienPuesto;
	private int x, y;
	
	public Bloque(int posArr, boolean hay) {
		hayBloque = hay;
		imagenes = new String[] {"/Texturas/Gris.png", "/Texturas/Empty.png", "/Texturas/Rojo.png", "/Texturas/Verde.png", "/Texturas/Azul.png", "/Texturas/Amarillo.png", "/Texturas/Violeta.png", "/Texturas/Celeste.png", "/Texturas/Naranja.png"};
		if (hayBloque) {
			textura = new ImageIcon(getClass().getResource(imagenes[posArr]));
			if (posArr != 0) {
				recienPuesto = true;
			}
		} else {
			textura = new ImageIcon(getClass().getResource(imagenes[1]));
		}
		
	}

	public ImageIcon getTextura() {
		return textura;
	}
	
	public boolean hayBloque() {
		return hayBloque;
	}
	
	public boolean getRecienPuesto() {
		return recienPuesto;
	}
	
	public void setRecienPuesto(boolean rp) {
		recienPuesto = rp;
	}
	
	public void setX(int xx) {
		x = xx;
	}
	
	public void setY(int yy) {
		y = yy;
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
