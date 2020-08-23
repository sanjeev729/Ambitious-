package sorting;

public class BinarySearch {
	// Returns location of key, or -1 if not found
	static int  BinarySearchM(int A[], int l, int r, int key)
	{
	    int m;
	 
	    while( l <= r )
	    {
	        m = l + (r-l)/2;
	 
	        if( A[m] == key ) // first comparison
	            return m;
	 
	        if( A[m] < key ) // second comparison
	            l = m + 1;
	        else
	            r = m - 1;
	    }
	 
	    return -1;
	}
	
	
	static int binarnySearchRec(int[] arr,int l,int r,int key){
		if(r<l)
			return -1;
		int m=l+(r-l)/2;
		if (arr[m]==key) {
			return m;	
		}
		if (arr[m]<key) {
			 return binarnySearchRec(arr,m+1,r,key);
		}
		else{
		     return binarnySearchRec(arr,l,m-1,key);
		}
	}
	public static void main(String[] args) {
	
			int a[] = {1,2, 5, 6, 9, 12 };
		System.out.println(BinarySearchM(a, 0, a.length-1, 9));
		System.out.println(binarnySearchRec(a, 0, a.length-1, 9));

			

		
	}
}

