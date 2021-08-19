package ws;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_1987 {

	static int R;
	static int C;
	static int ans;
	static char[][] map;
	static boolean[][] check;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static ArrayList<Character> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
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
		ans = Integer.MIN_VALUE;
		backtracking(0, 0, 1);

		System.out.println(ans);
	}

	static void backtracking(int i, int j, int cnt) {

		check[i][j] = true;
		list.add(map[i][j]);

		for (int k = 0; k < 4; k++) {
			int mi = i + di[k];
			int mj = j + dj[k];

			if (mi < 0 || mi >= R || mj < 0 || mj >= C)
				continue;
			if (isPromising(mi, mj)) {
				backtracking(mi, mj, cnt+1);
			}
		}
		ans = cnt > ans ? cnt : ans; 
		list.remove(list.size() - 1);
		check[i][j] = false;
		return;
	}

	static boolean isPromising(int i, int j) {
		if (check[i][j]) // 해당 구간을 이미 왔던 곳이면
			return false;
		if (list.contains(map[i][j])) // 해당 알파벳이 이미 들어왔다면
			return false;
		return true;
	}
}
