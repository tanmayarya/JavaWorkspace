package ArraysAndStrings;

import java.util.Scanner;

public class GlobalAndLocalInversions {
	public static boolean equal(int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (Math.abs(a[i] - i) > 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scn.nextInt();

		System.out.println(equal(a));

	}
}
