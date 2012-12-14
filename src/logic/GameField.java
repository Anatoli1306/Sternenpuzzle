/**
 * 
 */
package logic;

import gui.GuiElementField.eStates;

/**
 * Die GameField Klasse dient dazu, um ein Spiel Feld zu erstellen.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */

public class GameField extends Field 
{

	/**
	 * Dekleration der Variabeln für die Klasse
	 */
	private boolean _isStar = false;
	
	
	/**
	 * Konstruktor für die GameField - Klasse
	 * Als parameter wird hier das Board, die Position auf der X Achse und die Position auf der Y Achse angegeben
	 * @param board - Hier wird das Editor Board angegeben
	 * @param xPos - Hier wird die Position auf der X Achse angegeben
	 * @param yPos - Hier wird die Position auf der Y Achse angegeben
	 */
	public GameField(Board oBoard, int xPos, int yPos) 
	{
		super(oBoard, xPos, yPos);
	}

	
	/**
	 * 
	 */
	public void action()
	{
		
	}
	
	/**
	 * Setzt den Status des Feldes
	 * @param state - Der Status wird hier übergeben
	 */
	public void setState(eStates state) 
	{
		ICommand command = null;
		switch (state) 
		{
			case BLANK:
				command = new CommandSetBlank(this);
				break;
			
			case STAR:
				command = new CommandSetStar(this);
				break;

			case QUESTION:
				command = new CommandSetQuestion(this);
				break;
				
			case CROSS:
				command = new CommandSetCross(this);
				break;
				
			default:
			break;
		}
		
		GameBoard oBoard = (GameBoard)_oBoard;
		oBoard.getCommandTracker().add(command);
		
		super.setState(state);
		
		GameBoard tmpBoard = (GameBoard)_oBoard;
		tmpBoard.checkIfGameIsWon();
	}
	
	/**
	 * Setzt den Status des Feldes
	 * @param state - Der Status wird hier übergeben
	 */
	public void setState(eStates state, int aas)
	{
		super.setState(state);
	}
	
	/**
	 * Wenn das übergebene Boolean True ist, wird das Feld als Stern - Feld abgespeichert
	 * @param star - Hier wird übergeben, ob das Feld ein Stern ist
	 */
	public void setIsStarField(boolean star)
	{
		_isStar = star;
	}
	
	/**
	 * Gibt an ob das Feld ein Stern beinhaltet
	 * @return _isStar - Gibt an ob das Feld ein Stern ist
	 */
	public boolean isStarField()
	{
		return _isStar;
	}
}
