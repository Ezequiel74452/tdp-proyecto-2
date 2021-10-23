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
			if(izquierdaW.ocupado() == false && izquierdaX.ocupado() == false) {
				swap(w, izquierdaW);
				swap(x, izquierdaX);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
				swap(y, izquierdaY);
				izquierdaZ = grilla.getBloque(z.getX(), z.getY()-1);	
				swap(z, izquierdaZ);							
			}
		}

		//para 90 grados
		if(rotacion == 1) {
			if(izquierdaZ.ocupado() == false && izquierdaX.ocupado() == false && izquierdaY.ocupado() == false) {
				swap(x, izquierdaX);
				swap(z, izquierdaZ);		
				swap(y, izquierdaY);
				izquierdaW = grilla.getBloque(w.getX(), w.getY()-1);
				swap(w, izquierdaW);				
			}
		}
		
		//Roto 180 grados
		if(rotacion == 2) {
			if(izquierdaZ.ocupado() == false && izquierdaW.ocupado() == false) {
				swap(w, izquierdaW);
				swap(z, izquierdaZ);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
				swap(y, izquierdaY);			
				izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
				swap(x, izquierdaX);				
			}
		}
		//para 270 grados
		if(rotacion == 3) {
			if(izquierdaX.ocupado() == false && izquierdaW.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(w, izquierdaW);
				swap(x, izquierdaX);
				swap(z, izquierdaZ);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
				swap(y, izquierdaY);				
			}
		}
	}

	public void moverDer() {
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
				swap(z, derechaZ);
				swap(y, derechaY);
				swap(x, derechaX);
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
			if(abajoZ.ocupado()==false && abajoW.ocupado()==false)
				{
				swap(w, abajoW);
				swap(z, abajoZ);
				abajoY = grilla.getBloque(y.getX()+1, y.getY());
				swap(y, abajoY);
				abajoX = grilla.getBloque(x.getX()+1, x.getY());
				swap(x, abajoX);
				
				toreturn = true;
				}
			else toreturn = false;
		}
		else if(rotacion == 2) {
			if(abajoZ.ocupado()==false && abajoW.ocupado()==false && abajoX.ocupado()==false)
				{
				swap(w, abajoW);
				swap(z, abajoZ);
				swap(x, abajoX);
				abajoY = grilla.getBloque(y.getX()+1, y.getY());
				swap(y, abajoY);
				
				toreturn = true;
				}
			else toreturn = false;
		}
		else if(rotacion == 3) {
			if(abajoW.ocupado()==false && abajoX.ocupado()==false)
				{
				swap(w, abajoW);
				swap(x, abajoX);
				abajoY = grilla.getBloque(y.getX()+1, y.getY());
				swap(y, abajoY);
				abajoZ = grilla.getBloque(z.getX()+1, z.getY());
				swap(z, abajoZ);
						
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
			newW = (grilla.getBloque(w.getX()+1, w.getY()+1));
			newX = (grilla.getBloque(x.getX()-1, x.getY()+1));
			newY = (grilla.getBloque(y.getX(), y.getY()));
			newZ = (grilla.getBloque(z.getX()+1, z.getY()-1));
			
			if(newZ.ocupado()== false) {
				swap(z, newZ);
				newW = (grilla.getBloque(w.getX()+1, w.getY()+1));
				swap(w, newW);
				newX = (grilla.getBloque(x.getX()-1, x.getY()+1));
				swap(x, newX);		
				swap(y, newY);																																	
				rotacion=1;		
			}							
		}
		else if(rotacion == 1) {
			
			newW = (grilla.getBloque(w.getX()+1, w.getY()-1));
			newX = (grilla.getBloque(x.getX()+1, x.getY()+1));
			newY = (grilla.getBloque(y.getX(), y.getY()));
			newZ = (grilla.getBloque(z.getX()-1, z.getY()-1));
			
			if(newZ.ocupado()== false) {
				swap(z, newZ);
				newW = (grilla.getBloque(w.getX()+1, w.getY()-1));
				swap(w, newW);
				newX = (grilla.getBloque(x.getX()+1, x.getY()+1));
				swap(x, newX);		
				swap(y, newY);																			
				rotacion=2;
			}
		}
		else if(rotacion == 2) {
			newW = (grilla.getBloque(w.getX()-1, w.getY()-1));
			newX = (grilla.getBloque(x.getX()+1, x.getY()-1));
			newY = (grilla.getBloque(y.getX(), y.getY()));
			newZ = (grilla.getBloque(z.getX()-1, z.getY()+1));
		
			if(newZ.ocupado()== false) {
				swap(z, newZ);
				newW = (grilla.getBloque(w.getX()-1, w.getY()-1));
				swap(w, newW);	
				newX = (grilla.getBloque(x.getX()+1, x.getY()-1));
				swap(x, newX);
				swap(y, newY);																									
				rotacion=3;
			}
		}
		else if(rotacion == 3) {
			newW = (grilla.getBloque(w.getX()-1, w.getY()+1));
			newX = (grilla.getBloque(x.getX()-1, x.getY()-1));
			newY = (grilla.getBloque(y.getX(), y.getY()));
			newZ = (grilla.getBloque(z.getX()+1, z.getY()+1));
		
			if(newZ.ocupado()== false) {
				swap(z, newZ);
				newW = (grilla.getBloque(w.getX()-1, w.getY()+1));
				swap(w, newW);	
				newX = (grilla.getBloque(x.getX()-1, x.getY()-1));
				swap(x, newX);
				swap(y, newY);																									
				rotacion=0;
			}
		}
	}
}
