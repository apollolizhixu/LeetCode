public class Solution{
	public int[] searchRange(int[] A, int target){
		int[] rst = new int[2];
		if (A == null || A.length == 0){
			return rst;
		}
		int start = 0;
		int end = A.length - 1;
		while (start + 1 < end){
			int mid = start + (end - start) / 2;
			if (target > A[mid]){
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A[start] == target){
			rst[0] = start;
		} else if (A[end] == target){
			rst[0] = end;
		} else {
			rst[0] = rst[1] = -1;
			return rst;
		}

		start = 0;
		end = A.length - 1;
		while (start + 1 < end){
			int mid = start + (end - start) / 2;
			if (target >= A[mid]){
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A[end] == target){
			rst[1] = end;
		} else if (A[start] == target){
			rst[1] = start;
		} else {
			rst[0] = rst[1] = -1;
			return rst;
		}

		return rst;
	}
}