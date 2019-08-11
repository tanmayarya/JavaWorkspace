package HashMap;

import java.util.*;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		HashMap<Character, Integer> a = new HashMap<Character, Integer>();
		HashMap<Character, Integer> b = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			a.put(c, a.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = t.charAt(i);
			b.put(c, b.getOrDefault(c, 0) + 1);
		}

		return a.equals(b);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();

		if (isAnagram(s, t)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
