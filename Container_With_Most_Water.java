public class Solution{
	public int maxArea(int[] height){
		if (height == null || height.length <= 1){
			return 0;
		}
		int start = 0;
		int end = height.length - 1;
		int sum = 0;
		while (start < end){
			int pres = (end - start) * Math.min(height[start], height[end]);
			sum = Math.max(sum, pres);
			if (start > end){
				end--;
			} else {
				start++;
			}
		}
		return sum;
	}
}