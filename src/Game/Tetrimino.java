package Game;



public abstract class Tetrimino {
	
	
	protected Bloque w;
	protected Bloque x;
	protected Bloque y;
	protected Bloque z;
	protected int rotacion;
	protected Grilla grilla;
	
	public Tetrimino(Bloque w, Bloque x, Bloque y, Bloque z, int rotacion, Grilla grilla) {
		this.w=w;
		this.x=x;
		this.y=y;
		this.z=z;
		this.rotacion=rotacion;
		this.grilla=grilla;
	}
	
	
	public abstract void ocuparBloques();
	public abstract void moverIzq();
	public abstract void moverDer();
	
	//Intercambia la posicion de dos bloques dados, e informa a la grilla de actualizar los cambios
	protected void swap(Bloque b1, Bloque b2)
	{
		int x=b1.getX();
		int y=b1.getY();
		
		Bloque aux = grilla.getBloque(b1.getX(), b1.getY());
		grilla.setBloque(b1.getX(), b1.getY(), b2);
		grilla.setBloque(b2.getX(), b2.getY(), aux);
		
		b1.setX(b2.getX());
		b1.setY(b2.getY());
		
		b2.setX(x);
		b2.setY(y);
		
	}
	
	public abstract void rotar();
	
	public Bloque getW() {
		return w;
	}
	
	public Bloque getX() {
		return w;
	}
	
	public Bloque getY() {
		return w;
	}
	
	public Bloque getZ() {
		return w;
	}
	
}
