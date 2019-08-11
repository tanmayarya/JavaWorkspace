package ArraysAndStrings;

import java.util.*;

public class RevealCardsInIncreasingOrder {

	public static int[] Reveal(int a[]) {
		int res[] = new int[a.length];
		Arrays.sort(a);
		ArrayList<Integer> q = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++)
			q.add(i);
		int j = 0;
		while (!q.isEmpty()) {
			res[q.remove(0)] = a[j];
			j++;
			if (!q.isEmpty())
				q.add(q.remove(0));
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scn.nextInt();

		int res[] = Reveal(a);
		for (int i = 0; i < n; i++)
			System.out.print(res[i] + " ");
	}
}
