package HashMap;

import java.util.*;

public class IncompleteArray {

	public static int incomplete(int[] a) {

		HashSet<Integer> set = new HashSet<Integer>();
		int min = a[0], max = a[0];
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
			max = Math.max(max, a[i]);
			min = Math.min(min, a[i]);
		}
		int count = 0;
		for (int i = min; i <= max; i++)
			if (!set.contains(i))
				count++;

		return count;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(incomplete(arr));
	}
}