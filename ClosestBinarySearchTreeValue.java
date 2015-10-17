public class Solution {
    public int closestValue(TreeNode root, double target) {
    	//Time: O(logn), Space: O(1)
        if (root == null) {
            return 0;
        }
        TreeNode min = null;
        TreeNode node = root;
        while (node != null) {
            double diff = Math.abs(target - (double)node.val);
            if (diff == 0) {
                return node.val;
            }
            if (min == null || Math.abs(target - (double)min.val) > Math.abs(target - (double)node.val)) {
                min = node;
            }
            if (target < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return min.val;
    }
}