package dp;
public class ShortestCommonSupersequence
{ 
	int scs(char[] X, char[] Y, int m, int n) {
		return X.length + Y.length - LongestCommonSubsequence.lcs(X, Y, m, n);
	}
	
	void scsPrint(char[] X, char[] Y, int m, int n) {
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
				j--;
				i--;
			} else {

				if (t[i][j - 1] >= t[i - 1][j]) {
					lcs.append(Y[j - 1]);
					j--;
				} else {
					lcs.append(X[i - 1]);
					i--;
				}
			}
		}

		while (i > 0) {
			lcs.append(X[i - 1]);
			i--;
		}
		while (j > 0) {
			lcs.append(Y[j - 1]);
			j--;
		}

		System.out.println(lcs.reverse().toString());
	}
 
  public static void main(String[] args)
	{
		ShortestCommonSupersequence scs = new ShortestCommonSupersequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of SCS is" + " " + scs.scs(X, Y, m, n));

		scs.scsPrint(X, Y, m, n);
	}
 
}