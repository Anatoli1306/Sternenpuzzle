package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;

import javax.swing.*;
import javax.swing.border.Border;

public class BoardSizeDialog extends JFrame{

	private

	int zeile;
	int spalte;

	public BoardSizeDialog(final PlayFrame playFrame){

		final JFrame frame = new JFrame("Spielfeldgröße");
		frame.setLayout(null);
		frame.setSize(200, 180);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);


		JLabel label = new JLabel();
		label.setText("<html><p/><p/>Geben Sie die Spielfeldgröße an: <p/><p/></html>");
		label.setBounds(5, 5, 400, 50);
		label.setForeground(Color.white);

		JLabel x = new JLabel();
		x.setText("<html><p/><p/>Zeilen: <p/><p/></html>");
		x.setBounds(20, 35, 400, 50);
		x.setForeground(Color.white);

		NumberFormat format = NumberFormat.getInstance();

		final JFormattedTextField rows = new JFormattedTextField(format);
		((javax.swing.text.NumberFormatter)rows.getFormatter()).setAllowsInvalid(false);
		rows.setText("10");
		rows.setBounds(75, 50, 25, 25);

		JLabel y = new JLabel();
		y.setText("<html><p/><p/>Spalten: <p/><p/></html>");
		y.setBounds(20, 75, 400, 50);
		y.setForeground(Color.white);


		final JFormattedTextField cols = new JFormattedTextField(format);
		((javax.swing.text.NumberFormatter)cols.getFormatter()).setAllowsInvalid(false);
		cols.setText("10");
		cols.setBounds(75, 90, 25, 25);

		JButton ok = new JButton("OK");
		ok.setBounds(125, 60, 50, 50);
		ok.setBorder(null);

		ok.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0)
			{	
				zeile = new Integer(rows.getText());
				spalte = new Integer(cols.getText());
				JOptionPane pane = new JOptionPane();

				if(zeile > 1 || spalte > 1)
				{
					if(zeile > 50 || spalte > 50)
					{
						pane = new JOptionPane("Zeile und Spalte dürfen nicht größer als 50 sein", JOptionPane.ERROR_MESSAGE);
						JDialog dialog = pane.createDialog("SternenHimmelPuzzle");
						dialog.setAlwaysOnTop(true);
						dialog.setVisible(true);
					}
					else
					{
						if(playFrame._oBoard instanceof GuiElementGameBoard)
						{
							playFrame.drawGameBoard(zeile,spalte);			
							frame.dispose();
						}
						else
						{
							playFrame.drawEditorBoard(zeile,spalte);	
							frame.dispose();
						}
					}

				}
				else
				{
					pane = new JOptionPane("Zeile und Spalte müssen größer als 1 sein", JOptionPane.ERROR_MESSAGE);
					JDialog dialog = pane.createDialog("SternenHimmelPuzzle");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
				}								

			}
		});

		frame.getContentPane().add(label);
		frame.getContentPane().add(rows);
		frame.getContentPane().add(x);
		frame.getContentPane().add(cols);
		frame.getContentPane().add(y);
		frame.getContentPane().add(ok);
		frame.setAlwaysOnTop(true);

		JLabel backGroundImage = new JLabel(new ImageIcon(getClass().getResource("/resources/boardSizeDialogBackground.png")));
		backGroundImage.setLayout(null);
		backGroundImage.setOpaque(false);
		frame.getContentPane().add(backGroundImage);
		backGroundImage.setBounds(0,0,200,180);

		frame.repaint();
	}
}
