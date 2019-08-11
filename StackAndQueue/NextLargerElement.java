package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class NextLargerElement {

	static void printNGE(int arr[], int n) {
		int res[] = new int[arr.length];
		res[arr.length - 1] = -1;
		Stack<Integer> st = new Stack<Integer>();
		st.push(arr[arr.length - 1]);

		for (int i = arr.length - 2; i >= 0; i--) {
			
			while (!st.isEmpty() && arr[i] >= st.peek())
				st.pop();
			
			if(st.isEmpty())
				res[i]=-1;
			else
				res[i] = st.peek();
			st.push(arr[i]);
		}
		
		for(int i =0; i<res.length;i++)
			System.out.println(res[i]);
	}

	static class stack {
		int top;
		int items[] = new int[100];

		// Stack functions to be used by printNGE
		void push(int x) {
			if (top == 99) {
				System.out.println("Stack full");
			} else {
				items[++top] = x;
			}
		}

		int pop() {
			if (top == -1) {
				System.out.println("Underflow error");
				return -1;
			} else {
				int element = items[top];
				top--;
				return element;
			}
		}

		boolean isEmpty() {
			return (top == -1) ? true : false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		printNGE(arr, n);
	}
}
