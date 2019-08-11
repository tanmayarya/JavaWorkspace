package LinkedList;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveDuplicate {
	public static Node removeDuplicates(Node head) {
		Node p = head;
		Node c = p.next;

		HashMap<Integer, Boolean> set = new HashMap<Integer, Boolean>();
		set.put(head.data, true);

		while (c != null) {
			if (set.containsKey(c.data))
				p.next = c.next;
			else {
				p = c;
				set.put(c.data,true);
			}
			
			c = c.next;
		}
		return head;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		head = insert(head, a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			head = insert(head, a);
		}

		head = removeDuplicates(head);
		display(head);

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
