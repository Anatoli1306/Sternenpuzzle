/**
 * 
 */
package gui;

import gui.GuiElementField.eStates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logic.Board;


/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public abstract class GuiElementBoard extends JScrollPane
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
	private int _elementWidth = 40;
	
	/**
	 * 
	 */
	private int _elementHeight = 40;
	
	/**
	 * 
	 */
	protected Board _oLogicBoard = null;
	
	/**
	 * 
	 */
	protected JPanel _container = null;
	
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
		
		_container = new JPanel();
		_container.setLayout(null);
		_container.setLocation(0, 0);
		
		
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) 
	{
		// TODO Auto-generated method stub
		super.setBounds(x, y, width, height);
		initControls();
	}
	
	
	/**
	 * 
	 * 
	 */
	
	public void initControls()
	{
		if (_rows > 15)
		{
	    	// enable scrollbars
	    	_elementHeight = (getHeight()) / 15;
	    	setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		}
		else
		{
			_elementHeight = (getHeight()) / _rows;
			setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		}
	    
	    if (_cols > 15)
		{
	    	// enable scrollbars
	    	_elementWidth = (getWidth()) / 15;
	    	setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		}
		else
		{
			_elementWidth = (getWidth()) / _cols;
			setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
		}
	    
	    _container.setSize(_elementWidth * _cols, _elementHeight * _rows);
	    _container.setPreferredSize(_container.getSize());
	    
	    // draw all buttons 
	    for (int iY = 0; iY < _rows; iY++)
		{
	    	for (int iX = 0; iX < _cols; iX++)
			{
	    		GuiElementField oGuiElementField = (GuiElementField)_fields[iY][iX];
	    		oGuiElementField.setLocation((iX) *_elementWidth, (iY) *_elementHeight);
	    		oGuiElementField.setSize(_elementWidth, _elementHeight);
	    		oGuiElementField.setState(eStates.BLANK);
	    		_container.add(oGuiElementField);
			}
		}
	    
		setViewportView(_container);
	}
	
	/**
	 * 
	 * @author Andreas
	 *
	 */
	protected class onClick implements MouseListener 
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				GuiElementField oGuiElementField = (GuiElementField)e.getSource();
		    	oGuiElementField.setNextLeftState();
			}
			else if (e.getButton() == MouseEvent.BUTTON3)
			{
				GuiElementField oGuiElementField = (GuiElementField)e.getSource();
		    	oGuiElementField.setNextRightState();
			}
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			GuiElementField oGuiElementField = (GuiElementField)e.getSource();
			oGuiElementField.requestFocusInWindow();
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	 }

}
