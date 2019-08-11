package HashMap;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfPrimes {

	public static int countPrimes(int n) {
		int count = 0;
		boolean a[] = new boolean[n + 1];

		for (int i = 2; i < a.length; i++)
			a[i] = true;

		for (int i = 2; i * i <= n; i++) {
			if (a[i]) {
				for (int j = 2 * i; j <= n; j += i)
					a[j] = false;
			}
		}
		for (int i = 0; i <= n; i++)
			if (a[i])
				count++;

		return count;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(countPrimes(N));

	}

}
