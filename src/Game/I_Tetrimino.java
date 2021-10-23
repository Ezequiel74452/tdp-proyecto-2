package Game;
import bloquesGraficos.BloqueGrafico;
import bloquesGraficos.BloqueNaranja;
import bloquesGraficos.BloqueVacio;

public class I_Tetrimino extends Tetrimino {
	//"I"
	public I_Tetrimino(Bloque w, Bloque x, Bloque y, Bloque z, int rotacion, Grilla grilla) {
		super(w, x, y, z, rotacion, grilla);
	}

	@Override
	public void ocuparBloques() {
		// TODO Auto-generated method stub
		BloqueGrafico naranja = new BloqueNaranja();
		w.ocupar(naranja);
		x.ocupar(naranja);
		y.ocupar(naranja);
		z.ocupar(naranja);	
	}

	@Override
	public void moverIzq() {
		//Obtengo los bloques a la izquierda del tetrimino
		Bloque izquierdaW = grilla.getBloque(w.getX(), w.getY()-1);
		Bloque izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
		Bloque izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);					
		Bloque izquierdaZ = grilla.getBloque(z.getX(), z.getY()-1);					
																   					
		//Si no esta rotado o esta rotado 180 grados
		if(rotacion == 0) {
			if(izquierdaW.ocupado() == false && izquierdaX.ocupado() == false && izquierdaY.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(w, izquierdaW);
				swap(x, izquierdaX);
				swap(y, izquierdaY);
				swap(z, izquierdaZ);
			}
		}

		//para 90 grados o 270
		if(rotacion == 1) {
			if(izquierdaW.ocupado() == false) {
				swap(w, izquierdaW);	
				izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
				swap(x, izquierdaX);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
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
																 				
		//Si no roto o esta rotado 180 grados
		if(rotacion == 0) {
			if(derechaW.ocupado() == false && derechaX.ocupado() == false && derechaY.ocupado() == false && derechaZ.ocupado() == false) {
				swap(w, derechaW);
				swap(x, derechaX);
				swap(y, derechaY);
				swap(z, derechaZ);
			}
		}
		
		//Roto 90 grados o 270
		if(rotacion == 1) {
			if(derechaZ.ocupado() == false) {
				swap(z, derechaZ);
				derechaY = grilla.getBloque(y.getX(), y.getY()+1);
				swap(y, derechaY);
				derechaX = grilla.getBloque(x.getX(), x.getY()+1);
				swap(x, derechaX);
				derechaW = grilla.getBloque(w.getX(), w.getY()+1);
				swap(w, derechaW);												
			}
		}
		
	}
	
	public void rotar() {
		
		Bloque newW;
		Bloque newX;
		Bloque newY;					
		Bloque newZ;
		int aux =0;
		
		if (rotacion == 0) {
			if(x.getY()==1)
				aux=1;
			if(x.getY()==10)
				aux=-2;
			if(x.getY()==9)
				aux=-1;
			
			newW = (grilla.getBloque(w.getX()+1, w.getY()-1+aux));
			newX = (grilla.getBloque(x.getX(), x.getY()+aux));
			newY = (grilla.getBloque(y.getX()-1, y.getY()+1+aux));
			newZ = (grilla.getBloque(z.getX()-2, z.getY()+2+aux));
			
			if((newW.ocupado()== false || aux==1) && (newX.ocupado()== false || aux==0) && (newY.ocupado()== false || aux==(-1)) && (newZ.ocupado()== false || aux==(-2))) {
				newX = (grilla.getBloque(x.getX(), x.getY()+aux));
				swap(x, newX);
				newW = (grilla.getBloque(w.getX()+1, w.getY()-1+aux));
				swap(w, newW);				
				newY = (grilla.getBloque(y.getX()-1, y.getY()+1+aux));
				swap(y, newY);
				newZ = (grilla.getBloque(z.getX()-2, z.getY()+2+aux));
				swap(z, newZ);
				rotacion=1;		
			}							
		}
		else if(rotacion == 1) {
			
			newW = (grilla.getBloque(w.getX()-1, w.getY()+1));
			newX = (grilla.getBloque(x.getX(), x.getY()));
			newY = (grilla.getBloque(y.getX()+1, y.getY()-1));
			newZ = (grilla.getBloque(z.getX()+2, z.getY()-2));
			
			if(newW.ocupado()== false && newY.ocupado()== false && newZ.ocupado()== false) {
				swap(w, newW);
				swap(x, newX);
				swap(y, newY);
				swap(z, newZ);
				rotacion=0;
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
		
		if (rotacion == 1) {		
			if(abajoY.ocupado() == false && abajoZ.ocupado() == false && abajoX.ocupado() == false && abajoW.ocupado() == false ){
				swap(y, abajoY);
				swap(z, abajoZ);			
				swap(w, abajoW);
				swap(x, abajoX);
				toreturn = true;
			}
			else toreturn = false;
		}
		else if(rotacion == 0) {
			if(abajoZ.ocupado()==false)
				{
				abajoZ = grilla.getBloque(z.getX()+1, z.getY());
				swap(z, abajoZ);
				abajoY = grilla.getBloque(y.getX()+1, y.getY());
				swap(y, abajoY);
				abajoX = grilla.getBloque(x.getX()+1, x.getY());
				swap(x, abajoX);
				abajoW = grilla.getBloque(w.getX()+1, w.getY());
				swap(w, abajoW);
				toreturn = true;
				}
			else toreturn = false;
		}
		return toreturn;
	}
	
}