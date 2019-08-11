package ArraysAndStrings;

import java.util.*;

public class FlipStringToMonotoneIncreasing {

	public static int flip(String s) {
		int a = 0, b = 0;
		if (s.substring(0, 2).equals("00"))
			a = 1;
		else if (s.substring(0, 2).equals("01"))
			b = 1;
		else if (s.substring(0, 2).equals("10")) {
			a = 2;
			b = 1;
		} else {
			a = 1;
			b = 2;
		}
		for (int i = 2; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '0') {
				a = Math.min(a, b) + 1;

			} else {
				a = Math.min(a, b);
				b++;
			}
		}

		return a;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.println(flip(s));

	}
}
