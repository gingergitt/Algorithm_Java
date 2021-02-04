package code4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6. ��ǥ�����ϱ�
public class Ex6 {

	public static void main(String[] args) throws Exception {

		// �� N�� �־���
		// y��ǥ�� �����ϴ� ������ �����ϴµ�, y��ǥ�� ������x��ǥ�� �����ϴ� ������ ���� �ؼ� ���.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int[][] r = new int[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); //���ڿ��ɰ���
			r[i][0] = Integer.parseInt(st.nextToken());
			r[i][1] = Integer.parseInt(st.nextToken());
		}


		
		// ���ٽ�
		Arrays.sort(r, (o1, o2) -> {
			if (o1[0] == o2[0]) { //ù��° ���Ұ� ���ٸ� �ι�° ���ҳ��� ���Ѵ�.
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
