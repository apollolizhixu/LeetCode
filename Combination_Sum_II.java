public class Solution{
	public List<List<Integer>> combinationSum2(int[] num, int target){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0){
			return rst;
		}
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);
		helper(num, target, rst, list, 0);
		return rst;
	}
	public void helper(int[] num, int target, List<List<Integer>> rst, List<Integer> list, int pos){
		if (target == 0){
		    if (!rst.contains(list)){
		        rst.add(new ArrayList<Integer>(list));
		    }
			return;
		}
		if (target < 0){
		    return;
		}
		int prev = -1;
		for (int i = pos; i < num.length; i++){
			list.add(num[i]);
			helper(num, target - num[i], rst, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
}