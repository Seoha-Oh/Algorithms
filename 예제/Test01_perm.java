import java.util.Arrays;

public class Test01_perm {

	static int N = 4, R = 2;
	static String[] cards = { "A", "B", "C", "D" };
	static String[] result = new String[R];
	static boolean[] used = new boolean[N];

	public static void main(String[] args) {

//		perm(0);
		pperm(0);
	}

	static void perm(int idx) {
		if(idx ==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(used[i]) continue;
			result[idx] = cards[i];
			used[i] = true;
			perm(idx+1);
			used[i] = false;
		}
	}
	
	static void pperm(int idx) { // 중복허용
		if(idx ==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(used[i]) continue;
			result[idx] = cards[i];
			perm(idx+1);
		}
	}
}
