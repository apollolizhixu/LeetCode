import java.util.HashMap;
import java.util.Map;

public class Trie {
	private TrieNode root;

	class TrieNode {
		public boolean terminable;
		public int count;
		public Map<Character, TrieNode> children;

		public TrieNode() {
			terminable = false;
			count = 0;
			children = new HashMap<Character, TrieNode>();
		}
	}

	public Trie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode curr = root;
		word = word.trim();
		for (int i = 0; i < word.length(); i++) {
			char c = Character.toLowerCase(word.charAt(i));
			if (!curr.children.containsKey(c)) {
				curr.children.put(c, new TrieNode());
			}
			curr = curr.children.get(c);
		}
		curr.count++;
		curr.terminable = true;
	}

	public boolean find(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = Character.toLowerCase(word.charAt(i));
			if (!curr.children.containsKey(c)) {
				return false;
			}
			curr = curr.children.get(c);
		}
		return curr.terminable;
	}
	public void delete(String word) {
		if (word == null || !find(word)) {
			return;
		}
		delete(root, word);
	}
	public boolean delete(TrieNode curr, String word) {
		//boolean variable means if current node can be removed
		if (word.length() == 0) {
			curr.terminable = false;
			return curr.children.isEmpty();
		}

		if (delete(curr.children.get(word.charAt(0)), word.substring(1))) {
			curr.children.remove(word.charAt(0));
			return curr.children.isEmpty() && !curr.terminable;
		}
		return false;
	}

	public void traverse() {
		if (root == null) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		traverse(root, sb);
	}
	public void traverse(TrieNode curr, StringBuilder sb) {
		if (curr.terminable) {
			System.out.println(sb.toString());
			if (curr.children.isEmpty()) {
				return;
			}
		}
		for (char c : curr.children.keySet()) {
			sb.append(c);
			traverse(curr.children.get(c), sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("China");
		trie.insert("  China ");
		trie.insert("China   ");
		
		trie.insert("crawl");
	    trie.insert("crime");
	    trie.insert("ban");
		trie.insert("China");
		
		trie.insert("english");
	    trie.insert("establish");
	    trie.insert("eat");
	    trie.traverse();
	    System.out.println(" ");
	    trie.delete("crime");
	    trie.traverse();
	}
}