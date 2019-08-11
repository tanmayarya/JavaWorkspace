package StackAndQueue;

public class StackUsingArray {

	static class MyStack {
		int top;
		int arr[] = new int[1000];

		MyStack() {
			top = -1;
		}

		/*
		 * The method push to push element into the stack
		 */
		void push(int a) {
			if (top != 1000)
				arr[++top] = a;

			// Your code here
		}

		/*
		 * The method pop which return the element poped out of the stack
		 */
		int pop() {
			if (top == -1)
				return -1;
			return arr[top--];

			// Your code here
		}
	}
}