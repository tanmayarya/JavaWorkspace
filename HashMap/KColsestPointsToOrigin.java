package HashMap;

import java.util.*;

public class KColsestPointsToOrigin {

	static class Point implements Comparable<Point> {
		int x;
		int y;
		double dist;

		Point(int a, int b) {
			x = a;
			y = b;
			dist = Math.sqrt(a * a + b * b);
		}

		@Override
		public int compareTo(Point o) {
			if (this.dist < o.dist)
				return 1;
			else if (this.dist == o.dist) {
				if (this.x < o.x)
					return 1;
				return -1;
			}
			return -1;
		}

	}

	public static int[][] kClosest(Point[] points, int k) {
		// Write your code here
		PriorityQueue<Point> q = new PriorityQueue<Point>();

		for (int i = 0; i < points.length; i++) {
			if (i < k)
				q.add(points[i]);
			else {
				if (q.peek().dist > points[i].dist) {
					q.poll();
					q.add(points[i]);
				}
			}
		}
		int a[][] = new int[q.size()][2];

		for (int i = 0; i < a.length; i++) {
			a[i][0] = q.peek().x;
			a[i][1] = q.poll().y;
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
				int a = scn.nextInt();
				int b = scn.nextInt();
				points[i] = new Point(a, b);
		}
		int k = scn.nextInt();
		int[][] res = kClosest(points, k);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < 2; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
	}
}
