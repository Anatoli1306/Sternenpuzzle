/**
 * 
 */
package logic;

import gui.GuiElementBoard;
import gui.GuiElementEditorBoard;
import gui.GuiElementField.eStates;
import gui.GuiElementGameBoard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */
public class GameBoard extends Board 
{
	/**
	 * 
	 */
	private CommandTracker _oCommandTracker = null;
	
	/**
	 * 
	 */
	private int _currentMarker = 0;

	/**
	 * @param int height
	 * @param int width
	 */
	public GameBoard(int height, int width) 
	{
		super(height, width);
		this._fields = new Field[height][width];
		
		for (int iY = 0; iY < height; iY++)
		{
			for (int iX = 0; iX < width; iX++)
			{
				this._fields[iY][iX] = new GameField(this, iX, iY);
			}
		}
		
		_oCommandTracker = new CommandTracker();
	}

	/**
	 * @param int xPos
	 * @param int yPos
	 */
	public void onFieldClick(int xPos, int yPos)
	{
		
	}
	
	/**
	 * @param String filename
	 */
	public void save(String filename)
	{
		OutputStream fos = null; 
		 
		try 
		{ 
		  fos = new FileOutputStream( filename ); 
		  ObjectOutputStream o = new ObjectOutputStream( fos ); 
		  o.writeObject( this );
		} 
		catch ( IOException e ) { System.err.println( e ); } 
		finally { try { fos.close(); } catch ( Exception e ) { } }
		
	}
	

	/**
	 * @return the _oCommandTracker
	 */
	public CommandTracker getCommandTracker() 
	{
		return _oCommandTracker;
	}

	/**
	 * @param _oCommandTracker the _oCommandTracker to set
	 */
	public void set_oCommandTracker(CommandTracker _oCommandTracker) 
	{
		this._oCommandTracker = _oCommandTracker;
	}

	/**
	 * @return the _currentMarker
	 */
	public int getCurrentMarker() 
	{
		return _currentMarker;
	}

	/**
	 * @param int currentMarker
	 */
	public void setCurrentMarker(int currentMarker) 
	{
		this._currentMarker = currentMarker;
	}

	public static GuiElementBoard load(String filename )
	{
		
		FileInputStream fis = null;
		try 
		{ 
			fis = new FileInputStream( filename ); 
		//	System.out.println(filename);
			ObjectInputStream o = new ObjectInputStream( fis );
			
			Board oBoard = (Board) o.readObject();
			GuiElementGameBoard oGame = new GuiElementGameBoard(oBoard.getHeight(), oBoard.getWidth());
				
			for (int x = 0; x < oGame.getCols(); x++)
			{
				for (int y = 0; y < oGame.getRows();y++)
				{
				
					if (oBoard instanceof GameBoard){
						
						eStates asd = oBoard.getField(y, x).getState();
						oGame.getField(y, x).setState(asd, 1);
					}
					else 
					{		
						eStates asd = oBoard.getField(y, x).getState();
						if (asd != eStates.STAR)
						{
							oGame.getField(y, x).setState(asd, 1);
						}
						else
						{
							oGame.getField(y, x).setIsStarField(true);
						}
					}	
				}
			}
				
			return oGame;
			
		} 
		catch ( IOException e ) { e.printStackTrace(); return null; } 
		catch ( ClassNotFoundException e ) { e.printStackTrace(); return null; } 
		finally { try { fis.close(); } catch ( Exception e ) { } }
		
	}
	
	
	public void checkIfGameIsWon()
	{
		boolean isWon = true;
		for (int x = 0; x < getWidth(); x++)
		{
			for (int y = 0; y < getHeight();y++)
			{
				GameField field = (GameField)getField(y, x);
				if (field.isStarField() && field.getState() != eStates.STAR)
				{
					isWon = false;
				}
				else if (!field.isStarField() && field.getState() == eStates.STAR)
				{
					isWon = false;
				}
			}
		}
		
		if (isWon)
		{
			System.out.println("winning");
		}
		
	}
}



