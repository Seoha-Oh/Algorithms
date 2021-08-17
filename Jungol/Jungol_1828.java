package ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jungol_1828 {

	static class Chemical implements Comparable<Chemical> {
		int x; // 최저온도
		int y; // 최고온도

		public Chemical(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Chemical o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Chemical[] chemicals = new Chemical[N];

		for (int i = 0; i < N; i++) {
			chemicals[i] = new Chemical(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(chemicals);

		int refMin = chemicals[0].x;
		int refMax = chemicals[0].y;
		int cnt = 1;
		
		for (int i = 1; i < chemicals.length; i++) {
			int tempMin = chemicals[i].x;
			int tempMax = chemicals[i].y;

			if (refMin <= tempMin && refMax >= tempMin) { // 현재 냉장고 범위 안에 들어오면
				refMin = Math.max(refMin, tempMin);
				refMax = Math.min(refMax, tempMax);
			}
			else {
				++cnt;
				refMin = chemicals[i].x;
				refMax = chemicals[i].y;
			}
		}
		
		System.out.println(cnt);
	}
}
