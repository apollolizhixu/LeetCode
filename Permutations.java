public class Solution{
	public List<List<Integer>> permute(int[] num){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0){
			return rst;
		}
		List<Integer> list = new ArrayList<Integer>();
		helper(num, rst, list);
		return rst;
	}
	public void helper(int[] num, List<List<Integer>> rst, List<Integer> list){
		if (list.size() == num.length){
			rst.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0, i < num.length; i++){
			if (!list.contains(num[i])){
				list.add(num[i]);
				helper(num, rst, list);
				list.remove(list.size() - 1);
			}
		}
	}
}