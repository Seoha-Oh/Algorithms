package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		String[] RArr = { "(", "[", "{", "<" };
		String[] LArr = { ")", "]", "}", ">" };
		ArrayList<String> R = new ArrayList<>(Arrays.asList(RArr));
		ArrayList<String> L = new ArrayList<>(Arrays.asList(LArr));
		Stack<String> stack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			for(int j = 0 ; j < N ; j++) {
				String c = Character.toString(str.charAt(j));

				if(L.contains(c)) {
					int LIdx = L.indexOf(c);
					
					if(stack.isEmpty()) {
						System.out.println("#"+tc+" 0");
						break;
					}
					
					String Rc = stack.pop();
					int RIdx = R.indexOf(Rc);
					
					if(RIdx == LIdx)
						continue;
					else {
						System.out.println("#"+tc+" 0");
						break;
					}
				}
				else { // c는 왼쪽 연산이 아니고 오른쪽 {이니까 스택으로 넣기 
					stack.push(c);
				}
			}
			if(stack.size() == 0) 
				System.out.println("#"+tc+" 1");
			stack.clear();
		}
	}
}
