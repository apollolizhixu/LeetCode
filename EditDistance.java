public class Solution{
	public int minDistance(String word1, String word2){
		//Time: O(mn), Space: O(mn)
		if (word1 == null || word2 == null){
			return -1;
		}
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++){
			dp[i][0] = i;
		}
		for (int i = 1; i <= n; i++){
			dp[0][i] = i;
		}
		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++){
				if (word1.charAt(i - 1) == word2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		return dp[m][n];
	}

	public int minDistance(String word1, String word2) {
        //Time: O(mn), Space: O(n)
        if (word1 == null || word2 == null) {
            return 0;
        }
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prev[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev[j - 1];
                } else {
                    dp[j] = Math.min(dp[j - 1], Math.min(prev[j], prev[j - 1])) + 1;
                }
            }
            System.arraycopy(dp, 0, prev, 0, n + 1);
        }
        return prev[n];
    }
}