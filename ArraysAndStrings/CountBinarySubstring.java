package ArraysAndStrings;

import java.util.*;

public class CountBinarySubstring {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.print(countBinarySubstrings(s));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input a string
	// It should return the required output

	public static int countBinarySubstrings(String s) {
		int count = 0;
		int curr = 0, prev = 0;
		char current = s.charAt(0);

		for (int i = prev; i < s.length();) {

			

			while (i < s.length() && s.charAt(i) == current) {
				prev++;
				i++;
			}
			if (i < s.length())
				current = s.charAt(i);

			while (prev > curr && i < s.length()) {
				if (s.charAt(i) == current) {
					count++;
					curr++;
					i++;
				} else
					break;
			}
			prev = curr;
			curr = 0;
		}

		return count;
	}

}