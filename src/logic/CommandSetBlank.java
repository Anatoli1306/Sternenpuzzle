/**
 * 
 */
package logic;

import java.io.Serializable;

import gui.GuiElementField.eStates;

/**
 * Die CommandSetBlank Klasse dient dazu, um ein Feld Blank zu setzen.
 * Durch set und get Methoden können die Daten der CommandSetBlank Klasse gesetzt und ausgegeben werden.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */

public class CommandSetBlank implements ICommand, Serializable
{
	/**
	 * Dekleration der Variabeln für die Klasse
	 */
	GameField _oField = null;	
	eStates oldState = null;
	
	/**
	 * Das Feld was Blank gesetzt wereden soll, wird hier angegeben
	 * @param GameField - Hier wird das Feld angegeben, dass Blank gesetzt werden soll
	 */
	public CommandSetBlank(GameField field)
	{
		_oField = field;
		oldState = field.getState();
	}
	
	/**
	 * @see logic.ICommand#execute()
	 */
	
	/**
	 * Setzt das Feld blank
	 */
	public void execute()
	{
		_oField.setState(eStates.BLANK, true);
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
