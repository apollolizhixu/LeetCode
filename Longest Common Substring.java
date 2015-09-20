public class Solution{
	public int longestCommonSubstring(String A, String B){
		//Time: O(m * n), Space: O(m * n);
		if (A == null || B == null || A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int m = A.length();
		int n = B.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++){
			dp[i][0] = 0;
		}
		for (int i = 1; i <= n; i++){
			dp[0][i] = 0;
		}
		int maxLength = 0;
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++){
				if (A.charAt(i - 1) == B.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1] + 1;
					maxLength = Math.max(maxLength, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return maxLength;
	}
	public int longestCommonSubstring(String A, String B){
		//Time: O(m * n), Space: O(n);
		if (A == null || B == null || A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int m = A.length();
		int n = B.length();
		int[] dp = new int[m + 1];
		int maxLength = 0;
		for (int i = 1; i <= n; i++){
			for (int j = m; j >= 0; j--){
				if (j == 0) {
					dp[j] = 0;
				}
				if (B.charAt(i - 1) == A.charAt(j - 1)){
					dp[j] = dp[j - 1] + 1;
					maxLength = Math.max(maxLength, dp[j]);
				} else {
					dp[j] = 0;
				}
			}
		}
		return maxLength;
	}
}