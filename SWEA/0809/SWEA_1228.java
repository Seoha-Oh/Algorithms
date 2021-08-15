package ws;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1228 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int SIZE = 10;
		
		for(int tc = 1 ; tc <= 10 ; tc++) {
			ArrayList<String> list = new ArrayList<String>();
			
			br.readLine();
			st = new StringTokenizer(br.readLine()); //원본 암호문
			
			while(st.hasMoreTokens()) {
				if(list.size() == SIZE)
					break;
				list.add(st.nextToken());
			}
			
//			System.out.println(list.toString());
			
			int cnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "I"); //명령어 한줄로 입력
			
			while (st.hasMoreTokens()) { //cnt 갯수만큼 돌것
				String command = st.nextToken();
				StringTokenizer st2 = new StringTokenizer(command);
				
				int idx = Integer.parseInt(st2.nextToken());
				int comCnt = Integer.parseInt(st2.nextToken());
				
				for(int i = idx ; i < (idx + comCnt) ; i++) {
					if(i >= SIZE) break;
					list.add(i, st2.nextToken());
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i = 0 ; i < SIZE ; i++) {
				System.out.print(list.get(i)+" ");
			}
		}
		
	}
}
