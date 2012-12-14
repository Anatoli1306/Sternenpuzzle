package gui;

import javax.swing.JOptionPane;
/**
 * Dialogfeld für Speicheranfrage 
 * @author Andreas, Mats, Daniel, Eren, Fabian, Anatoli
 */
public class QuestionToSaveDialog {
	
	private boolean yes_no_answer = false; 
	private boolean save_is_cancel = false;
	
	public boolean isYes_no_answer() {
		return yes_no_answer;
	}
	
	public boolean isSave_is_cancel() {
		return save_is_cancel;
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
	    	SaveAsDialog saveDialog = new SaveAsDialog();
	    	yes_no_answer = true;
	    	save_is_cancel = saveDialog.isCancel();
	    }
	    
	    if( n == JOptionPane.NO_OPTION ){
	    	yes_no_answer = true;
	    }
	    
	    if( n == JOptionPane.CANCEL_OPTION) {
	    }
	}
}
