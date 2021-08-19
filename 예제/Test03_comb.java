import java.util.Arrays;

// 조합 : 4개 중에 2개를 반드시 뽑아야함. 순서 상관없다.
public class Test03_comb {
	static String[] cards = { "A", "B", "C", "D" };
	static boolean[] result = new boolean[cards.length];
	static int N = 4, R = 2;
	
	public static void main(String[] args) {
		comb(0, 0);
	}
	
	static void comb(int target, int cnt) {
		
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		if(target == N) /////////////////////////여기가 중요!!!
			return;
		
		result[target] = true;
		comb(target+1,cnt+1);
		result[target] = false;
		comb(target+1, cnt);
		
	}
}
