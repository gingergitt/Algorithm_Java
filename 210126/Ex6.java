package code4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6. 좌표정렬하기
public class Ex6 {

	public static void main(String[] args) throws Exception {

		// 점 N개 주어짐
		// y좌표가 증가하는 순으로 정렬하는데, y좌표가 같으면x좌표가 증가하는 순서로 정렬 해서 출력.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int[][] r = new int[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); //문자열쪼개기
			r[i][0] = Integer.parseInt(st.nextToken());
			r[i][1] = Integer.parseInt(st.nextToken());
		}


		
		// 람다식
		Arrays.sort(r, (o1, o2) -> {
			if (o1[0] == o2[0]) { //첫번째 원소가 같다면 두번째 원소끼리 비교한다.
				return o1[1] - o2[1];
			} else {
				return o1[0] - o2[0];
			}
		});

//		System.out.println(Arrays.toString(x));
		System.out.println("----------------------");
		for (int i = 0; i < N; i++) {
//			System.out.println(r[i][0] + " " + r[i][1]);
			sb.append(r[i][0] + " " + r[i][1]).append('\n');
		}
		System.out.println(sb);
	}
}
