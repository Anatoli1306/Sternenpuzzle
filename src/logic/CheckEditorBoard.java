/**
 * 
 */
package logic;

import gui.GuiElementField.eStates;

/**
 * @author Andreas
 *
 */
public class CheckEditorBoard extends CheckBoard 
{	
	public CheckEditorBoard(Board oBoard)
	{
		setBoard(oBoard);
	}
	
	
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
	
	
	private boolean checkStar(int curX, int curY)
	{
		boolean error = false;

		// check if south arrow is pointing at star
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

		// check if south-west arrow is pointing at star
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

		// check if west arrow is pointing at star
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
		
		
		// check if north-west arrow is pointing at star
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
		
		
		// check if north arrow is pointing at star
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
		
		
		// check if north-east arrow is pointing at star
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
		
		
		// check if east arrow is pointing at star
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
		
		
		// check if south-east arrow is pointing at star
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
