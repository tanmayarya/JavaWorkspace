package LinkedList;

import java.util.Scanner;

public class SortAbsoluteLL {

	public static Node sort(Node n) {
        if(n.next == null)
        	return n;
    	Node p=n;
    	Node c = n.next;
    	while(c != null) {
    		if(c.data<0) {
    			p.next = c.next;
    			c.next = n;
    			n = c;
    			c = p.next;
    		}
    		else {
    			p = c;
    			c = c.next;
    					
    		}
    	}
    	return n;
    }
 //------------------------------------------------------------------
 
 
 
 
 
     public static void main(String args[]) {
 
         Scanner sc = new Scanner(System.in);    
             
         int n = sc.nextInt();
         int a1 = sc.nextInt();
 
         insert(a1); // inserting first node
 
         for (int i = 1; i < n; i++) {
             int a = sc.nextInt();
             insert(a);
         }
 
         head = sort(head);
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
             System.out.print(node.data+" ");
         }
     }
 
 }
