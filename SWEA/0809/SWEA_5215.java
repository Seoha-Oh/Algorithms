package ws;

import java.util.Scanner;

public class SWEA_5215 {

	public static int[] scoreArr;
	public static int[] calArr;
	public static boolean[] isUsed;
	public static int N, L;
	static int MaxScore = -10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			
			MaxScore = -10;
			N = sc.nextInt(); // 재료 개수
			L = sc.nextInt(); // 제한된 칼로리

			scoreArr = new int[N];
			calArr = new int[N];
			isUsed = new boolean[N];

			for (int i = 0; i < N; i++) {
				scoreArr[i] = sc.nextInt();
				calArr[i] = sc.nextInt();
			} // 입력받기

			makeFood(0);

			System.out.println("#" + tc + " " + MaxScore);
		}
	}

	public static void makeFood(int idx) {

		if (idx == N) {
			int score = 0, cal = 0;

			for (int i = 0; i < N; i++) {
				if (isUsed[i]) {
					score += scoreArr[i];
					cal += calArr[i];

				}
			}
			if (cal > L)
				return;
			if (MaxScore < score)
				MaxScore = score;

			return;
		}

		isUsed[idx] = true;
		makeFood(idx + 1);

		isUsed[idx] = false;
		makeFood(idx + 1);
	}
}
