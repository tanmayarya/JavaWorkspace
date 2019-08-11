package ArraysAndStrings;

import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scn.nextInt();
		}
		System.out.print(threeSum(nums));
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array
	// It should return an required output
	public static List<List<Integer>> threeSum(int[] a) {

		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

		Arrays.sort(a);
		for (int i = 0; i < a.length - 2; i++) {
			int left = i + 1;
			int right = a.length - 1;
			while (left < right) {
				if (a[left] + a[right] == -a[i]) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(a[i]);
					list.add(a[left]);
					list.add(a[right]);
					if (!res.contains(list))
						res.add(list);
					left++;
					right--;
				} else if (a[left] + a[right] > -1 * a[i])
					right--;
				else
					left++;

			}
		}

		return res;
	}
}