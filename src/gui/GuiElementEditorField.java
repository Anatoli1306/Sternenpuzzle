/**
 * 
 */
package gui;

import gui.GuiElementField.eStates;

/**
 * Klasse definiert ein Feld im Editor Modus
 * 
 * @author Andreas, Fabian, Mats, Eren, Anatoli, Daniel
 * @version 0.1
 *
 */
public class GuiElementEditorField extends GuiElementField 
{

	/**
	 * Konstruktor
	 * 
	 * @param oBoard - Enthällt das Board
	 */
	public GuiElementEditorField(GuiElementBoard oBoard) 
	{
		super(oBoard);
		
		eStates tmpAllowedLeftTypes[] = {eStates.BLANK, eStates.ARROW_N, eStates.ARROW_NE, eStates.ARROW_E, eStates.ARROW_SE, eStates.ARROW_S, eStates.ARROW_SW, eStates.ARROW_W, eStates.ARROW_NW};
		_allowedLeftTypes = tmpAllowedLeftTypes;
		
		eStates tmpAllowedRightTypes[] = {eStates.BLANK, eStates.STAR};
		_allowedRightTypes = tmpAllowedRightTypes;
	}
	
	/**
	 * Funktion setzt den Status
	 * 
	 * @param eStates state - Status
	 */
	public void setState(eStates state)
	{
		super.setState(state);
		_oBoard.calculateStars();
	}

}
