package StackAndQueue;

import java.util.*;

public class FunWithAstroids {

	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(asteroids[0]);
		boolean positive = st.peek() > 0;
		for (int i = 1; i < asteroids.length; i++) {
			if (isOpp(st.peek(), asteroids[i])) {
				while (!st.isEmpty() && Math.abs(asteroids[i]) > Math.abs(st.peek()))
					st.pop();
				if (st.isEmpty())
					st.push(asteroids[i]);
				else if (asteroids[i] + st.peek() == 0)
					st.pop();
			} else
				st.push(asteroids[i]);
		}
		int[] res = new int[st.size()];
		for (int i = res.length - 1; i >= 0; i--)
			res[i] = st.pop();
		return res;
	}

	public static boolean isOpp(int a, int b) {
		return (a < 0 && b > 0) || (a > 0 && b < 0);
	}

	// Dont make changes
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ast[] = new int[n];
		for (int i = 0; i < n; i++)
			ast[i] = sc.nextInt();
		int res[] = asteroidCollision(ast);
		for (int v : res) {
			System.out.println(v);
		}
	}

}