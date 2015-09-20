public class Solution{
	public boolean isMatch(String s, Strig p) {
		if (s == null || p == null) {
			return false;
		}
		int m = s.length();
		int n = p.length();
		if (n == 0) {
			return m == 0;
		} 
		if (p.charAt(0) == '*') {
			int i = 0;
			while (i < n && p.charAt(i) == '*') {
				i++;
			}
			int j = 0;
			while (j <= m) {
				if (isMatch(s.substring(j), p.substring(i))) {
					return true;
				}
				j++;
			}
		} else if(m > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')){
			return isMatch(s.substring(1), p.substring(1));
		}
		return false;
	}
	public boolean isMatch1(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= n; i++) {
			if (p.charAt(i - 1) == '*' && dp[0][i - 1]) {
				dp[0][i] = true;
			}
		}
		for (int j = 1; j <= n; j++) {
			if (p.charAt(j - 1) == '*') {
				int i = 1;
				while (i <= m && (!dp[i][j - 1] && !dp[i - 1][j])) {
					i++;
				}
				for (; i <= m; i++) {
					dp[i][j] = true;
				}
			} else {
				for (int i = 1; i <= m; i++) {
					if (dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) {
						dp[i][j] = true;
					}
				}
			}
		}
		return dp[m][n];
	}
	public boolean isMatch2(String s, String p) {
        if (s == null || p == null){
			return false;
		}
		if (s.length() == 0 && p.length() == 0) {
		    return true;
		}
		int sLen = s.length();
		int pLen = p.length();
		boolean[] dp = new boolean[sLen + 1];
		boolean[] dpNext = new boolean[sLen + 1];
		dp[0] = true;
		
		for (int j = 1; j <= pLen; j++){
			dpNext[0] = dp[0] && p.charAt(j - 1) == '*';
            if (p.charAt(j - 1) == '*') {
                
                int i = 1;
                while (i <= sLen && !dp[i] && !dpNext[i - 1]) {
                    i++;
                }
                for (; i <= sLen; i++) {
                    dpNext[i] = true;
                }
            } else {
                for (int i = 1; i <= sLen; i++) {
                    dpNext[i] = dp[i - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
            }
            for (int i = 0; i <= sLen; i++) {
                dp[i] = dpNext[i];
            }
		}
		return dpNext[sLen];
    }
    public boolean isMatch3(String s, String p) {
    	if (s == null || p == null) {
    		return false;
    	}
    	int i = 0, j = 0, mark = -1, start = -1;
    	while (i < s.length()) {
    	    if (j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')){
    	        i++;
    	        j++;
    	    } else if (j < p.length() && p.charAt(j) == '*') {
    	        mark = i;
    	        start = j++;
    	    } else if (start != -1) {
    	        i = ++mark;
    	        j = start + 1;
    	    } else {
    	        return false;
    	    }
    	}
    	while (j < p.length() && p.charAt(j) == '*') {
    	    j++;
    	}
    	return j == p.length();
    }
}