package gui;

import javax.swing.JOptionPane;

public class QuestionToSaveDialog {
	
	public QuestionToSaveDialog()
	{
	    // Auswahldialog
		String[] options = {
			      "Ja", "Nein", "Abbrechen"};
		
		int n = JOptionPane.showOptionDialog( null,
	              "Möchten Sie die Datei speichern?",      // Fragetext
	              "Speichern?",  // Titel
	              JOptionPane.YES_NO_CANCEL_OPTION,
	              JOptionPane.QUESTION_MESSAGE,  // Icon
	              null, options,options[0] );
		
	    if ( n == JOptionPane.YES_OPTION ){
	    	SaveDialog saveDialog = new SaveDialog();
	    }
	    
	    if( n == JOptionPane.NO_OPTION ){
	    	System.out.println("Nicht gespeichert");
	    }
	    
	    if( n == JOptionPane.CANCEL_OPTION) {
	    	System.out.println("Speichern Abgebrochen");
	    }
	}
}
