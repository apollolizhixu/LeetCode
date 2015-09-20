public class Solution{
	public int backPack(int m, int[] A){
		//Time: O(m * n), Space: O(m * n)
		if (m == 0 || A == null || A.length == 0){
			return 0;
		}
		int n = A.length;
		Arrays.sort(A);
		boolean[][] dp = new boolean[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= n; i++) {
		    for (int j = 1; j <= m; j++) {
		        if (dp[i - 1][j]) {
		            dp[i][j] = true;
		        }
		        if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]]) {
		        	//Attention: it has to be dp[i-1][j-A[i-1]], if it's dp[i][j-A[i-1]], then it will be viewed as reusable;
		            dp[i][j] = true;
		        }
		    }
		}
		for (int i = m; i >= 1; i--) {
		    if (dp[n][i]) {
		        return i;
		    }
		}
		return 0;
	}
	public int backPack1(int m, int[] A) {
		//Time: O(m * n), Space: O(m)
		if (m == 0 || A == null || A.length == 0) {
			return 0;
		}
		int n = A.length;
		boolean[] dp = new boolean[m + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = m; j > 0; j--) {
				if (dp[j]) {
					continue;
				}
				if (j >= A[i - 1] && dp[j - A[i - 1]]) {
					dp[j] = true;
				}
			}
		}
		for (int i = m; i > 0; i--) {
			if (dp[i]) {
				return i;
			}
		}
		return 0;
	}
}