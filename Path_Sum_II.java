public class Solution{
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (root == null){
			return rst;
		}
		List<Integer> path = new ArrayList<Integer>();
		helper(rst, path, root, sum);
		return rst;
	}
	public void helper(List<List<Integer>> rst, List<Integer> path, TreeNode root, int sum){
		if (root == null){
		    return;
		}
		if (root.left == null && root.right == null){
			if (sum == root.val){
			    path.add(root.val);
				rst.add(new ArrayList<Integer>(path));
				path.remove(path.size() - 1);
			}
			return;
		}
		path.add(root.val);
		helper(rst, path, root.left, sum - root.val);
		helper(rst, path, root.right, sum - root.val);
		path.remove(path.size() - 1);
	}
}