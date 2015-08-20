public class Solution{
	public int minimumTotal1(List<List<Integer>> triangle){
		//Top-down
		//Time: O(n^2), Space:O(n)
		if (triangle == null || triangle.size() == 0){
			return 0;
		}
		int m = triangle.size();
		int[] min = new int[m];
		min[0] = triangle.get(0).get(0);
		for (int i = 1; i < m; i++){
			List<Integer> list = triangle.get(i);
			min[i] = list.get(i) + min[i - 1];
			for (int j = i - 1; j > 0; j--){
				min[j] = Math.min(min[j], min[j - 1]) + list.get(j);
			}
			min[0] = list.get(0) + min[0];
		}
		int rst = Integer.MAX_VALUE;
		for (int i = 0; i < min.length; i++){
			rst = Math.min(rst, min[i]);
		}
		return rst;
	}
	public int minimumTotal(List<List<Integer>> triangle){
		//Bottom-up
		//Time:O(n^2), Space:O(n)
		if (triangle == null || triangle.size() == 0){
			return 0;
		}
		int m = triangle.size();
		int[] min = new int[m];
		for (int i = 0; i < m; i++){
			min[i] = triangle.get(m - 1).get(i);
		}
		for (int i = m - 2; i >= 0; i--){
			for (int j = 0; j <= i; j++){
				min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
			}
		}
		return min[0];
	}
}