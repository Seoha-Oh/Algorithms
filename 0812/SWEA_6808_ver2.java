package ws;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6808_ver2 {

	static boolean[] used;
	static boolean[] rem;
	static int[] InArr;
	static int[] arr;
	static int[] chooseArr;
	static int loseCnt;
	static int winCnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		arr = new int[9];
		InArr = new int[9];
		chooseArr = new int[9];
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			// 테케마다 초기화 되어야 할 값
			rem = new boolean[18];
			used = new boolean[9];
			loseCnt = 0;
			winCnt = 0;

			for (int i = 0; i < 9; i++) {
				int val = sc.nextInt();
				arr[i] = val;
				rem[val - 1] = true;
			}

			int k = 0;
			for (int i = 0; i < 18; i++) {
				if (rem[i])
					continue;
				InArr[k++] = i + 1;
			}
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(InArr));
			comb(0);
			System.out.println("#"+tc+" "+ winCnt +" " +loseCnt);

		} // tc 반복문 종료
	}

	static void comb(int Inidx) {
		
		if (Inidx == 9) {
			int InScore = 0, Score = 0;
			for (int i = 0; i < 9; i++) {
				int tmpInScore = chooseArr[i];
				int tmpScore = arr[i];
				
				if (tmpInScore > tmpScore)
					InScore += tmpInScore + tmpScore;
				else if(tmpInScore < tmpScore)
					Score += tmpInScore + tmpScore;
			}
			
			if(InScore > Score)
				loseCnt++;
			else if(InScore < Score)
				winCnt++;
		
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (used[i])
				continue;
			
			used[i] = true;
			chooseArr[Inidx] = InArr[i];
			comb(Inidx + 1);
			used[i] = false;
		}
	}
}
