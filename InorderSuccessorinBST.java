public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //Divide and Conquer
        //Time:O(n), Space: O(logn)
        if (root == null || p == null) {
            return null;
        }
        TreeNode left = inorderSuccessor(root.left, p);
        TreeNode right = inorderSuccessor(root.right, p);
        if (root.val <= p.val) {
            return right;
        }
        if (left == null) {
            return root;
        } else {
            return left;
        }
    }

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        //Iterative DFS
        //Time:O(n), Space: O(logn)
        if (root == null || p == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        boolean flag = false;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.push(node.left);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    return null;
                }
                node = stack.pop();
                if (flag) {
                    return node;
                }
                //Attention, p might be an root node which we should return its right child, 
                //which hasn't been pushed into the stack. So we should set the flag and wait for it coming.
                if (node == p) {
                    flag = true;
                }
                stack.push(node.right);
            }
        }
        return null;
    }
}