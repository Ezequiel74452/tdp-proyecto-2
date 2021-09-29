package TetrisGUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Color;
import Game.Juego;
import exceptions.ImposibleRotar;

@SuppressWarnings("serial")
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
						} else if (c == 'd') {
							Tetris.mover(0);
						} else if (c == 's') {
							Tetris.descender();
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
				try {
					Clip clip;
					Random ran = new Random();
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
		    }
		}, 0, 1000);
	}
	
	/*public static void actualizar() {
		for(int i=Tetris.getTetrimino().getAltMax()-1; i<=Tetris.getTetrimino().getAltMin(); i++) {
			for(int j=Tetris.getTetrimino().getBIzq()-1; j<Tetris.getTetrimino().getBDer()+2; j++) {
				casillas[i][j].setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance((int) (width/12)-2, (int) (height/23)-3, Image.SCALE_DEFAULT)));
			}
		}
	}*/
	
	public static void actualizar() {
        int iArriba=Tetris.getTetrimino().getAltMax()-2;
        if(iArriba<0)
            iArriba=0;

        int iAbajo =Tetris.getTetrimino().getAltMin()+2;
        if(iAbajo>22)
            iAbajo=22;

        for(int i=iArriba; i<=iAbajo; i++) {
            for(int j=0; j<12; j++) {
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