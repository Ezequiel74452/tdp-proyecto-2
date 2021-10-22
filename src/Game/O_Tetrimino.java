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
		if(grilla.getBloque(w.getX(), w.getY()-1).ocupado()==false &&
			grilla.getBloque(y.getX(), y.getY()-1).ocupado()==false)
		{
				swap(w,grilla.getBloque(w.getX(), w.getY()-1));
				swap(y,grilla.getBloque(w.getX(), w.getY()-1));
				swap(x,grilla.getBloque(w.getX(), w.getY()-1));
				swap(z,grilla.getBloque(w.getX(), w.getY()-1));
		}
	}
	
	public void moverDer() {
		if(grilla.getBloque(x.getX(), x.getY()+1).ocupado()==false &&
				grilla.getBloque(z.getX(), z.getY()+1).ocupado()==false)
		{
					swap(x,grilla.getBloque(w.getX(), w.getY()+1));
					swap(z,grilla.getBloque(w.getX(), w.getY()+1));
					swap(w,grilla.getBloque(w.getX(), w.getY()+1));
					swap(y,grilla.getBloque(w.getX(), w.getY()+1));
		}
					
	}


	
}
