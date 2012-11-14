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
					
				}
				else if (oField.getState() == eStates.ARROW_N)
				{
					error = true;
					for (int iCheckY = iY; iCheckY > 0; iCheckY--)
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
					int diffWidth = _oBoard.getWidth() - iX;
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
					int diffWidth = _oBoard.getWidth() - iX;
					int diffHeight = _oBoard.getHeight() - iY;

					int minDiff = Math.min(diffWidth, diffHeight);
					
					error = true;
					for (int iCheck = 1; iCheck < minDiff; iCheck++)
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
					int diffHeight = _oBoard.getHeight() - iY;
					System.out.println(diffWidth);
					System.out.println(diffHeight);
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
					for (int iCheckX = iX; iCheckX > 0; iCheckX--)
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
}
