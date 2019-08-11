package ArraysAndStrings;

import java.util.*;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String version1 = scn.next();
		String version2 = scn.next();
		System.out.print(compareVersion(version1, version2));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input two strings
	// It should return required output.

	public static int compareVersion(String version1, String version2) {

		int i = 0, j = 0;

		while (i < version1.length() && j < version2.length()) {
			if (version1.charAt(i) == version2.charAt(j)) {
				i++;
				j++;
			} else if (version1.charAt(i) > version2.charAt(j))
				return 1;
			else
				return -1;
		}
		while (i < version1.length() && (version1.charAt(i) == '0' || version1.charAt(i) == '.'))
			i++;

		while (j < version2.length() && (version2.charAt(j) == '0' || version2.charAt(j) == '.'))
			j++;
		if (i < version1.length())
			return 1;
		else if (j < version2.length())
			return -1;
		return 0;

	}
}