package HashMap;

import java.util.*;

public class SmallestSubarrayWithallOccurencesOfMostFrequentElement {

	public static class Element {
		int c;
		int f;
		int si, ei;

		public Element(int c, int f, int s, int e) {
			this.c = c;
			this.f = f;
			si = s;
			ei = e;
		}

	}

	public static void subarrAllOcc(int[] a) {

		int mf = 0, mfs = -1, mfe = -1;

		HashMap<Integer, Element> map = new HashMap<Integer, Element>();

		for (int i = 0; i < a.length; i++) {

			if (map.containsKey(a[i])) {
				Element e = map.get(a[i]);
				e.f++;
				e.ei = i;
				if (e.f > mf) {
					mf = e.f;
					mfs = e.si;
					mfe = e.ei;

				} else if (e.f == mf) {
					if (e.ei - e.si < mfe - mfs) {
						mfs = e.si;
						mfe = e.ei;
					} else if (e.ei - e.si == mfe - mfs) {
						if (e.si < mfs) {
							mfs = e.si;
							mfe = e.ei;
						}
					}
				}

			} else {
				Element e = new Element(a[i], 1, i, i);
				if (e.f > mf) {
					mf = e.f;
					mfs = e.si;
					mfe = e.ei;
				}
				map.put(a[i], e);
			}
		}

		for (int i = mfs; i <= mfe; i++)
			System.out.print(a[i] + " ");

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		subarrAllOcc(arr);
	}
}
