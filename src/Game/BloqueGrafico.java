package Game;

import javax.swing.ImageIcon;

//Almacena la textura correspondiente segun este instanciado, se encarga de la parte grafica del bloque
public abstract class BloqueGrafico {
	protected ImageIcon textura;
	protected final String[] texturas = {"/Texturas/Bloques/Gris.png", "/Texturas/Bloques/Empty.png", "/Texturas/Bloques/Rojo.png", "/Texturas/Bloques/Verde.png", "/Texturas/Bloques/Azul.png", "/Texturas/Bloques/Amarillo.png", "/Texturas/Bloques/Violeta.png", "/Texturas/Bloques/Celeste.png", "/Texturas/Bloques/Naranja.png"};
	
	public BloqueGrafico(int color) {
		this.textura = new ImageIcon(getClass().getResource(texturas[color]));;
		// TODO Auto-generated constructor stub
	}


	public ImageIcon getTextura() {
		return textura;
	}
	
}
