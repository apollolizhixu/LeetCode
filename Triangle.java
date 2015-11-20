public class Solution{
	public int minimumTotal1(List<List<Integer>> triangle) {
        //Time: O(mn), Space: O(n)
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int m = triangle.size();
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(triangle.get(0).get(0));
        for (int i = 1; i < m; i++) {
            int n = triangle.get(i).size();
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(pre.get(0) + triangle.get(i).get(0));
            for (int j = 1; j < n - 1; j++) {
                curr.add(Math.min(pre.get(j - 1), pre.get(j)) + triangle.get(i).get(j));
            }
            curr.add(pre.get(n - 2) + triangle.get(i).get(n - 1));
            pre = curr;
        }
        int min = Integer.MAX_VALUE;
        for (int i : pre) {
            min = Math.min(i, min);
        }
        return min;
    }
	public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //Time: O(mn), Space: O(mn)
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            min[i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            n = triangle.get(i).size();
            for (int j = 0; j < n; j++) {
                min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
            }
        }
        return min[0];
    }
}
}