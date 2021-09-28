package Game;

import javax.swing.ImageIcon;

public class Bloque {
	
	private String[] imagenes;
	private ImageIcon textura;
	private boolean sobre;
	private int x, y;
	
	public Bloque(int posArr) {
		imagenes = new String[] {"/Texturas/Gris.png", "/Texturas/Empty.png", "/Texturas/Rojo.png", "/Texturas/Verde.png", "/Texturas/Azul.png", "/Texturas/Amarillo.png", "/Texturas/Violeta.png", "/Texturas/Celeste.png", "/Texturas/Naranja.png"};
		textura = new ImageIcon(getClass().getResource(imagenes[posArr]));
		if (posArr == 0) {
			sobre = false;
		} else {
			sobre = true;
		}
		
	}

	public ImageIcon getTextura() {
		return textura;
	}
	
	public boolean esSobre() {
		return sobre;
	}
	
	public void setSobre(boolean rp) {
		sobre = rp;
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
