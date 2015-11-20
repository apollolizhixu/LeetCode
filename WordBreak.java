public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        //Time: O(n ^ 2), Space: O(n);
        if (s == null || s.length() == 0) {
            return true;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j]) {
                    String subfix = s.substring(j, i);
                    if (wordDict.contains(subfix)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}