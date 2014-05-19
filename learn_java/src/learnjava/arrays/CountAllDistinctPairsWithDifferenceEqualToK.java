package learnjava.arrays;

/**
 * http://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * @author sudheerl
 *
 */
public class CountAllDistinctPairsWithDifferenceEqualToK {

}


/**
Given an integer array and a positive integer k, count all distinct pairs with difference equal to k.

Examples:

Input: arr[] = {1, 5, 3, 4, 2}, k = 3
Output: 2
There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2} 

Input: arr[] = {8, 12, 16, 4, 0, 20}, k = 4
Output: 5
There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8}, 
{8, 12}, {12, 16} and {16, 20} 
Method 1 (Simple) 
A simple solution is to consider all pairs one by one and check difference between every pair. Following program implements the simple solution. We run two loops: the outer loop picks the first element of pair, the inner loop looks for the other element. This solution doesn’t work if there are duplicates in array as the requirement is to count only distinct pairs.

/?? A simple program to count pairs with difference k??/
#include<iostream>
using namespace std;
 
int countPairsWithDiffK(int arr[], int n, int k)
{
    int count = 0;
     
    // Pick all elements one by one
    for (int i = 0; i < n; i++)
    {       
        // See if there is a pair of this picked element
        for (int j = i+1; j < n; j++)
            if (arr[i] - arr[j] == k || arr[j] - arr[i] == k )
                  count++;
    }
    return count;
}
 
// Driver program to test above function
int main()
{
    int arr[] =  {1, 5, 3, 4, 2};
    int n = sizeof(arr)/sizeof(arr[0]);
    int k = 3;
    cout << "Count of pairs with given diff is "
         << countPairsWithDiffK(arr, n, k);
    return 0;
}
Output:

Count of pairs with given diff is 2
Time Complexity of O(n2)

Method 2 (Use Sorting)
We can find the count in O(nLogn) time using a O(nLogn) sorting algorithm like Merge Sort, Heap Sort, etc. Following are the detailed steps.

1) Initialize count as 0
2) Sort all numbers in increasing order.
3) Remove duplicates from array.
4) Do following for each element arr[i]
   a) Binary Search for arr[i] + k in subarray from i+1 to n-1.
   b) If arr[i] + k found, increment count. 
5) Return count. 
/?? A sorting based program to count pairs with difference k??/
#include <iostream>
#include <algorithm>
using namespace std;
 
/?? Standard binary search function ??/
int binarySearch(int arr[], int low, int high, int x)
{
    if (high >= low)
    {
        int mid = low + (high - low)/2;
        if (x == arr[mid])
            return mid;
        if (x > arr[mid])
            return binarySearch(arr, (mid + 1), high, x);
        else
            return binarySearch(arr, low, (mid -1), x);
    }
    return -1;
}
 
/?? Returns count of pairs with difference k in arr[] of size n. ??/
int countPairsWithDiffK(int arr[], int n, int k)
{
    int count = 0, i;
    sort(arr, arr+n);  // Sort array elements
 
    /?? code to remove duplicates from arr[] ??/
   
    // Pick a first element point
    for (i = 0; i < n-1; i++)
        if (binarySearch(arr, i+1, n-1, arr[i] + k) != -1)
            count++;
 
    return count;
}
Output:

Count of pairs with given diff is 2
Time complexity: The first step (sorting) takes O(nLogn) time. The second step runs binary search n times, so the time complexity of second step is also O(nLogn). Therefore, overall time complexity is O(nLogn). The second step can be optimized to O(n), see this.

Method 3 (Use Self-balancing BST)
We can also a self-balancing BST like AVL tree or Red Black tree to solve this problem. Following is detailed algorithm.

1) Initialize count as 0.
2) Insert all elements of arr[] in an AVL tree. While inserting, 
   ignore an element if already present in AVL tree.
3) Do following for each element arr[i].
   a) Search for arr[i] + k in AVL tree, if found then increment count.
   b) Search for arr[i] - k in AVL tree, if found then increment count.
   c) Remove arr[i] from AVL tree. 
Time complexity of above solution is also O(nLogn) as search and delete operations take O(Logn) time for a self-balancing binary search tree.

Method 4 (Use Hashing)
We can also use hashing to achieve the average time complexity as O(n) for many cases.

1) Initialize count as 0.
2) Insert all distinct elements of arr[] in a hash map.  While inserting, 
   ignore an element if already present in AVL tree.
3) Do following for each element arr[i].
   a) Look for arr[i] + k in the hash map, if found then increment count.
   b) Look for arr[i] - k in the hash map, if found then increment count.
   c) Remove arr[i] from hash table. 
A very simple case where hashing works in O(n) time is the case where range of values is very small. For example, in the following implementation, range of numbers is assumed to be 0 to 99999. A simple hashing technique to use values as index can be used.

/?? An efficient program to count pairs with difference k when the range
   numbers is small ??/
#define MAX 100000
int countPairsWithDiffK(int arr[], int n, int k)
{
    int count = 0;  // Initialize count
 
    // Initialize empty hashmap.
    bool hashmap[MAX] = {false};
 
    // Insert array elements to hashmap
    for (int i = 0; i < n; i++)
        hashmap[arr[i]] = true;
 
    for (int i = 0; i < n; i++)
    {
        int x = arr[i];
        if (x - k >= 0 && hashmap[x - k])
            count++;
        if (x + k < MAX && hashmap[x + k])
            count++;
        hashmap[x] = false;
    }
    return count;
}

*/