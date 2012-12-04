/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import logic.Board;
import logic.Field;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

abstract public class GuiElementField extends JButton
{
	/**
	 *
	 */
	public static enum eStates 
	{
	    BLANK, 
	    STAR, 
	    CROSS, 
	    QUESTION,
	    ARROW_N,
	    ARROW_E,
	    ARROW_S,
	    ARROW_W,
	    ARROW_NW,
	    ARROW_NE,
	    ARROW_SW,
	    ARROW_SE,
	}
	
	/**
	 * 
	 */
	protected Map<eStates, String> _eStateToResource = new HashMap<eStates, String>();
	
	/**
	 * this mapping speed things up.
	 * instead of resizing alle images everytime
	 * we store the resized image
	 */
	private static Map<String, ImageIcon> _instancesOfImages = new HashMap<String, ImageIcon>();
	
	/**
	 * this mapping speed things up.
	 * instead of resizing alle images everytime
	 * we store the resized image
	 */
	private static Map<String, ImageIcon> _instancesOfHighlightedImages = new HashMap<String, ImageIcon>();

	/**
	 * 
	 */
	protected eStates _allowedLeftTypes[] = null;
	
	/**
	 * 
	 */
	protected eStates _allowedRightTypes[] = null;
	
	/**
	 * 
	 */
	protected eStates _currentState = null;
	
	
	/**
	 * 
	 */
	protected GuiElementBoard _oBoard = null;
	
	/**
	 * 
	 */
	protected Field _oLogicField = null;
	
	/**
	 * 
	 */
	public GuiElementField(GuiElementBoard oBoard) 
	{
		_eStateToResource.put(eStates.BLANK, "/resources/fieldBlank.png");
		_eStateToResource.put(eStates.STAR, "/resources/fieldStar.png");
		_eStateToResource.put(eStates.CROSS, "/resources/fieldCross.png");
		_eStateToResource.put(eStates.QUESTION, "/resources/fieldQuestion.png");
		_eStateToResource.put(eStates.ARROW_N, "/resources/fieldArrowN.png");
		_eStateToResource.put(eStates.ARROW_NE, "/resources/fieldArrowNE.png");
		_eStateToResource.put(eStates.ARROW_E, "/resources/fieldArrowE.png");
		_eStateToResource.put(eStates.ARROW_SE, "/resources/fieldArrowSE.png");
		_eStateToResource.put(eStates.ARROW_S, "/resources/fieldArrowS.png");
		_eStateToResource.put(eStates.ARROW_SW, "/resources/fieldArrowSW.png");
		_eStateToResource.put(eStates.ARROW_W, "/resources/fieldArrowW.png");
		_eStateToResource.put(eStates.ARROW_NW, "/resources/fieldArrowNW.png");
		
		setContentAreaFilled(false);
		_oBoard = oBoard;
		setFocusPainted(false);
		setFocusable(false);
	}
	
	/**
	 * 
	 * @param eStates state
	 */
	public void setState(eStates state)
	{
		_currentState = state;
		_oLogicField.setState(state);
		setScaledImage(_eStateToResource.get(state));
	}
	
	/**
	 * 
	 * @param eStates state
	 */
	public void setState(eStates state, int skipTracker)
	{
		_currentState = state;
		_oLogicField.setState(state, skipTracker);
		setScaledImage(_eStateToResource.get(state));
	}
	
	/**
	 * 
	 * @param String path
	 */
	
