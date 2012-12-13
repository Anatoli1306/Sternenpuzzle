package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.Board;
import logic.EditorBoard;

public class SaveDialog extends JFrame {

	public SaveDialog() {
		save(null);
	}

	boolean save(String pfad) {
	
		FileInputStream fis = null;

		try {
			fis = new FileInputStream( "SaveInfo.xml" );
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

		Board oBoard = PlayFrame._oPlayFrame._oBoard.getLogicBoard();
		if (oBoard instanceof EditorBoard)
		{
			oBoard.save(pfad);
		}
		else
		{
			oBoard.save(pfad);
		}
		PlayFrame._oPlayFrame._oBoard.setHasChanged(false);
		
		FileOutputStream fos  = null;

		try {
			fos = new FileOutputStream("SaveInfo.xml");
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(fos);
			oos.writeObject(pfad);
			oos.close();
		}
		catch ( IOException e ) { System.err.println( e ); } 
		finally { try { fos.close(); } catch ( Exception e ) { } }
		
		return true;


	}

}
