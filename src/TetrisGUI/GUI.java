package TetrisGUI;

import java.awt.Dimension;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.tools.javac.Main;

import Game.Bloque;
import Game.Juego;
import exceptions.ImposibleRotar;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.awt.Color;

public class GUI extends JFrame {

	private static JPanel contentPane;
	private static double height;
	private static double width;
	private static Juego Tetris;
	private static JLabel[][] casillas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GUI frame = new GUI();
				frame.setVisible(true);
				frame.addKeyListener(new KeyListener() {
					public void keyTyped(KeyEvent e) {
						
					}

					public void keyPressed(KeyEvent e) {
						char c = e.getKeyChar();
						if(c == 'a') {
							Tetris.mover(1);
							actualizar();
						} else if (c == 'd') {
							Tetris.mover(0);
							actualizar();
						} else if (c == 'q') {
							try {
								Tetris.rotar();
								actualizar();
							} catch (ImposibleRotar e1) {
								System.out.println(e1.getMessage());
							}
							
						} 
					}

					public void keyReleased(KeyEvent e) {
						
					}
				});
				Clip clip;
				try {
					clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(
							getClass().getResourceAsStream("/Images/Music.wav"));
						    clip.open(inputStream);
						    clip.start();
				} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
					e1.printStackTrace();
				}
			    
			} });
	}
	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public GUI() {
		setForeground(Color.WHITE);
		height = Toolkit.getDefaultToolkit().getScreenSize().getHeight()-30;
		width = (height/23)*12;
		Dimension test = new Dimension(383, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()-30);
		test.setSize(width, height);
		//Dimension test = new Dimension(383, 735);
		//setExtendedState(6); FullScreen
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
		
		Tetris = new Juego();
		Tetris.crearTetrimino();
		casillas = new JLabel[23][12];
		for(int i=0; i<23; i++) {
			for(int j=0; j<12; j++) {
				casillas[i][j] = new JLabel();
				casillas[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				casillas[i][j].setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance((int) (width/12)-2, (int) (height/23)-3, Image.SCALE_DEFAULT)));
				//lblNewLabel.setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance(29, 29, Image.SCALE_DEFAULT)));
				contentPane.add(casillas[i][j]);
			}
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/icon.png")));
		setTitle("Tetris");
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    public void run() {
		       Tetris.descender();
		       actualizar();
		    }
		}, 0, 1000);
	}
	
	public static void actualizar() {
		for(int i=Tetris.getTetrimino().getAltMax()-1; i<=Tetris.getTetrimino().getAltMin(); i++) {
			for(int j=Tetris.getTetrimino().getBIzq()-1; j<Tetris.getTetrimino().getBDer()+2; j++) {
				casillas[i][j].setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance((int) (width/12)-2, (int) (height/23)-3, Image.SCALE_DEFAULT)));
			}
		}
	}
	
	
	
}