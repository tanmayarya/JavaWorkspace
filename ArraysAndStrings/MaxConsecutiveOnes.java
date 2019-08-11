package ArraysAndStrings;

import java.util.*;

public class MaxConsecutiveOnes {

	public static int findMaxConsecutiveOnes(int[] nums) {
		// write your code here.
		int len = 0;

		int n0 = 0;

		for (int i = 0, j = 0; i < nums.length && j < nums.length;) {
			while (n0 < 2 && j < nums.length) {
				if (nums[j] == 0)
					n0++;
				j++;
			}
			if (nums[j - 1] == 0)
				len = Math.max(len, j - i - 1);
			else
				len = Math.max(len, j - i);

			while (n0 > 1) {
				if (nums[i] == 0)
					n0--;
				i++;
			}
		}

		return len;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr1 = new int[N];

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
		}

		int result = findMaxConsecutiveOnes(arr1);

		System.out.println(result);

	}

	public static void display(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

}