package ws;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding;

public class SWEA_1225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] cycle = {1,2,3,4,5};
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		int TC = 10;
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			
			int inputTC = sc.nextInt();
			for(int i = 0 ; i < 8 ; i ++) {
				q.add(sc.nextInt());
			} // 입력받는 for문
			
			boolean flag = true;
			
			while(flag) {
				for(int k = 1 ; k <=5 ; k++) {
					int moveVal = q.poll() - k;
					
					if(moveVal <= 0) {
						moveVal = 0;
						q.add(moveVal);
						flag = false;
						break;
					}
					else
						q.add(moveVal);
				}
			}
			System.out.print("#"+inputTC+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
			q.clear();
		} // tc 종료 for문
	}
}
