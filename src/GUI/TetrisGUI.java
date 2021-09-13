package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class TetrisGUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TetrisGUI frame = new TetrisGUI();
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
	public TetrisGUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TetrisGUI.class.getResource("/images/icon.png")));
		setTitle("Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 490);
		setExtendedState(6);
		getContentPane().setBackground(Color.DARK_GRAY);
		
	}
}
