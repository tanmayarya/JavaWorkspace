package HashMap;

import java.util.*;

public class UncommonCharacters {

	public static void uncommon(String a, String b) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++)
			map.put(a.charAt(i), 0);

		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c) == 0)
					map.put(c, 2);
			} else
				map.put(c, 1);
		}

		ArrayList<Character> list = new ArrayList<Character>();
		
		map.forEach((k, v) -> {
			if (v == 1 || v == 0)
				list.add(k);
		});
	
		Collections.sort(list);
		for(char c:list)
			System.out.print(c);

	}

	// Don't make any changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();

		String str2 = sc.next();

		uncommon(str1, str2);

	}
}
