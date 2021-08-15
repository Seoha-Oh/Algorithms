package ws;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_15686 {

	static int N;
	static int M; //
	static int A; // 맵 중 치킨 가게의 총 개수
	static int[][] map;
	static boolean[] check;
	static int[] storeX;
	static int[] storeY;
	static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][N];

		// 맵 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2)
					A++; // 총 치킨 가게가 몇개 있는가 확인
			}
		}

		check = new boolean[A];
		storeX = new int[A];
		storeY = new int[A];


		int k = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					storeX[k] = i;
					storeY[k] = j;
					k++;
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		
		comb(0,0);
		System.out.println(ans);
	}

	static void comb(int idx, int cnt) {
		if (cnt == M) { // 총 A 개의 치킨 가게 중 m개를 선택한 경우 == 조합
			int tempDis = getDistance();
			ans = Math.min(ans, tempDis);
			return;
		}

		if (idx == A) // 인덱스 범위가 총 치킨의 가게 수(A)를 넘어가면
			return;

		check[idx] = true;
		comb(idx + 1, cnt + 1);
		check[idx] = false;
		comb(idx + 1, cnt);
	}

	static int getDistance() { //완성된 조합에서의  치킨 거리 반환하는 함수
		int chickenDis = 0;	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					int distance = Integer.MAX_VALUE;
					//한 집에서 뽑힌 m개의 치킨집의 각 거리를 비교- m개중 가장 작은 값을 distance로 저장
					for (int k = 0; k < check.length; k++) {	
						if (check[k]) {
							int storeI = Math.abs(i - storeX[k]);
							int storeJ = Math.abs(j - storeY[k]);
							int tmpDis = Math.abs(storeI + storeJ);
							distance = Math.min(distance, tmpDis);
						}
					}

					chickenDis += distance;
				}//모든 집에서 m개의 치킨 가게 중 가장 짧은 거리를 찾는 for문 종료
			}
		} // 모든 i,j에서 뽑는 가게 거리 구하기 for문 종료
		return chickenDis;
	}
}
