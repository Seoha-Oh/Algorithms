package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_3109 {

	static int[] di = { -1, 0, 1 };
	static int[] dj = { 1, 1, 1 };
	static int R, C;
	static char[][] map;
	static boolean[][] check;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		check = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			backtracking(i, 0);			
		}
		System.out.println(cnt);

	}

	public static boolean backtracking(int i, int j) {
		check[i][j] = true;
		
		if (j == C - 1) {
			cnt++;
			return true;
		}

		for (int k = 0; k < 3; k++) {
			int mi = i + di[k];
			int mj = j + dj[k];
			
			if (mi < 0 || mi >= R || mj < 0 || mj >= C) // 이동 범위를 벗어나면..
				continue;
			if (isPromising(mi, mj)) {
				if(backtracking(mi, mj))
					return true;
			}
		} 
		return false;
	}

	public static boolean isPromising(int i, int j) {
		if (check[i][j]) // 누군가가 이미 해당 칸을 방문했다면
			return false;
		if (map[i][j] == 'x') {
			check[i][j] = true;
			return false;
		}
		return true;
	}
}
