package General;

import java.lang.reflect.Array;
import java.util.Scanner;

public class SwapKFromBegningAndEnd {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void swap(int a[], int size, int k) {
//		Node c1 = head;
//		Node c2 = head;
//		for (int i = 1; i < k; i++) {
//			c1 = c1.next;
//		}
//		for (int i = 0; i < size - k; i++) {
//			c2 = c2.next;
//		}
//		int t = c1.data;
//		c1.data = c2.data;
//		c2.data = t;
//
//		c1 = head;
//		while (c1 != null) {
//			System.out.println(c1.data);
//			c1 = c1.next;
//		}

		int t = a[k - 1];
		a[k - 1] = a[size - k];
		a[size - k] = t;
		
		for(int i=0;i<size;i++)
			System.out.print(a[i]+" ");
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();

		}
		swap(a, n, k);
	}
}
