package HashMap;

import java.util.*;

public class SmallerOnLeft {

	public static int[] greatestSmaller(int[] arr) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		int[] res = new int[arr.length];
		res[0] = -1;
		for (int j = 1; j < arr.length; j++) {
			ts.add(arr[j - 1]);
			if (ts.lower(arr[j]) == null)
				res[j] = -1;
			else {
				res[j] = ts.lower(arr[j]);
			}
		}
		return res;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		for (int val : greatestSmaller(arr))
			System.out.print(val + " ");
	}
}