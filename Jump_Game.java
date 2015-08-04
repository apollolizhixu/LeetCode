public class Solution{
	public boolean canJump(int[] A){
		//Time: O(n^2); Space: O(n)
		if (A == null || A.length == 0 || A[0] == 0){
			return false;
		}
		boolean[] dp = new boolean[A.length];
		dp[0] = true;
		for (int i = 1; i < A.length; i++){
			for (int j = 0; j < i; j++){
				if (A[j] + j >= i){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[A.length - 1];
	}
	public boolean canJump(int[] A){
		//Time: O(n), Space: O(n)
		if (A == null || A.length == 0){
			return false;
		}
		int pres = 0;
		int max = 0;
		for (int i = 0; i < A.length && i <= max; i++){
		    pres = i + A[i];
		    max = Math.max(max, pres);
		}
		return max >= A.length - 1;
	}
}