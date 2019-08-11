package HashMap;

import java.util.*;

public class KeyBoardRow {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < n; i++)
			words[i] = scn.next();
		String[] res = findWords(words);
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array of string.
	// It should return an array of suitable strings.

	public static String[] findWords(String[] words) {
		ArrayList<String> list = new ArrayList<String>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		map.put('q', 1);
		map.put('w', 1);
		map.put('e', 1);
		map.put('r', 1);
		map.put('t', 1);
		map.put('y', 1);
		map.put('u', 1);
		map.put('i', 1);
		map.put('o', 1);
		map.put('p', 1);

		map.put('a', 2);
		map.put('s', 2);
		map.put('d', 2);
		map.put('f', 2);
		map.put('g', 2);
		map.put('h', 2);
		map.put('j', 2);
		map.put('k', 2);
		map.put('l', 2);

		map.put('z', 3);
		map.put('x', 3);
		map.put('c', 3);
		map.put('v', 3);
		map.put('b', 3);
		map.put('n', 3);
		map.put('m', 3);

		map.put('Q', 1);
		map.put('W', 1);
		map.put('E', 1);
		map.put('R', 1);
		map.put('T', 1);
		map.put('Y', 1);
		map.put('U', 1);
		map.put('I', 1);
		map.put('O', 1);
		map.put('P', 1);

		map.put('A', 2);
		map.put('S', 2);
		map.put('D', 2);
		map.put('F', 2);
		map.put('G', 2);
		map.put('H', 2);
		map.put('J', 2);
		map.put('K', 2);
		map.put('L', 2);

		map.put('Z', 3);
		map.put('X', 3);
		map.put('C', 3);
		map.put('V', 3);
		map.put('B', 3);
		map.put('N', 3);
		map.put('M', 3);

		boolean flag = false;
		for (int i = 0; i < words.length; i++) {
			flag = true;
			int row = map.get(words[i].charAt(0));
			for (int j = 1; j < words[i].length(); j++) {
				if (map.get(words[i].charAt(j)) != row) {
					flag = false;
					break;
				}
			}
			if (flag)
				list.add(words[i]);
		}

		String res[] = new String[list.size()];
		for (int i = 0; i < list.size(); i++)
			res[i] = list.get(i);
		
		return res;

	}
}
