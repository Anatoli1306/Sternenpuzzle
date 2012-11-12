package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
        JLabel x = new JLabel();
        x.setText("<html><p/><p/>Zeilen: <p/><p/></html>");
        x.setBounds(20, 35, 400, 50);
        
        final JTextField rows = new JTextField("10");
        rows.setBounds(75, 50, 25, 25);
        
        JLabel y = new JLabel();
        y.setText("<html><p/><p/>Spalten: <p/><p/></html>");
        y.setBounds(20, 75, 400, 50);
        
        final JTextField cols = new JTextField("10");
        cols.setBounds(75, 90, 25, 25);
        
        JButton ok = new JButton("OK");
        ok.setBounds(125, 60, 50, 50);
        ok.setBorder(null);
        
        ok.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0)
			{	
				zeile = new Integer(rows.getText());
				spalte = new Integer(cols.getText());
				
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
