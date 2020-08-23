package dp;

public class PrevSum {

	static int arr[] = new int[15];

	public int sumHeadRecurrion(int arr[], int i) {
		if (i == 0)
			return arr[i];

		return arr[i] = arr[i] + sumHeadRecurrion(arr, i - 1);

	}

	public void sumTailRecurrion(int arr[], int i) {
		if (i == arr.length)
			return;

		arr[i] = arr[i] + arr[i - 1];
		sumTailRecurrion(arr, i + 1);

	}

	public void loopcustom(int i) {
		if (i == 100)
			return;

		System.out.println(i);

		loopcustom(i + 1);

	}

	public int coffecient(int x, int n) {

		if (n == 0)
			return 1;
		if (x == 1)
			return x;

		return x * coffecient(x, n - 1);
	}

	public void towerHanoi(char s, char d, char e, int n) {

		if (n <= 0)
			return;
		System.out.println("before");
		towerHanoi(s, e, d, n - 1);
		System.out.println("Move " + n + " from source " + s + " to" + " Destination " + d);
		System.out.println("after");
		towerHanoi(e, d, s, n - 1);

	}

	public int fib(int n) {
		if (n == 1 || n == 2)
			return 1;

		return fib(n - 1) + fib(n - 2);

	}

	public int fibMemo(int n) {

		if (arr[n] != 0)
			return arr[n];

		if (n == 1 || n == 2)
			arr[n] = 1;

		else
			arr[n] = fibMemo(n - 1) + fibMemo(n - 2);

		return arr[n];

	}

	public int fibIterative(int n) {

		int combine=0, prv1 = 1, prv2 = 1;

		if (n == 1 || n == 2)
			return 1;

			for (int i = 3; i <=n; i++) {
				combine = prv1 + prv2;

				prv2 = prv1;
				prv1 = combine;

			}

		return combine;

	}

	/*
	 * public int sum(int arr[],int i) { if (i <0 || i>arr.length) return
	 * arr[i];
	 * 
	 * return arr[i]=arr[i-1]+sum(arr,i);
	 * 
	 * }
	 */

	public static void main(String[] args) {
		PrevSum ps = new PrevSum();

		int arr[] = { 0, 1, 2, 3, 4, 5, 6 };
		// ps.sumHeadRecurrion(arr,arr.length-1);

		// ps.sumTailRecurrion(arr, 1);
		// ps.loopcustom(0);

		// for (int i : arr)
		// System.out.println(i);

		// System.out.println(ps.coffecient(1, 4));

		ps.towerHanoi('S', 'D', 'E', 3);

		System.out.println("------Recursion-----------");
		for (int i = 1; i < 10; i++) {
			System.out.print(" " + ps.fibMemo(i));

		}
		System.out.println();
		System.out.println("------Memoization with recursion------");

		for (int i = 1; i < 10; i++) {
			System.out.print(" " + ps.fibMemo(i));

		}
		
		System.out.println();
		System.out.println("------Dp with Iterative------");

		for (int i = 1; i < 10; i++) {
			System.out.print(" " + ps.fibIterative(i));

		}

	}

}
