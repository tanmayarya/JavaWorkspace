package HashMap;

import java.util.*;

public class IPO {

	public static class Project {
		int profit;
		int capital;

		Project(int profit, int capital) {
			this.profit = profit;
			this.capital = capital;
		}
	}

	public static class ProjectProfitComparator implements Comparator<Project> {
		@Override
		public int compare(Project o1, Project o2) {
			return o1.profit - o2.profit;
		}
	}

	public static class ProjectCapitalComparator implements Comparator<Project> {
		@Override
		public int compare(Project o1, Project o2) {
			return o1.capital - o2.capital;
		}
	}

	public static int findMaximizedCapital(int k, int W, Project projects[]) {

		Arrays.sort(projects, new ProjectCapitalComparator());
		PriorityQueue<Project> q = new PriorityQueue<Project>(new ProjectProfitComparator());
		
		
		
		return 0;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int w = sc.nextInt();

		int n = sc.nextInt();
		Project[] projects = new Project[n];

		for (int i = 0; i < n; i++) {
			projects[i].profit = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			projects[i].capital = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			projects[i].profit -= projects[i].capital;
		}
		System.out.println(findMaximizedCapital(k, w, projects));

	}

}
