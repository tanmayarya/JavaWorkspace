package LinkedList;

import java.util.*;

public class TwoLLIntersection {

	public static Node findIntersection(Node n1, Node n2) {
		HashMap<Integer, Node> map = new HashMap<>();
		HashSet<Integer> st = new HashSet<>();
		while (n1 != null) {
			st.add(n1.data);
			n1 = n1.next;
		}
		while (n2 != null) {
			if (st.contains(n2.data)) {
				map.put(n2.data, n2);
			}
			n2 = n2.next;

		}
		Node head = null;
		Node prev = null;
		for (int val : map.keySet()) {
			Node cur = map.get(val);
			if (head == null) {
				head = cur;
				prev = cur;
				cur.next = null;
			} else {
				cur.next = null;
				prev.next = cur;
				prev = cur;

			}
		}
		return insertionSortList(head);
	}

	// -----------------------------------------------------

	static Node result;

	public static Node insertionSortList(Node head) {
		result = null;
		Node cur = head;

		while (cur != null) {
			Node nt = cur.next;
			insert(cur);
			cur = nt;
		}
		return result;
	}

	public static void insert(Node add) {
		if (result == null || result.data >= add.data) {
			add.next = result;
			result = add;
		} else {
			Node cur = result;
			while (cur.next != null && cur.next.data < add.data) {
				cur = cur.next;
			}
			add.next = cur.next;
			cur.next = add;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int a1 = sc.nextInt();
		head = insert(head, a1);

		for (int i = 1; i < n1; i++) {
			int a = sc.nextInt();
			head = insert(head, a);
		}

		int n2 = sc.nextInt();
		int a2 = sc.nextInt();
		head2 = insert(head2, a2);

		for (int i = 1; i < n2; i++) {
			int a = sc.nextInt();
			head2 = insert(head2, a);
		}

		head3 = findIntersection(head, head2);
		display(head3);

	}

	// Class declaration for a Node of the Linked List
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	static Node head;

	static Node head2;

	static Node head3;

	/*
	 * Input Parameters: head: head of the linked list in which a new node is to be
	 * inserted. data: the data value of the node which is to be inserted.
	 * 
	 * Return Value: head of the linked list in which the node is inserted
	 */
	public static Node insert(Node head, int data) {

		if (head == null) {
			return new Node(data);
		}

		head.next = insert(head.next, data);
		return head;
	}

	/*
	 * Input Parameters: head: head of the linked list in which is to be displayed.
	 * 
	 * Return Value: null
	 */
	public static void display(Node head) {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

}
