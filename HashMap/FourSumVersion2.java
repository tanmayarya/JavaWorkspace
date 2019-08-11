package HashMap;

import java.util.*;

public class FourSumVersion2 {

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		// write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int val = A[i] + B[j];
				map.put(val, map.getOrDefault(val, 0) + 1);
			}
		}
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int res = C[i] + D[j];
				count += map.getOrDefault(-1 * res, 0);
			}
		}

		return count;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int[] arr3 = new int[n];
		int[] arr4 = new int[n];

		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr3[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr4[i] = sc.nextInt();
		}

		System.out.println(fourSumCount(arr1, arr2, arr3, arr4));

	}

}
