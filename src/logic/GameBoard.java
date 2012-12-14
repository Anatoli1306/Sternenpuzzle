/**
 * 
 */
package logic;

import gui.GuiElementBoard;
import gui.GuiElementEditorBoard;
import gui.PlayWin;
import gui.GuiElementField.eStates;
import gui.GuiElementGameBoard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

/**
 * Die Klasse GameBoard erstellt das Game Board
 * Durch set und get Methoden k�nnen die Daten der GameBoard Klasse gesetzt und ausgegeben werden.
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */
public class GameBoard extends Board 
{
	/**
	 * Derkleration der Klassen Variabel Board
	 */
	private CommandTracker _oCommandTracker = null;
	private int _currentMarker = 0;

	/**
	 * @param int height
	 * @param int width
	 */
	
	/**
	 * Konstruktor f�r die GameBoard - Klasse
	 * Als parameter wird hier die H�he und die Breite angegeben
	 * @param height - H�he des Boards
	 * @param width - Breite des Boards
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
	 * Die Funktion save speichert das Board als XML
	 * @param filename - Hier wird der Dateiname f�r das Spiel angegeben
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
	 * Gibt die Tracker Daten zur�ck
	 * @return _oCommandTracker - Die Tracker Daten werden zur�ckgegeben
	 */
	public CommandTracker getCommandTracker() 
	{
		return _oCommandTracker;
	}

	/**
	 * Setzt die Daten f�r den Tracker
	 * @param CommandTracker - Die Daten f�r den Tracker werden hier gesetzt
	 */
	public void set_oCommandTracker(CommandTracker _oCommandTracker) 
	{
		this._oCommandTracker = _oCommandTracker;
	}

	/**
	 * Gibt den aktuellen Marker zur�ck
	 * @return _currentMarker - Der Marker wird zur�ckgegeben
	 */
	public int getCurrentMarker() 
	{
		return _currentMarker;
	}

	/**
	 * Setzt die Daten f�r den Marker
	 * @param currentMarker - Die Daten f�r den Marker werden hier gesetzt
	 */
	public void setCurrentMarker(int currentMarker) 
	{
		this._currentMarker = currentMarker;
	}

	
	/**
	 * Die Funktion load ladet das Board aus der XML - Datei in ein Board Objekt
	 * @param filename - Hier wird der Dateiname f�r das Spiel angegeben
	 */
	public static GuiElementBoard load(String filename )
	{
		
		FileInputStream fis = null;
		try 
		{ 
			
			fis = new FileInputStream( filename ); 

			ObjectInputStream o = new ObjectInputStream( fis );
			
			Board oBoard = (Board) o.readObject();
			GuiElementGameBoard oGame = new GuiElementGameBoard(oBoard.getHeight(), oBoard.getWidth());
			
			if (oBoard instanceof EditorBoard)
			{
				EditorBoard tmpBoard = (EditorBoard)oBoard;
				if (!tmpBoard.isSolvable)
				{
					JOptionPane.showMessageDialog(null, "Spiel ist nicht l�sbar!");
					return null;
				}
			}
			
			
				
			for (int x = 0; x < oGame.getCols(); x++)
			{
				for (int y = 0; y < oGame.getRows();y++)
				{
				
					if (oBoard instanceof GameBoard)
					{
						eStates asd = oBoard.getField(y, x).getState();
						oGame.getField(y, x).setState(asd, 1);
						// isStarField
						GameField oBoardFiled = (GameField)oBoard.getField(y, x);
						oGame.getField(y, x).setIsStarField(oBoardFiled.isStarField());
						
						GameBoard lBoardTmp = (GameBoard)oGame.getLogicBoard();
						lBoardTmp.getCommandTracker().resetTracker();
						
						oGame.setLogicBoard(oBoard);
						
						GameBoard lBoard = (GameBoard)oBoard;
						lBoard.getCommandTracker()._blockReset = true;
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
	
	/**
	 * Die Funktion checkIfGameIsWon pr�ft ob das Spiel gel�st ist.
	 * Wenn das Spiel gel�st ist, wird die Klasse PlayWin aufgerufen.
	 */
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
			PlayWin pw = new PlayWin();
		}
		
	}
}



