package gui;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.Board;
import logic.EditorBoard;
import logic.GameBoard;

// Klasse beinhaltet Laden-Fenster

/**
 * 
 * @author Eren, Fabian
 * @version 0.1
 *
 */

public class LoadDialog
{
  public LoadDialog()
  {
	// Dateipfad auswählen
	String pfad = System.getProperty("user.home");
	pfad = pfad + "\\Sternenhimmel-Puzzle";	
	File saveDirectory = new File(pfad);
	if(saveDirectory.isDirectory()){}
	else{
		saveDirectory.mkdir();
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
				PlayFrame._oPlayFrame.drawLoadedGameBoard(oGameBoard);
				PlayFrame.refreshWindow();
				
				GameBoard lBoard = (GameBoard)oGameBoard.getLogicBoard();
				lBoard.getCommandTracker().resetTracker();
					
				
			}
		}
    
    }

  }
}
