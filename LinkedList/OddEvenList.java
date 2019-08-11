package LinkedList;

import java.util.Scanner;

public class OddEvenList {

	public static Node oddEvenList(Node head) {
        // write your code here
		if(head.next ==null)
			return head;
		if(head.next.next == null)
			return head;
		
		boolean isOdd =true;
		Node oddHead = head;
		Node oddTail = head;
		Node evenHead = head.next;
		Node evenTail = evenHead;
		
		while(evenTail !=null && oddTail!=null) {
			if(isOdd)
			{
				if(evenTail.next == null)
					break;
				
				oddTail.next = evenTail.next;
				oddTail = oddTail.next;
			}
			else {
				evenTail.next = oddTail.next;
				evenTail = evenTail.next;
			}
			isOdd =!isOdd;
		}
		oddTail.next = evenHead;
		return head;
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
 
         head1 = oddEvenList(head1);
         display(head1);
 
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
      * Input Parameters: head: head of the linked list in which a new node is to
      * be inserted. data: the data value of the node which is to be inserted.
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
      * Input Parameters: head: head of the linked list in which is to be
      * displayed.
      * 
      * Return Value: null
      */
     public static void display(Node head) {
         for (Node node = head; node != null; node = node.next) {
             System.out.print(node.data + " ");
         }
     }
 
 }
