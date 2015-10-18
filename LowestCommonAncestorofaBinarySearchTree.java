public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Divide and Conquer
        //Time: O(n), Space: O(logn)
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
             return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }
    public class Solution {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //Eliminate some cases which definitely don't contain p & q based on BST's property
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return helper(root, p, q);
        }
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        //Divide and Conquer
        //Time: O(n), Space: O(logn)
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (left == null && right == null) {
             return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }
}
}