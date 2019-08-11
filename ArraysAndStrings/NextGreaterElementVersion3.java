package ArraysAndStrings;

import java.util.*;

public class NextGreaterElementVersion3 {

	public static int nextGreaterElement(int n) {
		int num = n;
		StringBuilder s = new StringBuilder(n + "");
		List<Integer> l = new ArrayList<Integer>();
		int idx = -1;
		for (int i = s.length() - 1; i > 0; i--) {
			if (s.charAt(i) > s.charAt(i - 1)) {
				idx = i;
				break;
			}
		}
		if (idx == -1)
			return -1;

		for (int i = idx; i < s.length();) {
			if (s.charAt(i) <= s.charAt(idx - 1)) {
				char c = s.charAt(idx - 1);
				s.setCharAt(idx - 1, s.charAt(i - 1));
				s.setCharAt(i - 1, c);
				break;
			}
			i++;
			if (i == s.length()) {
				char c = s.charAt(idx - 1);
				s.setCharAt(idx - 1, s.charAt(i - 1));
				s.setCharAt(i - 1, c);
				break;

			}
		}
		for (int i = idx; i < s.length(); i++)
			l.add(s.charAt(i) - '0');

		Collections.sort(l);

		String q = "";
		for (int i = 0; i < l.size(); i++)
			q += l.get(i);

		s.replace(idx, s.length(), q);

		return Integer.parseInt(s.toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(nextGreaterElement(sc.nextInt()));
//		List<Integer> a = new ArrayList<Integer>();
//		a.add(2);
//		a.add(3);
//		System.out.println(a.toString());
	}

}