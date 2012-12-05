/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public class DemoForm extends JFrame
{
	
	public DemoForm()
	{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		final JPanel oPanel = (JPanel)getContentPane();
		oPanel.setLayout(null);
		
		final JButton oButtonGame = new JButton();
		oButtonGame.setBounds(10, 10, 150, 30);
		oButtonGame.setText("Spiele Board");
		
		final JButton oButtonEditor = new JButton();
		oButtonEditor.setBounds(10, 50, 150, 30);
		oButtonEditor.setText("Editor Board");
		
		oPanel.add(oButtonGame);
		oPanel.add(oButtonEditor);
		
		
		oButtonGame.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent ae) 
            {
            	// clear Panel, add Buttons, add Gameboard
            	oPanel.removeAll();
        		oPanel.add(oButtonGame);
        		oPanel.add(oButtonEditor);
            	
            	GuiElementGameBoard oGameBoard = new GuiElementGameBoard(10, 10);
        		oGameBoard.setBounds(10, 100, 500, 500);
        		oPanel.add(oGameBoard);
        		oPanel.repaint();
            }
        });

		oButtonEditor.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent ae) 
            {
            	// clear Panel, add Buttons, add Editorboard
            	oPanel.removeAll();
        		oPanel.add(oButtonGame);
        		oPanel.add(oButtonEditor);
        		
            	GuiElementEditorBoard oEditorBoard = new GuiElementEditorBoard(10, 10);
            	oEditorBoard.setBounds(10, 100, 500, 500);
            	oPanel.add(oEditorBoard);
            	oPanel.repaint();
            }
        });
	}
	
	
}
