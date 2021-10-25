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
		
		if(rotacion == 0) {
			if(izquierdaW.ocupado() == false && izquierdaX.ocupado() == false) {
				swap(w, izquierdaW);
				swap(x, izquierdaX);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
				swap(y, izquierdaY);
				izquierdaZ = grilla.getBloque(z.getX(), z.getY()-1);
				swap(z, izquierdaZ);
			}
		}
		
		if(rotacion == 1) {
			if(izquierdaX.ocupado() == false && izquierdaY.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(x, izquierdaX);
				swap(y, izquierdaY);
				swap(z, izquierdaZ);
				izquierdaW = grilla.getBloque(w.getX(), w.getY()-1);
				swap(w, izquierdaW);
			}
		}
		
		if(rotacion == 2) {
			if(izquierdaW.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(w, izquierdaW);
				swap(z, izquierdaZ);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
				swap(y, izquierdaY);
				izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
				swap(x, izquierdaX);
			}
		}
		
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
			if(derechaW.ocupado() == false && derechaZ.ocupado() == false) {
				swap(w, derechaW);
				swap(z, derechaZ);
				derechaY = grilla.getBloque(y.getX(), y.getY()+1);
				swap(y, derechaY);
				derechaX = grilla.getBloque(x.getX(), x.getY()+1);
				swap(x, derechaX);
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
			if(derechaW.ocupado() == false && derechaX.ocupado() == false) {
				swap(w, derechaW);
				swap(x, derechaX);
				derechaY = grilla.getBloque(y.getX(), y.getY()+1);
				swap(y, derechaY);
				derechaZ = grilla.getBloque(z.getX(), z.getY()+1);
				swap(z, derechaZ);
			}
		}
		
		//Roto 270 grados
		if(rotacion == 3) {
			if(derechaX.ocupado() == false && derechaY.ocupado() == false && derechaZ.ocupado() == false) {
				swap(x, derechaX);
				swap(y, derechaY);
				swap(z, derechaZ);
				derechaW = grilla.getBloque(w.getX(), w.getY()+1);
				swap(w, derechaW);
			}
		}
	}

	@Override
	public void rotar() {
		// TODO Auto-generated method stub
		Bloque rotaW, rotaX, rotaZ;	
		
		if(rotacion == 0){
			rotaZ = grilla.getBloque(z.getX()+1, z.getY()-1);
			rotaW = grilla.getBloque(w.getX()+2, w.getY());
			rotaX = grilla.getBloque(x.getX()-1, x.getY()+1);
			if(rotaZ.ocupado() == false && rotaW.ocupado() == false && rotaX.ocupado() == false) {
				swap(z, rotaZ);
				swap(w, rotaW);
				swap(x, rotaX);
				rotacion++;
			}
		}
		
		else if(rotacion == 1) {
			rotaZ = grilla.getBloque(z.getX()-1, z.getY()-1);
			rotaW = grilla.getBloque(w.getX(), w.getY()-2);
			rotaX = grilla.getBloque(x.getX()+1, x.getY()+1);
			if(rotaZ.ocupado() == false && rotaW.ocupado() == false && rotaX.ocupado() == false) {
				swap(z, rotaZ);
				swap(x, rotaX);
				swap(w, rotaW);
				rotacion++;
			}
		}
		
		else if(rotacion == 2) {
			rotaZ = grilla.getBloque(z.getX()-1, z.getY()+1);
			rotaW = grilla.getBloque(w.getX()-2, w.getY());
			rotaX = grilla.getBloque(x.getX()+1, x.getY()-1);
			if(rotaZ.ocupado() == false && rotaW.ocupado() == false && rotaX.ocupado() == false) {
				swap(z, rotaZ);
				swap(x, rotaX);
				swap(w, rotaW);
				rotacion++;
			}
		}
		
		else if(rotacion == 3) {
			rotaZ = grilla.getBloque(z.getX()+1, z.getY()+1);
			rotaW = grilla.getBloque(w.getX(), w.getY()+2);
			rotaX = grilla.getBloque(x.getX()-1, x.getY()-1);
			if(rotaZ.ocupado() == false && rotaW.ocupado() == false && rotaX.ocupado() == false) {
				swap(z, rotaZ);
				swap(x, rotaX);
				swap(w, rotaW);
				rotacion = 0;
			}
		}
	}

	@Override
	protected boolean descender() {
		// TODO Auto-generated method stub
		boolean toreturn = false;
		//Obtengo los bloques abajo del tetrimino
		Bloque abajoW = grilla.getBloque(w.getX()+1, w.getY());
		Bloque abajoX = grilla.getBloque(x.getX()+1, x.getY());
		Bloque abajoY = grilla.getBloque(y.getX()+1, y.getY());
		Bloque abajoZ = grilla.getBloque(z.getX()+1, z.getY());
		
		if(rotacion == 0) {
			if(abajoX.ocupado() == false && abajoZ.ocupado() == false && abajoY.ocupado() == false){
				swap(y, abajoY);
				swap(z, abajoZ);
				swap(x, abajoX);
				abajoW = grilla.getBloque(w.getX()+1, w.getY());
				swap(w, abajoW);
				toreturn = true;
			}
		}
		
		if(rotacion == 1) {
			if(abajoW.ocupado() == false && abajoZ.ocupado() == false){
				swap(z, abajoZ);
				swap(w, abajoW);
				abajoY = grilla.getBloque(y.getX()+1, y.getY());
				swap(y, abajoY);
				abajoX = grilla.getBloque(x.getX()+1, x.getY());
				swap(x, abajoX);
				toreturn = true;
			}
		}
		
		if(rotacion == 2) {
			if(abajoX.ocupado() == false && abajoY.ocupado() == false && abajoW.ocupado() == false){
				swap(w, abajoW);
				swap(x, abajoX);
				swap(y, abajoY);
				abajoZ = grilla.getBloque(z.getX()+1, z.getY());
				swap(z, abajoZ);
				toreturn = true;
			}
		}
		
		if(rotacion == 3) {
			if(abajoX.ocupado() == false && abajoW.ocupado() == false){
				swap(w, abajoW);
				swap(x, abajoX);
				abajoY = grilla.getBloque(y.getX()+1, y.getY());
				swap(y, abajoY);
				abajoZ = grilla.getBloque(z.getX()+1, z.getY());
				swap(z, abajoZ);
				toreturn = true;
			}
		}
		
		return toreturn;
	}
}