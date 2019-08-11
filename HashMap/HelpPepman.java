package HashMap;

import java.util.*;
import java.util.Map.Entry;

public class HelpPepman {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int ce = 0;
		int co = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++)
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

		for (Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() % 2 == 1 && e.getKey() % 2 == 1)
				co++;
			else if (e.getValue() % 2 == 0 && e.getKey() % 2 == 0)
				ce++;
		}

		if ((ce + co) % 2 == 1)
			System.out.println("ODD");
		else
			System.out.println("EVEN");
	}
}
