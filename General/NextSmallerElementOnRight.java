package General;

import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElementOnRight {

	public static void nextSmallerElement(int arr[]) {
		int res[] = new int[arr.length];
		res[arr.length - 1] = -1;
		Stack<Integer> st = new Stack<Integer>();
		st.push(arr[arr.length - 1]);

		for (int i = arr.length - 2; i >= 0; i--) {

			while (!st.isEmpty() && arr[i] < st.peek())
				st.pop();

			if (st.isEmpty())
				res[i] = -1;
			else
				res[i] = st.peek();
			st.push(arr[i]);
		}
		for(int i =0; i<res.length;i++)
			System.out.println(res[i]);

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		nextSmallerElement(arr);
	}
}
