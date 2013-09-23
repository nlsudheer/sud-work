package learnjava;



public class CloseFile extends Thread{

	/**
	 * @param args
	 */
	public  void run() {
		// TODO Auto-generated method stub
		
		 try{
				System.out.println("Calling Save file script");
			    String[] Dialog =  new String[]{ "F:\\temp\\Save_Dialog_FF.exe" , "Opening dispute_details.csv",  "Save" ,"f:\\temp\\myfile9.csv"};
	            Runtime.getRuntime().exec(Dialog);
	            }catch(Exception e)
	            {}

	}

}
