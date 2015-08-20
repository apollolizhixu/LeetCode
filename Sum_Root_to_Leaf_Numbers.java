public class Solution{
	public int sumNumbers(TreeNode root){
		return helper(0, root);
	}
	public int helper(int pre, int root){
		if (root == null){
			return pre;
		}
		int sum = 10 * pre;
		return helper(sum, root.left) + helper(sum, root.right);
	}
}