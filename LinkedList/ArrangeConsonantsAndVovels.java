package LinkedList;

import java.util.Scanner;

public class ArrangeConsonantsAndVovels {

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
            
        int n = sc.nextInt();
        char h = sc.next().charAt(0);
        insert(h);

        for (int i = 1; i < n; i++) {
            char ch = sc.next().charAt(0);
            insert(ch);
        }
        
        head = arcv(head);
        display();
        
    }

    //---------------------------------------------------------------
    //This is a functional problem. Only this function has to be written.
    // This function returns the head of node after sorting.
    public static Node arcv(Node head) {
        Node vhead = null;
        Node prevv = null;
        Node prevc = null;
        Node chead = null;

        Node n = head;

        while (n != null) {

            if (n.data == 'a' || n.data == 'e' || n.data == 'i' || n.data == 'o' || n.data == 'u') {
                if (vhead == null) {

                    vhead = n;
                    prevv = vhead;

                } else {
                    prevv.next = n;
                    prevv = n;
                }
            } else {
                if (chead == null) {

                    chead = n;
                    prevc = chead;
                } else {
                    prevc.next = n;
                    prevc = n;
                }
            }
            Node next = n.next;
            n.next = null;
            n = next;
        }
        if (vhead != null) {
            prevv.next = chead;
            return vhead;
        } else {
            return chead;
        }
    }
//------------------------------------------------------------------

    
    private static class Node {
        char data;
        Node next;

        public Node(char data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    static Node head;
    static Node tail;
    static int size;

    public static void insert(char data) {

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