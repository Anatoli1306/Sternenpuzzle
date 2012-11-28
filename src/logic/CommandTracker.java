/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;

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
	
	public void undoTillPosition()
	{
		
	}
}
