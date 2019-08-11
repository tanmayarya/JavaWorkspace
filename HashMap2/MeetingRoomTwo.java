package HashMap2;

import java.util.*;

public class MeetingRoomTwo {

	public static int minMeetingRooms(int[] start, int end[]) {
		// write your code here.
		int count = 0, max = 0;
		Arrays.sort(start);
		Arrays.sort(end);
		int i = 0, j = 0;
		while (i < start.length && j < end.length) {
			if (start[i] < end[j]) {
				count++;
				i++;
			} else {
				count--;
				j++;
			}
			max = Math.max(count, max);
		}
		while (i < start.length) {
			count++;
			i++;
			max = Math.max(count, max);
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input for number of meetings.
		int N = sc.nextInt();

		int[] start = new int[N];
		int[] end = new int[N];
		// Input for intervals.
		for (int i = 0; i < N; i++) {
			start[i] = sc.nextInt();
			end[i] = sc.nextInt();
		}

		int result = minMeetingRooms(start, end);

		System.out.println(result);

	}

	// Function to display a 2D array.
	public static void display(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}

	}

}
