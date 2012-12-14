/**
 * 
 */
package logic;

import java.io.Serializable;

import gui.GuiElementField.eStates;

/**
 * Die CommandSetQuestion Klasse dient dazu, um ein Fragezeichen in das Feld zu setzen.
 * Durch set und get Methoden können die Daten der CommandSetQuestion Klasse gesetzt und ausgegeben werden.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */

public class CommandSetQuestion implements ICommand, Serializable
{
	/**
	 * Dekleration der Variabeln für die Klasse
	 */
	GameField _oField = null;	
	eStates oldState = null;

	/**
	 * Das Feld wo ein Fragezeichen gesetzt wereden soll, wird hier angegeben
	 * @param GameField - Hier wird das Feld angegeben, wo das Fragezeichen gesetzt werden soll
	 */
	public CommandSetQuestion(GameField field)
	{
		_oField = field;
		oldState = field.getState();
	}
	
	/**
	 * @see logic.ICommand#execute()
	 */
	
	/**
	 * Setzt ein Fragezeichen in das Feld
	 */
	public void execute() 
	{
		_oField.setState(eStates.QUESTION, true);
	}

	/**
	 * @see logic.ICommand#execute()
	 */
	
	/**
	 * Setzt den Status des Feldes wieder zurück
	 */
	public void undo() 
	{
		_oField.setState(oldState, true);
	}

}
