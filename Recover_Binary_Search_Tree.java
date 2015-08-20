public class Solution{
	public void recoverTree(TreeNode root){
		TreeNode firstElement = null;
		TreeNode secondElement = null;
		TreeNode prev = null
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()){
			TreeNode present = stack.peek();
			if (present.left != null){
				stack.push(present.left);
				continue;
			} else {
				TreeNode tmp = stack.pop();
				if (stack.isEmpty()){
					return;
				}
				tmp = stack.pop();
				if (prev != null){
					if (prev.val > tmp.val){
						if (firstElement == null){
							firstElement = prev;
						} else {
							secondElement = tmp
						}
					}
				}
			}
		}
		int tmp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = tmp;
	}
}