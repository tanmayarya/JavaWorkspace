package HashMap;

import java.util.*;

public class AllAnagramsInStrings {

	public static ArrayList<Integer> findAnagrams(String s, String p) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		int count = 0;
		HashMap<Character, Integer> fmap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> chkmap = new HashMap<Character, Integer>();

		for (int i = 0; i < p.length(); i++)
			fmap.put(p.charAt(i), fmap.getOrDefault(p.charAt(i), 0) + 1);

		for (int i = 0; i < p.length(); i++) {
			char c = s.charAt(i);

			if (chkmap.getOrDefault(c, 0) < fmap.getOrDefault(c, 0)) {
				count++;
			}
			chkmap.put(c, chkmap.getOrDefault(c, 0) + 1);
		}

		if (count == p.length())
			res.add(0);

		for (int i = 0, j = p.length(); j < s.length(); j++, i++) {
			char c = s.charAt(i);
			char n = s.charAt(j);
			if (fmap.containsKey(c)) {
				if (chkmap.get(c) <= fmap.get(c))
					count--;
			}
			if (chkmap.get(c) == 1)
				chkmap.remove(c);
			else
				chkmap.put(c, chkmap.get(c) - 1);

			if (chkmap.getOrDefault(n, 0) < fmap.getOrDefault(n, 0))
				count++;

			chkmap.put(n, chkmap.getOrDefault(n, 0) + 1);

			if (count == p.length())
				res.add(i + 1);
		}

		return res;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		System.out.println(findAnagrams(s, p));
	}
}