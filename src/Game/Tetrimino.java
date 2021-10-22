package Game;

import javax.swing.ImageIcon;

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
	
	public void rotar(Grilla grilla) {
		
		int desplazar=0;
		int xt=bloques[ejeDeRotacion].getX();
		int yt=bloques[ejeDeRotacion].getY();
		
			//en caso de que al rotar, choque contra la pared izquierda, moveremos la pieza a la derecha
		  if(getAltMin()-xt==1 && yt == 1)
	        	desplazar ++;	
	        else if(getAltMin()-xt==2 && yt == 1)
	        	desplazar =desplazar+2;
	        else if(getAltMin()-xt==2 && yt == 2)
	        	desplazar =desplazar+1;
	      
	        //en caso de que al rotar, choque contra la pared derecha, moveremos la pieza a la izquierda
	       
	        if(xt-getAltMax()==1 && yt == 10)
	        	desplazar --;
	        else if(xt-getAltMax()==2 && yt == 10)
	        	desplazar =desplazar -2;
	        else if(xt-getAltMax()==2 && yt == 9)
	        	desplazar = desplazar -1;
	           	 
	        puedeRotar=true;
	        
	        rotarRecursivo(grilla,0,desplazar);
			
	}
	
	private void rotarRecursivo(Grilla grilla,int i,int desplazar) {
		
		if(!puedeRotar || i==4  )
			return;
		else
		{
		
        int xbAux, ybAux,xb,yb,xbRotacion,ybRotacion;
        int aux,xt,yt;
        
        xt=bloques[ejeDeRotacion].getX();
        yt=bloques[ejeDeRotacion].getY();
        
        xb=bloques[i].getX();
        yb=bloques[i].getY();

        xbAux=xb-xt; 
        ybAux=yb-yt; 

        aux=ybAux;
        ybAux=-xbAux;
        xbAux=aux;
        
        xbRotacion = xt + xbAux;
        ybRotacion = yt + ybAux+desplazar;
        
        if(solapa(grilla,xbRotacion,ybRotacion)==false)
        	puedeRotar=false;
        
        rotarRecursivo(grilla,i+1,desplazar);
        
        if(puedeRotar)
        {	
        	
        	grilla.setBloque(xb, yb, new Bloque(1));
        	grilla.setBloque(xbRotacion, ybRotacion, bloques[i]);
        	bloques[i].setX(xbRotacion);
        	bloques[i].setY(ybRotacion);
        
        }
        	    
		}
	}
	
	private boolean solapa(Grilla grilla, int xbRotacion, int ybRotacion) {
		
		if(xbRotacion<1 || xbRotacion>22 || 
		( (ybRotacion>0 && ybRotacion<11) && !grilla.getBloque(xbRotacion,ybRotacion).esSobre() ))
			return false;
		else 
			return true;
	}

	/*
	public int[][] rotar() {

        int i =0;
        int xbAux, ybAux,xb,yb,xbRotacion,ybRotacion;
        int aux;
        
        int xt,yt;

        int[][] MatrizRotada;

        MatrizRotada = new int[4][2];

        xt=bloques[ejeDeRotacion].getX();
        yt=bloques[ejeDeRotacion].getY();

        for (i=0; i<4; i++) {
                xb=bloques[i].getX();
                yb=bloques[i].getY();

                xbAux=xb-xt; 
                ybAux=yb-yt; 

                aux=ybAux;
                ybAux=-xbAux;
                xbAux=aux;

                xbRotacion = xt + xbAux;
                ybRotacion = yt + ybAux;

                MatrizRotada[i][0]=xbRotacion;
                MatrizRotada[i][1]=ybRotacion;

                }

        return MatrizRotada;
    }
		
	
	public Bloque getBloquePos(int f, int c) {
		return grilla[f][c];
	}*/
	public Bloque getBloque(int pos) {
		return bloques[pos];
	}

	
	public int getAltMax() {
		int max = bloques[0].getX();
		for(int i=1; i<4; i++) {
			if(bloques[i].getX()<max) {
				max = bloques[i].getX();
			}
		}
		return max;
	}
	public int getAltMin() {
		int min = bloques[0].getX();
		for(int i=1; i<4; i++) {
			if(bloques[i].getX()>min) {
				min = bloques[i].getX();
			}
		}
		return min;
	}
	public int getBIzq() {
		int izq = bloques[0].getY();
		for(int i=1; i<4; i++) {
			if(bloques[i].getY()<izq) {
				izq = bloques[i].getY();
			}
		}
		return izq;
	}
	public int getBDer() {
		int der = bloques[0].getY();
		for(int i=1; i<4; i++) {
			if(bloques[i].getY()>der) {
				der = bloques[i].getY();
			}
		}
		return der;
	}
	public ImageIcon getImagen() {
		return imagen;
	}


	public boolean mover(Grilla grilla,int direccionH,int direccionV ) {
		boolean sePuede = true;
		for (int i=0; i<4 && sePuede; i++) {
			if(!(grilla.getBloque(bloques[i].getX()+direccionV,bloques[i].getY()+direccionH).esSobre())) {
				sePuede = false;
			}
		}
		if (sePuede) {
			for(int i=0;i<4;i++) {
				Bloque empty = new Bloque(1);
				grilla.setBloque(bloques[i].getX(),bloques[i].getY(),empty);
				}
			
			for (int j=0; j<4; j++) {
				int x = bloques[j].getX();
				int y =bloques[j].getY();
				grilla.setBloque(x+direccionV,y+direccionH,bloques[j]);
				bloques[j].setY(y+direccionH);	
				bloques[j].setX(x+direccionV);
				}
						
			}
			if (!sePuede && direccionV>0 )
				return true;
			else
				return false;
	}


	protected abstract boolean checkGameOver(Grilla grilla);
	
}
