package Recursion;

public class a_PrintNumbers {

	private static void printNumbersInc(int n) {
		if (n == 1) {
			System.out.print(1 + " ");
			return;
		}

		printNumbersInc(n - 1);
		System.out.print(n + " ");
	}

	private static void printNumbersDec(int n) {
		if (n == 1) {
			System.out.print(1 + " ");
			return;
		}

		System.out.print(n + " ");

		printNumbersDec(n - 1);

	}

	private static int factorial(int n) {

		if (n == 0 || n == 1) {
			return 1;
		}

		return n * factorial(n - 1);
	}

	private static int fib(int n) {

		if (n == 1 || n == 2) {
			return 1;
		}

		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		printNumbersInc(7);
		System.out.println();
		printNumbersDec(7);
		System.out.println();
		System.out.print(factorial(5));
		System.out.println();
		System.out.print(fib(4));

	}

}
