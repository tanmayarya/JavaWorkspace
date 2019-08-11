package ArraysAndStrings;

import java.util.*;

public class FlipGame {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		List<String> res = generatePossibleNextMoves(s);
		System.out.print(res);
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input a string
	// It should return required List

	public static List<String> generatePossibleNextMoves(String s) {
		// Write your code here
		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < s.length() - 1; i++) {
			String pair = s.substring(i, i + 2);
			if (pair.equals("++")) {
				list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));
			}
		}

		return list;
	}
}