package hw;

import java.util.Scanner;

public class Baekjoon_1012_유기농배추 {

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static int[][] map;
	static boolean[][] visit;

	static int N, M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 0; tc < TC; tc++) {
			M = sc.nextInt(); // 가로 - 열의 갯수 (|)
			N = sc.nextInt(); // 세로 - 행의 갯수 (-)
			int K = sc.nextInt();
			
			map = new int[N][M];
			visit = new boolean[N][M];

			for (int k = 0; k < K; k++) {
				int x = sc.nextInt(); // M
				int y = sc.nextInt(); // N
				map[y][x] = 1;
			}

//			print();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visit[i][j]) { // 배추가 심어져있으면서, 방문하지 않은 곳 탐색
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}

	}

	static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for (int k = 0; k < 4; k++) {
			int ni = x + di[k];
			int nj = y + dj[k];

			if (ni < 0 || ni >= N || nj < 0 || nj >= M || visit[ni][nj] == true) // 범위를 벗어나거나 이미 방문했으면 패스 
				continue;
			if(map[ni][nj] == 1)
				dfs(ni,nj);
		}
	}
	
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
