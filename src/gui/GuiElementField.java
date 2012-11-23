/**
 * 
 */
package gui;

import java.awt.Image;
import java.awt.Toolkit;
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
	private eStates _currentState = null;
	
	
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
	 */
	
	public void setScaledImage(String path)
	{
		if (!_instancesOfImages.containsKey(path))
		{
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			
			Image oImage = toolkit.getImage(getClass().getResource(path));
			Image scaledImage = oImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);   
			ImageIcon oScaledIcon = new ImageIcon(scaledImage);
			
			_instancesOfImages.put(path, oScaledIcon);
		}
		
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
}
