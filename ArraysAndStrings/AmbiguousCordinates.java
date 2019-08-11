package ArraysAndStrings;

import java.util.*;

public class AmbiguousCordinates {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		List<String> res = ambiguousCoordinates(s);
		System.out.print(res);
	}

	// -----------------------------------------------------
	// This is a functional problem. Do not modify main
	// This function takes as input an array and integer k.
	// It should return required output.

	public static List<String> ambiguousCoordinates(String s) {
		ArrayList<String> res = new ArrayList<String>();

		for (int i = 1; i < s.length() - 2; i++) {
			List<String> A = findAll(s.substring(1, i + 1));
			List<String> B = findAll(s.substring(i + 1, s.length() - 1));

			for (String a : A)
				for (String b : B)
					res.add("(" + a + ", " + b + ")");

		}
		return res;
	}

	public static List<String> findAll(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s.length() == 0 || (s.charAt(0) == '0' && s.charAt(s.length() - 1) == '0' && s.length() > 1))
			return res;

		if (s.length() > 1 && s.charAt(0) == '0') {
			res.add("0." + s.substring(1));
			return res;
		}

		res.add(s);
		if (s.length() == 1 || s.charAt(s.length() - 1) == '0')
			return res;

		for (int i = 1; i < s.length(); i++) {
			res.add(s.substring(0, i) + "." + s.substring(i));
		}
		Collections.sort(res);
		return res;
	}
}