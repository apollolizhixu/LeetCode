public class Solution{
	public List<List<Integer>> subsets(int[] S){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (S == null || S.length == 0){
			return rst;
		}
		Arrays.sort(S);
		List<Integer> list = new ArrayList<Integer>();
		helper(S, rst, list, 0);
		return rst;
	}
	public void helper(int[] S, List<List<Integer>> rst, List<Integer> list, int pos){
    	rst.add(new ArrayList<Integer>(list));
		for (int i = pos; i < S.length; i++){
			list.add(S[i]);
			helper(S, rst, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
}