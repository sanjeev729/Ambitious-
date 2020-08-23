package arrays;

import java.util.HashSet;
import java.util.Set;

public class PairSum {

	public PairSum() {
		// TODO Auto-generated constructor stub
	}
	
	public void getPairSum(int array[],int sum) {
		
		 Set<Integer> hs =new HashSet<Integer>();
		 
		 for(int a:array)
		 {
			 if(hs.contains(sum-a))
				 System.out.println(a+" "+ (sum-a));
			 else
				 hs.add(a);
				 
		 }
	}
	
	static void findTriplets(int arr[], int n, int sum) 
	{ 
	    for (int i = 0; i < n - 1; i++)  
	    { 
	        // Find all pairs with sum equals to 
	        // "sum-arr[i]" 
	        HashSet<Integer> s = new HashSet<>(); 
	        for (int j = i + 1; j < n; j++)  
	        { 
	            int x = sum - (arr[i] + arr[j]); 
	            if (s.contains(x)) 
	                System.out.printf("%d %d %d\n", x, arr[i], arr[j]); 
	            else
	                s.add(arr[j]); 
	        } 
	    } 
	} 

	public static void main(String[] args) {
		System.out.println("PairSum");
		int a[] = { 0, -1, 2, -3, 1 };
		PairSum pe = new PairSum();
		int sum=-4;
		pe.getPairSum(a,sum);
		System.out.println("TrippletSum");
		int arr[] = { 0, -1, 2, -3, 1 }; 
		int Sum = -2; 
		int n = arr.length; 
		findTriplets(arr, n, Sum); 

	}
	
	

}
