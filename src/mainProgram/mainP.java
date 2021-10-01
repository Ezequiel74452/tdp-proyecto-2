package mainProgram;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Game.Juego;
import Game.Reloj;
import TetrisGUI.GUI;

public class mainP {

		/**
		 * Launch the application.
		 */

		public static void main(String[] args) {
			   Reloj r;
			   Juego Tetris;
			   
				Tetris = new Juego();
				r = new Reloj(Tetris);
				Thread d= new Thread(r);
				d.start();
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						GUI frame = new GUI(Tetris);
						frame.setVisible(true);
						frame.setFocusable(true);
						
						frame.addKeyListener(new KeyListener() {
							public void keyTyped(KeyEvent e) {
								
							}

							public void keyPressed(KeyEvent e) {
								char c = e.getKeyChar();
								if(c == 'a' && !Tetris.getGameOver()) {
									Tetris.mover(1);
								} else if (c == 'd' && !Tetris.getGameOver()) {
									Tetris.mover(0);
								} else if (c == 's' && !Tetris.getGameOver()) {
									Tetris.descender();
								} else if (c == 'q' && !Tetris.getGameOver()) {
									
										Tetris.rotar();
										GUI.actualizar();							
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
		}




