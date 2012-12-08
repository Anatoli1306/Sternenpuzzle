package gui;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// @ EREN: Bitte den entsprechend formatierten Hintergrund einfügen und Schrift auf weiss setzen. Nach Vollendung diesen Kommentar löschen!

/**
 * 
 * @author Eren, Fabian, Mats
 * @version 0.1
 *
 */

public class InstructionDialog {

	JFrame frame;
	//	JLabel label;
	JLabel backGroundImage;

	public InstructionDialog() {
		frame = new JFrame ("Sternenpuzzle - Info");
		//	        label = new JLabel ("");
		//	        label.setHorizontalAlignment(JLabel.CENTER);
		//	        label.setVerticalAlignment(JLabel.TOP);
		//	        label.setForeground(Color.white);
		//	        label.setText("<html><p/><p/><h1>Anleitung: </h1><p/><p/>" +
		//	        		"Zeichnen Sie die Sterne ein. <p/>"+
		//	        		"Auf jeden Stern muss mindestens ein Pfeil zeigen, <p/>" +
		//	        		"und jeder Pfeil muss mindestens auf einen Stern zeigen. <p/>" +
		//	        		"Pfeile zeigen auf die ganze Reihe, Spalte oder Diagonale; <p/>" +
		//	        		"auch über andere Pfeile und Sterne hinweg <p/>" +
		//	        		"Die Zahlen am Rand des Diagrams nennen die Anzahl der Sterne <p/>" +
		//	        		"in der entsprechenden Zeile, bezeihungsweise Spalte. <p/> <p/>" +
		//	        		"<h1>Tipp: </h1> <p/> <p/>" +
		//	        		"Finden Sie zuerst die Fehler, die von keinem Pfeil angezeigt werden. <p/>" +
		//	        		"Makieren Sie diese als Leerfelder. <p/>" +
		//	        		"Alle Zeilen und Spalten mit einer 1 und einem Pfeil, <p/>" +
		//	        		"der in die betreffende Reihe zeigt, können hinter dem Pfeil <p/>"+
		//	        		"mit Leerfeldern gekennzeichnet werden. <p/>"+
		//	        		"Schauen Sie sich jetzt die hohen Zahlen an. <p/>" +
		//	        		"Sind in der jeweiligen Reihe nur noch so viele Felder wie angegeben? <p/>" +
		//	        		"Suchen Sie am besten dort nach Sternen!");	        
		//	        frame.add(label);
		frame.setSize(472, 622);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		backGroundImage = new JLabel(new ImageIcon(getClass().getResource("/resources/instructionBackground.png")));
		backGroundImage.setLayout(null);
		backGroundImage.setOpaque(false);
		frame.getContentPane().add(backGroundImage);
		backGroundImage.setBounds(0,0,472,622);
	}
}
