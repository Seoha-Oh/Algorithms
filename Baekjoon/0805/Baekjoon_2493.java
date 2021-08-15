package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> originS = new Stack<Integer>();
		Stack<Integer> copyS;
		Stack<Integer> ansS = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			originS.push(Integer.parseInt(st.nextToken()));
		}
			
		while (!originS.isEmpty()) {
			int val = originS.pop();
			copyS = (Stack<Integer>) originS.clone();
			while (true) {
				if (copyS.isEmpty()) {
					ansS.push(0);
					break;
				}

				int tempIdx = copyS.size();
				int tempVal = copyS.pop();

				if (val <= tempVal) {
					ansS.push(tempIdx);
					break;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(ansS.pop() + " ");
		}
	}
}
