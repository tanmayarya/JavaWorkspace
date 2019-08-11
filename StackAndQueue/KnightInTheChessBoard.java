package StackAndQueue;

import java.util.*;

public class KnightInTheChessBoard {
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
	static boolean isValid(int x, int y, int n) {
		if (x >= 1 && x <= n && y <= n && y >= 1)
			return true;
		return false;
	}

	static int knightChessboard(int knightPos[], int targetPos[], int n) {
		int dx[] = { 1, 1, -1, -1, 2, 2, -2, -2 };
		int dy[] = { 2, -2, 2, -2, 1, -1, 1, -1 };
		boolean visited[][] = new boolean[n + 1][n + 1];
		LinkedList<Cell> q = new LinkedList<Cell>();
		q.add(new Cell(knightPos[0], knightPos[1], 0));
		visited[knightPos[0]][knightPos[1]] = true;
		while (!q.isEmpty()) {
			Cell t = q.poll();
			if (t.x == targetPos[0] && t.y == targetPos[1])
				return t.level;
			
			for (int i = 0; i < 8; i++) {
				int x = t.x + dx[i];
				int y = t.y + dy[i];
				if (isValid(x, y, n) && !visited[x][y]){
				    visited[x][y] = true;
					q.add(new Cell(x, y, t.level + 1));
                }
			}
		}

		return Integer.MAX_VALUE;
	}

	// Dont change here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int knightPos[] = new int[2];
		int targetPos[] = new int[2];
		knightPos[0] = sc.nextInt();
		knightPos[1] = sc.nextInt();
		targetPos[0] = sc.nextInt();
		targetPos[1] = sc.nextInt();
		System.out.println(knightChessboard(knightPos, targetPos, N));
	}
}
