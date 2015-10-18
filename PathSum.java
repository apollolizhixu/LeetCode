public class Solution{
	public boolean hasPathSum(TreeNode root, int sum){
		//Recursive DFS;
		//Time: O(n), Space: O(logn)
	    if (root == null){
		    return false;
		}
		if (root.left == null && root.right == null){
			return root.val == sum;
		}
		
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}