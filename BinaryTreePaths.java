public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        //Recursive DFS
        //Time: O(n), Space: O(n)
        List<String> rst = new ArrayList<String>();
        if (root == null) {
            return rst;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        helper(root, rst, list);
        return rst;
    }
    public void helper(TreeNode root, List<String> rst, List<TreeNode> list) {
        if (root.left == null && root.right == null) {
            build(root, rst, list);
            return;
        }
        list.add(root);
        if (root.left != null) {
            helper(root.left, rst, list);
        }
        if (root.right != null) {
            helper(root.right, rst, list);
        }
        list.remove(list.size() - 1);
    }
    public void build(TreeNode root, List<String> rst, List<TreeNode> list) {
        StringBuilder sb = new StringBuilder();
        for (TreeNode node : list) {
            sb.append(node.val + "->");
        }
        sb.append(root.val);
        rst.add(sb.toString());
    }
}