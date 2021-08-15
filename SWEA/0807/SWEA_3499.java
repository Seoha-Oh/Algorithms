package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;

public class SWEA_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		Queue<String> aQ = new LinkedList<>();
		Queue<String> bQ = new LinkedList<>();

		for (int tc = 1; tc <= TC; tc++) {

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());


			for (int i = 0; i < N; i++) {
				if (i >= (N / 2)) {
					bQ.add(st.nextToken());
					
				}
				else
					aQ.add(st.nextToken());
			}

			System.out.print("#" + tc + " ");
			if (aQ.size() < bQ.size()) {
				while (!aQ.isEmpty()) {
					System.out.print(bQ.poll() + " ");
					System.out.print(aQ.poll() + " ");
				}
//				System.out.print(bQ.poll() + " ");
			}
			else if (aQ.size() == bQ.size()) {
				while (!aQ.isEmpty()) {
					System.out.print(aQ.poll() + " ");
					System.out.print(bQ.poll() + " ");
				}
//				System.out.print(bQ.poll() + " ");
			}
		}
		System.out.println();

	}

}
