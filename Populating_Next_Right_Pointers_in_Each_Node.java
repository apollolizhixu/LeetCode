public class Solution{
	public void connect(TreeLinkNode root){
		if (root == null){
			return;
		}
		TreeLinkNode pres = root;
		TreeLinkNode next;
		while (next != null){
			pres = next;
			next = pres.left;
			while (pres != null){
				pres.left.next = pres.right;
				pres.right.next = pres.next == null ? null : pres.next.left;
				pres = pres.next;
			}
		}
	}
}