import gui.DemoForm;
import gui.PlayFrame;


public class Main 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
//		startBoardDemo();
		PlayFrame wnd = new PlayFrame();
	}
	
	
	/**
	 * start demo form 
	 */
	
	public static void startBoardDemo()
	{
		DemoForm demo = new DemoForm();
		demo.setSize(800, 600);
		demo.show();
	}

}
