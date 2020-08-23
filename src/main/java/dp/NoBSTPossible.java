package dp;
//Appication of catalan no
public class NoBSTPossible {
//Total number of possible Binary Search Trees with n different keys (countBST(n)) = Catalan number Cn = (2n)!/(n+1)!*n!
	static int noBSTPoss(int n) {
		int N[] = new int[n + 1];
		N[0] = 1;
		N[1] = 1;
		for (int i = 2; i <= n; i++) {
			N[i] = 0;
			for (int j = 0; j < i; j++) //fix one node as root node at a time
			{
				N[i] += N[j] * N[i - j - 1]; //1)multiply the to ends for a particular possibility
				                             //2)Add all possibilities
			}
		}
		return N[n];
	}

	public static void main(String[] args) {

	}

}
