package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//7. 나이순정렬
public class Ex8 {

	public static void main(String[] args) throws Exception {
		// 사람들의 나이, 이름이 가입한 순서대로 주어짐
		// 나이 증가 순으로, 그리고 나이가 같으면 먼저 가입한 사람이 앞에 오도록 정렬!

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[][] list = new String[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); // 문자열쪼개기
			list[i][0] = st.nextToken();
			list[i][1] = st.nextToken();
		}
//		System.out.println(Arrays.deepToString(list));

		// 1. 나이순 비교, 나이가 같으면 가입한 순으로.
		// 람다식
		Arrays.sort(list, (o1, o2) -> {
			// 첫번째 원소가 같다면 두번째 원소끼리 비교한다.
			if (Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
				return 0;
			} else {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		// 2. 나이같으면 먼저 가입한 사람이 앞에 오도록 - 입력이 나이순임
		// 3. 출력
		System.out.println("----------------------");
		for (int i = 0; i < N; i++) {
			sb.append(list[i][0] + " " + list[i][1]).append('\n');
		}
		System.out.println(sb);

	}
}
