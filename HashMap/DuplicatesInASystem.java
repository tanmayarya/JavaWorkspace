package HashMap;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class DuplicatesInASystem {

	public static ArrayList<ArrayList<String>> findDuplicate(String[] paths) {

		// write your code here
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i < paths.length; i++) {
			String s = paths[i];
			String root = s.substring(0, s.indexOf(' '));
			for (int j = s.indexOf(' ') + 1; j < s.length(); j++) {
				String fname = "";
				if (s.charAt(j) == ' ')
					continue;
				while (s.charAt(j) != '(') {
					fname += s.charAt(j);
					j++;
				}
				j++;
				String content = "";
				while (s.charAt(j) != ')') {
					content += s.charAt(j);
					j++;
				}
				if (map.containsKey(content))
					map.get(content).add(root + '/' + fname);
				else {
					ArrayList<String> list = new ArrayList<String>();
					list.add(root + '/' + fname);
					map.put(content, list);
				}
			}
		}
		return new ArrayList<ArrayList<String>>(map.values());
	}

	// -----------------------------------------------------

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] paths = new String[n];

		for (int i = 0; i < n; i++) {
			paths[i] = br.readLine();
		}
		ArrayList<ArrayList<String>> ans = findDuplicate(paths);
//		for (ArrayList<String> val : ans) {
//			Collections.sort(val);
//		}

		for (ArrayList<String> val : ans) {
			System.out.println(val);
		}
	}
}
