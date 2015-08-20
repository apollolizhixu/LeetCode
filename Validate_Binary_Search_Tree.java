public class Solution{
	public boolean isValidBST(TreeNode root){
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	public boolean helper(TreeNode root, Long min, Long max){
		if (root == null){
			return true;
		}
		if (root.val <= min || root.val >= max){
			return false;
		}
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}

	public boolean isValidBST1(TreeNode root){
		if (root == null){
			return true;
		}
		TreeNode prev = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()){
			TreeNode tmp = stack.peek();
			if (tmp != null){
				stack.push(tmp.left);
			} else {
				stack.pop();
				if (stack.isEmpty()){
					return true;
				}
				tmp = stack.pop();
				if (prev != null){
					if (tmp.val <= prev.val){
						return false;
					}
				}
				prev = tmp;
				stack.push(tmp.right);
			}
		}
		return true;
	}
}
