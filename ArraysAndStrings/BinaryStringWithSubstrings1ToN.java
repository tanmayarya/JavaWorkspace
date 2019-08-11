package ArraysAndStrings;

import java.util.*;

public class BinaryStringWithSubstrings1ToN {

	public static boolean queryString(String s, int n) {
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = n / 2; i <= n; i++)
			set.add(i);
		int val = 0;
		for (int i = 0, j = 0; i < s.length() && j < s.length();) {

			while (val <= n && j < s.length()) {
				val = val * 2 + Integer.parseInt(s.charAt(j) + "");
				j++;
				set.remove(val);
			}
			while (val > n && i < j) {
				val = val - (int) (Integer.parseInt("" + s.charAt(i)) * Math.pow(2, j - i - 1));
				i++;
				set.remove(val);
			}
		}

		return set.isEmpty();
	}

	// Don't make any changes here.
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String str = s.next();
		System.out.println(queryString(str, n));

	}

}