public class BSTIterator {
    //Time: O(n), Space: O(logn)
    Stack<TreeNode> stack;
    TreeNode node;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int rst = node.val;
        node = node.right;
        return rst;
    }
}
public class BSTIterator1 {
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int rst = stack.peek().val;
        TreeNode node = stack.pop().right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return rst;
    }
}