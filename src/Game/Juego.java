package Game;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import TetrisGUI.GUI;
import exceptions.ImposibleRotar;

public class Juego {
	
	protected Bloque[][] grilla;
	private int puntos;
	private Tetrimino tactual, tsiguiente;
	
	public Juego() {
		grilla = new Bloque[23][12];
		crearPerimetro();
		crearGrillaInicial();
		puntos = 0;
		tactual = crearTetrimino();
		tsiguiente = crearSiguiente();
	}
	
	
	private void crearPerimetro() {
		Bloque borde = new Bloque(0);
		for (int i=0; i<23; i++) {
			grilla[i][0] = borde;
			grilla[i][11] = borde;
		}
		for (int j=0; j<12; j++) {
			grilla[0][j] = borde;
			grilla[22][j] = borde;
		}
	}
	
	private void crearGrillaInicial() {
		Bloque empty = new Bloque(1);
		for(int i=0; i<23; i++) {
			for(int j=0; j<12; j++) {
				if(grilla[i][j] == null) {
					grilla[i][j] = empty;
				}
			}
		}
	}
	
	public Tetrimino crearTetrimino() {
		Random ran = new Random();
		int num = ran.nextInt(7);
		Random ran2 = new Random();
		int col = ran2.nextInt(7)+2;
		switch (num) {
		case 0: tactual= new Forma1(col);
		setTetrimino(tactual);
		break;
		case 1: tactual= new Forma2(col);
		setTetrimino(tactual);
		break;
		case 2: tactual= new Forma3(col);
		setTetrimino(tactual);
		break;
		case 3: tactual= new Forma4(col);
		setTetrimino(tactual);
		break;
		case 4: tactual= new Forma5(col);
		setTetrimino(tactual);
		break;
		case 5: tactual= new Forma6(col);
		setTetrimino(tactual);
		break;
		case 6: tactual= new Forma7(col);
		setTetrimino(tactual);
		break;
		}
		return tactual;
	}
	public Tetrimino crearSiguiente() {
		Random ran = new Random();
		int num = ran.nextInt(7);
		Random ran2 = new Random();
		int col = ran2.nextInt(7)+2;
		switch (num) {
		case 0: tsiguiente= new Forma1(col);
		break;
		case 1: tsiguiente= new Forma2(col);
		break;
		case 2: tsiguiente= new Forma3(col);
		break;
		case 3: tsiguiente= new Forma4(col);
		break;
		case 4: tsiguiente= new Forma5(col);
		break;
		case 5: tsiguiente= new Forma6(col);
		break;
		case 6: tsiguiente= new Forma7(col);
		break;
		}
		return tsiguiente;
	}
	
	private void setTetrimino(Tetrimino tr) {
		for(int i=1; i<3; i++) {
			for(int j=4; j<8; j++) {
				if (tr!=null && tr.getBloquePos(i-1, j-4)!=null) {
					setBloque(tr.getBloquePos(i-1, j-4), i, j);
					grilla[i][j].setX(i);
					grilla[i][j].setY(j);
				}
			}
		}
	}
	
	/*public void mover(int pos) {
		if (pos==0) {
			moverDer();
		} else {
			moverIzq();
		}
		
	}
	
	private void moverIzq() {
		boolean sePuede = true;
		for (int i=0; i<4 && sePuede; i++) {
			if(!(grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()-1].esSobre())) {
				sePuede = false;
			}
		}
		if (sePuede) {
			for (int j=0; j<4; j++) {
				int x = tactual.getBloque(j).getX();
				int y = tactual.getBloque(j).getY();
				Bloque aux = grilla[x][y-1];
				grilla[x][y-1] = tactual.getBloque(j);
				tactual.getBloque(j).setY(y-1);
				grilla[x][y] = aux;
			}
		}
	}
	private void moverDer() {
		boolean sePuede = true;
		for (int i=0; i<4 && sePuede; i++) {
			if(!(grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()+1].esSobre())) {
				sePuede = false;
			}
		}
		if (sePuede) {
			for (int j=3; j>=0; j--) {
				int x = tactual.getBloque(j).getX();
				int y = tactual.getBloque(j).getY();
				Bloque aux = grilla[x][y+1];
				grilla[x][y+1] = tactual.getBloque(j);
				tactual.getBloque(j).setY(y+1);
				grilla[x][y] = aux;
			}
		}
	}*/
	
