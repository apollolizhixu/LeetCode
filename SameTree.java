public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	//Recursive
    	//Time: O(n), Space: O(logn)
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
    	//Iterative BFS
    	//Time: O(n), Space: O(n) Last layer contains 2^(logn - 1) = n / 2 leaves, so it's O(n)
        Queue<TreeNode> qp = new LinkedList<TreeNode>();
        Queue<TreeNode> qq = new LinkedList<TreeNode>();
        qp.offer(p);
        qq.offer(q);
        while (!qp.isEmpty() && !qq.isEmpty()) {
            TreeNode currP = qp.poll();
            TreeNode currQ = qq.poll();
            if (currP == null && currQ == null) {
                continue;
            }
            if (currP == null || currQ == null || currP.val != currQ.val) {
                return false;
            }
            qp.offer(currP.left);
            qp.offer(currP.right);
            qq.offer(currQ.left);
            qq.offer(currQ.right);
        }
        return qp.isEmpty() && qq.isEmpty();
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	//Iterative DFS
    	//Time: O(n), Space: O(logn)
        Stack<TreeNode> stackP = new Stack<TreeNode>();
        Stack<TreeNode> stackQ = new Stack<TreeNode>();
        stackP.push(p);
        stackQ.push(q);
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode nP = stackP.pop();
            TreeNode nQ = stackQ.pop();
            if (nP == null && nQ == null) {
                continue;
            }
            if (nP == null || nQ == null || nP.val != nQ.val) {
                return false;
            }
            stackP.push(nP.right);
            stackP.push(nP.left);
            stackQ.push(nQ.right);
            stackQ.push(nQ.left);
        }
        return stackP.isEmpty() && stackQ.isEmpty();
    }
}