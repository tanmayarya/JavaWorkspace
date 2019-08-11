package HashMap;

import java.util.*;

import HashMap.IdentifyString.Element;

public class IdentifyString {

	static class Element implements Comparable<Element> {
		char c;
		int f;

		public Element(char a, int b) {
			c = a;
			f = b;
		}

		@Override
		public int compareTo(Element o) {
			if (this.f > o.f)
				return -1;
			else if (this.f < o.f)
				return 1;
			return 0;
		}
	}

	public static String reorganizeString(String s) {

		PriorityQueue<Element> q = new PriorityQueue<Element>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		String res = "";
		for (int i = 0; i < s.length(); i++)
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

		map.forEach((k, v) -> {
			q.add(new Element(k, v));
		});

		while (!q.isEmpty()) {
			Element a = q.poll();
			res += a.c;
			if (!q.isEmpty()) {
				Element b = q.poll();
				res += b.c;
				if (--b.f > 0)
					q.add(b);
			}
			if (--a.f > 0)
				q.add(a);

		}

		for (int i = 1; i < res.length(); i++)
			if (res.charAt(i) == res.charAt(i - 1))
				return "";

		return res;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		System.out.println(reorganizeString(s));

	}

}
