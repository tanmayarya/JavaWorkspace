package ArraysAndStrings;

import java.util.*;

public class ProductOfArrayExceptSelf {

	public static int[] productExceptSelf(int[] nums) {
		// Write your code here.
		int res[] = new int[nums.length];
		int pleft[] = new int[nums.length];
		int pright[] = new int[nums.length];
		pleft[0] = 1;
		pright[nums.length - 1] = 1;

		for (int i = 1; i < nums.length; i++)
			pleft[i] = pleft[i - 1] * nums[i - 1];

		for (int i = nums.length - 2; i >= 0; i--)
			pright[i] = pright[i + 1] * nums[i + 1];

		for (int i = 0; i < nums.length; i++)
			res[i] = pleft[i] * pright[i];

		return res;
	}

	// Don't make changes here.
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int Input[] = new int[n];
		for (int i = 0; i < n; i++) {
			Input[i] = scn.nextInt();
		}
		int ans[] = productExceptSelf(Input);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

}