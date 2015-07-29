public class Solution{
	public ArrayList<String> generateParenthesis(int n){
		ArrayList<String> rst = new ArrayList<String>();
		if (n <= 0){
			return rst;
		}
		helper("", n, n, rst);
		return rst;
	}
	public void helper(String s, int left, int right, ArrayList<String> rst){
		if (left > right || left < 0 || right < 0){
			return;
		}
		if (left == 0 && right == 0){
			rst.add(s);
			return;
		}
		helper(s + "(", left - 1, right, rst);
		helper(s + ")", left, right - 1, rst);
	}
}