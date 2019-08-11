package StackAndQueue;

import java.util.*;

public class NegativeInKsizedWindow {

	public static void window(int[] arr, int k) {
		ArrayList<Integer> q = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) 
			if (arr[i] < 0) {
				q.add(i);
				if(i+k>=arr.length)
					break;
			}
		int count = 0;
		for (int i = 0; !q.isEmpty(); i++) {
			int nidx = q.get(0);
			if (i == nidx) {
				System.out.print(arr[nidx] + " ");
				q.remove(0);
			} else if (i + k < nidx) {
				System.out.print(0 + " ");
			} else if (i + k >= nidx) {
				System.out.print(arr[nidx] + " ");
				if(i + k >= arr.length)
					q.remove(0);
			}
			count++;
		}
		for (; count+k <= arr.length; count++)
			System.out.print(0 + " ");
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		int k = s.nextInt();

		window(arr, k);

	}
}
