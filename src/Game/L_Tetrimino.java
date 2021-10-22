package Game;

import bloquesGraficos.BloqueGrafico;
import bloquesGraficos.BloqueVerde;

public class L_Tetrimino extends Tetrimino {
	//"L"
	public L_Tetrimino(Bloque w, Bloque x, Bloque y, Bloque z, int rotacion, Grilla grilla) {
		super(w, x, y, z, rotacion, grilla);
	}

	@Override
	public void ocuparBloques() {
		// TODO Auto-generated method stub
		BloqueGrafico verde = new BloqueVerde();
		w.ocupar(verde);
		x.ocupar(verde);
		y.ocupar(verde);
		z.ocupar(verde);
	}

	@Override
	public void moverIzq() {
		// TODO Auto-generated method stub
		//Obtengo los bloques a la izquierda del tetrimino
		Bloque izquierdaW = grilla.getBloque(w.getX(), w.getY()-1);
		Bloque izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
		Bloque izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
		Bloque izquierdaZ = grilla.getBloque(z.getX(), z.getY()-1);
		
		//Si no roto
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
		
		//Roto 90 grados
		if(rotacion == 1) {
			if(izquierdaX.ocupado() == false && izquierdaW.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(x, izquierdaX);
				swap(w, izquierdaW);
				swap(z, izquierdaZ);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
				swap(y, izquierdaY);

			}
		}
		
		//Roto 180 grados
		if(rotacion == 2) {
			if(izquierdaY.ocupado() == false && izquierdaZ.ocupado() == false) {

				swap(y, izquierdaY);
				swap(z, izquierdaZ);
				izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
				swap(x, izquierdaX);
				izquierdaW = grilla.getBloque(w.getX(), w.getY()-1);
				swap(w, izquierdaW);
			}
		}
		
		//Roto 270 grados
		if(rotacion == 3) {
			if(izquierdaW.ocupado() == false && izquierdaX.ocupado() == false && izquierdaY.ocupado() == false) {
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
		// TODO Auto-generated method stub
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
			if(derechaX.ocupado() == false && derechaW.ocupado() == false && derechaZ.ocupado() == false) {
				swap(x, derechaX);
				swap(w, derechaW);
				swap(z, derechaZ);
				derechaY = grilla.getBloque(y.getX(), y.getY()+1);
				swap(y, derechaY);
			}
		}
	}
}