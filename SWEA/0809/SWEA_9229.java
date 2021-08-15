package ws;

import java.util.Scanner;

public class SWEA_9229 {

	static boolean[] isUsed;
	static int[] weightArr;
	static int N, W;
	static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			ans = -1;
			isUsed = new boolean[N];
			weightArr = new int[N];

			for (int i = 0; i < N; i++) {
				weightArr[i] = sc.nextInt();
			}

			maxWeight(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void maxWeight(int idx, int cnt) {
		if (cnt == 2) {
			int total = 0;
			for (int i = 0; i < N; i++) {
				if (isUsed[i]) {
					total += weightArr[i];
				}
			}
			if (total <= W && total > ans) {
				ans = total;
			}
			return;
		}
		if (idx == N) {
			return;
		}

		isUsed[idx] = true;
		maxWeight(idx + 1, cnt + 1);
		isUsed[idx] = false;
		maxWeight(idx + 1, cnt);

		return;
	}
}
