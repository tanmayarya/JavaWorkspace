package ip_Test3;

import java.util.*;

public class Bazooka {

	static boolean isPalindrome(String s) {
		int l = s.length();

		for (int i = 0; i < l / 2; i++)
			if (s.charAt(i) != s.charAt(l - i - 1))
				return false;

		return true;
	}

	static int countPalindromePair(String strings[]) {
		int count = 0;
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings.length; j++) {

				if (i == j)
					continue;

				if (isPalindrome(strings[i] + strings[j])) {
					count++;
				}

			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String a[] = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.next();
		}
		System.out.println(countPalindromePair(a));

	}
}
