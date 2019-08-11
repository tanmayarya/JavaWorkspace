package HackWithInfy;

import java.util.*;

public class Shoper {

	public static int getMaximumOutfits(List<Integer> outfits, int money) {
		int max = 0;
		int sum = 0;
		for (int i = 0, j = 0; i < outfits.size() && j < outfits.size();) {

			while (j < outfits.size() && sum <= money && outfits.get(j) + sum <= money) {
				sum += outfits.get(j);
				j++;
			}
			max = Math.max(max, j-i);
			sum-=outfits.get(i++);

		}

		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			list.add(sc.nextInt());

		int cost = sc.nextInt();
		System.out.println(getMaximumOutfits(list, cost));
	}
}
