public class Solution{
	public int maxDepth(TreeNode root){
		//Divide and Conquer
		//Time: O(n), Space: O(logn)
		if (root == null){
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}