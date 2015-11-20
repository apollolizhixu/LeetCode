public class Solution{
	public int numDistinct(String S, String T){
		//Time: O(m * n); Space: O(m * n);
		if (S == null){
			return 0;
		}
	    int m = S.length();
	    int n = T.length();
		int[][] dp = new int[m + 1][n + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= m; i++){
			dp[i][0] = 1;
		}
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++){
				dp[i][j] = dp[i - 1][j];
				if (S.charAt(i - 1) == T.charAt(j - 1)){
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		return dp[m][n];
	}

	public int numDistinct(String s, String t) {
        //Time: O(mn), Space: O(n)
        if (s == null || t == null) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];
        prev[0] = 1;
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 0; j--) {
                dp[j] = prev[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += prev[j - 1];
                }
                prev[j] = dp[j];
            }
            
        }
        return dp[n];
    }
}
