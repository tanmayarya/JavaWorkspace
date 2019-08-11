package ArraysAndStrings;

import java.util.*;

public class nestingArray {

	public static int MaxSet(int a[]) {
		int count = 0, max = 0;

		boolean visited[] = new boolean[a.length];

		for (int i = 0; i < a.length; i++) {
			int toVisit = i;
			if (!visited[i]) {
				while (toVisit < a.length && !visited[toVisit]) {
					visited[toVisit] = true;
					toVisit = a[toVisit];
					count++;
				}
				max = Math.max(count, max);
				count = 0;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
		}
		System.out.println(MaxSet(a));
	}
}
