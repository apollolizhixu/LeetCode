public class Solution {
    public List<TreeNode> generateTrees(int n) {
        //Time: O(), Space: O(n)
        return helper(1, n);
    }
    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> rst = new ArrayList<TreeNode>();
        if (start > end) {
            rst.add(null);
            return rst;
        }
        for (int i = start; i <= end; i++) {
            
            List<TreeNode> l = helper(start, i - 1);
            List<TreeNode> r = helper(i + 1, end);
            for (TreeNode left : l) {
                for (TreeNode right : r) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    rst.add(root);
                }
            }
        }
        return rst;
    }
}