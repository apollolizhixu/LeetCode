public class Solution{
	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (n <= 0 || k <= 0){
			return rst;
		}
		List<Integer> list = new ArrayList<Integer>();
		helper(n, k, rst, list, 1);
		return rst;
	}
	public void helper(int n, int k, List<List<Integer>> rst, List<Integer> list, int pos){
		if (list.size() == k){
			rst.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = pos; i <= n; i++){
			list.add(i);
			helper(n, k, rst, list, i);
			list.remove(list.size() - 1);
		}
	}
}