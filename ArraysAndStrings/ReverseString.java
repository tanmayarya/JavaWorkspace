package ArraysAndStrings;

import java.util.*;

public class ReverseString {

	public static void reverseString(char[] s) {

		for (int i = 0; i < s.length; i++) {
			char t = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - 1 - i] = t;
		}
	}

	// Don't make any changes here.
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		char[] charArray = new char[n];
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = scn.next().charAt(0);
		}

		reverseString(charArray);

		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i] + " ");
		}

	}

}
