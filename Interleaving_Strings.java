public class Solution{
	public boolean isInterleave(String s1, String s2, String s3){
		if (s3.length() != (s1.length() + s2.length())){
			return false;
		}
		int m = s1.length();
		int n = s2.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= m; i++){
			if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]){
				dp[i][0] = true;
			}
		}
		for (int i = 1; i <= n; i++){
			if (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1]){
				dp[0][i] = true;
			}
		}
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++){
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1)){
					dp[i][j] |= dp[i - 1][j];
				}
				if (s2.charAt(j - 1) == s3.charAt(i + j - 1)){
					dp[i][j] |= dp[i][j - 1];
				}
			}
		}
		return dp[m][n];
	}
}