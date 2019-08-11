package HashMap;

import java.util.*;

public class SortCharactersByFreequency {

	public static class CharF implements Comparable<CharF> {
		char c;
		int f;

		CharF(char a, int b) {
			c = a;
			f = b;
		}

		@Override
		public int compareTo(CharF o) {
			return o.f - this.f;
		}

	}

	public static String frequencySort(String s) {
		// Write your code here
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		PriorityQueue<CharF> q = new PriorityQueue<CharF>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		map.forEach((k, v) -> {
			q.add(new CharF(k, v));
		});
		String res = "";
		while (!q.isEmpty()) {
			CharF c = q.poll();
			for (int i = 0; i < c.f; i++)
				res += c.c;
		}
		return res;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(frequencySort(sc.next()));
	}

}
