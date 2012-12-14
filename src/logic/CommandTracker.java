/**
 * 
 */
package logic;

import gui.PlayFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

/**
 * Die CommandTracker Klasse dient dazu, das Tracking zu aktevieren.
 * Durch set und get Methoden können die Daten der CommandTracker Klasse gesetzt und ausgegeben werden.
 * 
 * @author Fabian, Mats, Eren, Daniel, Andreas, Anatoli
 * @version 0.1
 * 
 */

public class CommandTracker implements Serializable
{
	/**
	 * Dekleration der Variabeln für die Klasse
	 */
	private List<ICommand> _trackerList = new ArrayList<ICommand>();
	
	private int _currentPos = 0;
	
	public boolean _blockReset = false;
	
	private int _positionOfFirstFailure = 0;
	
	public javax.swing.Timer _myTimer;
	
	private List<Integer> _markerPositions = new ArrayList<Integer>();
	
	/**
	 * Konstruktor für die CommandTracker - Klasse
	 */
	public CommandTracker()
	{
		
	}
	
	/**
	 * Setzt den Command für das Tracking
	 * @param ICommand - Das Command für das Tracking wird übergeben
	 */
	public void add(ICommand oCmd)
	{
		_trackerList.add(_trackerList.size(), oCmd);
		_currentPos++;
	}
	
	
	public void remove()
	{

	}
	
	public void execute()
	{
		
	}
	
	/**
	 * Setzt den Command für das Tracking zurück
	 */
	public void undo()
	{
		if (_currentPos > 0)
		{
			_currentPos--;

			_trackerList.get(_currentPos).undo();
			_trackerList.remove(_trackerList.size()-1);
		}
	}
	
	/**
	 * Gibt die die anzahl der Tracking Daten zurück
	 * @return _trackerList - Gibt die Anzahl der Tracking Daten zurück
	 */
	public int getLength()
	{
		return _trackerList.size();
	}
	
	
	public void executeTillPosition()
	{
		
	}
	
	/**
	 * Die Trackingdaten werden bis zu einer bestimmten Postion zurückgesetzt
	 * @param pos - Hier wird die Position angegeben, bis wo die Tracking Daten zurückgesetzt werden
	 */
	public void undoTillPosition(final int pos)
	{	
		int delayTime = 500;
		
		ActionListener actionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				 // TODO: put in the code you want called in xxx mSecs.
		    	if (pos < _trackerList.size() && 0 != pos)
		 		{
		    		undo();
				    PlayFrame._oPlayFrame.refreshWindow();
		 		}
		    	else
		    	{
		    		_myTimer.stop();
		    		return;
		    	}
			}
		};
		
		_myTimer = new Timer(delayTime, actionListener);
		_myTimer.setRepeats(true);
		_myTimer.start();
	}
	
	/**
	 * Hier werden die Positionen des Markers in eine List<integer> gespeichert
	 */	
	public void setMarkerPosition()
	{
		_markerPositions.add(_trackerList.size());
	}
	
	/**
	 * Hier wird die erste falsche Position des Markers gespeichert
	 */	
	public void setFirstFailurePosition()
	{
		if (_positionOfFirstFailure == 0)
		{
			_positionOfFirstFailure = _trackerList.size();
		}	
	}
	
	/**
	 * Hier werden die Daten bis zum ersten Fehler zurückgesetzt
	 */
	public void goBackToFirstFailure()
	{
		if (_positionOfFirstFailure != 0)
		{
			undoTillPosition(_positionOfFirstFailure - 1);
			_positionOfFirstFailure = 0;
		}
	}
	
	/**
	 * Hier werden die Daten bis zum ersten Marker zurückgesetzt
	 */
	public void goBackToLastMarker()
	{
		if (_markerPositions.size() > 0)
		{
			int pos = _markerPositions.get(_markerPositions.size()-1);
			undoTillPosition(pos);
			_markerPositions.remove(_markerPositions.size()-1);
		}
		else
		{
			undoTillPosition(0);
		}
	}
	
	/**
	 * Hier werden die Tracking Daten zurückgesetzt
	 *
	 */
	public void resetTracker()
	{
		if (!_blockReset)
		{
			_trackerList = new ArrayList<ICommand>();
			_markerPositions = new ArrayList<Integer>();
			_currentPos = 0;
		}
		_blockReset = false;
	}
}
