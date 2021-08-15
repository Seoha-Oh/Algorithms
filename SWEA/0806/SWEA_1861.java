package ws;

import java.util.Scanner;

public class SWEA_1861 {

	public static boolean isPassed[][];
	public static int[][] map;

	public static int[] di = { -1, 0, 1, 0 };
	public static int[] dj = { 0, 1, 0, -1 };
	public static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();

			map = new int[N][N];
			isPassed = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			} // 입력받기

			int maxCnt = 0; // 총 몇번을 움직일 수 있냐
			int maxVal = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!isPassed[i][j]) { // 아직 방문 안했다면
						int cnt = search(i, j, 0);
						
//						System.out.println("[ " + i + " , " +j +" ] = " + cnt);
						if (maxCnt < cnt) {
							maxCnt = cnt;
							maxVal = map[i][j];
						} else if (maxCnt == cnt && maxVal > map[i][j]) { // 횟수는 동일한데 더작은 수로
							maxVal = map[i][j];
						}
					}
				}
			}
			// 자기 자신을 포함해야하기 때문에 답에 +1 해야함
			System.out.println("#" + tc + " " + maxVal + " " + (maxCnt + 1));

		} // 테스트케이스 반복문 종료
	}

	public static int search(int i, int j, int counting) {
		
		int cnt = counting;
		isPassed[i][j] = true; // 현재 위치 방문했다 표시

		for (int k = 0; k < 4; k++) {
			int currentVal = map[i][j];
			int taget = currentVal + 1;

			int movei = i + di[k];
			int movej = j + dj[k];

			if (movei < 0 || movei >= N || movej < 0 || movej >= N) // 범위에서 벗어나면
				continue;
			if (map[movei][movej] == taget) {
				cnt = search(movei, movej, counting+1);
			}
		}
		return cnt;
	}
}
