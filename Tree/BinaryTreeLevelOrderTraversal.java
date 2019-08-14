package Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// This is a functional problem. You have to complete this function.
	// It takes as input the root of the given tree. It should return the
	// level order traversal as an arraylist of arraylist.
	public static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode node) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		ArrayList<TreeNode> cq = new ArrayList<TreeNode>();
		ArrayList<TreeNode> nq = new ArrayList<TreeNode>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		cq.add(node);

		while (!cq.isEmpty()) {
			TreeNode n = cq.remove(0);
			list.add(n.val);

			if (n.left != null)
				nq.add(n.left);
			if (n.right != null)
				nq.add(n.right);
			
			if(cq.isEmpty()) {
				cq = nq;
				nq = new ArrayList<TreeNode>();
				res.add(list);
				list = new ArrayList<Integer>();
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// length of array representing the tree
		int len = sc.nextInt();

		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		TreeNode root = levelOrder(arr);

		ArrayList<ArrayList<Integer>> res = levelOrderTraversal(root);

		for (ArrayList<Integer> list : res) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

	// utility function to display a binary tree
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

	// creation of tree from array by level order, -1 says there is no node
	public static TreeNode levelOrder(int[] arr) {

		TreeNode[] nodes = new TreeNode[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new TreeNode(arr[i]);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}

		TreeNode root = nodes[0];
		return root;
	}

}
