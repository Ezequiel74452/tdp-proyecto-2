package Game;

import javax.swing.ImageIcon;

public class L_Tetrimino extends Tetrimino {

	//"L" invertida,
	
	public L_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
		figuras = new String[] {"/Texturas/Tetriminos/L/L_rojo.png","/Texturas/Tetriminos/L/L_verde.png","/Texturas/Tetriminos/L/L_azul.png","/Texturas/Tetriminos/L/L_amarillo.png","/Texturas/Tetriminos/L/L_violeta.png","/Texturas/Tetriminos/L/L_celeste.png","/Texturas/Tetriminos/L/L_naranja.png"};
		imagen = new ImageIcon(getClass().getResource(figuras[rndm-2]));
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 1);
		setCubo(bloques[1], 0, 2);
		setCubo(bloques[2], 0, 3);
		setCubo(bloques[3], 1, 3);
		ejeDeRotacion = 1;
	}
}