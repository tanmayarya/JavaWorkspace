package StackAndQueue;

import java.util.*;

public class ping {

	static class RecentFetch {

		ArrayList<Integer> q = new ArrayList<Integer>();
		public int ping(int t) {
			q.add(t);
			while(q.get(0)<t-3000)
				q.remove(0);
			return q.size();
		}

	}

	// Dont make changes here
	public static void main(String[] args) {
		RecentFetch rf = new RecentFetch();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print(rf.ping(sc.nextInt()) + " ");
		}
	}

}
