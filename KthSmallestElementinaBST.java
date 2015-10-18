public class Solution {
    //Recursive DFS 1
    //Time: O(n), Space: O(logn)
    int rst;
    int num = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        helper(root, k);
        return rst;
    }
    public void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        helper(root.left, k);
        num++;
        if (num == k) {
            rst = root.val;
            return;
        }
        helper(root.right, k);
    }

    //Recursive DFS 2
    //Time: O(n), Space: O(logn)
    int rst;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        helper(root, k);
        return rst;
    }
    public int helper(TreeNode root, int k) {
        //the return value means how many nodes in current subtree;
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, k);
        if (k == left + 1) {
            rst = root.val;
        }
        int right = helper(root.right, k - left - 1);
        return left + 1 + right;
}

    //Recursive DFS 3
    //Time: O(n), Space: O(logn)
    int rst;
    public int kthSmallest3(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        helper(root, 0, k);
        return rst;
    }
    public int helper(TreeNode root, int preNum, int k) {
        //the return value means how many nodes totally have been scanned;
        int left = preNum;
        if (root.left != null) {
            left = helper(root.left, preNum, k);
        }
        if (k == left + 1) {
            rst = root.val;
        }
        int right = left + 1;
        if (root.right != null) {
            right = helper(root.right, left + 1, k);
        }
        return right;
    }
}