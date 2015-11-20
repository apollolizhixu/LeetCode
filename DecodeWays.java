public class Solution {
    public int numDecodings(String s) {
        //Time: O(n), Space: O(n)
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            String part = s.substring(i - 1, i);
            if (valid(part)) {
                dp[i] = dp[i - 1];
            }
            part = s.substring(i - 2, i);
            if (valid(part)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
    public boolean valid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int i = Integer.parseInt(s);
        return i > 0 && i <= 26;
    }
}