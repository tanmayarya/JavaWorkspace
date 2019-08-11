package HashMap2;

import java.util.*;

public class UniqueNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int l = scn.nextInt();
		int r = scn.nextInt();
		numners(l, r);
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input two numbers as range
	// It should print required output

	public static void numners(int l, int r) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = l; i <= r; i++) {
			int num = i;
			boolean print = true;
			while (num > 0) {
				if (set.contains(num % 10)) {
					print = false;
					break;
				} else {
					set.add(num % 10);
					num /= 10;
				}
			}
			if (print)
				System.out.print(i + " ");
			set.clear();
		}
	}
}
