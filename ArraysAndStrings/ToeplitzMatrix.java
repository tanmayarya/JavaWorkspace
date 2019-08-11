package ArraysAndStrings;

import java.util.*;

public class ToeplitzMatrix {

	public static boolean isToeplitzMatrix(int[][] matrix) {

		int count = 1;
		for (int i = 0, j = matrix[i].length - 1;;) {
			int val = matrix[i][j];
			for (; i < matrix.length && j < matrix[i].length; i++, j++) {
				if (matrix[i][j] != val)
					return false;
			}
			if (count + 1 == matrix.length + matrix[0].length)
				break;
			count++;
			if (count > matrix[0].length) {
				i = count % matrix[0].length;
				j = 0;
			} else {
				i = 0;
				j = matrix[0].length - count;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] arr = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(isToeplitzMatrix(arr));
	}
}