package HashMap2;

import java.util.*;

public class LongestPalindrome {

	public static int longestPalindrome(String s) {
		int count = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		boolean odd = false;
		for (int f : map.values()) {
			if (f % 2 == 1 && !odd)
				odd = true;
			count += (f / 2) * 2;
		}
		if (odd)
			count++;

		return count;
	}

	// Don't make any changes here.
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(longestPalindrome(str));

	}

}
