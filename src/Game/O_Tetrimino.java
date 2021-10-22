package Game;



import bloquesGraficos.*;

public class O_Tetrimino extends Tetrimino {

	//"Cuadrado".
	
	public O_Tetrimino(Bloque w, Bloque x, Bloque y, Bloque z, int rotacion, Grilla grilla) {
		super(w, x, y, z, rotacion, grilla);
	}
	
	public void ocuparBloques() {
		BloqueGrafico amarillo = new BloqueAmarillo();
		w.ocupar(amarillo);
		x.ocupar(amarillo);
		y.ocupar(amarillo);
		z.ocupar(amarillo);	
	}
	
	
	public void rotar() {
	
	}
	
	
	public void moverIzq() {
		//Obtengo los bloques a la izquierda del tetrimino						
		Bloque izquierdaW = grilla.getBloque(w.getX(), w.getY()-1);	
		Bloque izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
		
		//No importa la rotacion
		if(izquierdaW.ocupado() == false && izquierdaY.ocupado() == false){
			swap(w, izquierdaW);
			swap(y, izquierdaY);
			Bloque izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
			Bloque izquierdaZ = grilla.getBloque(z.getX(), z.getY()-1);
			swap(x, izquierdaX);
			swap(z, izquierdaZ);
		}
	}
	
	public void moverDer() {
		//Obtengo los bloques a la derecha del tetrimino
		Bloque derechaX = grilla.getBloque(x.getX(), x.getY()+1);
		Bloque derechaZ = grilla.getBloque(z.getX(), z.getY()+1);
		
		//No importa la rotacion
		if(derechaX.ocupado() == false && derechaZ.ocupado() == false){
			swap(x, derechaX);
			swap(z, derechaZ);
			Bloque derechaW = grilla.getBloque(w.getX(), w.getY()+1);
			Bloque derechaY = grilla.getBloque(y.getX(), y.getY()+1);
			swap(w, derechaW);
			swap(y, derechaY);
		}
					
	}


	
}
