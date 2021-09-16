package TetrisGUI;

import java.awt.Dimension;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Game.Bloque;
import Game.Juego;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import javax.imageio.ImageIO;
import java.awt.Color;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setForeground(Color.WHITE);
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight()-30;
		double width = (height/23)*12;
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
		
		Juego Tetris = new Juego();
		Tetris.crearTetrimino();
		for(int i=0; i<23; i++) {
			for(int j=0; j<12; j++) {
				JLabel lblNewLabel = new JLabel();
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance((int) (width/12)-2, (int) (height/23)-3, Image.SCALE_DEFAULT)));
				//lblNewLabel.setIcon(new ImageIcon(Tetris.obtenerBloque(i, j).getTextura().getImage().getScaledInstance(29, 29, Image.SCALE_DEFAULT)));
				contentPane.add(lblNewLabel);
			}
		}
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/images/icon.png")));
		setTitle("Tetris");
		
		
	}

}
