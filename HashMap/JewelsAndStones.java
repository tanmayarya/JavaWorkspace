package HashMap;

import java.util.*;

public class JewelsAndStones {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String J = scn.next();
		String S = scn.next();
		System.out.print(numJewelsInStones(J, S));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input 2 strings.
	// It should return an integer value.
	public static int numJewelsInStones(String J, String S) {
		// Write your code here
		int count = 0;
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < J.length(); i++)
			set.add(J.charAt(i));

		for (int i = 0; i < S.length(); i++)
			if (set.contains(S.charAt(i)))
				count++;
		return count;
	}
}
