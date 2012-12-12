package gui;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// @ EREN: Bitte den entsprechend formatierten Hintergrund einf�gen und Schrift auf weiss setzen. Nach Vollendung diesen Kommentar l�schen!

/**
 * 
 * @author Eren, Fabian, Mats
 * @version 0.1
 *
 */

public class InstructionDialog {

	JFrame frame;
	JLabel backGroundImage;

	public InstructionDialog() {
		frame = new JFrame ("Sternenpuzzle - Info");

		frame.setSize(472, 622);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		backGroundImage = new JLabel(new ImageIcon(getClass().getResource("/resources/instructionBackground.png")));
		backGroundImage.setLayout(null);
		backGroundImage.setOpaque(false);
		frame.getContentPane().add(backGroundImage);
		backGroundImage.setBounds(0,0,472,622);
		
		// Icon setzen
	    BufferedImage image = null;
		try {
			image = ImageIO.read(this.getClass().getResource("/resources/msIcon.ico"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    frame.setIconImage(image);
	}
}
