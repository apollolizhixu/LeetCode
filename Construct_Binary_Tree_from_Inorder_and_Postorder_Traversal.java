public class Solution{
	public TreeNode buildTree(int[] inorder, int[] postorder){
		if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0){
			return null;
		}
		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}
	public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
	    if (inStart > inEnd){
	        return null;
	    }
		TreeNode root = new TreeNode(postorder[postEnd]);
		int pos = findPosition(inorder, root.val);
		root.left = helper(inorder, inStart, pos - 1, postorder, postStart, postStart + pos - inStart - 1);
		root.right = helper(inorder, pos + 1, inEnd, postorder, postStart + pos - inStart, postEnd - 1);
		return root;
	}
	public int findPosition(int[] order, int target){
		for (int i = 0; i < order.length; i++){
			if (order[i] == target){
				return i;
			}
		}
		return 0;
	}
}