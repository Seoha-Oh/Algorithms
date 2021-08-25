import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10026 {

	static char[][] map;
	static boolean[][] visited;
	static int N;
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited = new boolean[N][N];

		int nCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				dfs(i, j, map[i][j]);
				++nCnt;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G')
					map[i][j] ='R';
			}
		}
		visited = new boolean[N][N];
		int pCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
//				System.out.println(i + " " + j);
				dfs(i, j, map[i][j]);
				++pCnt;
			}
		}
		System.out.println(nCnt + " " + pCnt);
	}

	static void dfs(int i, int j, char color) {
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int mi = i + di[k];
			int mj = j + dj[k];

			if (mi < 0 || mi >= N || mj < 0 || mj >= N || visited[mi][mj]) // 범위를 벗어나거나, 이미 방문한 곳이라면 패스
				continue;
			if (color == map[mi][mj]) {

				dfs(mi, mj, map[mi][mj]);
			}
		}
	}
}
