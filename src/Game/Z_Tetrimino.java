package Game;

import bloquesGraficos.BloqueGrafico;
import bloquesGraficos.BloqueVioleta;

public class Z_Tetrimino extends Tetrimino {
	//"S"
	public Z_Tetrimino(Bloque w, Bloque x, Bloque y, Bloque z, int rotacion, Grilla grilla) {
		super(w, x, y, z, rotacion, grilla);
	}

	@Override
	public void ocuparBloques() {
		// TODO Auto-generated method stub
		BloqueGrafico violeta = new BloqueVioleta();
		w.ocupar(violeta);
		x.ocupar(violeta);
		y.ocupar(violeta);
		z.ocupar(violeta);
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
			if(izquierdaW.ocupado() == false && izquierdaY.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(w, izquierdaW);
				swap(y, izquierdaY);
				swap(z, izquierdaZ);
				izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
				swap(x, izquierdaX);
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
			if(izquierdaW.ocupado() == false && izquierdaX.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(w, izquierdaW);
				swap(x, izquierdaX);
				swap(z, izquierdaZ);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
				swap(y, izquierdaY);
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
			if(derechaW.ocupado() == false && derechaX.ocupado() == false && derechaZ.ocupado() == false) {
				swap(w, derechaW);
				swap(x, derechaX);
				swap(z, derechaZ);
				derechaY = grilla.getBloque(y.getX(), y.getY()+1);
				swap(y, derechaY);
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
			if(derechaW.ocupado() == false && derechaY.ocupado() == false && derechaZ.ocupado() == false) {
				swap(z, derechaZ);
				swap(w, derechaW);
				swap(y, derechaY);
				derechaX = grilla.getBloque(x.getX(), x.getY()+1);
				swap(x, derechaX);
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
			if(abajoY.ocupado() == false && abajoZ.ocupado() == false && abajoW.ocupado() == false){
				swap(y, abajoY);
				swap(z, abajoZ);
				swap(w, abajoW);
				abajoX = grilla.getBloque(x.getX()+1, x.getY());
				swap(x, abajoX);
								
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
		
		if (rotacion == 0) {				
			newW = (grilla.getBloque(w.getX(), w.getY()+2));
			newX = (grilla.getBloque(x.getX()+1, x.getY()+1));
			newY = (grilla.getBloque(y.getX(), y.getY()));
			newZ = (grilla.getBloque(z.getX()+1, z.getY()-1));
			
			if((newZ.ocupado()== false) && (newZ.ocupado()== false)) {
				swap(w, newW);
				swap(z, newZ);
				newX = (grilla.getBloque(x.getX()+1, x.getY()+1));
				swap(x, newX);		
				swap(y, newY);																						
				rotacion=1;		
			}							
		}
		else if(rotacion == 1) {
			
			newW = (grilla.getBloque(w.getX(), w.getY()-2));
			newX = (grilla.getBloque(x.getX()-1, x.getY()-1));
			newY = (grilla.getBloque(y.getX(), y.getY()));
			newZ = (grilla.getBloque(z.getX()-1, z.getY()+1));
			
			if(newW.ocupado()== false  && newX.ocupado()== false) {
				swap(w, newW);
				swap(x, newX);	
				newZ = (grilla.getBloque(z.getX()-1, z.getY()+1));
				swap(z, newZ);
				swap(y, newY);				
				rotacion=0;
			}
		}
	}
}
