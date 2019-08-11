package LinkedList;

import java.util.*;

import LinkedList.palindrome.Node;

public class SplitCircularLL {

	public static Node[] splitList(Node head) {
		// write your code here
		Node a[] = new Node[2];
		a[0] = head;
		if (head.next == head)
			return a;
		if(head.next.next==head)
		{
			a[1] = head.next;
			a[0].next = a[0];
			a[1].next = a[1];
			return a;
		}
		Node slow = head;
		Node fast = head;
		Node head2;
		while (fast.next.next != head) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast.next == head)
				break;
		}
		head2 = slow.next;
		slow.next = head;

		if (fast.next.next == head)
			fast.next.next = head2;
		else
			fast.next = head2;
		a[0] = head;
		a[1] = head2;
		return a;

	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int a1 = sc.nextInt();
		head1 = addLast(head1, a1);

		for (int i = 1; i < n1; i++) {
			int a = sc.nextInt();
			head1 = addLast(head1, a);
		}

		Node[] arr = splitList(head1);

		if (checkCyclic(arr[0]) && checkCyclic(arr[1])) {
			display(arr[0]);
			display(arr[1]);
		} else {
			System.out.println(-1);
		}

	}

	// Class declaration for a Node of the Linked List
	static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	static Node head1;

	static Node head2;

	static Node head3;

	/*
	 * Input Parameters: head: head of the linked list in which a new node is to be
	 * inserted. data: the data value of the node which is to be inserted.
	 * 
	 * Return Value: head of the linked list in which the node is inserted
	 */
	public static Node addLast(Node head, int data) {
		if (head == null) {
			Node nn = new Node(data, null);
			nn.next = nn;
			return nn;
		}

		Node curr = head;

		// go to tail
		while (curr.next != head) {
			curr = curr.next;
		}

		// add new node to next to tail and make new node's
		// next as head to maintain cyclic nature of linked list
		curr.next = new Node(data, head);
		return head;
	}

	public static boolean checkCyclic(Node head) {
		if (head == null) {
			return true;
		}

		Node curr = head;

		boolean result = false;
		while (curr.next != null && curr.next != head) {
			curr = curr.next;
		}
		if (curr.next == head) {
			result = true;
		}

		return result;
	}

	/*
	 * Input Parameters: head: head of the cyclic linked list in which is to be
	 * displayed.
	 * 
	 * Return Value: null
	 */
	public static void display(Node head) {

		if (head == null) {
			return;
		}

		Node curr = head;
		System.out.print(curr.data + " ");
		curr = curr.next;

		while (curr != head) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}

		System.out.println();
	}

}
