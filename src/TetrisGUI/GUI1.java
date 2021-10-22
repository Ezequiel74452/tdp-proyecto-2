package TetrisGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Game.Juego;
import Game.Reloj;
import javax.swing.JSplitPane;



@SuppressWarnings("serial")
public class GUI1 extends JFrame {
	
	private static int height;
	private static int width;
	private static JLabel[][] casillas;	
	private static Juego tetris;
	private static JLabel lbl_next;
	private static JLabel lbl_tiempo;
	private static JLabel lbl_puntuacion;
	private static Juego miJuego;

	public GUI1() {
		initialize();
	}
	
	private void initialize() {
		
	
		width = 360;
		height = 690;
		
		getContentPane().setLayout(null);
		getContentPane().setBounds(0, 0,width+200, 900);
		
		Dimension test = new Dimension(width+200,height+35);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setPreferredSize(test);
		pack();
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(Color.BLACK);
		panelIzq.setBounds(0, 0, width, height);
		getContentPane().add(panelIzq);
		panelIzq.setLayout(new GridLayout(23, 12, 0, 0));
	
	
		JPanel panelDer = new JPanel();
		panelDer.setBounds(width, 0, 200, height);
		getContentPane().add(panelDer);
		panelDer.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puntuacion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 11, 64, 14);
		panelDer.add(lblNewLabel);
		
		lbl_puntuacion = new JLabel("0");
		lbl_puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_puntuacion.setBounds(82, 36, 46, 14);
		panelDer.add(lbl_puntuacion);
		
		JLabel lblNewLabel_1 = new JLabel("Tiempo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(82, 61, 46, 14);
		panelDer.add(lblNewLabel_1);
		
		lbl_tiempo = new JLabel("");
		lbl_tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tiempo.setBounds(82, 86, 46, 14);
		panelDer.add(lbl_tiempo);
		
		JLabel lblNewLabel_2 = new JLabel("lbl_next");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(82, 111, 46, 14);
		panelDer.add(lblNewLabel_2);
		
		lbl_next = new JLabel("");
		lbl_next.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_next.setBounds(10, 140, 184, 97);
		panelDer.add(lbl_next);
		
		casillas = new JLabel[23][12];
		for(int i=0; i<23; i++) {
			for(int j=0; j<12; j++) {
				casillas[i][j] = new JLabel();
				casillas[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				casillas[i][j].setBounds(j*30, i*30, 30, 30);
				/*casillas[i][j].setIcon(new ImageIcon(tetris.getGrilla().getBloque(i,j).getBloqueGrafico().
						getTextura().getImage().getScaledInstance						
							((int)width/12,(int)height/23 , Image.SCALE_DEFAULT)));*/
				panelIzq.add(casillas[i][j]);
					}		
		}
		
			this.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {}
	
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if(c == 'a' || c=='A') {
					miJuego.operarJuego(1);
				} else if (c == 'd' || c=='D') {
					miJuego.operarJuego(2);
				} else if (c == 's'|| c=='S') {
					miJuego.operarJuego(3);
				} else if (c == 'q'|| c=='Q') {
					miJuego.operarJuego(4);
				} 
			}
	
			public void keyReleased(KeyEvent e) {}
		});
		
			Clip clip;
			Random ran = new Random();
			try {
				clip = AudioSystem.getClip();
				AudioInputStream inputStream;
				if (ran.nextInt(1000) == 622) {
					inputStream = AudioSystem.getAudioInputStream(
							getClass().getResourceAsStream("/Sonidos/GiornosTheme.wav"));
				    clip.open(inputStream);
				} else {
					inputStream = AudioSystem.getAudioInputStream(
							getClass().getResourceAsStream("/Sonidos/Music.wav"));
						    clip.open(inputStream);
				}
				clip.start();
				
			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
				e1.printStackTrace();
			}
			
			
	
	}
	
	public static void actualizar(int i, int j, ImageIcon nuevaImg){
        casillas[i][j].setIcon(new ImageIcon (nuevaImg.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
    }
	
	public static void actualizarLinea(int l) {
		for(int i=1; i<12; i++) {
			casillas[l][i].setIcon(new ImageIcon(tetris.obtenerBloque(l, i).getTextura().getImage().getScaledInstance((int) (width/12), (int) (height/23), Image.SCALE_DEFAULT)));
		}
	}
	
	public static void actualizarNext() {
		Image im = tetris.getSiguiente().getImagen().getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imic = new ImageIcon(im);
		lbl_next.setIcon(imic);
	}
	
	public static void actualizarPuntuación() {
		lbl_puntuacion.setText(Integer.toString(tetris.getPuntos()));
	}
	
	public static void actualizarTiempo(int tiempo) {
		lbl_tiempo.setText(Integer.toString(tiempo));
	}
	
	public static void gameOver() {
		JOptionPane.showMessageDialog(null, "Game Over");
	}
	
	public void registrarJuego(Juego juego) {
		miJuego = juego;
		
	}
}
