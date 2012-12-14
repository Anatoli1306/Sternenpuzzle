/**
 * 
 */
package logic;

import gui.GuiElementField.eStates;

/**
 * Die CheckEditorBoard Klasse prüft das Editor Board nach der lösbarkeit.
 * Durch set und get Methoden können die Daten des Editor Boards gesetzt und ausgegeben werden.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */
public class CheckEditorBoard extends CheckBoard 
{	
	/**
	 * Konstruktor der Klasse CheckEditorBoard
	 * Das Editor Board wird gesetzt
	 * @param Board - Hier wird das Editor Board angegeben
	 */
	public CheckEditorBoard(Board oBoard)
	{
		setBoard(oBoard);
	}
	
	/**
	 * Die Funktion check prüft das Board nach Fehlern
	 * @return error - Wenn das Editor Board Fehler enthält wird hier ein true zurückgegeben
	 */
	public boolean check()
	{
		boolean error = false;
		
		for (int iY = 0; iY < _oBoard.getHeight(); iY++) 
		{
			for (int iX = 0; iX < _oBoard.getWidth(); iX++) 
			{
				Field oField = _oBoard.getField(iY, iX);
				if (oField.getState() == eStates.STAR)
				{
					error = this.checkStar(iX, iY);
				}
				else if (oField.getState() == eStates.ARROW_N)
				{
					error = true;
					for (int iCheckY = iY; iCheckY >= 0; iCheckY--)
					{
						Field oTmpField = _oBoard.getField(iCheckY, iX);
						if (oTmpField.getState() == eStates.STAR)
						{
							error = false;
							break;
						}
					}
				}
				else if (oField.getState() == eStates.ARROW_NE)
				{
					int diffWidth = _oBoard.getWidth() - iX -1;
					int diffHeight = iY;
					
					int minDiff = Math.min(diffWidth, diffHeight);

					error = true;
					for (int iCheck = 1; iCheck <= minDiff; iCheck++)
					{
						Field oTmpField = _oBoard.getField(iY-iCheck, iX+iCheck);
						if (oTmpField.getState() == eStates.STAR)
						{
							error = false;
							break;
						}
					}
				}
				else if (oField.getState() == eStates.ARROW_E)
				{
					error = true;
					for (int iCheckX = iX; iCheckX < _oBoard.getWidth(); iCheckX++)
					{
						Field oTmpField = _oBoard.getField(iY, iCheckX);
						if (oTmpField.getState() == eStates.STAR)
						{
							error = false;
							break;
						}
					}
				}
				else if (oField.getState() == eStates.ARROW_SE)
				{
					int diffWidth = _oBoard.getWidth() - iX -1;
					int diffHeight = _oBoard.getHeight() - iY -1;

					int minDiff = Math.min(diffWidth, diffHeight);
					
					error = true;
					for (int iCheck = 1; iCheck <= minDiff; iCheck++)
					{
						Field oTmpField = _oBoard.getField(iY+iCheck, iX+iCheck);
						if (oTmpField.getState() == eStates.STAR)
						{
							error = false;
							break;
						}
					}
				}
				else if (oField.getState() == eStates.ARROW_S)
				{
					error = true;
					for (int iCheckY = iY; iCheckY < _oBoard.getHeight(); iCheckY++)
					{
						Field oTmpField = _oBoard.getField(iCheckY, iX);
						if (oTmpField.getState() == eStates.STAR)
						{
							error = false;
							break;
						}
					}
				}
				else if (oField.getState() == eStates.ARROW_SW)
				{
					int diffWidth = iX;
					int diffHeight = _oBoard.getHeight() - iY -1;

					int minDiff = Math.min(diffWidth, diffHeight);
					
					error = true;
					for (int iCheck = 1; iCheck <= minDiff; iCheck++)
					{
						Field oTmpField = _oBoard.getField(iY+iCheck, iX-iCheck);
						if (oTmpField.getState() == eStates.STAR)
						{
							error = false;
							break;
						}
					}
				}
				else if (oField.getState() == eStates.ARROW_W)
				{
					error = true;
					for (int iCheckX = iX; iCheckX >= 0; iCheckX--)
					{
						Field oTmpField = _oBoard.getField(iY, iCheckX);
						if (oTmpField.getState() == eStates.STAR)
						{
							error = false;
							break;
						}
					}
				}
				else if (oField.getState() == eStates.ARROW_NW)
				{
					int diffWidth = iX;
					int diffHeight = iY;
					
					int minDiff = Math.min(diffWidth, diffHeight);
					
					error = true;
					for (int iCheck = 1; iCheck <= minDiff; iCheck++)
					{
						Field oTmpField = _oBoard.getField(iY-iCheck, iX-iCheck);
						if (oTmpField.getState() == eStates.STAR)
						{
							error = false;
							break;
						}
					}
				}
				
				if (error)
				{
					return error;
				}
			}
		}

		
		return error;
	}
	
