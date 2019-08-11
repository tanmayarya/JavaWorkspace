package General;

import java.util.Scanner;
import java.util.Stack;

public class RajneeshInTrouble {
	static int getId(int m[][], int n) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < n; i++)
			st.push(i);

		while (st.size() > 1) {
			int a = st.pop();
			int b = st.pop();
			if (m[a][b] == 0)
				st.push(a);
			else
				st.push(b);
		}
		int a = st.pop();
		for (int i = 0; i < n; i++) {
			if (m[a][i] != 0 && i != a)
				return -1;
		}
		for (int i = 0; i < n; i++) {
			if (m[i][a] != 1 && i != a)
				return -1;
		}
		return a;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] A = new int[n][n];
		for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				A[a][b] = 1;
		}
		System.out.println(getId(A, n));
	}
}
