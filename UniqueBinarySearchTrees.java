public class Solution{
	public int numTrees(int n){
		//Time: O(n ^ 2), Space: O(n)
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
	public int numTrees(int n) {
		//Time: O(2 ^ (n^2)), space: O(n)
        if (n <= 0) {
            return 0;
        }
        return helper(1, n);
    }
    public int helper(int start, int end) {
        if (start >= end) {
            return 1;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            num += (helper(start, i - 1) * helper(i + 1, end));
        }
        return num;
    }

	//Time: O(n ^ 2), Space: O(n)
    HashMap<Integer, Integer> map;
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        map = new HashMap<Integer, Integer>();
        return helper(1, n);
    }
    public int helper(int start, int end) {
        if (start >= end) {
            return 1;
        }
        if (map.containsKey(end - start)) {
            return map.get(end - start);
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            num += (helper(start, i - 1) * helper(i + 1, end));
        }
        map.put(end - start, num);
        return num;
    }
}