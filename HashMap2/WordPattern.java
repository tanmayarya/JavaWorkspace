package HashMap2;

import java.util.*;

public class WordPattern {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String pattern = scn.nextLine();
		String str = scn.nextLine();
		System.out.println(wordPattern(pattern, str));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input 2 strings
	// It should return a boolean value

	static Boolean wordPattern(String pattern, String str) {
		String s[] = str.split(" ");
		if (pattern.length() != s.length)
			return false;
		HashMap<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < s.length; i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(s[i]))
					return false;
			} else
				map.put(c, s[i]);
		}
		return true;
	}

}
