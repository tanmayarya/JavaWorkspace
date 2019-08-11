package StackAndQueue;

import java.util.*;

public class TinyBigTiny {

	public static boolean find132pattern(int[] num) {
		// Write your code here
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < num.length - 1; j++) {
			min = min < num[j] ? min : num[j];
			for(int k=j+1;k<num.length;k++) {
				if(num[j]>num[k] && min<num[k])
					return true;
			}
		}
		return false;
	}

	// Dont make changes here
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = sc.nextInt();
		System.out.println(find132pattern(A));
	}

}
