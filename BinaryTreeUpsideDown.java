public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //Recursive
        //Time: O(logn), Space: O(logn)
        return helper(root, null);
    }
    public TreeNode helper(TreeNode root, TreeNode parent) {
        if (root == null) {
            return parent;
        }
        TreeNode left = helper(root.left, root);
        root.right = parent;
        root.left = parent == null? null : parent.right;
        return left;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //Iterative 1 using Stack;
        //Time: O(logn), Space: O(logn)
        if (root == null) {
            return null;
        }
        TreeNode newRoot = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        newRoot = stack.peek();
        node = stack.pop();
        while (!stack.isEmpty()) {
            node.right = stack.peek();
            node.left = stack.peek() == null ? null : stack.peek().right;
            node = stack.pop();
        }
        return newRoot;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //Iterative 2
        //Time: O(logn), Space: O(1)
        if (root == null) {
            return null;
        }
        TreeNode p = root;
        TreeNode parent = null;
        TreeNode parentRight = null;
        while (p != null) {
            TreeNode left = p.left;
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;
            parent = p;
            p = left;
        }
        return parent;
    }
}