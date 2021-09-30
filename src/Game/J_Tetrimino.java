package Game;

import javax.swing.ImageIcon;

public class J_Tetrimino extends Tetrimino {
	
	//"L"
	
	public J_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
		figuras = new String[] {"/Texturas/Tetriminos/J/J_rojo.png","/Texturas/Tetriminos/J/J_verde.png","/Texturas/Tetriminos/J/J_azul.png","/Texturas/Tetriminos/J/J_amarillo.png","/Texturas/Tetriminos/J/J_violeta.png","/Texturas/Tetriminos/J/J_celeste.png","/Texturas/Tetriminos/J/J_naranja.png"};
		imagen = new ImageIcon(getClass().getResource(figuras[rndm-2]));
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 3);
		setCubo(bloques[1], 1, 1);
		setCubo(bloques[2], 1, 2);
		setCubo(bloques[3], 1, 3);
		ejeDeRotacion = 2;
	}
}
