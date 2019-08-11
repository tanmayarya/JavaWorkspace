package HashMap;

import java.util.*;

public class FakeProfile {

	public static void findIfFake(String s) {
		// Write your code here
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}

		set.remove('a');
		set.remove('e');
		set.remove('i');
		set.remove('o');
		set.remove('u');

		if (set.size() % 2 == 1)
			System.out.println("HE!");
		else
			System.out.println("SHE!");
	}

	// Don't make any changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		findIfFake(scn.next());
	}
}
