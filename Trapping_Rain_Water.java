public class Solution{
	public int trap(int[] A){
		if (A == null || A.length == 0){
			return 0;
		}
		int maxIndex = 0;
		for (int i = 1; i < A.length; i++){
			if (A[i] > A[maxIndex]){
				maxIndex = i;
			}
		}
		int sum = 0;
		int prev = 0;
		for (int i = 0; i < maxIndex; i++){
			if (A[i] > prev){
				sum += (maxIndex - i) * (A[i] - prev);
				prev = A[i];
			}
			sum -= A[i];
		}
		prev = 0;
		for (int i = A.length - 1; i > maxIndex; i--){
			if (A[i] > prev){
				sum += (i - maxIndex) * (A[i] - prev);
				prev = A[i];
			}
			sum -= A[i];
		}
		return sum;
	}
}