	/**
	 * Die Funktion checkStar prüft ob in allen Richtungen ein Stern existiert
	 * @param curX - Hier wird die Position des Sterns auf der X Achse angegeben
	 * @param curY - Hier wird die Position des Sterns auf der Y Achse angegeben
	 */
	private boolean checkStar(int curX, int curY)
	{
		boolean error = false;

		// Prüft ob es im Süd Bereich ein Stern existiert
		error = true;
		for (int iCheckY = curY; iCheckY >= 0; iCheckY--)
		{
			Field oTmpField = _oBoard.getField(iCheckY, curX);
			if (oTmpField.getState() == eStates.ARROW_S)
			{
				error = false;
				break;
			}
		}
		
		if (!error)
		{
			return error;
		}

		// Prüft ob Süd-West Bereich ein Stern existiert
		int diffWidth = _oBoard.getWidth() - curX -1;
		int diffHeight = curY;
		
		int minDiff = Math.min(diffWidth, diffHeight);
		
		error = true;
		for (int iCheck = 1; iCheck <= minDiff; iCheck++)
		{
			Field oTmpField = _oBoard.getField(curY-iCheck, curX+iCheck);
			if (oTmpField.getState() == eStates.ARROW_SW)
			{
				error = false;
				break;
			}
		}
		
		if (!error)
		{
			return error;
		}

		// Prüft ob im Westen Bereich ein Stern existiert
		error = true;
		for (int iCheckX = curX; iCheckX < _oBoard.getWidth(); iCheckX++)
		{
			Field oTmpField = _oBoard.getField(curY, iCheckX);
			if (oTmpField.getState() == eStates.ARROW_W)
			{
				error = false;
				break;
			}
		}
		
		if (!error)
		{
			return error;
		}
		
		
		// Prüft ob es im Nord-West Bereich ein Stern existiert
		diffWidth = _oBoard.getWidth() - curX -1;
		diffHeight = _oBoard.getHeight() - curY -1;

		minDiff = Math.min(diffWidth, diffHeight);
		
		error = true;
		for (int iCheck = 1; iCheck <= minDiff; iCheck++)
		{
			Field oTmpField = _oBoard.getField(curY+iCheck, curX+iCheck);
			if (oTmpField.getState() == eStates.ARROW_NW)
			{
				error = false;
				break;
			}
		}
		
		if (!error)
		{
			return error;
		}
		
		
		// Prüft ob es im Nord Bereich ein Stern existiert
		error = true;
		for (int iCheckY = curY; iCheckY < _oBoard.getHeight(); iCheckY++)
		{
			Field oTmpField = _oBoard.getField(iCheckY, curX);
			if (oTmpField.getState() == eStates.ARROW_N)
			{
				error = false;
				break;
			}
		}
		
		if (!error)
		{
			return error;
		}
		
		
		// Prüft ob es im Nord-Osten Bereich ein Stern existiert
		diffWidth = curX;
		diffHeight = _oBoard.getHeight() - curY -1;

		minDiff = Math.min(diffWidth, diffHeight);
		
		error = true;
		for (int iCheck = 1; iCheck <= minDiff; iCheck++)
		{
			Field oTmpField = _oBoard.getField(curY+iCheck, curX-iCheck);
			if (oTmpField.getState() == eStates.ARROW_NE)
			{
				error = false;
				break;
			}
		}
		
		if (!error)
		{
			return error;
		}
		
		
		// Prüft ob es im Osten Bereich ein Stern existiert
		error = true;
		for (int iCheckX = curX; iCheckX >= 0; iCheckX--)
		{
			Field oTmpField = _oBoard.getField(curY, iCheckX);
			if (oTmpField.getState() == eStates.ARROW_E)
			{
				error = false;
				break;
			}
		}
		
		if (!error)
		{
			return error;
		}
		
		
		// Prüft ob es im Süd-Ost Bereich ein Stern existiert
		diffWidth = curX;
		diffHeight = curY;
		
		minDiff = Math.min(diffWidth, diffHeight);

		error = true;
		for (int iCheck = 1; iCheck <= minDiff; iCheck++)
		{
			Field oTmpField = _oBoard.getField(curY-iCheck, curX-iCheck);
			if (oTmpField.getState() == eStates.ARROW_SE)
			{
				error = false;
				break;
			}
		}
		
		return error;
	}
}
