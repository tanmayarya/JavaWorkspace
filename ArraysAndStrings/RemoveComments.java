package ArraysAndStrings;

import java.util.*;
import java.util.Scanner;

public class RemoveComments {
	public static ArrayList<String> removeComments(String[] source) {
		ArrayList<String> res = new ArrayList<String>();
		res.add("");
		boolean commented = false;
		String ans = "";
		for (int i = 0; i < source.length; i++) {

			String str = source[i];

			for (int j = 0; j < str.length() - 1; j++) {
				String pair = "" + str.charAt(j) + str.charAt(j + 1);

				if (!commented) {
					if (pair.equals("//")) {
						if (ans != "")
							res.add(ans);
						break;
					} else if (pair.equals("/*"))
						commented = true;
					else
						ans += str.charAt(j);
				} else {
					if (pair.equals("*/")) {
						commented = false;
						j++;
					}
				}
			}
			if (!commented) {
				if (str.length() == 1)
					res.add(str);
				if (!res.contains(ans)) {
					res.add(ans + str.charAt(str.length() - 1));
				}
				ans = "";
			}

		}
		res.remove(0);
		return res;
	}

	// Don't make any changes here.
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] source = new String[n];
		for (int i = 0; i < source.length; i++) {
			source[i] = scn.next();
		}

		System.out.println(removeComments(source));

	}

}
