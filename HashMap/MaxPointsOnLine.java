package HashMap;

import java.util.*;

public class MaxPointsOnLine {

	static class Line {
		int dx;
		int dy;

		Line(int a, int b) {
			dx = a;
			dy = b;
		}

		@Override
		public boolean equals(Object o) {
			Line lo = (Line) o;

			if (this.dx == lo.dx && this.dy == lo.dy)
				return true;
			return false;
		}

		@Override
		public int hashCode() {
			return this.dx + this.dy;
		}
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static int maxPoints(Point[] points) {
		int max = 2;
		HashMap<Line, Integer> map = new HashMap<Line, Integer>();
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int x1 = points[i].x;
				int y1 = points[i].y;
				int x2 = points[j].x;
				int y2 = points[j].y;

				int dx = x2 - x1;
				int dy = y2 - y1;
				int gcd = gcd(dy, dx);

				Line line = new Line(dx / gcd, dy / gcd);
				if (map.containsKey(line)) {
					map.put(line, map.get(line) + 1);
					max = Math.max(max, map.get(line));
				} else
					map.put(line, 2);
			}
			map.clear();
		}

		return max;
	}

	/// Dont make changes here
	static class Point {

		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			points[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		System.out.println(maxPoints(points));
	}
}
