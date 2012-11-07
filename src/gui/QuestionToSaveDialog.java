package gui;

import javax.swing.JOptionPane;

public class QuestionToSaveDialog {
	
	private boolean yes_no_answer = false;
	
	public boolean isYes_no_answer() {
		return yes_no_answer;
	}

	public QuestionToSaveDialog()
	{		
	    // Auswahldialog
		String[] options = {
			      "Ja", "Nein", "Abbrechen"};
		
		int n = JOptionPane.showOptionDialog( null,
	              "Möchten Sie die Datei speichern?", // Fragetext
	              "Speichern?",  // Titel
	              JOptionPane.YES_NO_CANCEL_OPTION,
	              JOptionPane.QUESTION_MESSAGE,  // Icon
	              null, options,options[0] );
		
	    if ( n == JOptionPane.YES_OPTION ){
	    	SaveDialog saveDialog = new SaveDialog();
	    	yes_no_answer = true;
	    }
	    
	    if( n == JOptionPane.NO_OPTION ){
	    	yes_no_answer = true;
	    }
	    
	    if( n == JOptionPane.CANCEL_OPTION) {
	    }
	}
}
