public class Solution{
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (root == null){
			return rst;
		}
		List<Integer> list = new ArrayList<Integer>();
		helper(root, sum, rst, list);
		return rst;
	}
	public void helper(TreeNode root, int sum, List<List<Integer>> rst, List<Integer> list){
		if (root == null){//Avoid NullPointer exception when a node only have one child;
			return;
		}
		if (root.left == null && root.right == null){//Judge when get to the leaf node;
		    if (root.val == sum){
		        list.add(root.val);
		        rst.add(new ArrayList<Integer>(list));
		        list.remove(list.size() - 1);
		    }
		    return;
		}
		list.add(root.val);
		helper(root.left, sum - root.val, rst, list);
		helper(root.right, sum - root.val, rst, list);
		list.remove(list.size() - 1);
	}
}
