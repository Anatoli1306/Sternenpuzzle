/**
 * 
 */
package logic;

import gui.GuiElementBoard;
import gui.GuiElementEditorBoard;
import gui.GuiElementField.eStates;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * 
 * @author Andreas, Anatoli
 * @version 0.1
 * 
 */

public class EditorBoard extends Board
{
	boolean isSolvable = false;


	/**
	 * @param int height
	 * @param int width
	 */
	
	public EditorBoard(int height, int width) 
	{
		super(height, width);
		this._fields = new Field[height][width];
		
		for (int iY = 0; iY < height; iY++)
		{
			for (int iX = 0; iX < width; iX++)
			{
				this._fields[iY][iX] = new EditorField(this, iX, iY);
			}
		}
	}
	
	/**
	 * @param int yPos
	 * @param int xPos
	 * return Field
	 */
	public Field getField(int yPos, int xPos)
	{
		return this._fields[yPos][xPos];
	}
	
	
	/**
	 * @param String filename
	 */
	public void save(String filename)
	{
		OutputStream fos = null;
		
		CheckEditorBoardDifficulty oDiff = new CheckEditorBoardDifficulty(this);
		String result = oDiff.checkDifficulty();
		if (result == CheckEditorBoardDifficulty.BOARD_DIFFICULTY_NOT_SOLVABLE)
		{
			isSolvable = false;
		}
		else
		{
			isSolvable = true;
		}
		 
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
	 * @param String filename
	 * @return 
	 */
	
	public static GuiElementBoard loadEdit(String filename)
	{
		FileInputStream fis = null;
		try 
		{ 
			fis = new FileInputStream( filename ); 
			
			ObjectInputStream o = new ObjectInputStream( fis );
			
			Board oBoard = (Board) o.readObject();
			GuiElementEditorBoard oEditor = new GuiElementEditorBoard(oBoard.getHeight(), oBoard.getWidth());
				
		   if (oBoard instanceof EditorBoard) 
		   {
			
			   for (int x = 0; x < oEditor.getCols(); x++)
			   {
				   for (int y = 0; y < oEditor.getRows();y++)
				   {
					   eStates asd = oBoard.getField(y, x).getState();
					   oEditor.getField(y, x).setState(asd);
				   }
			   }
		   }else{
			   
			    JOptionPane pane = new JOptionPane("Sie k�nnen kein Game im Editormodus laden!! ", JOptionPane.ERROR_MESSAGE);
				JDialog dialog = pane.createDialog("SternenHimmelPuzzle");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
		   }
			
			
			return oEditor;
			
		} 
		catch ( IOException e ) { e.printStackTrace(); return null; } 
		catch ( ClassNotFoundException e ) { e.printStackTrace(); return null; } 
		finally { try { fis.close(); } catch ( Exception e ) { } }
		
	}

}
