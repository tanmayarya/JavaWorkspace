package StackAndQueue;

import java.util.*;

public class MustangTour {

	public static int mustangTour(int[] petrol, int[] dist) {
		int spare = 0;
		int i = 0;
		int j = 0;
		boolean found = false;
		while (true) {
			spare = 0;
			boolean first = true;
			for (j = i; true; j++) {
				j = j % petrol.length;
				if (spare >= 0) {
					spare += petrol[j] - dist[j];
					if (!first && i == j) {
						j = i;
						break;
					}
				} else {
					if (!first && i == j) {
						return -1;
					}
					if((j + 1) % petrol.length == i)
						return -1;
					i = j;
					j = (j + 1) % petrol.length;
					break;
				}
				first = false;
			}
			if (j == i) {
				found = true;
				break;
			}
			if (j < i)
				break;

		}
		return found ? i : -1;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] petrol = new int[n];
		int[] dist = new int[n];
		for (int i = 0; i < n; i++)
			petrol[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			dist[i] = sc.nextInt();
		System.out.println(mustangTour(petrol, dist));
	}

}
