package LinkedList;

import java.util.Scanner;

public class ModularNode {

	public static int moduarNode(Node head, int k) {
		int size =0;
		
		Node temp = head;
		while(temp!=null) {
			size++;
			temp=temp.next;
		}
		if(k>size)
			return -1;
		int idxTobeReturned= size - (size%k);
		
		int count =0;
		temp = head;
		while(temp!=null) {
			count++;
			if(count == idxTobeReturned)
				return temp.data;
			temp=temp.next;
		}
		return 0;
		
    }
    // -----------------------------------------------------

    static Node head1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int a1 = sc.nextInt();

        Node tail;
        head1 = tail = insert(null, a1);

        for (int i = 1; i < n1; i++) {
            int a = sc.nextInt();
            tail = insert(tail, a);
        }

        int k = sc.nextInt();

        System.out.println(moduarNode(head1, k));

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

    /*
     * Input Parameters: tail: tail of the linked list in which a new node is to
     * be inserted. data: the data value of the node which is to be inserted.
     * 
     * Return Value: tail of the linked list/the node that is inserted
     */
    public static Node insert(Node tail, int data) {

        if (tail == null) {
            return new Node(data);
        }

        Node nn = new Node(data);
        tail.next = nn;
        return nn;
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
