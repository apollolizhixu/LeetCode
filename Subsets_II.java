public class Solution{
	public List<List<Integer>> subsetsWithDup(int[] num){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0){
			return rst;
		}
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);
		helper(num, rst, list, 0);
		return rst;
	}
	public void helper(int[] num, List<List<Integer>> rst, List<Integer> list, int pos){
	    if (!rst.contains(list)){
	        rst.add(new ArrayList<Integer>(list));
	    }
		for (int i = pos; i < num.length; i++){
			list.add(num[i]);
			helper(num, rst, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
}