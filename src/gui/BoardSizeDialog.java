package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * 
 * @author Fabian, Anatoli, Eren
 * @version 0.1
 *
 */
public class BoardSizeDialog extends JFrame{

	private

	int zeile;
	int spalte;

	public BoardSizeDialog(final PlayFrame playFrame){

		final JFrame frame = new JFrame("Spielfeldgröße");
		frame.setLayout(null);
		frame.setSize(230, 150);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/resources/boardSizeDialogBackground.png")));
		background.setLayout(null);
		background.setOpaque(false);
		background.setBounds(0,0,230,150);

		JLabel label = new JLabel();
		label.setText("<html><p/><p/>Geben Sie die Spielfeldgröße an: <p/><p/></html>");
		label.setForeground(Color.WHITE);
		label.setBounds(20, 5, 280, 25);

		JLabel x = new JLabel();
		x.setText("<html><p/><p/>Zeilen: <p/><p/></html>");
		x.setForeground(Color.WHITE);
		x.setBounds(25, 40, 50, 25);

		NumberFormat format = NumberFormat.getInstance();

		final JFormattedTextField rows = new JFormattedTextField(format);
		((javax.swing.text.NumberFormatter)rows.getFormatter()).setAllowsInvalid(false);
		rows.setText("10");
		rows.setBounds(70, 40, 20, 20);

		JLabel y = new JLabel();
		y.setText("<html><p/><p/>Spalten: <p/><p/></html>");
		y.setForeground(Color.WHITE);
		y.setBounds(120, 40, 50, 25);

		final JFormattedTextField cols = new JFormattedTextField(format);
		((javax.swing.text.NumberFormatter)cols.getFormatter()).setAllowsInvalid(false);
		cols.setText("10");
		cols.setBounds(175, 40, 20, 20);
		

		JButton ok = new JButton("OK");
		ok.setBounds(80, 80, 70, 30);
		ok.setBorder(null);

		ok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0)
			{	
				zeile = new Integer(rows.getText());
				spalte = new Integer(cols.getText());
				if (zeile < 5 || zeile > 50 ||spalte < 5|| spalte > 50){
					JOptionPane pane = new JOptionPane("Die Feldgröße muss zwischen 5 x 5 und 50 x 50 liegen!! ", JOptionPane.ERROR_MESSAGE);
					JDialog dialog = pane.createDialog("SternenHimmelPuzzle");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}
				else
				{
					if(playFrame._oBoard instanceof GuiElementGameBoard){
						playFrame.drawGameBoard(zeile,spalte);						
					}
					else
						playFrame.drawEditorBoard(zeile,spalte);					
					frame.dispose();
				}				
			}
		});


		frame.getContentPane().add(label);
		frame.getContentPane().add(rows);
		frame.getContentPane().add(x);
		frame.getContentPane().add(cols);
		frame.getContentPane().add(y);
		frame.getContentPane().add(ok);
		frame.getContentPane().add(background); 
		frame.setAlwaysOnTop(true);

		frame.repaint();
	}
}
