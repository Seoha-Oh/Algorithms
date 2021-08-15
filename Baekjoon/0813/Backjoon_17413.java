package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjoon_17413 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			char current = arr[i];
			
			if(current == '<') {
				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				
				while (current != '>') {
					System.out.print(current);
					current = arr[++i];
				}
				System.out.print(current);				
			}
			
			else if(current == ' ') {
				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(" ");
			}
			
			else {
				stack.push(current);
			}
		} // 반복문 종료
	
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.print(" ");
	}
}
