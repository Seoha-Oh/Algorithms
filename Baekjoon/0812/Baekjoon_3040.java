package ws;

import java.util.Scanner;

public class Baekjoon_3040 {

	static int N = 7;
	static int[] arr;
	static boolean[] used;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		arr = new int[9];
		used = new boolean[9];
		
		for(int i = 0 ; i < 9 ; i++) {
			arr[i] = sc.nextInt();
		}
		
		comb(0,0);
	}
	
	static void comb(int cnt, int idx) {
		
		if(cnt == N) { //일곱난쟁이를 뽑은 경우
			int sum = 0;
			for(int i = 0 ; i < 9 ; i++) {
				if(used[i]) {
					sum += arr[i];
				}
			}
			
			if(sum == 100) { // 7난쟁이 출력
				for(int i = 0 ; i < 9 ; i++) {
					if(used[i]) {
						System.out.println(arr[i]);
					}
				}
			}
			return;
		}
		
		if(idx >= 9)
			return;
		
		used[idx] = true;
		comb(cnt+1, idx+1); // 자기자신을 뽑은 경우
		
		used[idx] = false;
		comb(cnt, idx+1); // 자기자신을 뽑은 경우	
	}
}
