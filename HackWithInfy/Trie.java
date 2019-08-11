package HackWithInfy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
	private class Node {
		Character data;
		boolean isTerminal;
		HashMap<Character, Node> children;

		Node(Character data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap<>();
		}
	}

	private Node root;
	private int numWords;

	Trie() {
		this.root = new Node('\0', false);
		this.numWords = 0;
	}

	public int numWords() {
		return this.numWords;
	}

	public void addWord(String word) {
		this.addWord(this.root, word);
	}

	private void addWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				// word already existed
			} else {
				parent.isTerminal = true;
				this.numWords++;
			}

			return;
		}

		Character ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = parent.children.get(ch);

		if (child == null) {
			child = new Node(ch, false);
			parent.children.put(ch, child);
		}

		this.addWord(child, ros);
	}

	public static void main(String[] args) {

		Trie trie = new Trie();

		trie.addWord("arts");
		trie.addWord("arts");
		System.out.println(trie.numWords());

	}

}
