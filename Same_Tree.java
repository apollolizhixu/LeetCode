public class Solution{
	public boolean isSameTree(TreeNode p, TreeNode q){
		if (p == null && q == null){
			return true;
		}
		return !(p == null || q == null) && (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	public boolean isSameTree(TreeNode p, TreeNode q){
		if (p == null && q == null){
			return true;
		}
		Queue<TreeNode> qp = new LinkedList<TreeNode>();
		Queue<TreeNode> qq = new LinkedList<TreeNode>();
		qp.offer(p);
		qq.offer(q);

		while (!qp.isEmpty() && !qq.isEmpty()){
			TreeNode tmp1 = qp.poll();
			TreeNode tmp2 = qq.poll();
			if (tmp1 == null && tmp2 == null){
				continue;
			}
			if (tmp1 == null || tmp2 == null || tmp1.val != tmp2.val){
				return false;
			}
			qp.offer(tmp1.left);
			qp.offer(tmp1.right);
			qq.offer(tmp2.left);
			qq.offer(tmp2.right);
		}
		return qp.isEmpty() && qq.isEmpty();
	}
}