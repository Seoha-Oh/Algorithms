package ws;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_3289 {

	static int N, M;
	static int[] parent;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc  = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC ; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			makeSet();
			for(int i = 0 ; i < M ; i++) {
				
				int cmd = sc.nextInt();
				int start = sc.nextInt();
				int end = sc.nextInt();
				
				if(cmd == 0) {
					union(start, end);
				}
				else {
					int aRoot = find(start);
					int bRoot = find(end);					
					if(aRoot == bRoot) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}
			}
			
			System.out.println("#"+tc+" "+sb.toString());
		}
	}
	
	static void makeSet() { // 모든 원소의 부모를 자기 자신으로 만들기.
		parent = new int[N+1];
		for(int i = 1 ; i <= N ; i ++) {
			parent[i] = i;
		}
	}
	
	static int find(int i) {
		if(i == parent[i]) // 부모가 같다.
			return i;
		return parent[i] = find(parent[i]);
	}
	
	// 두 원소를 하나의 집합으로 합치기 
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false; // 이미 같은 집합으로 합치지 않는다.
		parent[bRoot] = aRoot;
		return true;
	}
}
