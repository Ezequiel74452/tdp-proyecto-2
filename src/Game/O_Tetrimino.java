package Game;

import javax.swing.ImageIcon;

public class O_Tetrimino extends Tetrimino {

	//"Cuadrado".
	
	public O_Tetrimino(Bloque w, Bloque x, Bloque y, Bloque z, int rotacion, Grilla grilla) {
		super(w, x, y, z, rotacion, grilla);
	}
	
	public void ocuparBloques() {
		w.ocupar(BloqueGraficoAmarillo);
		x.ocupar(BloqueGraficoAmarillo);
		y.ocupar(BloqueGraficoAmarillo);
		z.ocupar(BloqueGraficoAmarillo);	
	}
	
	public void acomodarCubos(Grilla grilla) {
		grilla.setBloque( 1, 5,(bloques[0]));
		bloques[0].setX(1);
		bloques[0].setY(5);
		grilla.setBloque( 2, 5,(bloques[1]));
		bloques[1].setX(2);
		bloques[1].setY(5);
		grilla.setBloque( 1, 6,(bloques[2]));
		bloques[2].setX(1);
		bloques[2].setY(6);
		grilla.setBloque( 2, 6,(bloques[3]));
		bloques[3].setX(2);
		bloques[3].setY(6);
		ejeDeRotacion = 2;
	}
	
	public boolean checkGameOver(Grilla grilla) {
		if(!grilla.getBloque(1, 5).esSobre())
			return true;
		grilla.setBloque( 1, 5,(bloques[0]));
		bloques[0].setX(1);
		bloques[0].setY(5);
		if(!grilla.getBloque(2, 5).esSobre())
			return true;
		grilla.setBloque( 2, 5,(bloques[1]));
		bloques[1].setX(2);
		bloques[1].setY(5);
		if(!grilla.getBloque(1, 6).esSobre())
			return true;
		grilla.setBloque( 1, 6,(bloques[2]));
		bloques[2].setX(1);
		bloques[2].setY(6);
		if(!grilla.getBloque(2, 6).esSobre())
			return true;
		grilla.setBloque( 2, 6,(bloques[3]));
		bloques[3].setX(2);
		bloques[3].setY(6);
		ejeDeRotacion = 2;
		return false;
	}
	
	public void rotar(Grilla grilla){
		
	}
}
