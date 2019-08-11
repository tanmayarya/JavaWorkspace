package ArraysAndStrings;

import java.util.*;

public class ThreeSumClosest {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		System.out.print(threeSumClosest(nums, k));
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array and an integer
	// It should return an integer value.

	public static int threeSumClosest(int[] nums, int target) {
		int diff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int val = target - (nums[i] + nums[left] + nums[right]);
				
				if(Math.abs(diff)>Math.abs(val))
					diff = val;

				if (target > nums[i] + nums[left] + nums[right])
					left++;
				else if (target < nums[i] + nums[left] + nums[right])
					right--;
				else
					return target;
			}
		}
		return target - diff;
	}
}