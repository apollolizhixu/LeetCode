public class Solution{
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0){
			return rst;
		}
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		helper(candidates, target, rst, list, 0);
		return rst;
	}
	public void helper(int[] candidates, int target, List<List<Integer>> rst, List<Integer> list, int pos){
		if (target == 0){
		    if (rst.contains(list)){
		        return;
		    }
			rst.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = pos; i < candidates.length; i++){
			/*if (i != 0 && candidates[i] == candidates[i - 1] && !list.contains(candidates[i])){
				continue;
			}*/
			if (candidates[i] > target){
			    return;
			}
			list.add(candidates[i]);
			helper(candidates, target - candidates[i], rst, list, i);
			list.remove(list.size() - 1);
		}
	}
}