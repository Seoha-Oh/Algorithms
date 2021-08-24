package ws;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_7465 {

	static int V, E;
	static int[] parent;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();

			makeSet(); // 각 집합을 만들자.

			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();

				union(from, to);
//				
//				if(union(from, to))
//					cnt++;
			}

			Arrays.sort(parent);
			int p = parent[1];
			int cnt = 1;
			for (int j = 2; j <= V; j++) {
				if (p != parent[j]) {
					cnt++;
					p = parent[j];
				}
//				System.out.print(parent[j] +" ");
			}
//			System.out.println();
			System.out.println("#" + tc + " " + cnt);
		}

	}

	static void makeSet() { // 각자 자신의 집합으로 만듦 => 자신의 부모를 자신으로.
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) { // a가 속한 집합의 대표자 반환
		if (a == parent[a]) // a가 집합의 대표자라면
			return a;
		return parent[a] = find(parent[a]); // a가 속한 집합의 대표자를 찾아서,
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) { // 집합의 대표자가 같으면..
			return false;
		}
		// bRoot의 부모를 aroot로 바꾸기 전에, broot를 가진 놈들도 다 aroot로 바꿔줘야 함

		for (int i = 1; i <= V; i++) {
			if (parent[i] == bRoot) {
				parent[i] = aRoot;
			}
		}
		parent[bRoot] = aRoot;
		return true;

	}

}
