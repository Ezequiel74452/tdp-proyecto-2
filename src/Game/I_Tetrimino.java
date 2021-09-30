package Game;

import javax.swing.ImageIcon;

public class I_Tetrimino extends Tetrimino {
	
	//"I".
	
	public I_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
		figuras = new String[] {"/Texturas/Tetriminos/I/I_rojo.png","/Texturas/Tetriminos/I/I_verde.png","/Texturas/Tetriminos/I/I_azul.png","/Texturas/Tetriminos/I/I_amarillo.png","/Texturas/Tetriminos/I/I_violeta.png","/Texturas/Tetriminos/I/I_celeste.png","/Texturas/Tetriminos/I/I_naranja.png"};
		imagen = new ImageIcon(getClass().getResource(figuras[rndm-2]));
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 0);
		setCubo(bloques[1], 0, 1);
		setCubo(bloques[2], 0, 2);
		setCubo(bloques[3], 0, 3);
		ejeDeRotacion = 2;
	}
}
