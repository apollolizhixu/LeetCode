public class Solution {
    public TreeNode invertTree(TreeNode root) {
        //Divide and Conquer
        //Time: O(n), space: O(logn)
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}