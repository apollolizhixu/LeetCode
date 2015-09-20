public class Solution{
	private static boolean matchLetter(char cs, char cp){
        return !(cs != cp && cp != '.');
    }
    public static boolean isMatch1(String s, String p) {
    	//Recursion Solution;
    	//Time: O(2 ^ n), Space: O(1);
		if (s == null || p == null) {
			return false;
		}
		if (p.length() == 0) {
			return s.length() == 0;
		}
		if (p.length() == 1) {
			return s.length() == 1 && matchLetter(s.charAt(0), p.charAt(0));
		}
		if (p.length() >= 2) {
			if (p.charAt(1) != '*') {
				if (s.length() < 2 || !matchLetter(s.charAt(0), p.charAt(0))) {
					return false;
				}
				return isMatch(s.substring(1), p.substring(1));
			} else {
				if (isMatch(s, p.substring(2))) {
					return true;
				} else {
					int i = 0;
					while (i < s.length() && matchLetter(s.charAt(i), p.charAt(0))) {
						if (isMatch(s.substring(i), p.substring(2))) {
							return true;
						}
						i++;
					}
				}
			}
		}
		return false;
	}
	public boolean isMatch1(String s, String p) {
		//DP Solution
		//Time: O(m * n), Space: O(m * n);
		if (s == null || p == null) {
			return false;
		}
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 2; i <= n; i++) {
		    dp[0][i] = dp[0][i - 2] && p.charAt(i - 1) == '*';
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char c1 = s.charAt(i - 1);
				char c2 = p.charAt(j - 1);
				if (c2 != '*') {
					dp[i][j] = (c2 == '.' || c1 == c2) && dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i][j - 2];
					if (c1 == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
						dp[i][j] = dp[i][j] || dp[i - 1][j];
					}
				}
			}
		}
		return dp[m][n];
	}
}