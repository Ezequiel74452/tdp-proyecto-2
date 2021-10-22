package Game;
import bloquesGraficos.BloqueGrafico;
import bloquesGraficos.BloqueNaranja;

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
		if(rotacion == 0 || rotacion == 2) {
			if(izquierdaW.ocupado() == false && izquierdaX.ocupado() == false && izquierdaY.ocupado() == false && izquierdaZ.ocupado() == false) {
				swap(w, izquierdaW);
				swap(x, izquierdaX);
				swap(y, izquierdaY);
				swap(z, izquierdaZ);
			}
		}

		//para 90 grados
		if(rotacion == 1) {
			if(izquierdaZ.ocupado() == false) {
				swap(z, izquierdaZ);
				izquierdaW = grilla.getBloque(w.getX(), w.getY()-1);
				swap(w, izquierdaW);
				izquierdaX = grilla.getBloque(x.getX(), x.getY()-1);
				swap(x, izquierdaX);
				izquierdaY = grilla.getBloque(y.getX(), y.getY()-1);
				swap(y, izquierdaY);

			}
		}
		
		//para 270 grados
		if(rotacion == 3) {
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
		if(rotacion == 0 || rotacion == 2) {
			if(derechaW.ocupado() == false && derechaX.ocupado() == false && derechaY.ocupado() == false && derechaZ.ocupado() == false) {
				swap(w, derechaW);
				swap(x, derechaX);
				swap(y, derechaY);
				swap(z, derechaZ);
			}
		}
		
		//Roto 90 grados
		if(rotacion == 1) {
			if(derechaW.ocupado() == false) {
				swap(w, derechaW);
				derechaX = grilla.getBloque(x.getX(), x.getY()+1);
				swap(x, derechaX);
				derechaY = grilla.getBloque(y.getX(), y.getY()+1);
				swap(y, derechaY);
				derechaZ = grilla.getBloque(z.getX(), z.getY()+1);
				swap(z, derechaZ);
			}
		}
		
		//Roto 270 grados
		if(rotacion == 3) {
			if(derechaZ.ocupado() == false) {
				swap(z, derechaZ);
				derechaW = grilla.getBloque(w.getX(), w.getY()+1);
				swap(w, derechaW);
				derechaX = grilla.getBloque(x.getX(), x.getY()+1);
				swap(x, derechaX);
				derechaY = grilla.getBloque(y.getX(), y.getY()+1);
				swap(y, derechaY);
			}
		}
	}
}