	public void mover(int pos) {
		if (pos==0) {
			moverDer();
		} else {
			moverIzq();
		}
		
	}
	
	private void moverIzq() {
		boolean sePuede = true;
		for (int i=0; i<4 && sePuede; i++) {
			if(!(grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()-1].esSobre())) {
				sePuede = false;
			}
		}
		if (sePuede) {
			for(int i=0;i<4;i++) {
				Bloque empty = new Bloque(1);
				grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()]=empty;
			}
			
			for (int j=0; j<4; j++) {
				int x = tactual.getBloque(j).getX();
				int y = tactual.getBloque(j).getY();
				//Bloque aux = grilla[x][y-1];
				grilla[x][y-1] = tactual.getBloque(j);
				tactual.getBloque(j).setY(y-1);
				//grilla[x][y] = aux;
			}
		}
	}
	private void moverDer() {
		boolean sePuede = true;
		for (int i=0; i<4 && sePuede; i++) {
			if(!(grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()+1].esSobre())) {
				sePuede = false;
			}
		}
		if (sePuede) {
			for(int i=0;i<4;i++) {
				Bloque empty = new Bloque(1);
				grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()]=empty;
			}
			
			for (int j=3; j>=0; j--) {
				int x = tactual.getBloque(j).getX();
				int y = tactual.getBloque(j).getY();
				//Bloque aux = grilla[x][y+1];
				grilla[x][y+1] = tactual.getBloque(j);
				tactual.getBloque(j).setY(y+1);
				//grilla[x][y] = aux;
			}
		}
	}
	
	
	/* public void moverIzq() {
		int cont=0;
		for(int i=1; i<21 && cont<4; i++) {
			for (int j=1; j<11; j++) {
				if(obtenerBloque(i, j).getRecienPuesto() && !obtenerBloque(i, j-1).hayBloque()) {
					cont++;
				}
			}
		}
		if (cont==4) {
			for(int i=1; i<21 && cont>0; i++) {
				for (int j=1; j<11; j++) {
					if(obtenerBloque(i, j).getRecienPuesto() && !obtenerBloque(i, j-1).hayBloque()) {
						cont--;
						Bloque bAux = grilla[i][j-1];
						grilla[i][j-1] = obtenerBloque(i, j);
						grilla[i][j] = bAux;
					}
				}
			}
		}
	} */
	
	public int getPuntos() {
		return puntos;
	}
	
	private void setBloque(Bloque b, int f, int c) {
		grilla[f][c] = b;
	}
	
	public Bloque obtenerBloque(int f, int c) {
		return grilla[f][c];
	}
	
	public Tetrimino getTetrimino() {
		return tactual;
	}

	
	/*public void descender() {
		boolean sePuede = true;
		for (int i=0; i<4 && sePuede; i++) {
			if(!(grilla[tactual.getBloque(i).getX()+1][tactual.getBloque(i).getY()].esSobre())) {
				sePuede = false;
			}
		}
		if(sePuede) {
			for(int i=3; i>=0; i--) {
				int x = tactual.getBloque(i).getX();
				int y = tactual.getBloque(i).getY();
				Bloque aux = grilla[x+1][y];
				grilla[x+1][y] = tactual.getBloque(i);
				tactual.getBloque(i).setX(x+1);
				grilla[x][y] = aux;
			}
		}
	}*/
	
	public void descender() {
		boolean sePuede = true;
		for (int i=0; i<4 && sePuede; i++) {
			if(!(grilla[tactual.getBloque(i).getX()+1][tactual.getBloque(i).getY()].esSobre())) {
				sePuede = false;
			}
		}
		if(sePuede) {
			for(int i=0;i<4;i++) {
				Bloque empty = new Bloque(1);
				grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()]=empty;
			}
			
			for(int i=3; i>=0; i--) {
				int x = tactual.getBloque(i).getX();
				int y = tactual.getBloque(i).getY();
				//Bloque aux = grilla[x+1][y];
				grilla[x+1][y] = tactual.getBloque(i);
				tactual.getBloque(i).setX(x+1);
				//grilla[x][y] = aux;
			}
		} else {
			for(int i=0; i<4; i++) {
				tactual.getBloque(i).setSobre(false);
				int x = tactual.getBloque(i).getX();
				int y = tactual.getBloque(i).getY();
				grilla[x][y].setSobre(false);
			}
			int max = tactual.getAltMax();
			int min = tactual.getAltMin();
			System.out.println("Máximo: "+max+". Mínimo: "+min);
			limpiarLineas(min, max);
			tactual = tsiguiente;
			tsiguiente = crearSiguiente();
			setTetrimino(tactual);
		}
	}
	public void limpiarLineas(int min, int max) {
		System.out.println("Entramos a limpiarLineas");
		boolean seLimpia = true;
		for(int i=max; i<=min; i++) {
			System.out.println("Primer for");
			for(int j=1; j<11 && seLimpia; j++) {
				System.out.println("Segundo for");
				if(grilla[i][j].esSobre()) {
					seLimpia = false;
				}
			}
			System.out.println("SeLimpia: "+seLimpia);
			if (seLimpia) {
				limpiar(i);
				bajarBloques(i);
			}
			seLimpia = true;
		}
	}
	private void limpiar(int linea) {
		System.out.println("Entra a limpiar");
		for(int i=1; i<11; i++) {
			grilla[linea][i] = new Bloque(1);
		}
		GUI.actualizarLinea(linea);
	}
	private void bajarBloques(int l) {
		System.out.println("Entro a bajar bloques");
		for(int j=l; j>1; j--) {
			for(int i=1; i<11; i++) {
				grilla[j][i] = grilla[j-1][i];
			}
		}
		GUI.actualizarTodo();
	}
	public void rotar() throws ImposibleRotar {
		
		boolean solapado = false;
		int [][] matrizRotada;
		int i=0;
		
		matrizRotada = tactual.rotar();
		
		while(!solapado && (i<4) ) {
			
			solapado = Solapa(matrizRotada[i][0],matrizRotada[i][1]);
			i++;			
		}
		
		if (solapado)
			throw new ImposibleRotar("error: El tetrimino no puede rotar en esa posición");
		else
			{
			for( i=0;i<4;i++) {
				Bloque empty = new Bloque(1);
				grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()]=empty;
			}
			
			for(i=0;i<4;i++)
			{	
				tactual.getBloque(i).setX(matrizRotada[i][0]);
				tactual.getBloque(i).setY(matrizRotada[i][1]);
				grilla[matrizRotada[i][0]][matrizRotada[i][1]]=tactual.getBloque(i);
			}
			
			}
	} 
	
	 private boolean Solapa(int x, int y) {
		
		boolean solapado=false;
		
		if ((x<0) || (x>22) || y<0 || y>11 || (!grilla[x][y].esSobre()))
		solapado = true;
		
		return solapado;
		
	} 
	
	/* public void keyPressed(KeyEvent e) {


        int keycode = e.getKeyCode();

       
        try {
			switch (keycode) {

			    case KeyEvent.VK_Z -> rotar();
      
			}
		} catch (ImposibleRotar e1) {
			System.out.println(e1.getMessage());
		}
    } */
	
	
}
