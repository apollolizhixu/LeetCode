public class Solution{
	 public int maxProduct(int[] A) {
		 //Time: O(n^2), Space: O(n^2)
	 	if (A == null || A.length == 0) {
	 		return 0;
	 	}
	 	int n = A.length;
	 	int[][] dp = new int[n][n];
	 	int maxValue = Integer.MIN_VALUE;
	 	for (int i = 0; i < n; i++) {
	 		dp[i][i] = A[i];
	 		maxValue = Math.max(maxValue, dp[i][i]);
	 	}
	 	
	 	for (int i = 0; i < n; i++) {
	 		for (int j = i - 1; j >= 0; j--) {
	 			dp[j][i] = dp[j + 1][i] * A[j];
	 			maxValue = Math.max(maxValue, dp[j][i]);
	 		}
	 	}
	 	return maxValue;
	 }
	 public int maxProduct(int[] A) {
		 	if (A == null || A.length == 0) {
		 		return 0;
		 	}
		 	int n = A.length;
		 	int[] max = new int[n];
		 	int[] min = new int[n];
		 	int rst = Integer.MIN_VALUE;
		 	max[0] = A[0];
		 	min[0] = A[0];
		 	rst = Math.max(max[0], min[0]);
		 	for (int i = 1; i < n; i++) {
		 		rst = Math.max(rst, Math.max(max[i - 1] * A[i], min[i - 1] * A[i]));
		 		max[i] = Math.max(A[i], Math.max(max[i - 1] * A[i], min[i - 1] * A[i]));
		 		min[i] = Math.min(A[i], Math.min(max[i - 1] * A[i], min[i - 1] * A[i]));
		 	}
			return rst;
		 }
	public int maxProduct(int[] A) {
	 	if (A == null || A.length == 0) {
	 		return 0;
	 	}
	 	int maxPro = 1;
	 	int minPro = 1;
	 	int rst = Integer.MIN_VALUE;
	 	for (int i = 0; i < A.length; i++) {
	 		int max = maxPro * A[i];
	 		int min = minPro * A[i];
	 		rst = Math.max(rst, Math.max(max, min));
	 		maxPro = Math.max(1, Math.max(max, min));
	 		minPro = Math.min(1, Math.min(max, min));
	 	}
	 	return rst;
	 }
	 public static void main(String[] args) {
		 Solution s = new Solution();
		 int[] A = {2, 3, -2, 4};
		 System.out.println(s.maxProduct(A));
	 }
}