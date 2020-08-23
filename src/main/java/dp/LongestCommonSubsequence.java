package dp;

public class LongestCommonSubsequence {

	/*
	 * Recursive implementation Returns length of LCS for X[0..m-1], Y[0..n-1]
	 * 
	 * Time complexity of recursive approach is O(2^n) in worst case and worst
	 * case happens when all characters of X and Y mismatch i.e., length of LCS
	 * is 0.
	 */

	public static int lcs(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (X[m - 1] == Y[n - 1])
			return 1 + lcs(X, Y, m - 1, n - 1);
		else
			return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
	}

	// DP way

	public static int lcsDp(char[] X, char[] Y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that
		 * L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (X[i - 1] == Y[j - 1])
					t[i][j] = t[i - 1][j - 1] + 1;
				else
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
			}
		}
		return t[m][n];
	}

	public static void lcsPrint(char[] X, char[] Y, int m, int n) {
		int t[][] = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (X[i - 1] == Y[j - 1])
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
			}
		}

		int i = m;
		int j = n;
		StringBuffer lcs = new StringBuffer();
		while (i > 0 && j > 0) {
			
			if (X[i - 1] == Y[j - 1]) {
				lcs.append(X[i - 1]);
				i--;
				j--;
			} else {
				if (t[i][j - 1] >= t[i - 1][j])
					j--;
				else
					i--;
			}
		}
		System.out.println(lcs.reverse().toString());
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYyuyuyuwyuB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, m, n));
		System.out.println("Length of LCS is" + " " + lcs.lcsDp(X, Y, m, n));
		lcs.lcsPrint(X, Y, m, n);
	}

}