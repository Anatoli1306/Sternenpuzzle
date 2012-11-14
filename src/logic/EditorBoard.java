/**
 * 
 */
package logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * 
 * @author Andreas, Anatoli
 * @version 0.1
 * 
 */

public class EditorBoard extends Board implements Serializable
{

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
				this._fields[iY][iX] = new EditorField(this);
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
		 
		try 
		{ 
		  fos = new FileOutputStream( filename ); 
		  ObjectOutputStream o = new ObjectOutputStream( fos ); 
		  o.writeObject( this );
		} 
		catch ( IOException e ) { System.err.println( e ); } 
		finally { try { fos.close(); } catch ( Exception e ) { } }
		
	}

	public void load(String filename) {
		// TODO Auto-generated method stub
		
	}
		
	/**
	 * @param String filename
	 * @return 
	 */
	
	/*public EditorBoard load(String filename)
	{
		FileInputStream fis = null;
		try 
		{ 
			fis = new FileInputStream( filename ); 
			ObjectInputStream o = new ObjectInputStream( fis ); 
			return (EditorBoard) o.readObject(); 
		} 
		catch ( IOException e ) { System.err.println( e ); return null; } 
		catch ( ClassNotFoundException e ) { System.err.println( e ); return null; } 
		finally { try { fis.close(); } catch ( Exception e ) { } }
	}*/

}
