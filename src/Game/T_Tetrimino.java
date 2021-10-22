package Game;

import bloquesGraficos.BloqueCeleste;
import bloquesGraficos.BloqueGrafico;

public class T_Tetrimino extends Tetrimino {
	
	//"T"
	public T_Tetrimino(Bloque w, Bloque x, Bloque y, Bloque z, int rotacion, Grilla grilla) {
		super(w, x, y, z, rotacion, grilla);
	}

	@Override
	public void ocuparBloques() {
		// TODO Auto-generated method stub
		BloqueGrafico celeste = new BloqueCeleste();
		w.ocupar(celeste);
		x.ocupar(celeste);
		y.ocupar(celeste);
		z.ocupar(celeste);	
	}

	@Override
	public void moverIzq() {
		//Obtengo los bloques a la izquierda del tetrimino
		Bloque izquierdaW = grilla.getBloque(w.getX(), w.getY()-1);
		Bloque izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
		Bloque izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
		Bloque izquierdaZ = grilla.getBloque(z.getX(), z.getY()-1);					
																   					
		//Si no esta rotado
		if(rotacion == 0) {
			if(izquierdaW.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(w, izquierdaW);
				swap(z, izquierdaZ);
				izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
				swap(x, izquierdaX);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
				swap(y, izquierdaY);
			}
		}

		//para 90 grados
		if(rotacion == 1) {
			if(izquierdaZ.ocupado() == false && izquierdaW.ocupado() == false && izquierdaY.ocupado() == false) {
				swap(z, izquierdaZ);
				swap(w, izquierdaW);
				swap(y, izquierdaY);
				izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
				swap(x, izquierdaX);
			}
		}
		
		//Roto 180 grados
		if(rotacion == 2) {
			if(izquierdaZ.ocupado() == false && izquierdaY.ocupado() == false) {
				swap(y, izquierdaY);
				swap(z, izquierdaZ);
				izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
				swap(x, izquierdaX);
				izquierdaW = grilla.getBloque(w.getX(), w.getY()-1);
				swap(w, izquierdaW);
			}
		}
		//para 270 grados
		if(rotacion == 3) {
			if(izquierdaX.ocupado() == false && izquierdaW.ocupado() == false && izquierdaY.ocupado() == false) {
				swap(w, izquierdaW);
				swap(x, izquierdaX);
				swap(y, izquierdaY);
				izquierdaZ = grilla.getBloque(z.getX(), z.getY()-1);
				swap(z, izquierdaZ);
			}
		}
	}

	@Override
	public void moverDer() {
		//Obtengo los bloques a la derecha del tetrimino
		Bloque derechaW = grilla.getBloque(w.getX(), w.getY()+1);
		Bloque derechaX = grilla.getBloque(x.getX(), x.getY()+1);
		Bloque derechaY = grilla.getBloque(y.getX(), y.getY()+1);					
		Bloque derechaZ = grilla.getBloque(z.getX(), z.getY()+1);						
																 				
		//Si no roto
		if(rotacion == 0) {
			if(derechaY.ocupado() == false && derechaZ.ocupado() == false) {
				swap(y, derechaY);
				swap(z, derechaZ);
				derechaX = grilla.getBloque(x.getX(), x.getY()+1);
				swap(x, derechaX);
				derechaW = grilla.getBloque(w.getX(), w.getY()+1);
				swap(w, derechaW);
			}
		}
		
		//Roto 90 grados
		if(rotacion == 1) {
			if(derechaW.ocupado() == false && derechaX.ocupado() == false && derechaY.ocupado() == false) {
				swap(w, derechaW);
				swap(x, derechaX);
				swap(y, derechaY);
				derechaZ = grilla.getBloque(z.getX(), z.getY()+1);
				swap(z, derechaZ);
			}
		}
		//Roto 180 grados
		if(rotacion == 2) {
			if(derechaW.ocupado() == false && derechaZ.ocupado() == false) {
				swap(w, derechaW);
				swap(z, derechaZ);
				derechaX = grilla.getBloque(x.getX(), x.getY()+1);
				swap(x, derechaX);
				derechaY = grilla.getBloque(y.getX(), y.getY()+1);
				swap(y, derechaY);
			}
		}
		
		//Roto 270 grados
		if(rotacion == 3) {
			if(derechaW.ocupado() == false && derechaY.ocupado() == false && derechaZ.ocupado() == false) {
				swap(z, derechaZ);
				swap(w, derechaW);
				swap(y, derechaY);
				derechaX = grilla.getBloque(x.getX(), x.getY()+1);
				swap(x, derechaX);
			}
		}
	}
}
