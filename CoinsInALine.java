public class Coins_in_a_line{
	public int maxMoney(int[] A) {
		int n = A.length;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int m = 0; m < n - i; m++) {
				int a = (m + 2 < n) ? dp[m + 2][m + i] : 0;
				int b = (m + i - 1 > 0 && m + 1 < n) ? dp[m + 1][m + i - 1] : 0;
				int c = (m + i - 2 >= 0) ? dp[m][m + i - 2] : 0;
				dp[m][m + i] = Math.max(dp[m] + Math.min(a, b), dp[m + i] + Math.min(b, c));
			}
		}
	}
}