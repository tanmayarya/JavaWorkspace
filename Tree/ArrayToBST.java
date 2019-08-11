package Tree;

import java.util.*;

import Tree.AncestorsInBinaryTree.TreeNode;

public class ArrayToBST {

	public static class Node {

		int val;
		Node left;
		Node right;

		Node(int x) {
			val = x;
		}
	}

	public static void preoder(Node n) {
		if (n == null)
			return;
		System.out.print(n.val + " ");
		preoder(n.left);
		preoder(n.right);

	}

	public static Node construct(int a[], int l, int h) {

		if (l > h)
			return null;

		int m = (l + h) / 2;
		Node n = new Node(a[m]);
		n.left = construct(a, l, m - 1);
		n.right = construct(a, m + 1, h);

		return n;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		preoder(construct(arr, 0, arr.length - 1));
	}

}