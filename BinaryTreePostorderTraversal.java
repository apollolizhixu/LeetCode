public class Solution{
	public class Solution {
	    public List<Integer> postorderTraversal(TreeNode root) {
	    	//Recursive Solution
	    	//Time: O(n), Space: O(logn)
	        List<Integer> rst = new ArrayList<Integer>();
	        helper(root, rst);
	        return rst;
	    }
	    public void helper(TreeNode root, List<Integer> rst) {
	        if (root == null) {
	            return;
	        }
	        helper(root.left, rst);
	        helper(root.right, rst);
	        rst.add(root.val);
	    }
	}

	public class Solution {
	    public List<Integer> postorderTraversal1(TreeNode root) {
	    	//Divide and Conquer
	    	//Time: O(n), Space: O(logn)
	        List<Integer> rst = new ArrayList<Integer>();
	        if (root == null) {
	            return rst;
	        }
	        List<Integer> left = postorderTraversal(root.left);
	        List<Integer> right = postorderTraversal(root.right);
	        
	        rst.addAll(left);
	        rst.addAll(right);
	        rst.add(root.val);
	        return rst;
	    }
	}

	public List<Integer> postorderTraversal2(TreeNode root) {
		//Iterative Solution:
		//Time: O(n), Space: O(logn)
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            rst.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(rst);
        return rst;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
    	//Iterative Solution:
		//Time: O(n), Space: O(logn)
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                rst.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        Collections.reverse(rst);
        return rst;
    }
}