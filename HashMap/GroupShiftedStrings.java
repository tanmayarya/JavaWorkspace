package HashMap;

import java.util.*;

public class GroupShiftedStrings {

	public static List<List<String>> groupStrings(String[] strings) {

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		int dif = 0;
		for (int i = 0; i < strings.length; i++) {
			String s = strings[i];
			String key = "";
			for (int j = 1; j < s.length(); j++) {
				dif = s.charAt(j) - s.charAt(j - 1);
				if (dif < 0)
					dif += 26;
				key += dif + "-";
			}
			if (!map.containsKey(key)) 
				map.put(key, new ArrayList<String>());
			map.get(key).add(strings[i]);
		}
		
		

		return new ArrayList<List<String>>(map.values());
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Length of the array
		int N = sc.nextInt();

		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}

		List<List<String>> stringsGrouped = groupStrings(arr);

		for (List<String> lst : stringsGrouped) {
			Collections.sort(lst);
		}

		stringsGrouped.sort(new ListComparator());

		display(stringsGrouped);

	}

	// Comparator for sorting the result list.
	static class ListComparator implements Comparator<List<String>> {

		@Override
		public int compare(List<String> l1, List<String> l2) {

			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			for (int i = 0; i < l1.size(); i++) {
				String l1str = l1.get(i);
				String l2str = l2.get(i);

				return l1str.compareTo(l2str);

			}

			return 0;

		}
	}

	// Function to display a List of Lists of strings.
	public static void display(List<List<String>> list) {

		for (int i = 0; i < list.size(); i++) {

			List<String> currList = list.get(i);

			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}

			System.out.println();
		}

	}

}
