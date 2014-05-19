package learnjava.arrays;

/**
 * http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 * @author sudheerl
 * 
 *Method 3 (Make two equations)
Let the numbers which are being repeated are X and Y. We make two equations for X and Y and the simple task left is to solve the two equations.
We know the sum of integers from 1 to n is n(n+1)/2 and product is n!. We calculate the sum of input array, when this sum is subtracted from n(n+1)/2, we get X + Y because X and Y are the two numbers missing from set [1..n]. Similarly calculate product of input array, when this product is divided from n!, we get X*Y. Given sum and product of X and Y, we can find easily out X and Y.

Let summation of all numbers in array be S and product be P

X + Y = S – n(n+1)/2
XY = P/n!

Using above two equations, we can find out X and Y. For array = 4 2 4 5 2 3 1, we get S = 21 and P as 960.

X + Y = 21 – 15 = 6

XY = 960/5! = 8

X – Y = sqrt((X+Y)^2 – 4*XY) = sqrt(4) = 2

Using below two equations, we easily get X = (6 + 2)/2 and Y = (6-2)/2
X + Y = 6
X – Y = 2


 */

public class FindTwoRepeatingElementsInArray {

}

/**

/????
Find the two repeating elements in a given array
You are given an array of n+2 elements. All elements of the array are in range 1 to n. And all elements occur once except two numbers which occur twice. Find the two repeating numbers.

For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5

The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output should be 4 2.

Method 1 (Basic)
Use two loops. In the outer loop, pick elements one by one and count the number of occurrences of the picked element in the inner loop.

This method doesn’t use the other useful data provided in questions like range of numbers is between 1 to n and there are only two repeating elements.

#include<stdio.h>
#include<stdlib.h>
void printRepeating(int arr[], int size)
{
  int i, j;
  printf(" Repeating elements are ");
  for(i = 0; i < size; i++)
    for(j = i+1; j < size; j++)
      if(arr[i] == arr[j])
        printf(" %d ", arr[i]);
}     
 
int main()
{
  int arr[] = {4, 2, 4, 5, 2, 3, 1};
  int arr_size = sizeof(arr)/sizeof(arr[0]);  
  printRepeating(arr, arr_size);
  getchar();
  return 0;
}
Time Complexity: O(n??n)
Auxiliary Space: O(1)

Method 2 (Use Count array)
Traverse the array once. While traversing, keep track of count of all elements in the array using a temp array count[] of size n, when you see an element whose count is already set, print it as duplicate.

This method uses the range given in the question to restrict the size of count[], but doesn’t use the data that there are only two repeating elements.

#include<stdio.h>
#include<stdlib.h>
 
void printRepeating(int arr[], int size)
{
  int ??count = (int ??)calloc(sizeof(int), (size - 2));
  int i;
   
  printf(" Repeating elements are ");
  for(i = 0; i < size; i++)
  {  
    if(count[arr[i]] == 1)
      printf(" %d ", arr[i]);
    else
     count[arr[i]]++;
  }    
}     
 
int main()
{
  int arr[] = {4, 2, 4, 5, 2, 3, 1};
  int arr_size = sizeof(arr)/sizeof(arr[0]);  
  printRepeating(arr, arr_size);
  getchar();
  return 0;
}
Time Complexity: O(n)
Auxiliary Space: O(n)

Method 3 (Make two equations)
Let the numbers which are being repeated are X and Y. We make two equations for X and Y and the simple task left is to solve the two equations.
We know the sum of integers from 1 to n is n(n+1)/2 and product is n!. We calculate the sum of input array, when this sum is subtracted from n(n+1)/2, we get X + Y because X and Y are the two numbers missing from set [1..n]. Similarly calculate product of input array, when this product is divided from n!, we get X??Y. Given sum and product of X and Y, we can find easily out X and Y.

Let summation of all numbers in array be S and product be P

X + Y = S – n(n+1)/2
XY = P/n!

Using above two equations, we can find out X and Y. For array = 4 2 4 5 2 3 1, we get S = 21 and P as 960.

X + Y = 21 – 15 = 6

XY = 960/5! = 8

X – Y = sqrt((X+Y)^2 – 4??XY) = sqrt(4) = 2

Using below two equations, we easily get X = (6 + 2)/2 and Y = (6-2)/2
X + Y = 6
X – Y = 2

Thanks to geek4u for suggesting this method. As pointed by Beginer , there can be addition and multiplication overflow problem with this approach.
The methods 3 and 4 use all useful information given in the question :)

#include<stdio.h>
#include<stdlib.h>
#include<math.h>
 
/?? function to get factorial of n ??/
int fact(int n);
 
void printRepeating(int arr[], int size)
{
  int S = 0;  /?? S is for sum of elements in arr[] ??/
  int P = 1;  /?? P is for product of elements in arr[] ??/ 
  int x,  y;   /?? x and y are two repeating elements ??/
  int D;      /?? D is for difference of x and y, i.e., x-y??/
  int n = size - 2,  i;
 
  /?? Calculate Sum and Product of all elements in arr[] ??/
  for(i = 0; i < size; i++)
  {
    S = S + arr[i];
    P = P??arr[i];
  }        
   
  S = S - n??(n+1)/2;  /?? S is x + y now ??/
  P = P/fact(n);         /?? P is x??y now ??/
   
  D = sqrt(S??S - 4??P); /?? D is x - y now ??/
   
  x = (D + S)/2;
  y = (S - D)/2;
   
  printf("The two Repeating elements are %d & %d", x, y);
}     
 
int fact(int n)
{
   return (n == 0)? 1 : n??fact(n-1);
}    
 
int main()
{
  int arr[] = {4, 2, 4, 5, 2, 3, 1};
  int arr_size = sizeof(arr)/sizeof(arr[0]);  
  printRepeating(arr, arr_size);
  getchar();
  return 0;
}
Time Complexity: O(n)
Auxiliary Space: O(1)

Method 4 (Use XOR)
Thanks to neophyte for suggesting this method.
The approach used here is similar to method 2 of this post.
Let the repeating numbers be X and Y, if we xor all the elements in the array and all integers from 1 to n, then the result is X xor Y.
The 1’s in binary representation of X xor Y is corresponding to the different bits between X and Y. Suppose that the kth bit of X xor Y is 1, we can xor all the elements in the array and all integers from 1 to n, whose kth bits are 1. The result will be one of X and Y.

void printRepeating(int arr[], int size)
{
  int xor = arr[0]; /?? Will hold xor of all elements ??/
  int set_bit_no;  /?? Will have only single set bit of xor ??/
  int i;
  int n = size - 2;
  int x = 0, y = 0;
   
  /?? Get the xor of all elements in arr[] and {1, 2 .. n} ??/
  for(i = 1; i < size; i++)
    xor ^= arr[i];  
  for(i = 1; i <= n; i++)
    xor ^= i;   
 
  /?? Get the rightmost set bit in set_bit_no ??/
  set_bit_no = xor & ~(xor-1);
 
  /?? Now divide elements in two sets by comparing rightmost set
   bit of xor with bit at same position in each element. ??/
  for(i = 0; i < size; i++)
  {
    if(arr[i] & set_bit_no)
      x = x ^ arr[i]; /??XOR of first set in arr[] ??/
    else
      y = y ^ arr[i]; /??XOR of second set in arr[] ??/
  }
  for(i = 1; i <= n; i++)
  {
    if(i & set_bit_no)
      x = x ^ i; /??XOR of first set in arr[] and {1, 2, ...n }??/
    else
      y = y ^ i; /??XOR of second set in arr[] and {1, 2, ...n } ??/
  }
   
  printf("\n The two repeating elements are %d & %d ", x, y);
}     
 
 
int main()
{
  int arr[] = {4, 2, 4, 5, 2, 3, 1};
  int arr_size = sizeof(arr)/sizeof(arr[0]);  
  printRepeating(arr, arr_size);
  getchar();
  return 0;
}
Method 5 (Use array elements as index)
Thanks to Manish K. Aasawat for suggesting this method.

Traverse the array. Do following for every index i of A[].
{
check for sign of A[abs(A[i])] ;
if positive then
   make it negative by   A[abs(A[i])]=-A[abs(A[i])];
else  // i.e., A[abs(A[i])] is negative
   this   element (ith element of list) is a repetition
}
Example: A[] =  {1, 1, 2, 3, 2}
i=0; 
Check sign of A[abs(A[0])] which is A[1].  A[1] is positive, so make it negative. 
Array now becomes {1, -1, 2, 3, 2}

i=1; 
Check sign of A[abs(A[1])] which is A[1].  A[1] is negative, so A[1] is a repetition.

i=2; 
Check sign of A[abs(A[2])] which is A[2].  A[2] is  positive, so make it negative. '
Array now becomes {1, -1, -2, 3, 2}

i=3; 
Check sign of A[abs(A[3])] which is A[3].  A[3] is  positive, so make it negative. 
Array now becomes {1, -1, -2, -3, 2}

i=4; 
Check sign of A[abs(A[4])] which is A[2].  A[2] is negative, so A[4] is a repetition.
Note that this method modifies the original array and may not be a recommended method if we are not allowed to modify the array.

#include <stdio.h>
#include <stdlib.h>
 
void printRepeating(int arr[], int size)
{
  int i;  
  
  printf("\n The repeating elements are");
   
  for(i = 0; i < size; i++)
  {
    if(arr[abs(arr[i])] > 0)
      arr[abs(arr[i])] = -arr[abs(arr[i])];
    else
      printf(" %d ", abs(arr[i]));
  }         
}     
 
int main()
{
  int arr[] = {1, 3, 2, 2, 1};
  int arr_size = sizeof(arr)/sizeof(arr[0]);
  printRepeating(arr, arr_size);
  getchar();
  return 0;
}
The problem can be solved in linear time using other method also, please see this and this comments

Please write comments if you find the above codes/algorithms incorrect, or find better ways to solve the same problem.
??/
*/