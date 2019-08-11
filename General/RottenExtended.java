package General;

import java.util.ArrayList;
import java.util.Scanner;

public class RottenExtended {

	static class Cell {
		int x;
		int y;
		int level;

		public Cell(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}
	}

	static boolean isValid(int x, int y, int n, int m) {
		if (x >= 0 && x < n && y < m && y >= 0)
			return true;
		return false;
	}

	public static int rottenOranges(int[][] a) {
		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };
		ArrayList<Cell> q = new ArrayList<Cell>();
		ArrayList<Cell> q2 = new ArrayList<Cell>();
		boolean visited[][] = new boolean[a.length][a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 3) {
					Cell t = new Cell(i, j, 0);
					q.add(t);
					for (int b = 0; b < 4; b++) {
						int x = t.x + dx[b];
						int y = t.y + dy[b];
						if (isValid(x, y, a.length, a[0].length) && a[x][y] == 1) {
							a[x][y] = 3;
							visited[x][y] = true;
							q2.add(new Cell(x, y, t.level));
						}
					}
					visited[i][j] = true;
				}
			}
		}
		q.addAll(q2);
		q2 = new ArrayList<Cell>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 2) {
					q.add(new Cell(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		int maxt = 0;
		while (!q.isEmpty()) {
			Cell t = q.remove(0);
			maxt = t.level;
			for (int i = 0; i < 4; i++) {
				int x = t.x + dx[i];
				int y = t.y + dy[i];
				if (isValid(x, y, a.length, a[0].length) && !visited[x][y] && a[x][y] == 1) {
					visited[x][y] = true;
					if (a[t.x][t.y] == 2) {
						a[x][y] = 2;
						q.add(new Cell(x, y, t.level + 1));
					}
					else {
						a[x][y] = 3;
						Cell t2 = new Cell(x, y, t.level + 1);
						q.add(t2);
						for (int b = 0; b < 4; b++) {
							int cx = t2.x + dx[b];
							int cy = t2.y + dy[b];
							if (isValid(cx, cy, a.length, a[0].length) && a[cx][cy] == 1) {
								a[cx][cy] = 3;
								visited[cx][cy] = true;
								q2.add(new Cell(cx, cy, t2.level));
							}
						}
						q.addAll(q2);
						q2 = new ArrayList<Cell>();
					}
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 1) {
					return -1;
				}
			}
		}
		return maxt;
	}

	// Dont make changes here
	public static void main(String[] args) {
		// code
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] M = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < M[0].length; j++)
				M[i][j] = sc.nextInt();
		System.out.println(rottenOranges(M));

	}

}