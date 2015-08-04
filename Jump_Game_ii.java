public class Solution{
	public int jump(int[] A){
		//Time:O(n^2), Space:O(n)
		if (A == null || A.length == 0){
			return 0;
		}
		int[] opt = new int[A.length];
		opt[0] = 0;
		for (int i = 1; i < A.length; i++){
			for (int j = 0; j < i; j++){
				if (A[j] + j >= i){
					A[i] = A[j] + 1;
				}
			}
		}
		return opt[A.length - 1];
	}
	public int jump1(int[] A){
		//Time:O(n), Space:O(1)
		if (A == null || A.length == 0){
			return 0;
		}
		int step = 0;
		int curr = 0;
		int last = 0;
		for (int i = 0; i < A.length; i++){
		    if (i > last){
		        step++;
		        last = curr;
		    }
		    curr = Math.max(curr, i + A[i]);
		}
		return step;
	}
}