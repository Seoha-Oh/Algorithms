package ws;


import java.util.Scanner;

public class Baekjoon_16926 {

	static boolean[][] check;
	static int[][] map, rotateMap;
	static int N, M, K;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		map = new int[N][M];



		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 맵 채우기

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		} // 맵 채우기

		for (int k = 0; k < K; k++) {
			check = new boolean[N][M];
			rotateMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = i; j < M; j++) {
					if (check[i][j])
						continue;
					move(i, j);
				}
			}
			map = rotateMap;			
		}
		///맵  출력 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(rotateMap[i][j] +" ");
			}
			System.out.println();
		}
	}

	static void move(int i, int j) {

//		System.out.println(" ==== [ " + i +" , " + j +"] ====");
		for (int d = 0; d < 4; d++) {
			
			while(true) {
				
				int movei = i + di[d];
				int movej = j + dj[d];
				
				if (movei < 0 || movei >= N || movej < 0 || movej >= M) // 범위를 벗어나거나
					break;
				if(check[movei][movej])
					break;
				rotateMap[movei][movej] = map[i][j];
//				System.out.println(d+" = [ " + movei +" , " + movej +"] = " +rotateMap[movei][movej] );
				check[movei][movej] = true;
				i = movei;
				j = movej;
			}
		}
	}
}
