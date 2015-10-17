public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //Iterative BFS
        //Time: O(n), Space: O(n)
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) {
            return rst;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            rst.add(new ArrayList<Integer>(list));
        }
        Collections.reverse(rst);
        return rst;
    }
}