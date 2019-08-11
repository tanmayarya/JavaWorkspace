package LinkedList;

import java.util.Scanner;

public class AddPolynomials {
	static class Node {
		int coeff;
		int pow;
		Node next;

		Node(int a, int b) {
			coeff = a;
			pow = b;
			next = null;
		}

	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input the head of two linked lists representing
	// two polynomial numbers.
	// Print the polynomial formed by adding both LL in the function itself.

	public static void addPolynomial(Node poly1, Node poly2) {
		// write your code here
		// Print the polynomial formed by adding both LL in the function itself.
		Node a = poly1;
		Node b = poly2;
		Node res = new Node(0, 0);
		Node resHead = res;

		while (a != null && b != null) {
//        	res
			if (a.pow == b.pow) {
				res.pow = a.pow;
				res.coeff = a.coeff + b.coeff;
				a = a.next;
				b = b.next;
			} else if (a.pow > b.pow) {
				res.pow = a.pow;
				res.coeff = a.coeff;
				a = a.next;

			} else {
				res.pow = b.pow;
				res.coeff = b.coeff;
				b = b.next;
			}
			if (a != null && b != null) {
				res.next = new Node(0, 0);
				res = res.next;
			}
		}
		if (a == null) {
			res.next = b;
		} else
			res.next = a;
		
		res=resHead;
		while(res!=null) {
			System.out.print(res.coeff + "x^" +res.pow);
			if(res.next!=null)
				System.out.print(" + ");
			res=res.next;
		}

	}
	
	//

	// -----------------------------------------------------

	static Node head;

	static Node head2;

	static Node head3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		head = insert(head, a1, b1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			head = insert(head, a, b);
		}

		int n2 = sc.nextInt();
		int a2 = sc.nextInt();
		int b2 = sc.nextInt();
		head2 = insert(head2, a2, b2);

		for (int i = 1; i < n2; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			head2 = insert(head2, a, b);
		}

		addPolynomial(head, head2);
	}

	/*
	 * Input Parameters: head: head of the linked list in which a new node is to be
	 * inserted. data: the data value of the node which is to be inserted.
	 * 
	 * Return Value: head of the linked list in which the node is inserted
	 */
	public static Node insert(Node head, int a, int b) {

		if (head == null) {
			return new Node(a, b);
		}

		head.next = insert(head.next, a, b);

		return head;
	}

	/*
	 * Input Parameters: head: head of the linked list in which is to be displayed.
	 * 
	 * Return Value: null
	 */
	public static void display(Node head) {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.coeff + "x^" + node.pow + " ");
		}
	}
}
