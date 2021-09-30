package Game;

import javax.swing.ImageIcon;

public class Z_Tetrimino extends Tetrimino {

	//"S" invertida
	
	public Z_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
		figuras = new String[] {"/Texturas/Tetriminos/Z/Z_rojo.png","/Texturas/Tetriminos/Z/Z_verde.png","/Texturas/Tetriminos/Z/Z_azul.png","/Texturas/Tetriminos/Z/Z_amarillo.png","/Texturas/Tetriminos/Z/Z_violeta.png","/Texturas/Tetriminos/Z/Z_celeste.png","/Texturas/Tetriminos/Z/Z_naranja.png"};
		imagen = new ImageIcon(getClass().getResource(figuras[rndm-2]));
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 1);
		setCubo(bloques[1], 0, 2);
		setCubo(bloques[2], 1, 2);
		setCubo(bloques[3], 1, 3);
		ejeDeRotacion = 2;
	}
}
