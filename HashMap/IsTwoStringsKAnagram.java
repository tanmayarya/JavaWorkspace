package HashMap;

import java.util.*;

public class IsTwoStringsKAnagram {

	public static boolean areKAnagrams(String a, String b, int k) {

		if (a.length() != b.length())
			return false;
		
		
		
		return true;
	}

	// Don't make changes here
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}
