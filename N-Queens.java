public class Solution{
	public List<List<String>> solveNQueens(int n){
		List<List<String>> rst = new ArrayList<List<String>>();
		if (n <= 0){
			return rst;
		}
		List<Integer> row = new ArrayList<Integer>();
		helper(n, rst, row);
		return rst;
	}
	public void helper(int n, List<List<String>> rst, List<Integer> row){
		if (row.size() == n){
			output(rst, row, n);
			return;
		}
		for (int i = 0; i < n; i++){
			if (valid(row, i)){
				row.add(i);
				helper(n, rst, row);
				row.remove(row.size() - 1);
			}
		}
	}
	public boolean valid(List<Integer> row, int k){
		for (int i = 0; i < row.size(); i++){
			if (row.get(i) == k){
				return false;
			}
			if (i + row.get(i) == row.size() + k){
				return false;
			}
			if (i - row.get(i) == row.size() - k){
				return false;
			}
		}
		return true;
	}
	public void output(List<List<String>> rst, List<Integer> row, int n){
		List<String> tmp = new ArrayList<String>();
		for (int i = 0; i < n; i++){
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++){				
				if (row.get(i) != j){
					sb.append(".");
				} else {
					sb.append("Q");
				}
			}
			tmp.add(sb.toString());
		}
		rst.add(new ArrayList<String>(tmp));
	}
}