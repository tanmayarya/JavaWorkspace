package ArraysAndStrings;

import java.util.*;

public class StudentAttendnceRecord {

	public static boolean checkRecord(String s) {
		// write your code here.

		boolean wasAbsent = false;
		int late = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'A') {
				if (wasAbsent)
					return false;
				else
					wasAbsent = true;
			}
			if (c == 'L') {
				while (i < s.length() && s.charAt(i) == 'L') {
					late++;
					i++;
				}
				if (late > 2)
					return false;
				late = 0;
			}

		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		if (checkRecord(S)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}
}
