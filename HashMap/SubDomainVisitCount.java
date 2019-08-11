package HashMap;

import java.util.*;

public class SubDomainVisitCount {

	public static List<String> subdomainVisits(String[] cpdomains) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < cpdomains.length; i++) {
			String s = cpdomains[i];
			int didx = s.indexOf(' ');
			int num = Integer.parseInt(s.substring(0, didx));
			map.put(s.substring(didx + 1), map.getOrDefault(s.substring(didx + 1), 0) + num);

			didx = s.indexOf('.');
			map.put(s.substring(didx + 1), map.getOrDefault(s.substring(didx + 1), 0) + num);

			if (didx != s.lastIndexOf('.')) {
				didx = s.lastIndexOf('.');
				map.put(s.substring(didx + 1), map.getOrDefault(s.substring(didx + 1), 0) + num);
			}
		}

		map.forEach((k, v) -> {
			res.add(v + " " + k);
		});

		return res;
	}

	// Don't make any changes here
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		String[] cpd = new String[n];
		for (int i = 0; i < cpd.length; i++) {
			cpd[i] = s.nextLine();
		}
		List<String> ans = subdomainVisits(cpd);
		Collections.sort(ans);
		System.out.println(ans);
	}

}
