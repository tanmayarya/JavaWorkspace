package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class MaxRectangleAreaInHistogram {

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
		int height[] = new int[h];
		for (int i = 0; i < h; i++) {
			height[i] = scn.nextInt();
		}
		System.out.println(maxRectArea(height));
	}
}
