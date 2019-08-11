package LinkedList;

import java.util.Scanner;

public class ZigZagLL {

	public static void fashion(Node head) {
		// write your code here
		if (head.next == null)
			return;
		Node p = head;
		Node c = head.next;
		boolean greaterFlag = true;
		while (c != null) {
			if (greaterFlag) {
				if (p.data > c.data) {
					int temp = p.data;
					p.data = c.data;
					c.data = temp;
				}
			} else {
				if (p.data < c.data) {
					int temp = p.data;
					p.data = c.data;
					c.data = temp;
				}
			}
			p = c;
			c = c.next;
			greaterFlag = !greaterFlag;
		}

	}
 
     public static void main(String args[]) {
         Scanner sc = new Scanner(System.in);
 
         int n = sc.nextInt();
         int a1 = sc.nextInt();
         insert(a1);
 
         for (int i = 1; i < n; i++) {
             int a = sc.nextInt();
             insert(a);
         }
 
         fashion(head);
         display();
 
 
     }
 
     private static class Node {
         int data;
         Node next;
 
         public Node(int data, Node next) {
             this.data = data;
             this.next = next;
         }
 
     }
 
     static Node head;
     static Node tail;
     static int size;
 
     public static void insert(int data) {
 
         Node nn = new Node(data, null);
         if (head == null) {
             head = nn;
             tail = nn;
         } else {
             tail.next = nn;
             tail = nn;
         }
         size++;
     }
 
     public static void display() {
         for (Node node = head; node != null; node = node.next) {
             System.out.print(node.data + " ");
         }
     }
 
 }
