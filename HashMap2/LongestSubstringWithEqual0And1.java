package HashMap2;

import java.util.*;

public class LongestSubstringWithEqual0And1 {

	public static void print(char[] A) {
		int a[] = new int[A.length];
		for (int i = 0; i < a.length; i++) {
			if (A[i] == '0')
				a[i] = -1;
			else
				a[i] = 1;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int length = 0, sum = 0;
		map.put(0, -1);
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (map.containsKey(sum)) {
				

			} else
				map.put(sum, i);
			length = Math.max(length, i - map.get(sum));
		}
		System.out.println(length);
	}

	// Don't make any changes here.
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str = s.next();
		char[] ans = str.toCharArray();
		print(ans);
	}

}