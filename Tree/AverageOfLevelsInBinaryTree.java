package Tree;

import java.util.*;

public class AverageOfLevelsInBinaryTree {

	public static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		ArrayList<Double> sum = new ArrayList<Double>();

		ArrayList<TreeNode> q = new ArrayList<TreeNode>();
		q.add(root);
		q.add(null);
		int c = 0;
		double s = 0;
		while (!q.isEmpty()) {
			TreeNode r = q.remove(0);
			if (r == null) {
				if (!q.isEmpty())
					q.add(null);
				sum.add(s / c);
				c = 0;
				s = 0;
			} else {
				s += r.val;
				c++;
				if (r.left != null)
					q.add(r.left);
				if (r.right != null)
					q.add(r.right);
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().trim();

		Integer[] treeArr = inputSplitSpace(input);
		TreeNode root = createTree(treeArr);
		List<Double> res = averageOfLevels(root);
		for (Double v : res) {
			System.out.print(v + " ");
		}
		System.out.println();

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
