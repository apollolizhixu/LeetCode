public class Solution{
	TreeNode lastNode = null;
	public void flatten1(TreeNode root){
		if (root == null){
			return;
		}
		if (lastNode != null){
			lastNode.left = null;
			lastNode.right = root;
		}
		lastNode = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}
	public void flatten(TreeNode root){
		helper(root);
	}
	public TreeNode helper(TreeNode root){
		if (root == null){
			return null;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = null;
		root.right = null;
		TreeNode tail = root;
		if (left != null){
			tail.right = left;
			tail = helper(left);
		}
		if (right != null){
			tail.right = right;
			tail = helper(right);
		}
		return tail;
	}
}