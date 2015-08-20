public class Solution{
	public boolean isSymmetric(TreeNode root){
		if (root.left == null && root.right == null){
			return true;
		}
		if (root == null || root.left == null || root.right == null){
			return false;
		}
		Queue<TreeNode> left = new Queue<TreeNode>();
		Queue<TreeNode> right = new Queue<TreeNode>();
		left.offer(root.left);
		right.offer(root.right);

		while (!left.isEmpty() && !right.isEmpty()){
			TreeNode l = left.poll();
			TreeNode r = right.poll();
			if (l.val != r.val){
				return false;
			}
			left.offer(l.left);
			right.offer(r.right);
			left.offer(l.right);
			right.offer(r.left);
		}
		return left.isEmpty() && right.isEmpty();
	}
	public boolean isSymmetricRec(TreeNode root){
		if (root == null){
			return true;
		}
		return helper(root.left, root.right);
	}
	public boolean helper(TreeNode left, TreeNode right){
		if (left == null && right == null){
			return true;
		}
		if (left == null || right == null || left.val != right.val){
			return false;
		}
		return helper(left.left, right.right) && helper(left.right, right.left);
	}
}