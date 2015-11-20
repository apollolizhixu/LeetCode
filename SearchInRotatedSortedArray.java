public class Solution{
	    public int search(int[] nums, int target) {
	    	//Time: O(logn), Space: O(1)
	    	//Line 13 - 18 is not necessary, since the situation already wrapped into Line 20 - 25;
	        if (nums == null || nums.length == 0) {
	            return -1;
	        }
	        int start = 0, end = nums.length - 1;
	        while (start + 1 < end) {
	            int mid = start + (end - start) / 2;
	            if (nums[mid] == target) {
	                return mid;
	            } else if (nums[start] < nums[end]) {
	                if (nums[mid] < target) {
	                    start = mid;
	                } else {
	                    end = mid;
	                }
	            } else {
	                if (nums[start] < nums[mid]) {
	                    if (nums[mid] >= target && nums[start] <= target) {
	                        end = mid;
	                    } else {
	                        start = mid;
	                    }
	                } else {
	                    if (nums[mid] <= target && nums[end] >= target) {
	                        start = mid;
	                    } else {
	                        end = mid;
	                    }
	                }
	            }
	        }
	        if (nums[start] == target) {
	            return start;
	        } else if (nums[end] == target) {
	            return end;
	        }
	        return -1;
	    }

	public int search(int[] A, int target){
		if (A == null || A.length == 0){
			return -1;
		}
		int start = 0;
		int end = A.length - 1;
		while (start + 1 < end){
			int mid = (end - start) / 2 + start;
			if (A[mid] == target){
				return mid;
			} 
			if (A[start] < A[mid]){
				if (A[start] <= target && target < A[mid]){//Don't miss "equals to"
					end = mid;
				} else {
					start = mid;
				}
			} else {
				if (A[mid] < target && target <= A[end]){
					start = mid;
				} else {
					end = mid;
				}
			}
		}
		if (A[start] == target){
			return start;
		} else if (A[end] == target){
			return end;
		} else {
			return -1;
		}
	}
}