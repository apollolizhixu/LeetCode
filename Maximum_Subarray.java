public class Solution{
	public int maxSubArray1(int[] A){
		if (A == null || A.length == 0){
			return 0;
		}
		int rst = A[0];
		int minSum = A[0];
		int sum = A[0];
		for (int i = 1; i < A.length; i++){
			sum += A[i];
			if (rst < sum - minSum){
				rst = sum - minSum;
			}
			minSum = Math.min(minSum, sum);
		}
		return rst;
	}
	public int maxSubArray(int[] A){
		if (A == null || A.length == 0){
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < A.length; i++){
			sum += A[i];
			max = Math.max(max, sum);
			sum = Math.max(0, sum);
		}
		return max;
	}
}