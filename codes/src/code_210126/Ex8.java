package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//7. ���̼�����
public class Ex8 {

	public static void main(String[] args) throws Exception {
		// ������� ����, �̸��� ������ ������� �־���
		// ���� ���� ������, �׸��� ���̰� ������ ���� ������ ����� �տ� ������ ����!

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[][] list = new String[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); // ���ڿ��ɰ���
			list[i][0] = st.nextToken();
			list[i][1] = st.nextToken();
		}
//		System.out.println(Arrays.deepToString(list));

		// 1. ���̼� ��, ���̰� ������ ������ ������.
		// ���ٽ�
		Arrays.sort(list, (o1, o2) -> {
			// ù��° ���Ұ� ���ٸ� �ι�° ���ҳ��� ���Ѵ�.
			if (Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
				return 0;
			} else {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		// 2. ���̰����� ���� ������ ����� �տ� ������ - �Է��� ���̼���
		// 3. ���
		System.out.println("----------------------");
		for (int i = 0; i < N; i++) {
			sb.append(list[i][0] + " " + list[i][1]).append('\n');
		}
		System.out.println(sb);

	}
}
