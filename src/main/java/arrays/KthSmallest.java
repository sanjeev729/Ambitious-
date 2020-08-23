package arrays;

/* *
  * The idea is, not to do complete quicksort, 
  * but stop at the point where pivot itself is k’th smallest element.
  * Also, not to recur for both left and right sides of pivot, 
  * but recur for one of them according to the position of pivot. The worst case time complexity of this method is O(n2), 
  * but it works in O(n) on average.
  * */
class KthSmallest
{
    public static void swap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
     
    // Standard partition process of QuickSort. 
    // It considers the last element as pivot 
    // and moves all smaller element to left of
    // it and greater elements to right
    public static int partition(Integer [] arr, int l, 
                                               int r)
    {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++)
        {
            if (arr[j] <= x)
            {
                swap(arr[i], arr[j]);
                i++;
            }
        }
        swap(arr[i], arr[r]);
        return i;
    }
     
    // This function returns k'th smallest element 
    // in arr[l..r] using QuickSort based method. 
    // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
    public static int kthSmallest(Integer[] arr, int l, 
                                         int r, int k)
    {
        // If k is smaller than number of elements
        // in array
        if (k > 0 && k <= r - l + 1)
        {
            // Partition the array around last 
            // element and get position of pivot 
            // element in sorted array
            int pos = partition(arr, l, r); //same as in quicksort
 
            // If position is same as k
            if (pos-l == k-1)
                return arr[pos];
             
            // If position is more, recur for
            // left subarray
            if (pos-l > k-1) 
                return kthSmallest(arr, l, pos-1, k);
 
            // Else recur for right subarray
            return kthSmallest(arr, pos+1, r, k-pos+l-1);
        }
 
        // If k is more than number of elements
        // in array
        return Integer.MAX_VALUE;
    }
 
    // Driver program to test above methods 
    public static void main(String[] args)
    {
        Integer arr[] = new Integer[]{12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        System.out.print( "K'th smallest element is " +
                     kthSmallest(arr, 0, arr.length - 1, k) );
    }
}

// enhancement  

/* Randomized QuickSelect
 * we use a random function, 
 * rand() to generate index between l and r, 
 * swap the element at randomly generated index with the last element,
 *  and finally call the standard partition process which uses last element as pivot
 * 
 * 
 * still O(n2). In worst case, 
 * the randomized function may always pick a corner element.
 * 
 * The expected time complexity of above Randomized QuickSelect is O(n)
 * random number generator is equally likely to generate any number in the input range
 * */
 