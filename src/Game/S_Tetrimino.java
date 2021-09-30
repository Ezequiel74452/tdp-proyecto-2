package Game;

import javax.swing.ImageIcon;

public class S_Tetrimino extends Tetrimino {

	//"S"
	
	public S_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
		figuras = new String[] {"/Texturas/Tetriminos/S/S_rojo.png","/Texturas/Tetriminos/S/S_verde.png","/Texturas/Tetriminos/S/S_azul.png","/Texturas/Tetriminos/S/S_amarillo.png","/Texturas/Tetriminos/S/S_violeta.png","/Texturas/Tetriminos/S/S_celeste.png","/Texturas/Tetriminos/S/S_naranja.png"};
		imagen = new ImageIcon(getClass().getResource(figuras[rndm-2]));
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 2);
		setCubo(bloques[1], 0, 3);
		setCubo(bloques[2], 1, 1);
		setCubo(bloques[3], 1, 2);
		ejeDeRotacion = 3;
	}
}
