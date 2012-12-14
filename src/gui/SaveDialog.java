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
/**
 * Klasse zum Speichern des Spiels bzw. des Entwurfs
 *  @author Andreas, Mats, Daniel, Fabian, Anatoli, Eren
 *  @version 0.1
 */
public class SaveDialog extends JFrame {
	/**
	 * Konstruktor
	 */
	public SaveDialog() {
		save(null);
	}
	/**
	 * Speichervorgang
	 * @param pfad
	 * @return boolean 
	 */ 
	boolean save(String pfad) {
		//Initialisierung der Datei
		FileInputStream fis = null;

		try {
			fis = new FileInputStream( "SaveInfo.xml" );
			ObjectInputStream o = new ObjectInputStream( fis );			
			pfad = (String) o.readObject();

		} catch ( IOException e ) { System.err.println( e ); } 
		catch(ClassNotFoundException e){System.err.println(e);}
		finally { try { fis.close(); } catch ( Exception e ) { } }

		//Pfad vorgbelegen
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
		//Editor speichern
		if (oBoard instanceof EditorBoard)
		{
			oBoard.save(pfad);
		}
		else
		//Game speichern
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
