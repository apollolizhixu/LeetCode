public class Solution {
    //Time: O(n), Space: O(logn)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = helper(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1);
        root.right = helper(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}