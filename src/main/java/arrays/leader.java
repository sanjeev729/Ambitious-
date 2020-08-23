package arrays;

public class leader {

	public leader() {
		// TODO Auto-generated constructor stub
	}

	void printLeaders(int arr[], int size) {
		int max_from_right = arr[size - 1];
		int i;
		/* Rightmost element is always leader */

		System.out.println(max_from_right);
		for (i = size - 2; i >= 0; i--) {
			if (max_from_right < arr[i]) {
				System.out.println(arr[i]);
				max_from_right = arr[i];
			}
		}
	}

	public static void main(String[] args) {
		leader ra = new leader();
		int a[] = { 5, 6, 9, 12, 3, 7 };

		ra.printLeaders(a,a.length);

	}

}