	public void setScaledImage(String path)
	{
		if (!_instancesOfImages.containsKey(path))
		{
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			ImageIcon oScaledIcon = null;
			
			if (_eStateToResource.get(eStates.BLANK) == path)
			{
				Image oImage = toolkit.getImage(getClass().getResource(path));
				Image scaledImage = oImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);   
				oScaledIcon = new ImageIcon(scaledImage);
				
				Image oImageHighlight = toolkit.getImage(getClass().getResource("/resources/fieldBlankHighlight.png"));
				Image scaledImageHighlight = oImageHighlight.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);   
				ImageIcon oScaledIconHighlight = new ImageIcon(scaledImageHighlight);
				_instancesOfHighlightedImages.put(path, oScaledIconHighlight);
			}
			else
			{
				if (!_instancesOfImages.containsKey(_eStateToResource.get(eStates.BLANK)))
				{
					Image oImage = toolkit.getImage(getClass().getResource(_eStateToResource.get(eStates.BLANK)));
					Image scaledImage = oImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);   
					oScaledIcon = new ImageIcon(scaledImage);
					_instancesOfImages.put(_eStateToResource.get(eStates.BLANK), oScaledIcon);
					
					Image oImageHighlight = toolkit.getImage(getClass().getResource("/resources/fieldBlankHighlight.png"));
					Image scaledImageHighlight = oImageHighlight.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);   
					ImageIcon oScaledIconHighlight = new ImageIcon(scaledImageHighlight);
					_instancesOfHighlightedImages.put(_eStateToResource.get(eStates.BLANK), oScaledIconHighlight);
				}
				
				ImageIcon oBackgroundImage = _instancesOfImages.get(_eStateToResource.get(eStates.BLANK));
				ImageIcon oBackgroundImageHighlight = _instancesOfHighlightedImages.get(_eStateToResource.get(eStates.BLANK));
				
				Image oImage = toolkit.getImage(getClass().getResource(path));
				
				int getMin = Math.min(getWidth(), getHeight());
				
				Image scaledForegroundImage = oImage.getScaledInstance(getMin, getMin, Image.SCALE_DEFAULT);
				ImageIcon oScaledIconForeground = new ImageIcon(scaledForegroundImage);
				
				BufferedImage combined = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

				Graphics g = combined.getGraphics();
				g.drawImage(oBackgroundImage.getImage(), 0, 0, null);
				g.drawImage(oScaledIconForeground.getImage(), ((getWidth() - getMin)/2), ((getHeight() - getMin)/2), null);
				
				oScaledIcon = new ImageIcon(combined);
				
				BufferedImage combinedHighlight = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
				Graphics g1 = combinedHighlight.getGraphics();
				g1.drawImage(oBackgroundImageHighlight.getImage(), 0, 0, null);
				g1.drawImage(oScaledIconForeground.getImage(), ((getWidth() - getMin)/2), ((getHeight() - getMin)/2), null);
				
				ImageIcon oScaledIconHighlight = new ImageIcon(combinedHighlight);
				_instancesOfHighlightedImages.put(path, oScaledIconHighlight);
			}
			
			
			_instancesOfImages.put(path, oScaledIcon);
		}
		
		setContentAreaFilled(false);
		setIcon(_instancesOfImages.get(path));
		repaint();
	}
	
	
	/**
	 * 
	 */
	
	public void setNextLeftState()
	{
		getNextState(_allowedLeftTypes);
	}
	
	
	/**
	 * 
	 */
	
	public void setNextRightState()
	{
		getNextState(_allowedRightTypes);
	}
	
	
	/**
	 * 
	 */
	
	public void getNextState(eStates allowedStates[])
	{
		boolean found = false;
		for (int i = 0; i < allowedStates.length; i++) 
		{
			if (allowedStates[i] == _currentState)
			{
				found = true;
				if (i == (allowedStates.length - 1))
				{
					setState(allowedStates[0]);
					break;
				}
				else
				{
					setState(allowedStates[i+1]);
					break;
				}
			}
		}
		
		// if _currentState is unknown, set first element to new state
		if (!found)
		{
			setState(allowedStates[1]);
		}
	}
	
	
	/**
	 * clear image cache
	 * call when board size is changed so that all images are newly rezized
	 */
	
	public static void clearImageCache()
	{
		_instancesOfImages = new HashMap<String, ImageIcon>();
		_instancesOfHighlightedImages = new HashMap<String, ImageIcon>();
	}
	
	/**
	 * 
	 * @param Field oLogicField
	 * 
	 */
	public void setLogicField(Field oLogicField)
	{
		_oLogicField = oLogicField;
	}
	
	public eStates getState()
	{
		return _currentState;
	}

	
	public void setToHighlightField()
	{
		String path = _eStateToResource.get(_currentState);
		setIcon(_instancesOfHighlightedImages.get(path));
		repaint();
	}
	
	public void setToNormalField()
	{
		String path = _eStateToResource.get(_currentState);
		setIcon(_instancesOfImages.get(path));
		repaint();
	}
	
	/**
	 * @return the _xPos
	 */
	public int getXPos() {
		return _oLogicField.getXPos();
	}

	/**
	 * @return the _yPos
	 */
	public int getYPos() {
		return _oLogicField.getYPos();
	}
	
	public void markAsBadStar()
	{
		setBackground(new Color(255, 0, 0));
		setContentAreaFilled(true);
		repaint();
	}
}
