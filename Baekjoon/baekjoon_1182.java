import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_1182 {

	static int N, S;
	static int[] arr;
	static boolean[] check;
	static int cnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		check = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		subset(0);
		System.out.println(cnt);
	}

	static void subset(int idx) {
		if (idx == N) {
			int sum = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (check[i]) {
//					System.out.print(arr[i] +" ");
					sum += arr[i];
					flag = true;
				}
			}
//			System.out.println();
			if (sum == S && flag) {
				cnt++;				
			}
			return;
		}
		
		check[idx] = true;
		subset(idx+1);
		check[idx] = false;
		subset(idx+1);
		
	}

}
