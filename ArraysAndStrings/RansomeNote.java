package ArraysAndStrings;

import java.util.*;

public class RansomeNote {

	public static boolean canConstruct(String rans, String magazine) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < magazine.length(); i++) {
			map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
		}

		for (int i = 0; i < rans.length(); i++) {
			char c = rans.charAt(i);

			if (!map.containsKey(c))
				return false;

			int val = map.get(c);
			if (val == 1)
				map.remove(c);
			else
				map.put(c, val - 1);

		}

		return true;
	}

	// Don't make any changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String t = scn.next();
		System.out.print(canConstruct(s, t));

	}

}
