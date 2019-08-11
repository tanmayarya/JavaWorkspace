package StackAndQueue;

import java.util.Scanner;

public class FleetOfCars {

	public static int carFleet(int target, int[] position, int[] speed) {
		int count = 1;
		float ptime = (float) (target - position[speed.length-1]) / speed[speed.length-1];
		for (int i = speed.length - 2; i >= 0; i--) {
			float ctime = (float) (target - position[i]) / speed[i];
			if(ctime>ptime) {
				count++;
			}
		}
		return count;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int n = sc.nextInt();
		int[] pos = new int[n];
		int[] speed = new int[n];
		for (int i = 0; i < n; i++)
			pos[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			speed[i] = sc.nextInt();
		System.out.println(carFleet(target, pos, speed));
	}
}
