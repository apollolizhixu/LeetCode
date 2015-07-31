public class Solution{
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (root == null){
			return rst;
		}
<<<<<<< HEAD
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
=======
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
>>>>>>> 11d13433d43376792150d4d72cb82a2bc67e2149
