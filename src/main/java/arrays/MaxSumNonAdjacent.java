package arrays;

public class MaxSumNonAdjacent {

	public MaxSumNonAdjacent() {
		// TODO Auto-generated constructor stub
	}

	// DP solution
	// Kadane was contiguous,this is non-contiguous
	public int maxSum(int arr[]) {
		int excl = 0;
		int incl = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int temp = incl;
			incl = Math.max(excl + arr[i], incl);
			excl = temp;
		}
		return incl;
	}

	public static void main(String[] args) {
		MaxSumNonAdjacent ra = new MaxSumNonAdjacent();
		int a[] = { 10, -3, -9, 8, -7, -10, -11 };

		System.out.println(ra.maxSum(a));

	}

}
