/**
 * 
 */
package logic;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import gui.GuiElementField;
import gui.GuiElementField.eStates;

/**
 * @author Andreas
 *
 */
public class CheckEditorBoardDifficulty 
{
	final static public String BOARD_DIFFICULTY_EASY = "einfach";
	
	final static public String BOARD_DIFFICULTY_MEDIUM = "mittel";
	
	final static public String BOARD_DIFFICULTY_HARD = "schwer";
	
	final static public String BOARD_DIFFICULTY_NOT_SOLVABLE = "unlösbar";
	
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
	
	protected Map<Integer, HashMap<Integer, Integer>> _unsolvableStars = null;
	
	

	public CheckEditorBoardDifficulty(Board oBoard)
	{
		_oBoard = oBoard;
	}
	
	public String checkDifficulty()
	{
		_tmpDiff = new eStatesDiff[_oBoard.getHeight()][_oBoard.getWidth()];
		
		boolean isSolvable = false;
		boolean doMediumSearch = false;
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
				int rowStars = getCalculatedRowStars(iY, doMediumSearch);
				
				for (int iX = 0; iX < _oBoard.getWidth(); iX++) 
				{
					int columnStars = getCalculatedColumnStars(iX, doMediumSearch);
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
				int columnStars = getCalculatedColumnStars(iX, doMediumSearch);
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
			
			if (!isSolved && !doMediumSearch &&
				 (counter > 1 || !hasChanged))
			{
				// its medium
				doMediumSearch = true;
				hasChanged = true;
			}
		}
		
		if (isSolved && !doMediumSearch && counter <2)
		{
			return BOARD_DIFFICULTY_EASY;
		}
		else if(isSolved && counter < 4)
		{
			return BOARD_DIFFICULTY_MEDIUM;
		}
		else if(isSolved)
		{
			return BOARD_DIFFICULTY_HARD;
		}
		else
		{
			calculatedUnsolvableStars();
			return BOARD_DIFFICULTY_NOT_SOLVABLE;
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
			if (_oBoard.getField((yPos - adder), (xPos + adder)).getState() == eStates.ARROW_SW)
			{
				return true;
			}
			adder++;
		}
		
		// is there a southeast arrow pointing at me?
		adder = 1;
		while (((yPos + adder) < _oBoard.getHeight()) && ((xPos + adder) < _oBoard.getWidth()))
		{
			if (_oBoard.getField((yPos + adder), (xPos + adder)).getState() == eStates.ARROW_NW)
			{
				return true;
			}
			adder++;
		}
		
		// is there a northwest arrow pointing at me?
		adder = 1;
		while (((yPos - adder) >= 0) && ((xPos - adder) >= 0))
		{
			if (_oBoard.getField((yPos - adder), (xPos - adder)).getState() == eStates.ARROW_SE)
			{
				return true;
			}
			adder++;
		}
		
		// is there a southwest arrow pointing at me?
		adder = 1;
		while (((yPos + adder) < _oBoard.getHeight()) && ((xPos - adder) >= 0))
		{
			if (_oBoard.getField((yPos + adder), (xPos - adder)).getState() == eStates.ARROW_NE)
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
	
	public int getCalculatedRowStars(int iY, boolean isMedium)
	{
		int stars = _oBoard.getCountStarsForRow(iY);
		if (isMedium)
		{
			for (int iX = 0; iX < _oBoard.getWidth(); iX++) 
			{
				if (_tmpDiff[iY][iX] == eStatesDiff.ISSTAR)
				{
					stars--;
				}
			}
		}
		
		return stars;
	}
	
	public int getCalculatedColumnStars(int iX, boolean isMedium)
	{
		int stars = _oBoard.getCountStarsForColumn(iX);
		if (isMedium)
		{
			for (int iY = 0; iY < _oBoard.getHeight(); iY++) 
			{
				if (_tmpDiff[iY][iX] == eStatesDiff.ISSTAR)
				{
					stars--;
				}
			}
		}
		
		return stars;
	}
	
	public void calculatedUnsolvableStars()
	{
		HashMap<Integer, Integer> unsolvableStar = null;
		_unsolvableStars = new HashMap<Integer, HashMap<Integer, Integer>>();
		
		for (int iY = 0; iY < _oBoard.getHeight(); iY++) 
		{
			for (int iX = 0; iX < _oBoard.getWidth(); iX++) 
			{
				unsolvableStar = new HashMap<Integer, Integer>();
				Field oField = _oBoard.getField(iY, iX);
				if (oField.getState() == eStates.STAR &&
					_tmpDiff[iY][iX] != eStatesDiff.ISSTAR)
				{
					unsolvableStar.put(iY, iX);
					_unsolvableStars.put(_unsolvableStars.size(), unsolvableStar);
				}
			}
		}
	}
	
	public Map<Integer, HashMap<Integer, Integer>> getUnsolvableStars()
	{
		return _unsolvableStars;
	}
}
