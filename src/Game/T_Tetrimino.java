package Game;

import javax.swing.ImageIcon;

public class T_Tetrimino extends Tetrimino {
	
	// "Pirámide".
	
	public T_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
		figuras = new String[] {"/Texturas/Tetriminos/T/T_rojo.png","/Texturas/Tetriminos/T/T_verde.png","/Texturas/Tetriminos/T/T_azul.png","/Texturas/Tetriminos/T/T_amarillo.png","/Texturas/Tetriminos/T/T_violeta.png","/Texturas/Tetriminos/T/T_celeste.png","/Texturas/Tetriminos/T/T_naranja.png"};
		imagen = new ImageIcon(getClass().getResource(figuras[rndm-2]));
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 2);
		setCubo(bloques[1], 1, 1);
		setCubo(bloques[2], 1, 2);
		setCubo(bloques[3], 1, 3);
		ejeDeRotacion = 2;
	}
}
