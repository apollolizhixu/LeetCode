public class Solution{
	//Recursive 1:
    //Time:O(n), Space: O(logn)
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;
        return isValidBST(root.right);
    }

    //Recursive 2:
    //Time:O(n), Space: O(logn)
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, min, (long)root.val) && helper(root.right, (long)root.val, max);
    }

    //Iterative :
    //Time:O(n), Space: O(logn)
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.push(node.left);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    return true;
                }
                node = stack.pop();
                if (pre != null && pre.val >= node.val) {
                    return false;
                }
                stack.push(node.right);
                pre = node;
            }
        }
        return true;
    }
}
