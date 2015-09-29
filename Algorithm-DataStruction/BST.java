package BST;

class BST {
	class Node{
		int val;
		Node left;
		Node right;
		Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;
	BST() {
		this.root = null;
	}

	public boolean contains(int val) {
		if (root == null) {
			return false;
		}
		Node curr = root;
		while (curr != null) {
			if (curr.val == val) {
				return true;
			} else if (curr.val > val) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		return false;
	}

	public Node findMin() {
		if (root == null) {
			return null;
		}
		return findMin(root);
	}
	public Node findMin(Node curr) {
		if (curr.left == null) {
			return curr;
		} else {
			return findMin(curr.left);
		}
	}

	public Node findMax() {
		if (root == null) {
			return null;
		}
		return findMax(root);
	}
	public Node findMax(Node curr) {
		if (curr.right == null) {
			return curr;
		} else {
			return findMax(curr.right);
		}
	}

	public void insert(int val) {
		root = insert(root, val);
	}
	public Node insert(Node curr, int val) {
		if (curr == null) {
			return new Node(val);
		}
		if (curr.val > val) {
			curr.left = insert(curr.left, val);
		} else if (curr.val < val) {
			curr.right = insert(curr.right, val);
		}
		return curr;
	}

	public void delete(int val) {
		root = delete(root, val);
	}
	public Node delete(Node curr, int val) {
		if (curr == null) {
			return null;
		}
		if (curr.val > val) {
			curr.left = delete(curr.left, val);
		} else if (curr.val < val) {
			curr.right = delete(curr.right, val);
		} else {
			if (curr.left == null) {
				return curr.right;
			} else if (curr.right == null) {
				return curr.left;
			} else {
				curr.val = retrieveMaxData(curr.left);
				curr.left = delete(curr.left, curr.val);
			}
		}
		return curr;
	}
	public int retrieveMaxData(Node curr) {
		if (curr.right == null) {
			return curr.val;
		} else {
			return retrieveMaxData(curr.right);
		}
	}

	public void printTree() {
		if (root == null) {
			return;
		}
		printTree(root);
	}
	public void printTree(Node curr) {
		if (curr == null) {
			return;
		}
		printTree(curr.left);
		System.out.print(curr.val + " - ");
		printTree(curr.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST b = new BST();
		b.insert(1);
		b.insert(2);
		b.insert(3);
		b.insert(4);
		b.insert(5);
		b.insert(6);
		b.insert(7);
		b.delete(8);
		System.out.println(b.contains(8));
		System.out.println(b.findMin().val);
		System.out.println(b.findMax().val);
		b.printTree();
	}
}