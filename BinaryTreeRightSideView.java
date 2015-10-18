public class Solution {
    //Recursive DFS
    //Time: O(n), Space: O(logn)
    int maxLevel;
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        maxLevel = 0;
        helper(root, rst, 1);
        return rst;
    }
    public void helper(TreeNode root, List<Integer> rst, int currLevel) {
        if (root == null) {
            return;
        }
        if (currLevel > maxLevel) {
            rst.add(root.val);
            maxLevel = currLevel;
        }
        helper(root.right, rst, currLevel + 1);
        helper(root.left, rst, currLevel + 1);
    }

        public List<Integer> rightSideView1(TreeNode root) {
        //Iterative BFS
        //Time: O(n), Space: O(n)
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            boolean first = true;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (first) {
                    rst.add(node.val);
                    first = false;
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
            }
        }
        return rst;
    }
}