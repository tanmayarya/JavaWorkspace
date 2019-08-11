package ArraysAndStrings;

import java.util.*;

public class IntegerToRoman {

	public static class Pair {
		String roman;
		int val;

		public Pair(String s, int v) {
			roman = s;
			val = v;
		}
	}

	public static String intToRoman(int num) {
		String res = "";
		Pair a[] = { new Pair("I", 1), new Pair("IV", 4), new Pair("V", 5), new Pair("IX", 9), new Pair("X", 10),
				new Pair("XL", 40), new Pair("L", 50), new Pair("XC", 90), new Pair("C", 100), new Pair("CD", 400),
				new Pair("D", 500), new Pair("CM", 900), new Pair("M", 1000) };
		while (num > 0) {
			
			for (int i = a.length - 1; i >= 0; i--) {
				if(a[i].val <= num) {
					num-=a[i].val;
					res+=a[i].roman;
					break;
				}
			}
		}

		return res;
	}

	// Don't make any changes here
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		System.out.println(intToRoman(num));

	}

}
