package ArraysAndStrings;

import java.util.*;

public class SubarrayProductLessThanK {

	public static int numSubarrayProductLessThanK(int[] a, int k) {

		int count = 0;
		int prod = 1;
		for (int i = 0, j = 0; i < a.length && j < a.length;) {

			while (j < a.length && prod < k) {
				prod *= a[j];
				j++;
			}
			
			count += ((j - i) * (j - i - 1)) / 2;
			
			while (i < a.length && prod >= k) {
				prod /= a[i];
				i++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(numSubarrayProductLessThanK(nums, k));
	}

}