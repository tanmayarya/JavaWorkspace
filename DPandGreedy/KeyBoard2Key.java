package DPandGreedy;

import java.util.*;

public class KeyBoard2Key {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(_2KeysKeyboard(n));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an integer
	// It should return the required output

	public static int _2KeysKeyboard(int n) {
		int sum = 0;
		int a[] = new int[n + 1];

		for (int i = 2; i * i <= n; i++) {

			while (n % i == 0) {
				n /= i;
				a[i]++;
			}
		}

		if (n != 1)
			a[n]++;

		for (int i = 0; i <= n; i++) {
			sum += i*a[i];
		}

		return sum;
	}
}
