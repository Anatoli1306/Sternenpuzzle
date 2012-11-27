package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Anatoli
 * @version 0.1
 *
 */
public class BoardSizeError {

	public BoardSizeError(){
		
		final JFrame frame = new JFrame("Spielfeldgröße");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,150);
		frame.setVisible(true);
		frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        JLabel label = new JLabel();
        label.setText("<html><p/><p/>Die Eingabe darf keine Buchstaben oder Sonderzeichen enthalten! <p/><p/></html>");
        label.setBounds(30, 10, 250, 50);
        
        JButton ok = new JButton("OK");
        ok.setBounds(100, 80, 70, 30);
        ok.setBorder(null);
        ok.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0)
			{	
				frame.dispose();
			}
        });
		
        frame.getContentPane().add(label);
        frame.getContentPane().add(ok);
        frame.setAlwaysOnTop(true);
        frame.repaint();
	}
}
