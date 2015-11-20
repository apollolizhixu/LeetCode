public class Solution {
    int num;
    public int countUnivalSubtrees(TreeNode root) {
        num = 0;
        helper(root);
        return num;
    }
    public boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (!left || !right) {
            return false;
        }
        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        num++;
        return true;
    }
}