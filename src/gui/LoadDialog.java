package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.Board;
import logic.EditorBoard;
import logic.GameBoard;

/**
 * Klasse beinhaltet Laden-Fenster
 * @author Andreas, Mats, Daniel, Eren, Fabian, Anatoli
 * @version 0.1
 */

public class LoadDialog
{
	/**
	 * Konstruktor
	 */
	public LoadDialog()
	{
		// Dateipfad auswählen

		String pfad = null;

		FileInputStream fis = null;

		try {
			fis = new FileInputStream( "SaveAsInfo.xml" );
			ObjectInputStream o = new ObjectInputStream( fis );			
			pfad = (String) o.readObject();

		} catch ( IOException e ) { System.err.println( e ); } 
		catch(ClassNotFoundException e){System.err.println(e);}
		finally { try { fis.close(); } catch ( Exception e ) { } }  

		if (pfad == null){
			pfad = System.getProperty("user.home");
			pfad = pfad + "\\Sternenhimmel-Puzzle";	
			File saveDirectory = new File(pfad);
			if(saveDirectory.isDirectory()){}
			else{
				saveDirectory.mkdir();
			}
		}

		// File auswählen
		JFileChooser chooser = new JFileChooser(pfad);

		chooser.setFileFilter( new FileFilter()
		{
			@Override public boolean accept( File f )
			{
				return f.isDirectory() ||
						f.getName().toLowerCase().endsWith( ".xml" ); // Nur .xml-Dateien
			}
			@Override public String getDescription()
			{
				return "";
			}
		} );
		int state = chooser.showOpenDialog( null );
		if ( state == JFileChooser.APPROVE_OPTION )
		{
			File file = chooser.getSelectedFile();

			Board oBoard = PlayFrame._oPlayFrame._oBoard.getLogicBoard();
			if (oBoard instanceof EditorBoard)
			{
				GuiElementBoard oGuiBoard = EditorBoard.loadEdit(chooser.getSelectedFile().getAbsolutePath());
				PlayFrame._oPlayFrame.drawLoadedBoard(oGuiBoard);
				PlayFrame.refreshWindow();
			}
			else
			{
				if (oBoard instanceof GameBoard)
				{
					GuiElementBoard oGameBoard = GameBoard.load(chooser.getSelectedFile().getAbsolutePath());
					if (oGameBoard instanceof GuiElementBoard)
					{
						PlayFrame._oPlayFrame.drawLoadedGameBoard(oGameBoard);
						PlayFrame.refreshWindow();
						
						GameBoard lBoard = (GameBoard)oGameBoard.getLogicBoard();
						lBoard.getCommandTracker().resetTracker();
					}
				}
			}
		}
	}
}
