public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //Recursive Solution:
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
        rst.add(root.val);
        helper(root.right, rst);
    }
    
    public List<Integer> inorderTraversal1(TreeNode root) {
        //Iterative Solution:
        //Time: O(n), Space: O(n);
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.push(node.left);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    return rst;
                }
                node = stack.pop();
                rst.add(node.val);
                stack.push(node.right);
            }
        }
        return rst;
    }
}