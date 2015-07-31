public class Solution{
	public List<List<Integer>> permuteUnique(int[] num){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0){
			return rst;
		}
		List<Integer> list = new ArrayList<Integer>();
		boolean[] taken = new boolean[num.length];
		Arrays.sort(num);
		helper(rst, list, num, taken);
		return rst;
	}
	public void helper(List<List<Integer>> rst, List<Integer> list, int[] num, boolean[] taken){
		if (list.size() == num.length){
			rst.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < num.length; i++){
			if ((i != 0 && num[i] == num[i - 1] && !taken[i - 1]) || taken[i]){
				continue;
			}
			list.add(num[i]);
			taken[i] = true;
			helper(rst, list, num, taken);
			list.remove(list.size() - 1);
			taken[i] = false;
		}
	}
}