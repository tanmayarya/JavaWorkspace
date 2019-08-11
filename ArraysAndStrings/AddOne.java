package ArraysAndStrings;

import java.util.*;

public class AddOne {

	public static int[] plusOne(int[] digits) {
		// Write your code here
		ArrayList<Integer> list = new ArrayList<Integer>();
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int a = digits[i] + carry;
			if (a > 9) {
				carry = 1;
				a %= 10;
			} else
				carry = 0;
			list.add(a);
		}
		if (carry == 1)
			list.add(1);
		int ar[] = new int[list.size()];
		for (int i = 0; i < ar.length; i++)
			ar[i] = list.remove(list.size() - 1);

		return ar;
	}

	// Don't make any changes here.
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] Input = new int[n];
		for (int i = 0; i < Input.length; i++) {
			Input[i] = scn.nextInt();
		}
		int ans[] = plusOne(Input);
		for (int i : ans) {
			System.out.print(i + " ");
		}

	}

}