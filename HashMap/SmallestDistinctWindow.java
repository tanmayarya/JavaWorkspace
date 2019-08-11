package HashMap;

import java.util.*;

public class SmallestDistinctWindow {

	public static int minLength(String s) {
		int len = s.length();
		HashSet<Character> set = new HashSet<Character>();
		HashMap<Character, Integer> window = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++)
			set.add(s.charAt(i));

		for (int j = 0, i = 0; j < s.length() && i < s.length();) {

			while (window.size() != set.size() && j < s.length()) {
				window.put(s.charAt(j), window.getOrDefault(s.charAt(j), 0) + 1);
				j++;
			}
			len = Math.min(len, j - i);

			while (window.size() == set.size() && i < s.length()) {
				char c = s.charAt(i);
				if (window.get(c) == 1)
					window.remove(c);
				else
					window.put(c, window.get(c) - 1);
				i++;
			}
			len = Math.min(len, j - i + 1);
		}

		return len;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(minLength(sc.next()));
	}
}