package gui;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// Klasse beinhaltet Info-Fenster (Versionsangabe, Programmierer, Auftraggeber)

/**
 * Klasse beschreibt einen Info Dialog
 * Enthällt Informationen über das Spiel
 * 
 * @author Eren, Fabian, Mats, Andreas, Daniel, Anatoli
 * @version 0.1
 *
 */
public class InfoDialog {

	JFrame frame;
	JLabel backGroundImage;

	/**
	 * Konstruktor
	 *
	 */
	public InfoDialog() {
		// Frameeinstellungen 
		frame = new JFrame ("Sternenpuzzle - Info");

		frame.setSize(400, 520);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		// Hintergrundbild mit Text
		backGroundImage = new JLabel(new ImageIcon(getClass().getResource("/resources/infoBackground.png")));
		backGroundImage.setLayout(null);
		backGroundImage.setOpaque(false);
		frame.getContentPane().add(backGroundImage);
		backGroundImage.setBounds(0,0,400, 520);
		
		// Icon setzen
	    BufferedImage image = null;
		try {
			image = ImageIO.read(this.getClass().getResource("/resources/msIcon.ico"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    frame.setIconImage(image);
	}
	
	/**
	 * 
	 * @param image
	 */
	private void setIconImage(BufferedImage image) {
		// TODO Auto-generated method stub
		
	}
}
