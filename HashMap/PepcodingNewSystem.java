package HashMap;

import java.util.*;

public class PepcodingNewSystem {

	private static void solve(String[] str) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0;i<str.length;i++) {
			if(map.containsKey(str[i])) {
				int fcount = map.get(str[i]);
				System.out.println(str[i]+fcount);
				map.put(str[i], fcount+1);
			}
			else
			{
				map.put(str[i], 1);
				System.out.println("Verified");
			}
		}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Length of the array
        int N = sc.nextInt();

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        
        solve(arr);
        
        
    }

}
