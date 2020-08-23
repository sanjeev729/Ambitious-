package dp;

public class MaximumSubarrySum {
	// Kadane's algo only works if atleast one element is positive
	static int maxSubArraySum(int a[]) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0, sIndex = 0, eIndex = 0, s = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			} else if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				sIndex = s;
				eIndex = i;
			}
		}
		System.out.println("from" + sIndex + "to" + eIndex);
		return max_so_far;
	}

	// Dynamic programic way works for all negative no's also
	static int maxSubArraySumDP(int a[]) {
		int size = a.length;
		int max_so_far = a[0], max_ending_here = a[0];
		for (int i = 1; i < size; i++) {
			max_ending_here = Integer.max(max_ending_here + a[i], a[i]);
			max_so_far = Integer.max(max_so_far, max_ending_here);
		}

		return max_so_far;
	}

	public static void main(String[] args) {
		int[] a = { 10, -3, -9, 8,-7, -10, -11 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

}
