package ArraysAndStrings;

import java.util.*;

public class OneEditDistance {

	public static boolean isOneEditDistance(String s, String t) {

		int a = s.length();
		int b = t.length();
		int diff = 0;
		if (a == b) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					diff++;
					if (diff > 1)
						return false;
				}
			}
		} else {
			if (a - b > 1 || a - b < -1)
				return false;

			else if (a > b) {
				String temp = s;
				s = t;
				t = temp;
			}
			for (int i = 0, j = 0; i < s.length() && j < t.length();) {
				if (s.charAt(i) != t.charAt(j)) {
					j++;
					diff++;
					if (diff > 1)
						return false;
				} else {
					i++;
					j++;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();

		if (isOneEditDistance(s, t)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
