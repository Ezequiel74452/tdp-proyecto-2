package Game;

import bloquesGraficos.BloqueGrafico;
import bloquesGraficos.BloqueRojo;

public class S_Tetrimino extends Tetrimino {
	//"S"
	public S_Tetrimino(Bloque w, Bloque x, Bloque y, Bloque z, int rotacion, Grilla grilla) {
		super(w, x, y, z, rotacion, grilla);
	}

	@Override
	public void ocuparBloques() {
		// TODO Auto-generated method stub
		BloqueGrafico rojo = new BloqueRojo();
		w.ocupar(rojo);
		x.ocupar(rojo);
		y.ocupar(rojo);
		z.ocupar(rojo);
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
			if(izquierdaW.ocupado() == false && izquierdaY.ocupado() == false) {
				swap(w, izquierdaW);
				swap(y, izquierdaY);
				izquierdaZ = grilla.getBloque(z.getX(), z.getY()-1);
				swap(z, izquierdaZ);
				izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
				swap(x, izquierdaX);
			}
		}
		
		//Roto 90 grados
		if(rotacion == 1) {
			if(izquierdaX.ocupado() == false && izquierdaY.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(x, izquierdaX);
				swap(y, izquierdaY);
				swap(z, izquierdaZ);
				izquierdaW = grilla.getBloque(w.getX(), w.getY()-1);
				swap(w, izquierdaW);
			}
		}
		
		//Roto 180 grados
		if(rotacion == 2) {
			if(izquierdaX.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(x, izquierdaX);
				swap(z, izquierdaZ);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
				swap(y, izquierdaY);
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
			if(derechaX.ocupado() == false && derechaZ.ocupado() == false) {
				swap(x, derechaX);
				swap(z, derechaZ);
				derechaY = grilla.getBloque(y.getX(), y.getY()+1);
				swap(y, derechaY);
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
			if(derechaW.ocupado() == false && derechaY.ocupado() == false) {
				swap(w, derechaW);
				swap(y, derechaY);
				derechaZ = grilla.getBloque(z.getX(), z.getY()+1);
				swap(z, derechaZ);
				derechaX = grilla.getBloque(x.getX(), x.getY()+1);
				swap(x, derechaX);
			}
		}
		
		//Roto 270 grados
		if(rotacion == 3) {
			if(derechaX.ocupado() == false && derechaY.ocupado() == false && derechaZ.ocupado() == false) {
				swap(x, derechaX);
				swap(z, derechaZ);
				swap(y, derechaY);
				derechaW = grilla.getBloque(w.getX(), w.getY()+1);
				swap(w, derechaW);
			}
		}
	}

	public boolean descender() {
		
		boolean toreturn = false;
		//Obtengo los bloques abajo del tetrimino
		Bloque abajoY = grilla.getBloque(y.getX()+1, y.getY());
		Bloque abajoZ = grilla.getBloque(z.getX()+1, z.getY());
		Bloque abajoW = grilla.getBloque(w.getX()+1, w.getY());
		Bloque abajoX = grilla.getBloque(x.getX()+1, x.getY());
		
		if (rotacion == 0) {		
			if(abajoY.ocupado() == false && abajoZ.ocupado() == false && abajoX.ocupado() == false){
				swap(y, abajoY);
				swap(z, abajoZ);	
				swap(x, abajoX);
				abajoW = grilla.getBloque(w.getX()+1, w.getY());
				swap(w, abajoW);
				
				toreturn = true;
			}
			else toreturn = false;
		}
		else if(rotacion == 1) {
			if(abajoZ.ocupado()==false && abajoX.ocupado()==false )
				{
				swap(x, abajoX);
				swap(z, abajoZ);
				abajoY = grilla.getBloque(y.getX()+1, y.getY());
				swap(y, abajoY);			
				abajoW = grilla.getBloque(w.getX()+1, w.getY());
				swap(w, abajoW);
				
				toreturn = true;
				}
			else toreturn = false;
		}
		return toreturn;
	}

	public void rotar() {

		Bloque newW;
		Bloque newX;
		Bloque newY;					
		Bloque newZ;
		int aux =0;
		
		if(w.getY()==10)
			aux=-1;
		
		if (rotacion == 0) {				
			newW = (grilla.getBloque(w.getX(), w.getY()));
			newX = (grilla.getBloque(x.getX()+1, x.getY()-1));
			newY = (grilla.getBloque(y.getX()-2, y.getY()));
			newZ = (grilla.getBloque(z.getX()-1, z.getY()-1));
			
			if((newZ.ocupado()== false) && (newY.ocupado()== false)) {
				swap(y, newY);
				swap(z, newZ);
				newX = (grilla.getBloque(x.getX()+1, x.getY()-1));
				swap(x, newX);		
				swap(w, newW);																						
				rotacion=1;		
			}							
		}
		else if(rotacion == 1 && aux == -1) {
			
			newW = (grilla.getBloque(w.getX(), w.getY()+aux));
			newX = (grilla.getBloque(x.getX()-1, x.getY()+1+aux));
			newY = (grilla.getBloque(y.getX()+2, y.getY()+aux));
			newZ = (grilla.getBloque(z.getX()+1, z.getY()+1+aux));
			
			if(newY.ocupado()== false  && newZ.ocupado()== false) {
				swap(y, newY);
				swap(z, newZ);
				newW = (grilla.getBloque(w.getX(), w.getY()+aux));
				swap(w, newW);
				newX = (grilla.getBloque(x.getX()-1, x.getY()+1+aux));
				swap(x, newX);					
				
				rotacion=0;
			}
		}
		else if(rotacion == 1 && aux == 0) {
			newW = (grilla.getBloque(w.getX(), w.getY()));
			newX = (grilla.getBloque(x.getX()-1, x.getY()+1));
			newY = (grilla.getBloque(y.getX()+2, y.getY()));
			newZ = (grilla.getBloque(z.getX()+1, z.getY()+1));
		
			if(newY.ocupado()== false  && newX.ocupado()== false) {
				swap(y, newY);
				swap(x, newX);
				newZ = (grilla.getBloque(z.getX()+1, z.getY()+1));
				swap(z, newZ);
				swap(w, newW);															
				rotacion=0;
			}
		}
	}
}
