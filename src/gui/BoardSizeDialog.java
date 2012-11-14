package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * 
 * @author Fabian, Anatoli
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
        
        JLabel label = new JLabel();
        label.setText("<html><p/><p/>Geben Sie die Spielfeldgröße an: <p/><p/></html>");
        label.setBounds(20, 5, 280, 25);
        
        JLabel x = new JLabel();
        x.setText("<html><p/><p/>Zeilen: <p/><p/></html>");
        x.setBounds(25, 40, 50, 25);
        
        final JTextField rows = new JTextField("10");
        rows.setBounds(70, 40, 20, 20);
        
        JLabel y = new JLabel();
        y.setText("<html><p/><p/>Spalten: <p/><p/></html>");
        y.setBounds(120, 40, 50, 25);
        
        final JTextField cols = new JTextField("10");
        cols.setBounds(175, 40, 20, 20);
        
        JButton ok = new JButton("OK");
        ok.setBounds(80, 80, 70, 30);
        ok.setBorder(null);
        
        ok.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0)
			{	
				try{
				zeile = new Integer(rows.getText());
				spalte = new Integer(cols.getText());
				if (zeile < 5 || zeile > 40 ||spalte < 5|| spalte >40){
					BoardRangeError brd = new BoardRangeError();
					return;
				}
				}catch(NumberFormatException ex){
					BoardSizeError boardSizeError = new BoardSizeError();
					
					return;
				}
				if(playFrame._oBoard instanceof GuiElementGameBoard){
					playFrame.drawGameBoard(zeile,spalte);						
				}
				else
					playFrame.drawEditorBoard(zeile,spalte);					
				frame.dispose();
			}
        });
        
        frame.getContentPane().add(label);
        frame.getContentPane().add(rows);
        frame.getContentPane().add(x);
        frame.getContentPane().add(cols);
        frame.getContentPane().add(y);
        frame.getContentPane().add(ok);
        frame.setAlwaysOnTop(true);
        
        frame.repaint();
	}
}
