package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon_2798 {

	static boolean[] Used;
	static int[] valArr;
	static int MaxVal;
	static int N;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		N = sc.nextInt();
//		MaxVal = sc.nextInt();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		MaxVal = Integer.parseInt(st.nextToken());
		
		Used = new boolean[N];
		valArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int i = -1;
		while(st.hasMoreTokens()) {
			valArr[++i] = Integer.parseInt(st.nextToken());
		}
		ans = Integer.MIN_VALUE;
		comb(0,0);
		
		System.out.println(ans);
	}
	
	static void comb(int cnt, int idx) {
		
		if(cnt == 3) { // 3개 뽑기 완료
			int tmpCnt = 0;
			for(int i = 0 ; i < N ; i++) {
				if(Used[i]) {
					tmpCnt += valArr[i]; 
				}
			}
			if(tmpCnt > MaxVal)
				return;
			if(tmpCnt > ans)
				ans = tmpCnt;
			return;
		}
		
		if(idx == N)
			return;
		
		Used[idx] = true; // 해당 인덱스 값 선택
		comb(cnt+1, idx+1); // 카운트 + 1, 인덱스 옮기기 
		
		Used[idx] = false; // 해당 인덱스 값 선택x
		comb(cnt, idx+1); //  인덱스 옮기기
	}
}
