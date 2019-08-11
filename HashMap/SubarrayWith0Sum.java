package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class SubarrayWith0Sum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int size = scn.nextInt();

		long[] arr = new long[size];

		for (int j = 0; j < size; j++) {
			arr[j] = scn.nextLong();
		}

		zerosumarr(arr);

	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input an array
	// Print required output
	
	static void zerosumarr(long[] arr) {
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		long sum = 0;
		map.put(sum, 1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		sum = 0;
		for (HashMap.Entry<Long, Integer> entry : map.entrySet()) {
			{
				if (entry.getValue() > 1)
					sum++;
			}

		}

		System.out.println(sum);

	}
}
