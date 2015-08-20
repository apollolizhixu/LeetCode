public class Solution{
	public int longestIncreasingSubsequence(int[] nums){
		//Time Complexity: O(n^2), space: O(n)
		if (nums.length == 0 || nums == null){
			return 0;
		}
		int[] dp = new int[nums.length];
		for (int i = 0; i < dp.length; i++){
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--){
				if (nums[j] <= nums[i]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int rst = 0;
		for (int i = 0; i < dp.length; i++){
			rst = Math.max(rst, dp[i]);
		}
		return rst;
	}
}