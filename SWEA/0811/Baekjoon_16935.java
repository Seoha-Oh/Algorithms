package ws;

import java.util.Scanner;

public class Baekjoon_16935 {

	static int N, M, R;
	static int[][] map, changeMap;
	static int newN, newM;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		int[] userInput = new int[R];

		map = new int[N][M];
		changeMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int k = 0; k < R; k++) {
			userInput[k] = sc.nextInt();
		}

		for (int k = 0; k < R; k++) {

			int input = userInput[k];

			N = map.length;
			M = map[0].length;
			changeMap = new int[N][M];

			switch (input) {

			case 1:
				for (int i = 0; i < N; i++) {
					changeMap[N - 1 - i] = map[i];
				}
				break;

			case 2:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						changeMap[i][M - 1 - j] = map[i][j];
					}
				}
				break;

			case 3:
				newN = M;
				newM = N;
				changeMap = new int[newN][newM];

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						changeMap[j][newM - 1 - i] = map[i][j];
					}
				}
				break;

			case 4:
				newN = M;
				newM = N;
				changeMap = new int[newN][newM];

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						changeMap[newN - 1 - j][i] = map[i][j];
					}
				}
				break;

			case 5:

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						int movei = i, movej = j;
						if (i >= 0 && i < (N / 2)) {
							if (j >= 0 && j < (M / 2)) { // 1사분면 <우측>
								movei = i;
								movej = j + (M / 2);
							} else if (j >= (M / 2) && j < M) { // 2사분면 <아래>
								movei = i + (N / 2);
								movej = j;
							}
						} else if (i >= (N / 2) && i < N) {
							if (j >= 0 && j < (M / 2)) { // 4사분면 <위>
								movei = i - (N / 2);
								movej = j;
							} else if (j >= (M / 2) && j < M) { // 3사분면 <좌측>
								movei = i;
								movej = j - (M / 2);
							}
						}
						changeMap[movei][movej] = map[i][j];
					}
				}
				break;

			case 6:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						int movei = i, movej = j;
						if (i >= 0 && i < (N / 2)) {
							if (j >= 0 && j < (M / 2)) { // 1사분면 <아래>
								movei = i + (N / 2);
								movej = j;
							} else if (j >= (M / 2) && j < M) { // 2사분면 <좌측>
								movei = i;
								movej = j - (M / 2);
							}
						} else if (i >= (N / 2) && i < N) {
							if (j >= 0 && j < (M / 2)) { // 4사분면 <우측>
								movei = i;
								movej = j + (M / 2);
							} else if (j >= (M / 2) && j < M) { // 3사분면 <위>
								movei = i - (N / 2);
								movej = j;
							}
						}
						changeMap[movei][movej] = map[i][j];
					}
				}
				break;
			} // 스위치 문 종료
			map = new int[changeMap.length][changeMap[0].length];
			map = changeMap;
//			System.out.println(k + "--------------------------------------");
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map[0].length; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
		} // R번 횟수 반복문 종료

//		System.out.println(changeMap.length+ " "+ changeMap[0].length);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(changeMap[i][j] + " ");
			}
			System.out.println();
		}
	}

}
