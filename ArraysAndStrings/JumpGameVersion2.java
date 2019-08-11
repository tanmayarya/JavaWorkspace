package ArraysAndStrings;

import java.util.*;

public class JumpGameVersion2 {

	public static int jump(int[] nums) {

		int ladder = 0;
		int stair = 1;
		int jump = 0;

		for (int level = 0; level < nums.length; level++) {
			if (level == nums.length - 1) {
				return jump;
			}

			if (nums[level] + level >= ladder)
				ladder = nums[level] + level;

			stair--;

			if (stair == 0) {
				jump++;
				stair = ladder - level;
				if (stair == 0)
					return -1;
			}
		}
		return jump;
	}

	// Don't male any changes here
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < num.length; i++) {
			num[i] = s.nextInt();
		}
		System.out.println(jump(num));
	}
}