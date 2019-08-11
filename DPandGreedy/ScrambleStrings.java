package DPandGreedy;

import java.util.*;

public class ScrambleStrings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.print(isScramble(s1, s2));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as 2 strings
	// It should return the required output

	public static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int len = s1.length();
		boolean a[][][] = new boolean[len][len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (s1.charAt(i) == s2.charAt(j))
					a[0][i][j] = true;
			}
		}

		for (int k = 1; k < len; k++) {
			for (int i = 0; i < len - k; i++) {
				for (int j = 0; j < len - k; j++) {
					for (int l = 1; l <= k; l++) {
						if (a[l - 1][i][j] && a[k - l][i + l][j + l]) {
							a[k][i][j] = true;
							break;
						} else if (a[l - 1][i][j + k + 1 - l] && a[k - l][i + l][j]) {
							a[k][i][j] = true;
							break;
						}
					}
				}
			}
		}

		return a[len - 1][0][0];
	}
}
