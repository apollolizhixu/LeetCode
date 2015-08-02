public class Solution{
	public void connect(TreeLinkNode root){
		if (root == null){
			return;
		}
		TreeLinkNode parent = root;
		TreeLinkNode prev;
		TreeLinkNode next;
		while (parent != null){
			prev = null;
			next = null;
			wihle (parent != null){
				if (parent.left != null){
					if (next == null){
						next = parent.left;
					}
					if (prev != null){
						prev.next = parent.left;
					}
					prev = prev.next;
				}
				if (paret.right != null){
					if (next == null){
						next = parent.right;
					}
					if (prev != null){
						prev.next = parent.right;
					}
					prev = prev.next;
				}
				parent = parent.next;
			}
			parent = next;
		}
	}
}