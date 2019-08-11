package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleInMatrix {

	public static int MaxRectangleArea(int a[][]) {
		int h[] = new int[a[0].length];
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 0)
					h[j] = 0;
				else
					h[j] = h[j] + 1;
			}

			for (int j = 0; j < a.length; j++) {
				max = Math.max(max, maxRectArea(h));
			}
		}
		return max;
	}

	public static int maxRectArea(int[] ht) {
		// write your code here

		int ser[] = new int[ht.length];
		int sel[] = new int[ht.length];
		int area = 0;
		Stack<Integer> st = new Stack<Integer>();
		ser[ht.length - 1] = ht.length;
		st.push(ht.length - 1);
		for (int i = ht.length - 2; i >= 0; i--) {
			while (!st.isEmpty() && ht[i] <= ht[st.peek()])
				st.pop();
			if (st.isEmpty()) {
				ser[i] = ht.length;
			} else {
				ser[i] = st.peek();
			}
			st.push(i);
		}
		st.removeAllElements();
		sel[0] = -1;
		st.push(0);
		for (int i = 1; i < ht.length; i++) {
			while (!st.isEmpty() && ht[i] < ht[st.peek()])
				st.pop();
			if (st.isEmpty()) {
				sel[i] = -1;
			} else {
				sel[i] = st.peek();
			}
			st.push(i);
		}

		for (int i = 0; i < ht.length; i++) {
			int calValue = ht[i] * (ser[i] - sel[i] - 1);
			area = (area > calValue) ? area : calValue;
		}
		return area;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		
		int h = scn.nextInt();
		int b = scn.nextInt();
		int a[][] = new int[h][b];
		for (int i = 0; i < h; i++) {
			for(int j=0;j< b;j++)
				a[i][j] = scn.nextInt();
		}
		System.out.println(MaxRectangleArea(a));
	}
}
