package ArraysAndStrings;

import java.util.*;

public class RobotReturnToorigin {

	public static boolean judgeCircle(String s) {
		// Write code here
		int vertical = 0, horizontal = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case 'U':
				vertical++;
				break;
			case 'D':
				vertical--;
				break;
			case 'L':
				horizontal--;
				break;
			case 'R':
				horizontal++;
				break;

			}
		}

		return vertical == 0 && horizontal == 0;
	}

	// Don't make any changes here.
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(judgeCircle(str));

	}
}