/**
 * 
 */
package gui;

import gui.GuiElementField.eStates;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public class GuiElementEditorField extends GuiElementField 
{

	/**
	 * 
	 */
	public GuiElementEditorField() 
	{
		super();
		
		eStates tmpAllowedLeftTypes[] = {eStates.BLANK, eStates.ARROW_N, eStates.ARROW_NE, eStates.ARROW_E, eStates.ARROW_SE, eStates.ARROW_S, eStates.ARROW_SW, eStates.ARROW_W, eStates.ARROW_NW};
		_allowedLeftTypes = tmpAllowedLeftTypes;
		
		eStates tmpAllowedRightTypes[] = {eStates.BLANK, eStates.STAR};
		_allowedRightTypes = tmpAllowedRightTypes;
	}

}
