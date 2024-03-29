package ArraysAndStrings;

import java.util.*;

public class ClosestPalindrome {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String n = scn.next();
		System.out.println(nearestPalindromic(n));
	}

	static String Makefullpalindrome(String source) {
		String leftpart = source.substring(0, source.length() / 2);
		String rightpart = reverse(leftpart);
		if (source.length() % 2 == 1) {
			return leftpart + source.charAt(source.length() / 2) + rightpart;
		}
		return leftpart + rightpart;
	}

	static String reverse(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(j);
			s = s.substring(0, i) + ch2 + s.substring(i + 1, j) + ch1 + s.substring(j + 1);
			i++;
			j--;
		}

		return s;
	}

	static String makeStringborc(String n, int val) {
		String res = "";

		int i = (n.length() - 1) / 2;

		if (val == 1) {
			res = n.substring(0, i + 1);
			Long ans = Long.parseLong(res) + 1;
			res = String.valueOf(ans) + n.substring(i + 1);
			return res;
		} else {

			res = n.substring(0, i + 1);
			Long ans = Long.parseLong(res) - 1;
			String temp = String.valueOf(ans);

			// while(i>=0&&temp.charAt(i))

			if (temp.charAt(0) == '0' || res.length() - temp.length() > 0) {
				if (temp.charAt(0) == '0' && temp.length() == 1) {
					return "9";
				} else {

					temp = temp + "9" + n.substring(i + 2);
					return temp;

				}

			}

			return temp + n.substring(i + 1);
		}
	}

	public static String nearestPalindromic(String n) {

		if (n.equals("1"))
			return "0";

		String a = Makefullpalindrome(n);
		String b = Makefullpalindrome(makeStringborc(n, -1));
		String c = Makefullpalindrome(makeStringborc(n, 1));

		Long d1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
		d1 = d1 == 0 ? Long.MAX_VALUE : d1;
		Long d2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));
		d2 = d2 == 0 ? Long.MAX_VALUE : d2;
		Long d3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));
		d3 = d3 == 0 ? Long.MAX_VALUE : d3;

		if (d2 <= d1 && d2 <= d3)
			return b;
		if (d1 <= d3 && d1 <= d2)
			return a;
		else
			return c;

	}

}