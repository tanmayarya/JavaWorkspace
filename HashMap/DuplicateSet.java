package HashMap;

import java.util.*;

public class DuplicateSet {

	public static boolean containsDuplicate(int[] nums) {

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(containsDuplicate(arr));

	}

}
