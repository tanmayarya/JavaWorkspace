package ArraysAndStrings;

import java.util.*;

public class SortCustomStrings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String S = scn.next();
		String T = scn.next();
		System.out.print(customSortString(S, T));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input two strings
	// It should return required output.

	public static String customSortString(String s, String t) {

		String res = "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++)
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				int val = map.get(c);
				for (int j = 0; j < val; j++) {
					res += c;
				}
				map.remove(c);
			}
		}
		for (int i = 0; i < 26; i++) {
			char c = (char) (i + 'a');
			if (map.containsKey(c)) {
				int val = map.get(c);
				for (int j = 0; j < val; j++) {
					res += c;
				}
				map.remove(c);
			}
		}

		return res;
	}
}
