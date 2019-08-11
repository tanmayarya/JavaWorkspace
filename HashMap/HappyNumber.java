package HashMap;

import java.util.*;

public class HappyNumber {

	public static boolean isHappy(int n) {
		int sum = 0;
		int num = n;
		HashSet<Integer> set = new HashSet<Integer>();
		while (num > 0) {
			sum += Math.pow((num % 10), 2);
			num /= 10;
			if (num == 0) {
				if (sum == 1)
					return true;
				else if (set.contains(sum))
					return false;
				else {
					set.add(sum);
					num = sum;
					sum = 0;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		if (isHappy(N)) {
			System.out.println("Happy");
		} else {
			System.out.println("Not Happy");
		}
	}

}