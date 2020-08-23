package dp;

public class LongestRepeatingSubsequence {

	public static int lrepeatingSub(char[] X, char[] Y, int m, int n) {
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
				if (X[i - 1] == Y[j - 1] && i != j)
					t[i][j] = t[i - 1][j - 1] + 1;
				else
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
			}
		}
		return t[m][n];
	}

	public static void main(String[] args) {
		LongestRepeatingSubsequence lcs = new LongestRepeatingSubsequence();
		String s = "AABABCBCD";
		
		System.out.println("Length of LCS is" + " " + lcs.lrepeatingSub(s.toCharArray(), s.toCharArray(), s.length(), s.length()));
	}

}