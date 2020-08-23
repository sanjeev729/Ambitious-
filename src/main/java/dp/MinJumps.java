package dp;

public class MinJumps {

	// Q8. Determine if you are able to reach the last index.
	public boolean canJump(int[] nums) {
		int laspos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= laspos) {
				laspos = i;
			}
		}
		return laspos == 0;
	}

	// Q9. Minimum no of jumps required to reach the end of the arry/array
	// hopping problem
	public static int minNoOfjumps(int[] nums) {
		int jumps = 0, ending_pos = 0, curr_pos = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curr_pos = Math.max(curr_pos, i + nums[i]);
			if (i == ending_pos) {
				jumps++;
				ending_pos = curr_pos;
			}
		}
		return jumps;
	}

	private static int minJumps(int[] arr, int n) {
		int jumps[] = new int[n]; // jumps[n-1] will hold the
									// result
		int i, j;

		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE; // if first element is 0,
										// end cannot be reached

		jumps[0] = 0;

		// Find the minimum number of jumps to reach arr[i]
		// from arr[0], and assign this value to jumps[i]
		for (i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		return jumps[n - 1];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 1, 0, 9 };

		System.out.println("Minimum number of jumps to reach end is : " + minJumps(arr, arr.length) );
		System.out.println(minNoOfjumps(arr));
	}
}
