public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //Recursive Solution;
        //Time: O(n), Space: O(n);
        List<Integer> rst = new ArrayList<Integer>();
        helper(root, rst);
        return rst;
    }
    public void helper(TreeNode root, List<Integer> rst) {
        if (root == null) {
            return;
        }
        rst.add(root.val);
        helper(root.left, rst);
        helper(root.right, rst);
    }
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        //Iterative Solution: (Exclude null in Stack);
        //Time: O(n), Space: O(n);
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            rst.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return rst;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        //Iterative Solution: (Include null in Stack);
        //Time: O(n), Space: O(n);
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                rst.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return rst;
    }
    public List<Integer> preorderTraversal3(TreeNode root) {
        //Divide and conquer
        //Time: O(n), Space: O(nlogn)
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        rst.add(root.val);
        rst.addAll(left);
        rst.addAll(right);
        return rst;
    }
}