package HashMap;

import java.util.*;

public class FourSum {

	public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {

		Arrays.sort(nums);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < nums.length - 3;) {
			for (int j = i + 1; j < nums.length - 2;) {
				int l = j + 1;
				int r = nums.length - 1;
				while (l < r) {
					int sum = nums[i] + nums[j] + nums[l] + nums[r];
					if (sum < target) {
						while (nums[l] == nums[l + 1])
							l++;
						l++;
					} else if (sum > target) {
						while (nums[r] == nums[r - 1])
							r--;
						r--;
					} else {
						ArrayList<Integer> lres = new ArrayList<Integer>();
						lres.add(nums[i]);
						lres.add(nums[j]);
						lres.add(nums[l]);
						lres.add(nums[r]);
						res.add(lres);
						while (nums[r] == nums[r - 1])
							r--;
						r--;
						while (nums[l] == nums[l + 1])
							l++;
						l++;
					}
				}
				while (nums[j] == nums[j + 1])
					j++;
				j++;
			}
			while (nums[i] == nums[i + 1])
				i++;
			i++;
		}
		return res;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target);

		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + ",");
			}
			System.out.println();
		}

	}

}
