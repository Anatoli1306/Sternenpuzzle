package gui;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.Board;
import logic.EditorBoard;
import logic.GameBoard;

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
	String pfad = System.getProperty("user.home");
	pfad = pfad + "\\Sternenhimmel-Puzzle";
	File saveDirectory = new File(pfad);
	if(saveDirectory.isDirectory()){}
	else{
		saveDirectory.mkdir();
	}
	
    JFileChooser chooser = new JFileChooser(pfad);

    chooser.setFileFilter( new FileFilter()
    {
      @Override public boolean accept( File f )
      {
        return f.isDirectory() ||
          f.getName().toLowerCase().endsWith( ".xml" );
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
      System.out.println(chooser.getSelectedFile());

     Board oBoard = PlayFrame._oPlayFrame._oBoard.getLogicBoard();
     System.out.println("assd");
    if (oBoard instanceof EditorBoard)
	{
    	    	
		GuiElementBoard oGuiBoard = EditorBoard.loadEdit(chooser.getSelectedFile().getAbsolutePath());
		System.out.println( "BlaBla" );
		PlayFrame._oPlayFrame.drawLoadedBoard(oGuiBoard);
		PlayFrame.refreshWindow();
	}
	else
		
	if (oBoard instanceof GameBoard)
	{
		
		GuiElementBoard oGameBoard = GameBoard.load(chooser.getSelectedFile().getAbsolutePath());
		//System.out.print(oGameBoard);
		PlayFrame._oPlayFrame.drawLoadedGameBoard(oGameBoard);
		PlayFrame.refreshWindow();
		
			
		
	}else {System.out.println("Weder Game noch Editorboard vorhanden");}
    
    }
    else
      System.out.println( "Auswahl abgebrochen" );

  }
}
