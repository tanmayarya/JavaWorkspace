package ArraysAndStrings;

import java.util.*;

public class SimilarRGBcolor {

	public static String similarRGB(String color) {
		String res = "#";

		res += find(color.substring(1, 3));
		res += find(color.substring(3, 5));
		res += find(color.substring(5, 7));

		return res;
	}

	public static String find(String s) {
		ArrayList<Character> list = new ArrayList<Character>();

		for (int i = 0; i < 10; i++)
			list.add((char) (i + '0'));

		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		list.add('e');
		list.add('f');

		int g1 = 0, g2 = 0;
		char msb = s.charAt(0);
		char lsb = s.charAt(1);
		int msbi = list.indexOf(msb);
		int lsbi = list.indexOf(lsb);
		if (msbi > lsbi) {

			g1 = Math.abs(msbi - lsbi);
			g2 = 17 - g1;
			if (g1 < g2) {
				return "" + msb + msb;
			} else {
				return "" + list.get(msbi - 1) + list.get(msbi - 1);
			}

		} else if (msbi < lsbi) {

			g1 = Math.abs(msbi - lsbi);
			g2 = 17 - g1;
			if (g1 < g2) {
				return "" + msb + msb;
			} else {
				return "" + list.get(msbi + 1) + list.get(msbi + 1);
			}

		} else
			return s;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(similarRGB(sc.next()));
	}

}