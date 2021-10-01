import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_4013_특이한자석 {

	static class magnet {
		int idx;
		int[] state;

		public magnet(int idx, int[] state) {
			super();
			this.idx = idx;
			this.state = state;
		}
	}

	static Queue<magnet> queue = new LinkedList<>();
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int K = sc.nextInt();

			map = new int[5][8];
			queue.clear();

			for (int i = 1; i < 5; i++) {
				for (int j = 0; j < 8; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int k = 0; k < K; k++) {
				visit = new boolean[5]; // 1~4 자석
				int idx = sc.nextInt(); // 이동시키려는 자석 인덱스 1 - 4
				int dir = sc.nextInt(); // 회전 방향 1 = 시계, -1 = 반시계
				recur(idx, dir);
				update();
			}
			
			int ans = 0; 
			for(int k = 1 ; k < 5 ; k ++) {
				if(map[k][0] == 1)
					ans += Math.pow(2, k-1);
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void recur(int clockidx, int dir) {
		if (clockidx <= 0 || clockidx >= 5) // 자석 인덱스가 벗어난 경우
			return;
		if (visit[clockidx]) { // 앞서 해당 자석을 회전 시켰을 경우
			return;
		}

		visit[clockidx] = true;
		int leftClock = clockidx - 1;
		int rightClock = clockidx + 1;

		if (dir == -1) { // 현재 자석(colckidx)를 반시계(-1)로 돌리는 경우

			int[] move = LeftShift(map[clockidx]);
			queue.add(new magnet(clockidx, move));

			if (leftClock > 0 && leftClock < 5 && map[leftClock][2] != map[clockidx][6]) { // 현재 자석과 왼쪽 자석이 N-S극으로 왼쪽자석을
																							// 현재 자석의 반대방향으로 돌려야함
				recur(leftClock, 1);
			}

			if (rightClock > 0 && rightClock < 5 && map[rightClock][6] != map[clockidx][2]) { // 현재 자석과 오른쪽 자석이 N-S극으로
																								// 오른쪽자석을 현재 자석의 반대방향으로
																								// 돌려야함
				recur(rightClock, 1);
			}

		} else { // 현재 자석(colckidx)를 시계(1)로 돌리는 경우
			int[] move = RightShift(map[clockidx]);
			queue.add(new magnet(clockidx, move));

			if (leftClock > 0 && leftClock < 5 &map[leftClock][2] != map[clockidx][6]) { // 현재 자석과 왼쪽 자석이 N-S극으로 왼쪽자석을 현재 자석의 반대방향으로 돌려야함
				recur(leftClock, -1);
			}
			if (rightClock > 0 && rightClock < 5 && map[rightClock][6] != map[clockidx][2]) { // 현재 자석과 오른쪽 자석이 N-S극으로 오른쪽자석을 현재 자석의 반대방향으로 돌려야함
				recur(rightClock, -1);
			}
		}
	}

	static int[] RightShift(int[] before) {
		int[] after = new int[8];
		after[0] = before[7];
		for (int i = 0; i < 7; i++) {
			after[i + 1] = before[i];
		}
		return after;
	}

	static int[] LeftShift(int[] before) {
		int[] after = new int[8];
		after[7] = before[0];
		for (int i = 1; i < 8; i++) {
			after[i - 1] = before[i];
		}
		return after;
	}

	static void update() {
//		System.out.println("확인용 1번 돌때 몇개의 자석이 변경되어야하는가 :" + queue.size());

		int size = queue.size();
		for (int k = 0; k < size; k++) {
			magnet now = queue.poll();
			map[now.idx] = now.state;
		}
	}
}
