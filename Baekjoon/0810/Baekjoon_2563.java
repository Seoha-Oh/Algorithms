package ws;

import java.util.Scanner;

public class Baekjoon_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] map = new boolean[100][100];

		int N = sc.nextInt();
		int cnt = 0;
		for (int k = 0; k < N; k++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if(map[i][j]) continue;
					map[i][j] = true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
