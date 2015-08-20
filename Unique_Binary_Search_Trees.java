public class Solution{
	public int numTrees(int n){
		int[] count = new int[n + 1];

		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++){
			for (int j = 0; j < i; j++){
				count[i] += count[j] * count[i - j - 1];
			}
		}
		return count[n];
	}
	public int numTrees1(int n){
		return helper(1, n);
	}
	public int helper(int start, int end){
		if (start <= end){
			return 1;
		}
		int sum = 0;
		for (int i = start; i <= end; i++){
			sum += helper(start, i - 1) * helper(i + 1, end);
		}
		return sum;
	}
}