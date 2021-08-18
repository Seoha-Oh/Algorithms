package ws;

import java.util.Arrays;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding.Use;

public class SWEA_4012 {

	static int N;
	static boolean[] Used;
	static boolean[] UsedIngredient;
	static int[] indexArr = new int[2];
	static int[][] map;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		
		for(int  tc = 1 ; tc <=TC ; tc++) {
			N = sc.nextInt();
			Used = new boolean[N];
			UsedIngredient = new boolean[N/2];
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			for(int i = 0 ; i < N ; i ++) {
				for(int j = 0 ; j < N ; j ++) {
					map[i][j] = sc.nextInt();
				}
			}
			chooseIngredient(0, 0);
			
			System.out.println("#"+tc+" " +min);
		}
	}

	static void chooseIngredient(int idx , int cnt) { // N 개 중 선택할 식재료 N/2개
		if(cnt == N/2) {
			int[] chooseInArr = new int[N/2];
			int[] remInArr = new int[N/2];
			int cnt1 = 0;
			int cnt2 = 0;
			
			for(int i = 0 ; i < N ; i ++) {
				if(Used[i]) {
					chooseInArr[cnt1++] = i;
				}
				else {
					remInArr[cnt2++] = i;
				}
			}

//			System.out.println(Arrays.toString(chooseInArr));
			int foodScore1 = makeFoodPer(chooseInArr, 0, 0);
//			System.out.println(foodScore1);
//			
//			
//			System.out.println(Arrays.toString(remInArr));
			int foodScore2 = makeFoodPer(remInArr, 0, 0);
//			System.out.println(foodScore2);
//			System.out.println(Math.abs(foodScore1-foodScore2));
//			System.out.println();
//			System.out.println("--------------------------------");
			int tempScore = Math.abs(foodScore1-foodScore2); 
			min = min > tempScore ? tempScore : min;
			return;
		}
		
		if(idx == N) return;
		
		Used[idx] = true;
		chooseIngredient(idx+1, cnt+1);
		Used[idx] = false;
		chooseIngredient(idx+1, cnt);
	}
	

	static int makeFoodPer(int [] arr, int cnt, int sum) {
		
		if(cnt == 2) {
			int i = indexArr[0];
			int j = indexArr[1];
//			System.out.println(i +" " +j);
			return sum += map[i][j];
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			if(UsedIngredient[i]) continue;
			UsedIngredient[i] = true;
			indexArr[cnt] = arr[i];
			sum = makeFoodPer(arr, cnt+1, sum);
			UsedIngredient[i] = false;
			
		}
			return sum;
	}
}
