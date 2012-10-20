import gui.DemoForm;


public class Main 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		startBoardDemo();
		
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
