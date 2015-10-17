public class Solution {
    public boolean isSymmetric(TreeNode root) {
    	//Recursive DFS
    	//Time: O(n), Space: O(logn)
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
             return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetric1(TreeNode root) {
    	//Iterative DFS
    	//Time: O(n), Space: O(logn)
        if (root == null) {
            return true;
        }
        Stack<TreeNode> left = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();
        left.push(root.left);
        right.push(root.right);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.pop();
            TreeNode r  = right.pop();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null || l.val != r.val) {
                return false;
            }
            left.push(l.left);
            left.push(l.right);
            right.push(r.right);
            right.push(r.left);
        }
        return left.isEmpty() && right.isEmpty();
    }

    public boolean isSymmetric2(TreeNode root) {
    	//Iterative BFS
    	//Time: O(n), Space: O(n)
        if (root == null) {
            return true;
        }
        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
        left.offer(root.left);
        right.offer(root.right);
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode l = left.poll();
            TreeNode r  = right.poll();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null || l.val != r.val) {
                return false;
            }
            left.offer(l.left);
            left.offer(l.right);
            right.offer(r.right);
            right.offer(r.left);
        }
        return left.isEmpty() && right.isEmpty();
    }
}