package learnjava;

public class StaticMemberExample {




	/*

Java static member variable example

This Java Example shows how to declare and use static member variable inside

a java class

	 */


	public static void main(String[] args) {


//		ObjectCounter object = new ObjectCounter();
//		System.out.println(objectgetNumberOfObjects());

//		ObjectCounter object = new ObjectCounter();
//		System.out.println(objectgetNumberOfObjects());

	}

}



class ObjectCounter{



	/*

	 * Static members are class level variables and shared by all the objects

	 * of the class

	 *

	 * To define static member, use static keyword

	 * eg static int i=0;

	 *

	 * Please note that static member variables can be accessed inside

	 * non static methods because they are class level variables

	 *

	 */

	static int counter=0;

	public ObjectCounter(){

		/*increase the object counter Since only one varible is shared between

		 * all objects of this class, it always return number of objects till now

		 */
		counter++;

	}
	//returns number of objects created till now

	public int getNumberOfObjects(){

		return counter;

	}

}