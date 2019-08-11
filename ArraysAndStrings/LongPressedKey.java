package ArraysAndStrings;

import java.util.*;

public class LongPressedKey {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String name = scn.next();
		String typed = scn.next();
		System.out.println(isLongPressedName(name, typed));

	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input 2 strings
	// It should return boolean output.
	public static boolean isLongPressedName(String name, String typed) {
		if (typed.length() < name.length())
			return false;

		int i = 1, j = i;
		if (name.charAt(0) != typed.charAt(0))
			return false;
		while (i < name.length() && j < typed.length()) {

			if (name.charAt(i) == typed.charAt(j)) {
				i++;
				j++;
			} else if (name.charAt(i - 1) == typed.charAt(j)) {
				j++;
			} else
				return false;
			
			if(i<name.length())
				return false;
		}
		return true;
	}

}