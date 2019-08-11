package StackAndQueue;

import java.util.*;

public class RotationOfCards {

	public static void cardRotation(int n) {
		int res[] = new int[n];
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++)
			a.add(i);

		int idx = 0;
		int count = 1;

		while (!a.isEmpty()) {
			idx = (idx + count) % a.size();
			res[a.remove(idx) - 1] = count;
			if (idx == a.size())
				idx = 0;
			count++;
		}

		for (int i = 0; i < n; i++)
			System.out.print(res[i] + " ");

	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cardRotation(N);
	}

}
