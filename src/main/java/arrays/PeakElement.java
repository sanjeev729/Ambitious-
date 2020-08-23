package arrays;

public class PeakElement {

	public PeakElement() {

	}

	private static int getSinglePeakElement(int[] array) {
		int start = 0, end = array.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if ((mid == 0 || array[mid - 1] <= array[mid])
					&& (mid == array.length - 1 || array[mid] >= array[mid + 1])) {
				return array[mid];
			} else if (mid > 0 && array[mid - 1] > array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 1, 4, 6, 5 };
		int a1[] = { 4, 4, 4, 4, 4, 4 };
		int a2[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println(PeakElement.getSinglePeakElement(a));
		System.out.println(PeakElement.getSinglePeakElement(a1));
		System.out.println(PeakElement.getSinglePeakElement(a2));
	}

}
