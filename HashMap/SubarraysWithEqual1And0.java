package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraysWithEqual1And0 {

	static int nCr(int n, int r) {
		return fact(n) / (fact(r) * fact(n - r));
	}

	// Returns factorial of n
	static int fact(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res = res * i;
		return res;
	}

	public static int countSubArrays(int[] arr, int n) {
		// Write your code here.
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == 0)
				arr[i] = -1;

		int sum = 0;
		map.put(sum, 1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		sum = 0;
		for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
			{
					sum += nCr(entry.getValue(), 2);
			}

		}

		return sum;
	}

	// Don't make any changes here.
	public static void main(String[] args) {
		// code
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		System.out.println(countSubArrays(a, n));

	}

}
