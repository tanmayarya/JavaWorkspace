package HashMap;

import java.util.*;

public class FindDistinctElements {

	public static int count(int[][] a) {
		// Write your code here
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> fmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (!fmap.containsKey(a[i][j]))
					map.put(a[i][j], map.getOrDefault(a[i][j], 0) + 1);
				fmap.put(a[i][j], fmap.getOrDefault(a[i][j], 0) + 1);
			}
			fmap.clear();
		}
		int c = 0;
		for (Integer val : map.values())
			if (val == a.length)
				c++;

		return c;
	}

	// Don't make any changes here
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[][] = new int[n][n];
		int i = 0, j = 0;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				a[i][j] = in.nextInt();
			}
		}
		System.out.println(count(a));

	}

}
