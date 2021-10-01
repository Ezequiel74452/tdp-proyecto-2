package TetrisGUI;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Game.Juego;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI2 {

	private JFrame frame;
	private static double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight()-30;
	private static double width = (height/23)*12;
	private Dimension test = new Dimension((int)width+300, (int) height);
	private static Juego Tetris;
	private static JLabel[][] casillas;
	private JPanel panel = new JPanel();
	private static JLabel Prox = new JLabel("");
	private static JLabel Puntuaci�n = new JLabel("0");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
					window.frame.setVisible(true);
					window.frame.addKeyListener(new KeyListener() {
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
								Tetris.rotar();
								actualizar();
							} 
						}

						public void keyReleased(KeyEvent e) {
							
						}
					});
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setPreferredSize(test);
		frame.setResizable(false);
		frame.pack();
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 669, 699);
		frame.getContentPane().add(splitPane);
		
		splitPane.setLeftComponent(panel);
		
		panel.setBackground(Color.BLACK);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(23, 12, 0, 0));
		panel.setBounds(0, 0, (int) width, (int) height);
		panel.setPreferredSize(new Dimension((int) width-50, (int) height));
		
		Tetris = new Juego();
		casillas = new JLabel[23][12];
		for(int i=0; i<23; i++) {
			for(int j=0; j<12; j++) {
				casillas[i][j] = new JLabel();
				casillas[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				casillas[i][j].setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance((int) (width/12)-2, (int) (height/23)-3, Image.SCALE_DEFAULT)));
				//lblNewLabel.setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance(29, 29, Image.SCALE_DEFAULT)));
				panel.add(casillas[i][j]);
			}
		}
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI2.class.getResource("/images/icon.png")));
		frame.setTitle("Tetris");
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		
		Image im = Tetris.getSiguiente().getImagen().getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imic = new ImageIcon(im);
		Prox.setIcon(imic);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00F3ximo tetrimino:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("Puntaje:");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(109)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(92)
							.addComponent(Prox))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(126)
							.addComponent(lblNewLabel))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(Puntuaci�n)
							.addGap(65)))
					.addContainerGap(440, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(52)
					.addComponent(Puntuaci�n)
					.addGap(72)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Prox)
					.addContainerGap(394, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    public void run() {
		       Tetris.descender();
		    }
		}, 0, 500);
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
	
	public static void actualizarNext() {
		Image im = Tetris.getSiguiente().getImagen().getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imic = new ImageIcon(im);
		Prox.setIcon(imic);
	}
	
	public static void actualizarPuntuaci�n() {
		Puntuaci�n.setText(Integer.toString(Tetris.getPuntos()));
	}
}