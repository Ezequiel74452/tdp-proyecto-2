package Game;

import javax.swing.ImageIcon;

import bloquesGraficos.BloqueGrafico;
import bloquesGraficos.BloquePerimetro;
import bloquesGraficos.BloqueVacio;

public class Grilla {

	protected Bloque[][] grilla;
	protected Juego miJuego;
	
	//Inicializa la grilla y comunica a juego de los cambios realizados  en los bloques inicializados
	public Grilla(Juego juego) {
		
			grilla = new Bloque[23][12];
			this.miJuego = juego;
			
			//Inicializar bloques perimetro, primero las filas externas, luego las columnas externas
			
			BloqueGrafico bloquePerimetro = new BloquePerimetro();
			ImageIcon texturaPerimetro = bloquePerimetro.getTextura();
			
			for (int i=0; i<23; i++) {
				grilla[i][0] = new Bloque(i, 0, true, this, bloquePerimetro);
				miJuego.actualizarVentana(i, 0, texturaPerimetro);
				grilla[i][11] = new Bloque(i, 11, true, this, bloquePerimetro);
				miJuego.actualizarVentana(i, 11, texturaPerimetro);
			}
			
			for (int j=1; j<11; j++) {
				grilla[0][j] = new Bloque(0, j, true, this, bloquePerimetro);
				miJuego.actualizarVentana(0, j, texturaPerimetro);
				grilla[22][j] = new Bloque(22, j, true, this, bloquePerimetro);
				miJuego.actualizarVentana(22, j, texturaPerimetro);
			}
			
			//Inicializar el resto de bloques vacios
			
			BloqueGrafico bloqueVacio = new BloqueVacio();
			ImageIcon texturaVacio = bloqueVacio.getTextura();
			
			for(int i=1; i<22; i++) {
				for(int j=1; j<11; j++) {
					grilla[i][j] = new Bloque(i, j, false, this, bloqueVacio);	
					miJuego.actualizarVentana(i, j, texturaVacio);
				}
			}
	}
	
	public void setBloque( int f, int c, Bloque b) {
		grilla[f][c] = b;
		miJuego.actualizarVentana(f, c, b.getBloqueGrafico().getTextura());
	}
	
	public Bloque getBloque(int f, int c) {
		return grilla[f][c];
	}

	public void bloqueCambioEstado(int f, int c, ImageIcon textura) {
		miJuego.actualizarVentana(f, c, textura);
	}

}
