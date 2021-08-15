package ws;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		int N = sc.nextInt();
		int d = sc.nextInt();
		int idx = 0;
		
		for(int i = 1 ; i <=N ; i++) {
			list.add(i);
		}
		
		while(!list.isEmpty()) {
			idx += d-1;
			if(idx >= list.size()-1) {
				idx = idx % list.size();
			}

//			System.out.println(idx);
			
			ans.add(list.get(idx));
			list.remove(idx);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 0 ; i < ans.size() ; i++) {
			sb.append(ans.get(i)+", ");
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb.toString());
	}
}
