package ArraysAndStrings;

import java.util.*;

public class ShiftingLetters {

	public static String shiftingLetters(String s, int[] a) {
		// write your code here.
		String res = "";
		int sum = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			sum += a[i];
			char c = (char) ((s.charAt(i) - 'a' + sum) % 26 + 'a');
			res = c + res;
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		int N = sc.nextInt();

		int[] shifts = new int[N];

		for (int i = 0; i < N; i++) {
			shifts[i] = sc.nextInt();
		}

		System.out.println(shiftingLetters(S, shifts));
	}
}