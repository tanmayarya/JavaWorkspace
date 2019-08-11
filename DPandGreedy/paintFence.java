package DPandGreedy;

import java.util.*;

public class paintFence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		System.out.println(CountWays(a, b));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input 2 integers
	// It should return the required output

	public static int CountWays(int n, int k) {
		int same = 0;
		int diff = k;

		for (int i = 1; i < n; i++) {
			int oldsame = same;
			same = diff;
			diff = (oldsame + diff) * (k - 1);
		}

		return diff + same;
	}
}