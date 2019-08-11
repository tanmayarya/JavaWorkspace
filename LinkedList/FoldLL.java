package LinkedList;

import java.util.*;

import LinkedList.AlternateMerge2LL.Node;

public class FoldLL {

	public static Node rearrange(Node head) {
		if(head.next ==null)
			return head;
		if(head.next.next ==null)
			return head;

		Node slow = head;
		Node fast =head;
		Node head2;
		while(fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(fast.next == null)
				break;
		}
		head2 = slow.next;
		slow.next = null;
		
		
		Node p = null;
		Node c = head2;
		Node n = c.next;
		while (n != null) {

			n = c.next;
			c.next = p;
			p = c;
			c = n;
		}
		if (p != null)
			c = p;
		head2 =c;
		Node c1 = head;
		Node n1 = head.next;
		Node c2 = head2;
		Node n2 = head2.next;
		while ( n2 != null) {
			n1 = c1.next;
			n2 = c2.next;
			c1.next = c2;
			c2.next = n1;
			c1 = n1;
			c2 = n2;
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

        head = rearrange(head);
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
