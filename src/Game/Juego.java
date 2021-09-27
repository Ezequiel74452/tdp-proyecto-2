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
	private Tetrimino tactual;
	
	public Juego() {
		grilla = new Bloque[23][12];
		crearPerimetro();
		crearGrillaInicial();
		puntos = 0;
		tactual = null;
		
		
	}
	
	
	private void crearPerimetro() {
		Bloque borde = new Bloque(0, true);
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
		Bloque empty = new Bloque(1, false);
		for(int i=0; i<23; i++) {
			for(int j=0; j<12; j++) {
				if(grilla[i][j] == null) {
					grilla[i][j] = empty;
				}
			}
		}
	}
	
	public void crearTetrimino() {
		Random ran = new Random();
		int num = ran.nextInt(7);
		Random ran2 = new Random();
		int col = ran2.nextInt(7)+2;
		switch (num) {
		case 0: tactual= new Forma1(col);
		setTetrimino();
		break;
		case 1: tactual= new Forma2(col);
		setTetrimino();
		break;
		case 2: tactual= new Forma3(col);
		setTetrimino();
		break;
		case 3: tactual= new Forma4(col);
		setTetrimino();
		break;
		case 4: tactual= new Forma5(col);
		setTetrimino();
		break;
		case 5: tactual= new Forma6(col);
		setTetrimino();
		break;
		case 6: tactual= new Forma7(col);
		setTetrimino();
		break;
		}
	}
	
	private void setTetrimino() {
		for(int i=1; i<3; i++) {
			for(int j=4; j<8; j++) {
				if (tactual!=null && tactual.getBloquePos(i-1, j-4)!=null) {
					setBloque(tactual.getBloquePos(i-1, j-4), i, j);
					grilla[i][j].setX(i);
					grilla[i][j].setY(j);
				}
			}
		}
	}
	
	public void moverIzq() {
		boolean sePuede = true;
		for (int i=0; i<4 && sePuede; i++) {
			if(grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()-1].hayBloque() == true) {
				if(!(grilla[tactual.getBloque(i).getX()][tactual.getBloque(i).getY()-1].getRecienPuesto())) {
					sePuede = false;
				}
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
	
	public void moverDer() {
		
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	private void setBloque(Bloque b, int f, int c) {
		grilla[f][c] = b;
	}
	
	public Bloque obtenerBloque(int f, int c) {
		return grilla[f][c];
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
			throw new ImposibleRotar("error: El tetrimino no puede rotar en esa posici�n");
		else
			{
			for(i=0;i<4;i++)
			{
				Bloque empty = new Bloque(1, false);
				grilla[tactual.getXt()][tactual.getYt()]=empty;
			}
			for(i=0;i<4;i++)
			{
				grilla[matrizRotada[i][0]][matrizRotada[i][1]]=tactual.bloques[i];
				tactual.bloques[i].setX(matrizRotada[i][0]);
				tactual.bloques[i].setY(matrizRotada[i][1]);
			}
			
			}
	}
	
	private boolean Solapa(int x, int y) {
		
		boolean solapado=false;
		
		if (grilla[x][y].hayBloque() && !grilla[x][y].getRecienPuesto() )
		solapado = true;
		
		return solapado;
		
	}
	
	public void keyPressed(KeyEvent e) {


        int keycode = e.getKeyCode();

       
        try {
			switch (keycode) {

			    case KeyEvent.VK_Z -> rotar();
      
			}
		} catch (ImposibleRotar e1) {
			System.out.println(e1.getMessage());
		}
    }
	
	
}