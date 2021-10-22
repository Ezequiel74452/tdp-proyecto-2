package Game;

import javax.swing.ImageIcon;

import bloquesGraficos.BloqueGrafico;

public class Bloque {
	
	private Grilla miGrilla;
	private BloqueGrafico miRepresentacion;
	private boolean ocupado;
	private int x, y;
	
	public Bloque(int x, int y,boolean l, Grilla g,BloqueGrafico bg) {
		ocupado = l;
		this.x=x;
		this.y=y;
		miGrilla=g;
		miRepresentacion=bg;
		miGrilla.bloqueCambioEstado(x, y, miRepresentacion.getTextura());
	}
	
	public void ocupar(BloqueGrafico t) {
		miRepresentacion=t;
		ocupado = true;
		miGrilla.bloqueCambioEstado(x, y, miRepresentacion.getTextura());
		
	}

	public void desOcupar(BloqueGrafico t) {
		miRepresentacion=t;
		ocupado = false;
		miGrilla.bloqueCambioEstado(x, y, miRepresentacion.getTextura());
	}
	
	public BloqueGrafico getTextura() {
		return miRepresentacion;
	}
	
	public boolean ocupado() {
		return ocupado;
	}
	
	public void setX(int xx) {
		x = xx;
	}
	
	public void setY(int yy) {
		y = yy;
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
