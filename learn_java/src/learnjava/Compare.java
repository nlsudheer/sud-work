package learnjava;

import org.testng.annotations.Test;

import java.io.*;

public class Compare {

	/**
	 * @param args
	 */
	
	public static int k=0;
    @Test(groups="sort", enabled = false)
	public static void quick_sort(String array[],int low, int n){
	    int lo = low;
	    int hi = n;
	    if (lo >= n) {
	      return;
	    }
	    String mid = array[(lo + hi) / 2];
	  
	    while (lo < hi) {
	      while (lo<hi && (array[lo].compareTo(mid)<0)) {
	        lo++;
	      }
	      while (lo<hi && array[hi].compareTo(mid) >0 ) {
	        hi--;
	      }
	      if (lo < hi) {
	        String T = array[lo];
	        array[lo] = array[hi];
	        array[hi] = T;
	      }
	    }
	    if (hi < lo) {
	      int T = hi;
	      hi = lo;
	      lo = T;
	    }
	    quick_sort(array, low, lo);
	    quick_sort(array, lo == low ? lo+1 : lo, n);
	  }
	
	public static String[] readFile(String fname)
	{ 
		String[] s=new String[1500];
	
	try{
	BufferedReader input =  new BufferedReader(new FileReader(fname));
	String str=new String();
	
	while((str=input.readLine())!=null)
		{	
		String st[]=new String[5];
		st=str.split(",");
		for(int i=0;i<st.length;i++)
		{
		if(st[i].equals("\t\n")){
			System.out.println("#---- Junk Characters:"+st[i]);
		}else if(st[i].contains("(")){
			System.out.println("#---- Junk Characters:"+st[i]);
		}else if(st[i].contains("^#")){
			System.out.println("#---- Junk Characters:"+st[i]);
		}
		else{
			//System.out.println("array val i:k "+i+k+"  "+st[i]);
			s[k]=st[i];k++;	
		}
		}
			
	}
	
	}catch(Exception e){e.printStackTrace();}
	return s;	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String arr[]=new String[500];
		arr=readFile("\\\\hydws2731\\share\\submit\\present_channels1.txt");
		System.out.println("#####################################################");
		quick_sort(arr,0,k-1);
		System.out.println("#####################################################");
		for(int i=0;i<k;i++)
			System.out.println(arr[i]);
	}

}
