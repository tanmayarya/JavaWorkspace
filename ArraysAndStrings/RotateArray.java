package ArraysAndStrings;

import java.util.*;

public class RotateArray {

	public static void rotate(int[] a, int k) {

		k = k % a.length;
		int temp[] = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			temp[(i + k) % a.length] = a[i];
		}

		for (int i = 0; i < a.length; i++)
			a[i] = temp[i];
	}

	// Don't make any changes here
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = s.nextInt();
		}
		rotate(ar, k);
		for (int v : ar)
			System.out.print(v + " ");
	}

}