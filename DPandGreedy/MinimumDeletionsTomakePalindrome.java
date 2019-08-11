package DPandGreedy;

import java.util.*;

public class MinimumDeletionsTomakePalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		mindeletions(str);
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input a string
	// It should print the required output

	public static void mindeletions(String str) {
		// Write your code here
		System.out.println(str.length() - lcss(str));
	}

	public static int lcss(String s) {
		int a[][] = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++)
			a[i][i] = 1;

		for (int g = 1; g < s.length(); g++) {
			for (int i = 0, j = i + g; j < s.length(); j++, i++) {
				if (s.charAt(i) == s.charAt(j))
					a[i][j] = a[i + 1][j - 1] + 2;
				else
					a[i][j] = Math.max(a[i + 1][j], a[i][j - 1]);
			}
		}

		return a[0][s.length() - 1];
	}

}
