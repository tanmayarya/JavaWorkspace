package ArraysAndStrings;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int k = scn.nextInt();
		System.out.println(characterReplacement(s, k));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array and integer k.
	// It should return required output.

	public static int characterReplacement(String s, int k) {
		// Write your code here
		int count = 0;
		for (int i = 0, j = 0; i < s.length() && j < s.length();) {
			char c = s.charAt(i);
			int nk = 0;
			j = i+1;
			while (nk <= k && j < s.length()) {
				if (s.charAt(j) != c)
					nk++;
				j++;
			}
			count = Math.max(count, j - i - 1);

			while (i < s.length() && s.charAt(i) == c)
				i++;
		}

		return count;
	}
}
