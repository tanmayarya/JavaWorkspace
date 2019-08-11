package StackAndQueue;

import java.util.ArrayList;
import java.util.Scanner;

import StackAndQueue.KnightInTheChessBoard.Cell;

public class RottenCropsInFarm {

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
		boolean visited[][] = new boolean[a.length][a[0].length];
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
					a[x][y] = 2;
					q.add(new Cell(x, y, t.level + 1));
				}
			}
		}
//		for (int i = 0; i < a.length; i++) {
//			for (int j = 0; j < a[0].length; j++) {
//				System.out.print(a[i][j] + " ");
//			}
//			System.out.println();
//		}
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