public class Solution{
	public ArrayList<Integer> postorderTraversal1(TreeNode root){
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if (root == null){
			return rst;
		}
		rst.addAll(postorderTraversal(root.left));
		rst.add(root.val);
		rst.addAll(postorderTraversal(root.right));

		return rst;
	}
	public ArrayList<Integer> postorderTraversal(TreeNode root){
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if (root == null){
			return rst;
		}
		Stack<Integer> invert = new Stack<Integer>();
		Stack<TreeNode> output = new Stack<TreeNode>();
		output.push(root);
		while (!output.isEmpty()){
			TreeNode curr = output.pop();
			invert.push(curr.val);
			if (curr.left != null){
				output.push(curr.left);
			}
			if (curr.right != null){
				output.push(curr.right);
			}
		}
		while (!invert.isEmpty()){
			rst.add(invert.pop());
		}
		return rst;
	}
}