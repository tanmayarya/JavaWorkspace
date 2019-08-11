package ip_Test3;

import java.awt.Window;
import java.util.HashMap;
import java.util.Scanner;

public class SmallestWindowAllCharacters {

	public static String smallestWindow(String s, String r) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		HashMap<Character, Integer> set = new HashMap<Character, Integer>();

		for (int i = 0; i < r.length(); i++) {
			char c = r.charAt(i);
			set.put(c, set.getOrDefault(c, 0) + 1);
		}
		int count = 0, j = 0, min = Integer.MAX_VALUE, start = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.containsKey(c)) {
				if (map.getOrDefault(c, 0) < set.get(c))
					count++;
			}
			map.put(c, map.getOrDefault(c, 0) + 1);

			if (count == set.size()) {
				c = s.charAt(j);
				while (map.getOrDefault(c, 0) > set.getOrDefault(c, 0)) {
					if (map.get(c) == 1)
						map.remove(c);
					else
						map.put(c, map.getOrDefault(c, 0) - 1);
					j++;
					c = s.charAt(j);
				}
				int win_len = i - j + 1;
				if (min > win_len) {
					min = win_len;
					start = j;
				}
			}
		}
		if (start == -1)
			return "-1";

		return s.substring(start, start + min);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String r = scn.next();

		System.out.println(smallestWindow(s, r));
	}
}
