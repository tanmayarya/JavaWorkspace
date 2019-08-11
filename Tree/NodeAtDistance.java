package Tree;

import java.util.*;

public class NodeAtDistance {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	public static ArrayList<TreeNode> psf = new ArrayList<TreeNode>();
	public static int count = 0;

	// This is a functional problem. You have to complete this function.
	// It takes as input the root node of tree and K. It should return the required
	// count.
	public static int KDistantfromLeaf(TreeNode node, int k) {

		if (node == null)
			return 0;

		psf.add(node);
		if (node.left == null && node.right == null && psf.size() - 1 - k >= 0 && psf.get(psf.size() - k - 1) != null) {
			psf.set(psf.size() - 1 - k, null);
			count++;
		}
		KDistantfromLeaf(node.left, k);
		KDistantfromLeaf(node.right, k);

		psf.remove(psf.size() - 1);
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim();
		int K = sc.nextInt();
		Integer[] treeArr = inputSplitSpace(input);
		TreeNode root = createTree(treeArr);
		KDistantfromLeaf(root, K);
		System.out.println(count);
	}

	// utility function to display a binary tree.
	public static void display(TreeNode node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.val;
		str += " <= " + node.val + " => ";
		str += node.right == null ? "." : node.right.val;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	// utility function, don't change its code
	public static Integer[] inputSplitSpace(String str) {
		String[] sArr = str.split(" ");
		Integer[] arr = new Integer[sArr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
		}
		return arr;
	}

	// utility function to create a tree, don't change its code.
	public static TreeNode createTree(Integer[] arr) {
		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		TreeNode root = new TreeNode(arr[0]);
		que.addLast(root);
		int i = 1;
		while (!que.isEmpty() && i < arr.length) {
			TreeNode nn = que.removeFirst();

			if (i < arr.length && arr[i] != null) {
				TreeNode n = new TreeNode(arr[i]);
				nn.left = n;
				que.addLast(n);
			}
			i++;

			if (i < arr.length && arr[i] != null) {
				TreeNode n = new TreeNode(arr[i]);
				nn.right = n;
				que.addLast(n);
			}
			i++;
		}

		return root;
	}

}