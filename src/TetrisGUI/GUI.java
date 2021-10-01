package TetrisGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Game.Juego;


@SuppressWarnings("serial")
public class GUI extends JFrame {

	private static JPanel contentPane;
	private static double height;
	private static double width;
	private static Juego Tetris;
	
	private static JLabel[][] casillas;
	
	
	/**
	 * Create the frame.
	 */
	public GUI(Juego t) {
		Tetris= t;
		setForeground(Color.WHITE);
		height = Toolkit.getDefaultToolkit().getScreenSize().getHeight()-30;
		width = (height/23)*12;
		Dimension test = new Dimension(383, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()-30);
		test.setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(test);
		pack();
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(23, 12, 0, 0));
		contentPane.setBounds(0, 0, getWidth(), getHeight());
		setContentPane(contentPane);
		
		
		casillas = new JLabel[23][12];
		for(int i=0; i<23; i++) {
			for(int j=0; j<12; j++) {
				casillas[i][j] = new JLabel();
				casillas[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				casillas[i][j].setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance((int) (width/12)-2, (int) (height/23)-3, Image.SCALE_DEFAULT)));
				contentPane.add(casillas[i][j]);
			}
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/icon.png")));
		setTitle("Tetris");
		
		}
	
	
	public static void actualizar() {
        int iArriba=Tetris.getTetrimino().getAltMax()-2;
        if(iArriba<1)
            iArriba=1;

        int iAbajo =Tetris.getTetrimino().getAltMin()+2;
        if(iAbajo>21)
            iAbajo=21;
        
        int jIzq = Tetris.getTetrimino().getBIzq()-2;
        if(jIzq<1)
        	jIzq=1;
        
        int jDer = Tetris.getTetrimino().getBDer()+2;
        if(jDer>10)
        	jDer=10;


        for(int i=iArriba; i<=iAbajo; i++) {
            for(int j=jIzq; j<=jDer; j++) {
                casillas[i][j].setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance((int) (width/12)-2, (int) (height/23)-3, Image.SCALE_DEFAULT)));
            }
        }
    }
	
	public static void actualizarTodo() {
		for(int i=1; i<23; i++) {
			for(int j=1; j<12; j++) {
				casillas[i][j].setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance((int) (width/12)-2, (int) (height/23)-3, Image.SCALE_DEFAULT)));
			}
		}
	}
	
	public static void actualizarLinea(int l) {
		for(int i=1; i<12; i++) {
			casillas[l][i].setIcon(new ImageIcon(Tetris.obtenerBloque(l, i).getTextura().getImage().getScaledInstance((int) (width/12)-2, (int) (height/23)-3, Image.SCALE_DEFAULT)));
		}
	}
	
}