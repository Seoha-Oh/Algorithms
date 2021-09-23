import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2468_안전영역 {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	static int[][] map;
	static boolean[][] visit;
	static boolean[] rain;
	static Queue<Point> queue;

	static int N, height, safeArea;
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}	
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		rain = new boolean[101];
		safeArea = 1;
		
		//입력받긴
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				int val = sc.nextInt();
				map[i][j] = val;
				rain[val] = true;
			}
		}
		
		for(int idx = 1 ; idx <= 100 ; idx++) {
			if(!rain[idx]) continue;
			visit = new boolean[N][N];
			height = idx; // 현재 높이 설정
			int cnt = 0;
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(!visit[i][j] && map[i][j] > height) { // 방문하지 않았으며 현재 높이보다 높은 구역만 탐색
						//dfs(i,j);
						bfs(i,j);
						cnt++;
					}
				}
			}
			safeArea = safeArea < cnt ? cnt : safeArea;
		}
		System.out.println(safeArea);
	}
	private static void dfs(int i, int j) {
		// TODO Auto-generated method stub
		visit[i][j] = true;
		
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];

			if (ni < 0 || ni >= N || nj < 0 || nj >= N || visit[ni][nj] == true) // 범위를 벗어나거나 이미 방문했으면 패스 
				continue;
			if(map[ni][nj] > height)
				dfs(ni,nj);
		}
	}
	
	private static void bfs(int i, int j) {
		queue = new LinkedList<Point>();
		
		visit[i][j] = true;
		queue.add(new Point(i, j));
		
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			
			for(int k = 0 ; k < 4 ; k++) {
				int ni = now.x + di[k];
				int nj = now.y + dj[k];
				
				if (ni < 0 || ni >= N || nj < 0 || nj >= N || visit[ni][nj] == true) // 범위를 벗어나거나 이미 방문했으면 패스 
					continue;
				if(map[ni][nj] > height) {
					queue.add(new Point(ni, nj));		
					visit[ni][nj] = true;
				}
			}
		}
	}
}
