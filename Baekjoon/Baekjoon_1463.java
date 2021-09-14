import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1463 {

	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new int[N+1];
		
		recur(N,0);
		System.out.println(arr[1]);
	}

	static void recur(int val, int cnt) {
		if(arr[val] == 0 || arr[val] > cnt) {
			arr[val] = cnt;
			System.out.println(val + " : " + cnt);
		}
		if(val == 1)
			return;
		if(arr[val] < cnt)
			return;
		
		if(val % 3 == 0)
			recur(val / 3, cnt+1);
		if(val % 2 == 0)
			recur(val / 2, cnt+1);
		recur(val-1,cnt+1);
	
	}
}
