/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import logic.Board;


/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public abstract class GuiElementBoard extends JComponent
{
	/**
	 * 
	 */
	private int _cols = 0;
	
	/**
	 * 
	 */
	private int _rows = 0;
	
	/**
	 * 
	 */
	protected Board _oLogicBoard = null;
	
	/**
	 * 
	 */
	protected GuiElementField[][] _fields = new GuiElementField[0][0];
	
	/**
	 * 
	 * @param int rows
	 * @param int cols
	 */
	
	public GuiElementBoard(int rows, int cols)
	{
		this._cols = cols;
		this._rows = rows;
	}
	
	@Override
	/**
	 * 
	 */
	
	protected void paintComponent(Graphics g) 
	{
	    super.paintComponent(g);
	    
	    // draw some lines
	    // yes i know you can't see them atm
	    for (int iY = 0; iY <= _rows; iY++)
		{
	    	g.setColor(Color.black);
			g.drawLine(0, iY*40, _cols * 40, iY*40);
		}
	    
	    for (int iX = 0; iX <= _cols; iX++)
		{
	    	g.setColor(Color.black);
			g.drawLine(iX*40, 0, iX*40, _rows *40);
		}
	    
	    // draw all buttons 
	    for (int iY = 0; iY < _rows; iY++)
		{
	    	for (int iX = 0; iX < _cols; iX++)
			{
	    		GuiElementField oGuiElementField = (GuiElementField)_fields[iY][iX];
	    		oGuiElementField.setLocation(iX *40, iY *40);
	    		add(oGuiElementField);
			}
		}
	}
	
	/**
	 * 
	 * @author Andreas
	 *
	 */
	protected class onClick implements ActionListener 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
	    	GuiElementField oGuiElementField = (GuiElementField)e.getSource();
	    	oGuiElementField.getNextState();
	    }
	 }

}
