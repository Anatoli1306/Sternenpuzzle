/**
 * 
 */
package logic;

import gui.PlayFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

/**
 * 
 * @author Andreas
 * @version 0.1
 *
 */

public class CommandTracker 
{
	private List<ICommand> _trackerList = new ArrayList<ICommand>();
	
	private int _currentPos = 0;
	
	private List<Integer> _markerPositions = new ArrayList<Integer>();
	
	public CommandTracker()
	{
		
	}
	
	public void add(ICommand oCmd)
	{
		_trackerList.add(_currentPos, oCmd);
		_currentPos++;
	}
	
	public void remove()
	{
		
	}
	
	public void execute()
	{
		
	}
	
	public void undo()
	{
		if (_currentPos > 0)
		{
			_currentPos--;

			_trackerList.get(_currentPos).undo();
		}
	}
	
	public int getLength()
	{
		return _trackerList.size();
	}
	
	public void executeTillPosition()
	{
		
	}
	
	public void undoTillPosition(final int pos)
	{
		System.out.println(pos);
		System.out.println(_currentPos);
		
		int delayTime = 500;
		
		final javax.swing.Timer myTimer = new Timer(delayTime, new ActionListener() 
		{
		     public void actionPerformed(ActionEvent e) 
		     {
		        // TODO: put in the code you want called in xxx mSecs.
		    	if (pos < _currentPos)
		 		{
		    		undo();
				    PlayFrame._oPlayFrame.refreshWindow();
		 		}
		    	else
		    	{
		    		return;
		    	}
		    	
		     }
		});
		myTimer.setRepeats(true);
		myTimer.start();
	}
	
	
	public void setMarkerPosition()
	{
		_markerPositions.add(_currentPos);
	}
	
	
	public void goBackToLastMarker()
	{
		System.out.println(_markerPositions.size());
		if (_markerPositions.size() > 0)
		{
			int pos = _markerPositions.get(_markerPositions.size()-1);
			undoTillPosition(pos);
			_markerPositions.remove(_markerPositions.size()-1);
		}
	}
	
	public void resetTracker()
	{
		_trackerList = new ArrayList<ICommand>();
		_markerPositions = new ArrayList<Integer>();
		_currentPos = 0;
	}
}
