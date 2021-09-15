package Game;

import javax.swing.ImageIcon;

public class Bloque {
	
	private String[] imagenes;
	private ImageIcon textura;
	private boolean hayBloque;
	
	public Bloque(int pos, boolean hay) {
		hayBloque = hay;
		imagenes = new String[] {"/Texturas/Gris.png", "/Texturas/Empty.png", "/Texturas/Rojo.png", "/Texturas/Verde.png", "/Texturas/Azul.png", "/Texturas/Amarillo.png", "/Texturas/Violeta.png", "/Texturas/Celeste.png", "/Texturas/Naranja.png"};
		if (hayBloque) {
			textura = new ImageIcon(getClass().getResource(imagenes[pos]));
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
	
}
