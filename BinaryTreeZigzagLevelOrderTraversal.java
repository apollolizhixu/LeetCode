public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //BST: Time: O(n), Space: O(n);
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        currLevel.push(root);
        boolean order = false;
        while (!currLevel.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                list.add(node.val);
                if (!order) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }
            rst.add(new ArrayList<Integer>(list));
            order = !order;
            Stack<TreeNode> tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
        }
        return rst;
    }
}