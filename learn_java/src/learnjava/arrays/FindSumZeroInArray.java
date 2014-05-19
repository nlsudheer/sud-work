package learnjava.arrays;

/**
 * http://www.careercup.com/question?id=4691284505657344
 * use brute force algorithm
 * brute-force search or exhaustive search, 
 * http://www.careercup.com/question?id=9307474
 * @author sudheerl
 * you have an array which has a set of positive and negative numbers, print all the subset sum which is equal to 0. 

eg 2, 1, -1, 0, 2, -1, -1 
o/p: 1, -1 
1, -1, 0 
0 
2, -1, -1

 public void findSumZero(int [] arr){

   int sumArray [] = new int[arr.length];

   sumArray[0] =  arr[0];

   for(int i=1 ; i<arr.length ; i++){
       sumArray[i] = sumArray[i-1] + arr[i];
   }

   for(int i=0;i<sumArray.length;i++){
       for(int j = i+1; j<sumArray.length;j++){
           if(sumArray[i] == sumArray[j] || sumArray[j] == 0){
              print(i,j,arr);
           }
       }
   }
}

public void print(int i,int j,int [] arr){
   System.out.print("subArray is");
   for (int k = i; k<=j;k++){
       System.out.print(arr[k] + " ");
   }
   System.out.println();
}
 *
 */

public class FindSumZeroInArray {
   
  

}
