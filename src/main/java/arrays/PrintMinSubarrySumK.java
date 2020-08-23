package arrays;

public class PrintMinSubarrySumK {

	public PrintMinSubarrySumK() {
		// TODO Auto-generated constructor stub
	}

	public static void printMinSubArrayWithSum(int[] array, int k) {

		int start = -1;
		int end = -1;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {

			int currentSum = array[i];

			for (int j = i + 1; j < array.length && (j - i + 1) < min; j++) {
				currentSum += array[j];
				if (currentSum == k) {
					start = i;
					end = j;
					min = end - start + 1;
					break;
				}
			}
		}

		if (start == -1 || end == -1) {
			System.out.println("No subarray exists with sum = " + k);
			return;
		}

		System.out.print("[ ");
		while (start <= end) {
			System.out.print(array[start] + " ");
			start++;
			;
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		int[] array = { 4, 3, 1, 2, 4, -1 };
		int k = 7;
		printMinSubArrayWithSum(array, k);
	}

}
