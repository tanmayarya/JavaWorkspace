package HashMap2;

import java.util.*;

public class LongestKUniqueCharactersSubstring {

	public static int countUnique(String s, int k) {
		int count = 0, length = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		int i = 0, j = 0;
		while (i < s.length() && j < s.length()) {
			char c = s.charAt(j);
			while (map.size() < k || map.containsKey(c)) {
				map.put(c, map.getOrDefault(c, 0) + 1);
				count++;
				j++;
				if (j == s.length())
					break;
				c = s.charAt(j);
			}
			length = Math.max(count, length);

			while (map.size() != k - 1) {
				c = s.charAt(i);
				if (map.get(c) == 1)
					map.remove(c);
				else
					map.put(c, map.get(c) - 1);
				i++;
				count--;
			}

		}

		return length;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		String s = scn.next();
		System.out.println(countUnique(s, k));
	}
}
