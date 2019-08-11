package StackAndQueue;

import java.util.*;

public class KillProcesses {

	static class Node {
		int data;
		ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			children = new ArrayList<Node>();
		}
	}

	public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		for (int i = 0; i < pid.size(); i++)
			map.put(pid.get(i), new Node(pid.get(i)));

		for (int i = 0; i < ppid.size(); i++) {
			if (ppid.get(i) != 0)
				map.get(ppid.get(i)).children.add(map.get(pid.get(i)));
		}
		Stack<Node> res = new Stack<Node>();
		ArrayList<Integer> finalres = new ArrayList<Integer>();
		res.add(map.get(kill));
		while(!res.isEmpty()) {
			Node n = res.pop();
//			for(int i=0;i<n.children.size();i++)
//				res.push(item)
			res.addAll(n.children);
			finalres.add(n.data);
		}
//		for (int i = 0; i < n.children.size(); i++)
//			res.add(n.children.get(i).data);
		return finalres;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> pid = new ArrayList<>(n);
		List<Integer> ppid = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			pid.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			ppid.add(sc.nextInt());
		}
		System.out.println(killProcess(pid, ppid, k));
	}
}
