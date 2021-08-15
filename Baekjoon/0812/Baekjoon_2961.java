package ws;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2961 {

	static int N;
	static boolean[] usedS;
	static boolean[] usedB;
	static int[] sArr;
	static int[] bArr;
	static ArrayList<Integer> sList;
	static ArrayList<Integer> bList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int min = Integer.MAX_VALUE;

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		usedS = new boolean[N];
		usedB = new boolean[N];
		sArr = new int[N];
		bArr = new int[N];
		sList = new ArrayList<Integer>();
		bList = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			sArr[i] = sc.nextInt();
			bArr[i] = sc.nextInt();
		}

		subsetS(0);
		subsetB(0);

		for (int i = 0; i < sList.size(); i++) {

			int tmpVal = sList.get(i) - bList.get(i);
			tmpVal = Math.abs(tmpVal);
			min = tmpVal < min ? tmpVal : min;
		}
		System.out.println(min);

	}

	static void subsetS(int idx) {

		boolean flag = false;

		if (idx == N) {
			int val = 1;
			for (int i = 0; i < N; i++) {
				if (usedS[i]) {
					val *= sArr[i];
					flag = true;
				}
			}
			if (flag == false) { // 부분집합 중 모든 원소를 사용하지 않은 경우, 즉 0개원소 사용
				return;
			}
			sList.add(val);
			return;
		}

		usedS[idx] = true;
		subsetS(idx + 1);

		usedS[idx] = false;
		subsetS(idx + 1);

	}

	static void subsetB(int idx) {

		boolean flag = false;

		if (idx == N) {
			int val = 0;
			for (int i = 0; i < N; i++) {
				if (usedB[i]) {
					val += bArr[i];
					flag = true;
				}
			}
			if (flag == false) { // 부분집합 중 모든 원소를 사용하지 않은 경우, 즉 0개원소 사용
				return;
			}
			bList.add(val);
			return;
		}

		usedB[idx] = true;
		subsetB(idx + 1);

		usedB[idx] = false;
		subsetB(idx + 1);
	}
}
