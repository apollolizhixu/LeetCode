public class Solution {
	public int backPackII(int m, int[] A, int[] V) {
		//Time: O(mn), Space: O(mn)
		if (m == 0 || A == null || V == null || A.length == 0) {
			return 0;
		}
		int n = A.length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = -1;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (dp[i - 1][j] != -1) {
					dp[i][j] = dp[i - 1][j];
				}
				if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]] != -1) {
					dp[i][j] = dp[i - 1][j - A[i - 1]] + V[i - 1];
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= m; i++) {
			max = Math.max(dp[n][i], max);
		}
		return max;
	}
}