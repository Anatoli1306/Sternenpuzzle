/**
 * 
 */
package logic;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import gui.GuiElementField;
import gui.GuiElementField.eStates;

/**
 * @author Andreas
 *
 */
public class CheckEditorBoardDifficulty 
{
	/**
	 *
	 */
	public static enum eStatesDiff
	{
	    BLOCKED,
	    ISSTAR,
	}
	
	Board _oBoard = null;
	
	
	eStatesDiff[][] _tmpDiff = null;
	
	
	

	public CheckEditorBoardDifficulty(Board oBoard)
	{
		_oBoard = oBoard;
	}
	
	public void checkDifficulty()
	{
		_tmpDiff = new eStatesDiff[_oBoard.getHeight()][_oBoard.getWidth()];
		
		boolean isSolvable = false;
		boolean isSolved = false;
		boolean hasChanged = true;
		int tmpStarCount = 0;
		int tmpEmptyFields = 0;
		int counter = 0;
		
		
		while (!isSolved &&
				hasChanged)
		{
			hasChanged = false;
			for (int iY = 0; iY < _oBoard.getHeight(); iY++) 
			{
				int rowStars = _oBoard.getCountStarsForRow(iY);
				
				for (int iX = 0; iX < _oBoard.getWidth(); iX++) 
				{
					int columnStars = _oBoard.getCountStarsForColumn(iX);
					Field oField = _oBoard.getField(iY, iX);
					
					if (0 == columnStars ||
						0 == rowStars ||
						isArrow(oField.getState()))
					{
						boolean tmpChanged = updateTmpFields(iY, iX, eStatesDiff.BLOCKED);
						if (!hasChanged)
						{
							hasChanged = tmpChanged;
						}
					}
					
					if (!isArrowPointingAtField(iY, iX))
					{
						boolean tmpChanged = updateTmpFields(iY, iX, eStatesDiff.BLOCKED);
						if (!hasChanged)
						{
							hasChanged = tmpChanged;
						}
					}
					
					
				}
				
				tmpEmptyFields = 0;
				for (int iX2 = 0; iX2 < _oBoard.getWidth(); iX2++) 
				{
					if (_tmpDiff[iY][iX2] != eStatesDiff.BLOCKED)
					{
						tmpEmptyFields++;
					}
				}
				
				if (tmpEmptyFields == rowStars)
				{
					for (int iX2 = 0; iX2 < _oBoard.getWidth(); iX2++) 
					{
						if (_tmpDiff[iY][iX2] != eStatesDiff.BLOCKED)
						{
							boolean tmpChanged = updateTmpFields(iY, iX2, eStatesDiff.ISSTAR);
							if (!hasChanged)
							{
								hasChanged = tmpChanged;
							}
						}
					}
				}
			}
			
			tmpEmptyFields = 0;
			for (int iX = 0; iX < _oBoard.getWidth(); iX++) 
			{
				int columnStars = _oBoard.getCountStarsForColumn(iX);
				for (int iY = 0; iY < _oBoard.getHeight(); iY++) 
				{
					if (_tmpDiff[iY][iX] != eStatesDiff.BLOCKED)
					{
						tmpEmptyFields++;
					}
				}
				
				if (tmpEmptyFields == columnStars)
				{
					for (int iY2 = 0; iY2 < _oBoard.getWidth(); iY2++) 
					{
						if (_tmpDiff[iY2][iX] != eStatesDiff.BLOCKED)
						{
							boolean tmpChanged = updateTmpFields(iY2, iX, eStatesDiff.ISSTAR);
							if (!hasChanged)
							{
								hasChanged = tmpChanged;
							}
						}
					}
				}
			}

			isSolved = isSolved();
			counter++;
		}
	}
	
	
	public boolean isArrow(eStates state)
	{
		if (state == eStates.ARROW_E ||
			state == eStates.ARROW_N ||
			state == eStates.ARROW_NE ||
			state == eStates.ARROW_NW ||
			state == eStates.ARROW_S ||
			state == eStates.ARROW_SE ||
			state == eStates.ARROW_SW ||
			state == eStates.ARROW_W)
		{
			return true;
		}
		
		
		return false;
	}
	
	public boolean isArrowPointingAtField(int yPos, int xPos)
	{
		int adder = 0;
		// is there a north arrow pointing at me?
		for (int iY = yPos+1; iY < _oBoard.getHeight(); iY++) 
		{
			if (_oBoard.getField(iY, xPos).getState() == eStates.ARROW_N)
			{
				return true;
			}
		}
		
		// is there a south arrow pointing at me?
		for (int iY = 0; iY < yPos; iY++) 
		{
			if (_oBoard.getField(iY, xPos).getState() == eStates.ARROW_S)
			{
				return true;
			}
		}
		
		// is there a west arrow pointing at me?
		for (int iX = xPos+1; iX < _oBoard.getWidth(); iX++) 
		{
			if (_oBoard.getField(yPos, iX).getState() == eStates.ARROW_W)
			{
				return true;
			}
		}
		
		// is there a east arrow pointing at me?
		for (int iX = 0; iX < xPos; iX++) 
		{
			if (_oBoard.getField(yPos, iX).getState() == eStates.ARROW_E)
			{
				return true;
			}
		}
		
		// is there a northeast arrow pointing at me?
		adder = 1;
		while (((yPos - adder) >= 0) && ((xPos + adder) < _oBoard.getWidth()))
		{
			if (_oBoard.getField((yPos - adder), (xPos + adder)).getState() == eStates.ARROW_NE)
			{
				return true;
			}
			adder++;
		}
		
		// is there a southeast arrow pointing at me?
		adder = 1;
		while (((yPos + adder) < _oBoard.getHeight()) && ((xPos + adder) < _oBoard.getWidth()))
		{
			if (_oBoard.getField((yPos + adder), (xPos + adder)).getState() == eStates.ARROW_SE)
			{
				return true;
			}
			adder++;
		}
		
		// is there a northwest arrow pointing at me?
		adder = 1;
		while (((yPos - adder) >= 0) && ((xPos - adder) >= 0))
		{
			if (_oBoard.getField((yPos - adder), (xPos - adder)).getState() == eStates.ARROW_NW)
			{
				return true;
			}
			adder++;
		}
		
		// is there a southwest arrow pointing at me?
		adder = 1;
		while (((yPos + adder) < _oBoard.getHeight()) && ((xPos - adder) >= 0))
		{
			if (_oBoard.getField((yPos + adder), (xPos - adder)).getState() == eStates.ARROW_SW)
			{
				return true;
			}
			adder++;
		}
		
		return false;
	}
	
	
	public boolean isSolved()
	{
		boolean solved = true;
		for (int iY = 0; iY < _oBoard.getHeight(); iY++) 
		{
			for (int iX = 0; iX < _oBoard.getWidth(); iX++) 
			{
				if (_tmpDiff[iY][iX] != eStatesDiff.BLOCKED &&
					_tmpDiff[iY][iX] != eStatesDiff.ISSTAR)
				{
					return false;
				}
			}
		}
		
		return solved;
	}
	
	
	public boolean updateTmpFields(int iY, int iX, eStatesDiff state)
	{
		if (_tmpDiff[iY][iX] != eStatesDiff.BLOCKED &&
			_tmpDiff[iY][iX] != eStatesDiff.ISSTAR)
		{
			_tmpDiff[iY][iX] = state;
			return true;
		}
		
		return false;
	}
}
