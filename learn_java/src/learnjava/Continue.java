package learnjava;

public class Continue {

	
	
		  public static void main(String[] args){
		    Thread t = new Thread();
		    int a = 0;
		    try{
		      for (int i=1;i<10;i++)
		      {
		        if (i == 5)
		        {
		          continue;
		          //control will never reach here (after the continue statement).
		          //a = i;
		        }
		        t.sleep(1000);
		        System.out.println("chandan");
		        System.out.println("Value of a : " + a);
		      }
		    }
		    catch(InterruptedException e){}
		  }
		}
	


