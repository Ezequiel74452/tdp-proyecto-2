package Game;

import javax.swing.ImageIcon;

public class Bloque {
	
	private String[] imagenes;
	private ImageIcon textura;
	private boolean sobre;
	private int x, y;
	
	public Bloque(int posArr) {
		imagenes = new String[] {"/Texturas/Bloques/Gris.png", "/Texturas/Bloques/Empty.png", "/Texturas/Bloques/Rojo.png", "/Texturas/Bloques/Verde.png", "/Texturas/Bloques/Azul.png", "/Texturas/Bloques/Amarillo.png", "/Texturas/Bloques/Violeta.png", "/Texturas/Bloques/Celeste.png", "/Texturas/Bloques/Naranja.png"};
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
