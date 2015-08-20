public class Solution{
	public ArrayList<TreeNode> generateTrees(int n){
		return helper(1, n);
	}
	public ArrayList<TreeNode> helper(int start, int end){
		ArrayList<TreeNode> rst = new ArrayList<TreeNode>();
		if (start > end){
			rst.add(null);
			return rst;
		}
		for (int i = start; i <= end; i++){
			ArrayList<TreeNode> left = helper(start, i - 1);
			ArrayList<TreeNode> right = helper(i + 1, end);
			for (TreeNode l : left){
				for (TreeNode r : right){
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					rst.add(root);
				}
			}
		}
		return rst;
	}
}