package LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class SplitLLinKparts {

	public static Node[] splitListToParts(Node head, int k) {
		// write your code here
		Node temp = head;
		int size = 0;
		Node[] a = new Node[k];
		while (temp != null) {
			size++;
			temp = temp.next;
		}

		temp = head;
		int items = size / k;
		int ext = size % k;
		int j=0;
		while (temp != null) {
			
			int count;
			if(ext<=0) {
				count = items;
			}else {
				count=items+1;
				ext--;
			}
			a[j] = temp;
			for(int i=1;i < count; i++)
			{
				temp=temp.next;
			}
			j++;
			Node end =temp;
			temp = temp.next;
			end.next = null;
		}

		return a;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int a1 = sc.nextInt();
		head1 = insert(head1, a1);

		for (int i = 1; i < n1; i++) {
			int a = sc.nextInt();
			head1 = insert(head1, a);
		}

		int k = sc.nextInt();

		Node[] arr = splitListToParts(head1, k);

		for (int i = 0; i < arr.length; i++) {
			display(arr[i]);
		}

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

	static Node head1;

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
		System.out.println();
	}

}
