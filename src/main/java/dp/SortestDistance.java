package dp;

public class SortestDistance {

	// static int mem[][]={ { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	public int shortestDistanceTryNextTime(int[][] cost) {
		int[] mindistance = new int[3];
		mindistance[0] = 0;
		mindistance[1] = cost[0][1];

		for (int i = 2; i < 3; i++) {

			mindistance[i] = cost[0][i];

			for (int j = 1; j < i; j++) {

				if (mindistance[i] > (mindistance[j] + cost[j][i]))
					mindistance[i] = (mindistance[j] + cost[j][i]);
			}

		}
		return mindistance[2];

	}

	// Only Right and Down are allowed
	// -----------------------Recursion Bottom up exponential time
	// -------------------
	public int shortestDistance(int[][] cost, int r, int c) {
		if (r == 0 && c == 0)
			return cost[0][0];
		if (r == 0)
			return cost[r][c] + shortestDistance(cost, r, c - 1);
		if (c == 0)
			return cost[r][c] + shortestDistance(cost, r - 1, c);

		return cost[r][c] + Math.min(shortestDistance(cost, r - 1, c), shortestDistance(cost, r, c - 1));

	}

	// --------------------------Memoization exponential time ----------------
	public int shortestDistanceM(int[][] cost, int mem[][], int r, int c) {
		if (mem[r][c] != 0)
			return mem[r][c];
		if (r == 0 && c == 0)
			mem[r][c] = cost[0][0];
		else if (r == 0)
			mem[r][c] = cost[r][c] + shortestDistanceM(cost, mem, r, c - 1);
		else if (c == 0)
			mem[r][c] = cost[r][c] + shortestDistanceM(cost, mem, r - 1, c);
		else
			mem[r][c] = cost[r][c]
					+ Math.min(shortestDistanceM(cost, mem, r - 1, c), shortestDistanceM(cost, mem, r, c - 1));

		return mem[r][c];
	}

	// -------------------------DP Bottom Up O(n^2)----------------

	public int shortestDistanceDP(int[][] cost) {

		int mem[][] = new int[3][3];

		mem[0][0] = cost[0][0];
		// Filling top row
		for (int i = 1; i < 3; i++)
			mem[0][i] = mem[0][i - 1] + cost[0][i];
		// Filling Leftmost column
		for (int i = 1; i < 3; i++)
			mem[i][0] = mem[i - 1][0] + cost[i][0];
		// Filling other cells
		for (int r = 1; r < 3; r++)
			for (int c = 1; c < 3; c++) {
				mem[r][c] = cost[r][c] + Math.min(mem[r - 1][c], mem[r][c - 1]);

			}
		// returning the destination cell ,it will have min cost if we move from
		// (0,0) to (2,2)
		// where only down and right operation allowed
		return mem[2][2];
	}

	// Right,down and diagonally also allowed
	public int shortestDistanceThreeMove(int[][] cost, int r, int c) {
		if (r == 0 && c == 0)
			return cost[0][0];
		if (r == 0)
			return cost[r][c] + shortestDistanceThreeMove(cost, r, c - 1);
		if (c == 0)
			return cost[r][c] + shortestDistanceThreeMove(cost, r - 1, c);

		return cost[r][c] + Math.min(shortestDistanceThreeMove(cost, r - 1, c - 1),
				Math.min(shortestDistanceThreeMove(cost, r - 1, c), shortestDistanceThreeMove(cost, r, c - 1)));

	}

	// 2*n plot 2*1 tile
	public int numWaysTilesPlot(int n) {

		if (n == 0)
			return 0;

		else if (n == 1)
			return 1;
		else if (n == 2)
			return 2;

		else
			return numWaysTilesPlot(n - 1) + numWaysTilesPlot(n - 2);

	}

	public int numWaysTilesPlotDP(int n) {

		int mem[] = new int[n + 3];

		mem[0] = 0;

		mem[1] = 1;

		mem[2] = 2;

		for (int i = 3; i <= n; i++) {

			mem[i] = mem[i - 1] + mem[i - 2];

		}
		return mem[n];
	}

	public int UniqueWayToReachSum(int n) {

		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		return UniqueWayToReachSum(n - 3) + UniqueWayToReachSum(n - 5) + UniqueWayToReachSum(n - 10);
	}
//when (10,3) and (3,10) are considered different  
	public int UniqueWayToReachSumDP(int n) {
		int arr[] = new int[n + 1];

		arr[0] = 1;
		for (int i = 1; i <= n; i++)
			arr[i] = 0;

		for (int i = 1; i <= n; i++) {
			if (i - 3 >= 0)
				arr[i] += arr[i - 3];
			if (i - 5 >= 0)
				arr[i] += arr[i - 5];
			if (i - 10 >= 0)
				arr[i] += arr[i - 10];

		}
		return arr[n];

	}
//when (10,3) and (3,10) considered same 
	// this problem is same as coin change total no of ways 
	public int UniqueWayToReachSumDP2(int n) {
		int arr[] = new int[n + 1];

		arr[0] = 1;
		for (int i = 1; i <= n; i++)
			arr[i] = 0;

		for (int i = 3; i <= n; i++) {
			if (i - 3 >= 0)
				arr[i] += arr[i - 3];
		}
		for (int i = 5; i <= n; i++) {
			if (i - 5 >= 0)
				arr[i] += arr[i - 5];
		}
		for (int i = 10; i <= n; i++) {
			if (i - 10 >= 0)
				arr[i] += arr[i - 10];

		}
		return arr[n];

	}

	public static void main(String[] args) {

		int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		int mem[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		SortestDistance sd = new SortestDistance();

		// System.out.println(sd.shortestDistanceThreeMove(cost, 2, 2));

		// System.out.println(sd.shortestDistance(cost, 2, 2));
		// System.out.println(sd.shortestDistanceM(cost, mem, 2, 2));
		// System.out.println(sd.shortestDistanceDP(cost));

		// System.out.println(sd.numWaysTilesPlot(0));
		// System.out.println(sd.numWaysTilesPlotDP(0));
		System.out.println(sd.UniqueWayToReachSumDP(13));
		System.out.println(sd.UniqueWayToReachSumDP2(13));

	}

}
