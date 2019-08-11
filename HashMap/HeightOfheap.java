package HashMap;

import java.io.*;
import java.util.*;

public class HeightOfheap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int x = solve(n);
		System.out.println(x);
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array and n length of array.
	// It should return an integer value.

	private static int solve(int N) {
		
		return getLogCeil(N+1) - 1;
	}

	public static int getLogCeil(int n) {
		int h = 0;
		while ((1 << h) < n) {
			h++;
		}
		return h;
	}
}
