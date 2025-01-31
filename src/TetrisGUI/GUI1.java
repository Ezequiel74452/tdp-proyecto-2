package TetrisGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
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
import Game.Juego;



@SuppressWarnings("serial")
public class GUI1 extends JFrame {
	
	private static int height;
	private static int width;
	private static JLabel[][] casillas;	
	private static JLabel[][] casillasSiguiente;	
	private static Juego tetris;
	private static JLabel lbl_tiempo;
	private static JLabel lbl_puntuacion;
	private static JLabel lbl_next;
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
		lblNewLabel.setBounds(10, 11, 180, 14);
		panelDer.add(lblNewLabel);
		
		lbl_puntuacion = new JLabel("0");
		lbl_puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_puntuacion.setBounds(10, 36, 180, 14);
		panelDer.add(lbl_puntuacion);
		
		JLabel lblNewLabel_1 = new JLabel("Tiempo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 61, 180, 14);
		panelDer.add(lblNewLabel_1);
		
		lbl_tiempo = new JLabel("");
		lbl_tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tiempo.setBounds(10, 86, 180, 14);
		panelDer.add(lbl_tiempo);
		
		JLabel lblNewLabel_2 = new JLabel("Tetrimino Siguiente");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 111, 180, 14);
		panelDer.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 140, 120, 120);
		panelDer.add(panel);
		panel.setLayout(null);
		
		lbl_next = new JLabel("");
		lbl_next.setBounds(0, 0, 120, 120);
		panel.add(lbl_next);
		
		casillas = new JLabel[23][12];
		for(int i=0; i<23; i++) {
			for(int j=0; j<12; j++) {
				casillas[i][j] = new JLabel();
				casillas[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				casillas[i][j].setBounds(j*30, i*30, 30, 30);
				panelIzq.add(casillas[i][j]);
					}		
		}
		
		casillasSiguiente = new JLabel[4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				casillasSiguiente[i][j] = new JLabel();
				casillasSiguiente[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				casillasSiguiente[i][j].setBounds(j*30, i*30, 30, 30);
				panel.add(casillasSiguiente[i][j]);
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
			if (ran.nextInt(1000) == 420) {
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
	
	public void actualizar(int i, int j, ImageIcon nuevaImg){
        casillas[i][j].setIcon(new ImageIcon (nuevaImg.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
    }
	
	public void actualizarNext(int n) {
		switch (n) {
		case 0: lbl_next.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Texturas/Tetriminos/T_celeste.png")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));break;
		case 1: lbl_next.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Texturas/Tetriminos/O_amarillo.png")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));break;
		case 2: lbl_next.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Texturas/Tetriminos/I_naranja.png")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));break;
		case 3: lbl_next.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Texturas/Tetriminos/S_rojo.png")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));break;
		case 4: lbl_next.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Texturas/Tetriminos/Z_violeta.png")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));break;
		case 5: lbl_next.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Texturas/Tetriminos/J_azul.png")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));break;
		case 6: lbl_next.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/Texturas/Tetriminos/L_verde.png")).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
		}
	}
	
	public void actualizarPuntuación(int p) {
		lbl_puntuacion.setText(Integer.toString(p));
	}
	
	public void actualizarTiempo(int tiempo) {
		lbl_tiempo.setText(Integer.toString(tiempo));
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(null, "Game Over");
	}
	
	public void registrarJuego(Juego juego) {
		miJuego = juego;		
	}
}
